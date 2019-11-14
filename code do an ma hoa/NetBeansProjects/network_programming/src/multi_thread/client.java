/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multi_thread;
import java.io.*;
import java.net.*;

 
public class client {

    public static void main(String []args) throws IOException{  
        Socket ClientSocket = new Socket("localhost", 8888); 
        System.out.println("Kết nối thành công!");
        //Tạo luồng nhận dữ liệu từ bàn phím
        DataInputStream inFromUser = new DataInputStream(System.in); 
        //Tạo luồng nhận dữ liệu từ Server
     DataInputStream inFromServer = new DataInputStream(ClientSocket.getInputStream()); 
    //Tạo luồng gửi dữ liệu lên Server
        DataOutputStream outToServer = new DataOutputStream(ClientSocket.getOutputStream()); 
        while(true){
            try{ 
                System.out.println("\nClient: ");
                //Nhập dữ liệu nhập từ bàn phím rồi gửi lên Server
                String ask = inFromUser.readLine(); 
                outToServer.writeBytes(ask+"\n");
                //Đọc dữ liệu Server gửi về rồi in ra
                String listen=inFromServer.readLine();
                System.out.println("\nServer: "+listen);
            }
            catch(UnknownHostException e) { 
                System.err.println("Không tìm thấy máy chủ"); 
                System.exit(1); 
            }
            catch(IOException e){ 
                System.err.println("Không thể kết nối với máy chủ"); 
                System.exit(1); 
            }
       }
    }   
}
