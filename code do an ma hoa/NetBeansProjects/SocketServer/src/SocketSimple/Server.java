/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketSimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Server {
    
    public static void main(String[] args) {
        Server s=new Server();
        s.serve();
        
    }
    
    public  void serve(){
        try {
            //tao serversocket;mo cong 1024 va cho ket noi tu client;
            ServerSocket sever =new ServerSocket(1991);
            System.out.println("step 1:sever is ready:");
            Socket socket =sever.accept();
            
            //recier from client
            System.out.println("step 3:dang nhan du lieu tu client:");
            BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request =br.readLine();
            
            if (request !=null){
            System.out.println("step 4:ket qua nhan tu client :"+request);
            // process :seclect from database or caculate;
            
            }
            
            
            //respone to client;
            System.out.println("step 5:dang tra loi client:");
            PrintStream ps =new PrintStream(socket.getOutputStream());
            ps.println(request.toUpperCase());
            
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
}
