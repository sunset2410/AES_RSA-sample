/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Test {
    public static void main(String[] args) {
        
        ConnectToMSSQL s= new ConnectToMSSQL();
        Connection con =s.getconnectToMSSQL();
        try {
            Statement stm =con.createStatement();
            ResultSet rs =stm.executeQuery("select fldFirtName from tblStudent ");
            while (rs.next())
                System.out.print(rs.getString(""));
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }
}
