/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi3a.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author Willian Vieira
 */
public class ConnectionUtils {
    
    private static Connection connection = null;
    
    public static Connection getConnection() throws SQLException{
        
       
    
        if (connection == null || connection.isClosed()){
            
           String ddURL = "jdbc:mysql://localhost/agenda_contatos";
           Properties properties = new Properties();
            properties.put("user", "root");
            properties.put("password", "L@la280789");
            connection =  DriverManager.getConnection(ddURL,properties);
           
            
 
            
        }
        
        
        return connection;
    
    }
           
    
}
    

