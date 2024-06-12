package br.com.alura.comex.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection criaConexao() {
        String usuario = "root";
        String senha = "Mateus@2022";

        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/comex", usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
