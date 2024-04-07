
const mysql = require('mysql');

const pool = mysql.createPool({
    connectionLimit: 10,
    host: 'localhost',
    port: 3306,
    user: 'root',
    password: '',
    database: 'date-of-love'
});


function fazerLogin(callback) {
    var email = document.getElementById('email').value;
    var senha = document.getElementById('senha').value;

    const sql = 'SELECT * FROM tb_usuarios WHERE ds_email = ? AND ds_senha = ?';
    pool.getConnection(function (error, connection) {
        if (error) {
            callback(error, null);
            return;
        }
        connection.query(sql, [email, senha], function (error, results, fields) {
            connection.release();
            if (error) {
                callback(error, null);
                return;
            }

            if (results.length > 0) {

                callback(null, results[0]);
            } else {
                callback(null, null);
            }
        });
    });
}
