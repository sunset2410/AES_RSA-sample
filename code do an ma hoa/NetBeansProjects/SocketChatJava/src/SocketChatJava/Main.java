/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketChatJava;

import javax.swing.*;

/**
 *
 * @author admin
 */
public class Main {
    
    public static void main(String[] args){
        
        Object[] selectioValues={"Server","Client"};
        String initialSection="Server";
        Object selection = JOptionPane.showInputDialog(null,"Login as ","susan client server",JOptionPane.QUESTION_MESSAGE,null,selectioValues,initialSection );   
        if(selection.equals("Server")){
            Server susan =new Server();
            susan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            susan.startRunning();
            
                       
        }else if(selection.equals("Client")){ 
            String IPServer=JOptionPane.showInputDialog("enter ip ...");
            Client capsa =new Client(IPServer);
            capsa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            capsa.startRunning(); 
            
           
        }
        
        
    }
    
    
    
}
