/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StudyAndShare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Client {
    public static void main(String[] args) {
        Client c=new Client();
        c.connect();;
        
    }
    
    public void connect(){
        try {
            //ket noi toi server tai ip va cong 1024;
            Socket socket =new Socket("192.168.1.106",1991);
            
            //sending to server ( gui du lieu cho phia server);
            System.out.println("step 2:dang gui du lieu cho sever");
            PrintStream ps =new PrintStream(socket.getOutputStream());
            ps.println("dai hoc bach khoa ha noi!");
            
            
            // recier from server; (nhan du lieu tra loi tu server);
            System.out.println("step 6:dang nhan du lieu tu server:");
            BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String respone =br.readLine();
            if(respone !=null){
            System.out.println("step 7:tra loi cua sever la:"+respone);
            
            }
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
