package test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class NewClass{
public static void main(String[] args) {
   
    try {
    Socket theSocket = new Socket("java.sun.com", 80);
    InetAddress host = theSocket.getInetAddress( );
    System.out.println("Connected to remote host " + host);
    } // end try
    catch (UnknownHostException ex) {
    System.err.println(ex);
    }
    catch (IOException ex) {
    System.err.println(ex);
    }

 }
}