/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package getip;
 import java.net.*;
/**
 *
 * @author admin
 */
public class getip {
    
public static void main (String[] args) {
InetAddress address_local=null;
getip get1=new getip();
address_local=get1.getip();

}

    public InetAddress getip(){
      InetAddress address=null;  
        try {
    address= InetAddress.getLocalHost( );
    System.out.println(address);
        }
    catch (UnknownHostException ex) {
    System.out.println("Could not find this computer's address.");
    }
        return address;

     }

    
}


