/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multi_thread;
import java.io.*;
import java.net.*;

public class ThreadSocket extends Thread{
   private Socket socket;  
    // ham khoi tao;
    public ThreadSocket(Socket pSocket){
        this.socket=pSocket;
        }
    // viet lai ham run;
    @Override
    public void run(){

        try{
            //Tạo luồng nhận dữ liệu từ bàn phím
            DataInputStream inFromServer = new DataInputStream(System.in);
            //Tạo luồng nhận dữ liệu từ Client
            DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
            //Tạo luồng gửi dữ liệu về Client
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
            
            while(true)
            {
                //Đọc dữ liệu từ Client gửi tới rồi in ra
                String listen = inFromClient.readLine();
                System.out.println("\nClient: "+listen);
                System.out.println("\nServer: ");
                
                //Nhập dữ liệu từ bàn phím rồi gửi về Client
                String ask = inFromServer.readLine();
                outToClient.writeBytes(ask+"\n");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
