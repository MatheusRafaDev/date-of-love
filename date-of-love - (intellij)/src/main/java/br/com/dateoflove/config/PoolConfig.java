package br.com.dateoflove.config;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConfig {

    private static BasicDataSource dataSource;

    private PoolConfig() {
        getDataSource();
    }

    private static BasicDataSource getDataSource() {

        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://date-of-love.mysql.database.azure.com:3306/dateoflove");
            dataSource.setUsername("dateoflove");
            dataSource.setPassword("matheus123@");
            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(10);
            dataSource.setMaxTotal(50);

            System.out.println("Novo pool de conexões criado com sucesso");
        }

        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
