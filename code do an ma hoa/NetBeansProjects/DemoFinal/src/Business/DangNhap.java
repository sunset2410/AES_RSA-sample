/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import java.util.Vector;
import connection.DBhelper;
import java.sql.ResultSet;




/**
 *
 * @author admin
 */
public class DangNhap {
  private String user;
  private String pass;
  
  // ham khoi tao;
  public DangNhap(){
      user=null;
      pass=null;
  }
  
  // ham lay user
  public String getUser(){
      return this.user;
  }
    // ham set user;
   public void setUser(String user){
      this.user=user;
       
   } 
    
   
    // ham lay pass
  public String getPass(){
      return this.pass;
  }
    // ham set pass
   public void setPass(String pass){
      this.pass=pass;
       
   } 
    
  public   Vector getAllAdmin() throws Exception{
      Vector v=new Vector();
      String sql="select * from thongtintaikhoan";
      DBhelper db=new DBhelper();
      ResultSet rs=db.excuteQuery(sql);
      while(rs.next()){
          DangNhap dn=new DangNhap();
          dn.user =rs.getString("username");
          dn.pass=rs.getString("password");
          v.add(dn);   
          
      } 
      return v;
  }
   
  
 public int checkDangNhap(String user,String pass) throws Exception{
     
     Vector v=new Vector();
     DangNhap dn=new DangNhap();
     v=dn.getAllAdmin();
     for(int i=0;i<v.size();i++){
         DangNhap a=(DangNhap)v.get(i);
         if((a.user.equals(user))&&(a.pass.equals(pass))){
           return 1;
             
         }
     }
     return 0;
 } 
  
   
   
}
