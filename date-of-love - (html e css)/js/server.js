const mysql = require('mysql');
const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const app = express();

app.use(cors());
app.use(bodyParser.json());

const pool = mysql.createPool({
    connectionLimit: 10,
    host: 'localhost',
    port: 3306,
    user: 'root',
    password: '',
    database: 'date-of-love'
});

app.post('/login', (req, res) => {
    const { email, senha } = req.body;

    const sql = `SELECT * FROM tb_usuarios WHERE ds_email = ? AND ds_senha = ?`;

    pool.getConnection((err, connection) => {
        if (err) {
            res.status(500).json({ error: 'Erro interno no servidor' });
            return;
        }

        connection.query(sql, [email, senha], (err, result) => {
            connection.release();

            if (err) {
                res.status(500).json({ error: 'Erro interno no servidor' });
            } else if (result.length > 0) {
                const usuario = result[0];
                res.json(usuario);
            } else {
                res.status(401).json({ error: 'Credenciais inválidas' });
            }
        });
    });
});

app.post('/criar-conta', (req, res) => {
    const { nm_noivo, nm_noiva, ds_email, ds_senha, dt_cadastro } = req.body;

    if (!nm_noivo || !nm_noiva || !ds_email || !ds_senha || !dt_cadastro) {
        return res.status(400).json({ error: 'Todos os campos são obrigatórios' });
    }

    const sqlCheckEmail = `SELECT * FROM tb_usuarios WHERE ds_email = ?`;

    pool.query(sqlCheckEmail, [ds_email], (err, result) => {
        if (err) {
            return res.status(500).json({ error: 'Erro interno no servidor' });
        }
        if (result.length > 0) {
            return res.status(400).json({ error: 'Este email já está em uso' });
        }

        const sqlInsertUser = `INSERT INTO tb_usuarios (nm_noivo, nm_noiva, ds_email, ds_senha, dt_cadastro) VALUES (?, ?, ?, ?, ?)`;

        pool.query(sqlInsertUser, [nm_noivo, nm_noiva, ds_email, ds_senha, dt_cadastro], (err, result) => {
            if (err) {
                return res.status(500).json({ error: 'Erro ao criar conta' });
            }
            res.status(201).json({ message: 'Conta criada com sucesso' });
        });
    });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
