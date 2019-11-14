/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multi_thread;
import java.io.*;
import java.net.*;
public class server {

    public static void main(String[] args) {

        try{

            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Khởi chạy máy chủ thành công");
            while(true){
                //Tạo Thread mới khi có 1 Client kết nối thành công
                new ThreadSocket(serverSocket.accept()).start();
                System.out.println("Có 1 kết nối đến");
            }
        }

        catch(IOException e){

            System.out.println("Exception: " +e.getMessage());

        }
    }
}
