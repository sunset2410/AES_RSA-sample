/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ConnectToMSSQL {
    
    Connection connection ;
    
    public Connection getconnectToMSSQL()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectToMSSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection =DriverManager.getConnection("jdbc:sqlserver://ADMIN-PC\\SQLEXPRESS:1434;databaseName=Student","sa","chieu12a2");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectToMSSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
        
    }
    
    public void Close(){
        if(connection!=null)
            try {
            if(connection.isClosed())
                connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectToMSSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
            connection=null;

     }
  
    
    
}
