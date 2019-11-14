/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class DBhelper {
    public  Connection conn;
    public String dbUrl;
    
    public DBhelper(){
     try{   
     String url = "sun.jdbc.odbc.JdbcOdbcDriver";   
     Class.forName(url); //khia bao driver;
     //conn=DriverManager.getConnection("jdbc:odbc:DBSJ","","");
     //dbUrl="jdbc:odbc:Driver=[SQL Server];Server=ADMIN-PC\\SQLEXPRESS;Database=TaiKhoan;User"
     //String dbUrl="jdbc:odbc:Driver={SQL Server};Server=.;Database=TaiKhoan;UserName=sa;Password=chieu12a2";
     connect();
     }catch(Exception ex){
         
       ex.printStackTrace();
     }
        
    }

    
   public void connect() throws SQLException {
       // conn=DriverManager.getConnection(dbUrl);
       conn=DriverManager.getConnection("jdbc:odbc:DBSJ","","");
    }
    
    
   public int excuteUpdate(String sql) throws SQLException{
      Statement st =conn.createStatement();
      int kq= st.executeUpdate(sql);
      return kq; 
       
   } 
    
    public ResultSet excuteQuery(String sql) throws Exception {
        
        Statement st= conn.createStatement();
        ResultSet rs =st.executeQuery(sql);
        return rs;
    }
    
    
}
