/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3a.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author everton
 */
public class DBConnector {

    public static String status = "Não conectou...";

    //Método de Conexão
    public static java.sql.Connection getConexaoDB() {

        Connection connection = null;  //atributo do tipo Connection

        try {
            //********Conexão local***********///
            /*
            String serverName = "localhost"; // caminho do servidor do db
            String mydatabase = "agenda_contatos"; //nome do db
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;// Montagem da URL
            String username = "root"; //nome de um usuário do db      
            String password = "P@ssw0rd"; //senha de acesso
            */
      

            // Configurando a conexão com um banco de dados online
            String serverName = "cloud.kwcraft.com.br"; // caminho do servidor do db
            String mydatabase = "agenda_contatos"; //nome do db
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;// Montagem da URL
            String username = "agenda"; //nome de um usuário do db      
            String password = "P@ssw0rd"; //senha de acesso
             
            //Conexão com servidor db
            connection = DriverManager.getConnection(url, username, password);
            
            //Testando a conexão 
            if (connection != null) 
                status = ("STATUS ---> Conectado com sucesso!");
             else
                status = ("STATUS ---> Não foi possivel realizar conexão!");
            
            return connection;

        } catch (SQLException e) {

            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            
            System.err.println(e.getMessage());
            return null;
        }
    }

    //Método que retorna o status da conexão
    public static String statusConexao() {
        return status;
        
    }
    
    //Método que fecha a conexão
    public static boolean FecharConexao() {
        
        try {
            DBConnector.getConexaoDB().close();
            return true;
            
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia a conexão
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return DBConnector.getConexaoDB();
    }

}
