
package SocketChatJava2;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Server extends JFrame {
    
    private JTextField userText;
    private JTextArea chatWindow;
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private static ServerSocket server;
    private static Socket connection;
    
    //ham main;
    public static void main(String[] args) throws IOException {
        Server sk =new Server();
        sk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        server =new ServerSocket(6789,100);  
           
        while(true){   
         try{
        //wait for connection;     
        sk.showMessage("waiting For someone to connect \n");      
        connection  =server.accept();
        sk.showMessage("Now Connected by"+ connection.getInetAddress().getHostName() );
                
        //setupstream;
        output =new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input=new ObjectInputStream(connection.getInputStream());
        sk.showMessage("\n Streams are now setup " );
       
        //while chatting;
        String message =" you are Connected ";
        sk.sendMessage(message);
        do{         
          message=(String)input.readObject();
          sk.showMessage("\n "+message );    
         }while(true); 
        
         }catch(Exception e){
            e.printStackTrace();
        }finally{ 
          sk.showMessage("\n closing connection...");
          output.close();
          input.close();
          connection.close();
           
          }  
     }
    
 }  
    
   
    
   // ham khoi tao cho doi tuong server;
   public Server(){
       super("Phần Mềm Chát - Phía Server");
       userText=new JTextField();
       userText.setEditable(true);
       userText.addActionListener(               
       new  ActionListener(){           
       public void actionPerformed(ActionEvent e){    
       sendMessage(e.getActionCommand());
       userText.setText("");     
           }   
         }                   
       );              
      add(userText , BorderLayout.NORTH);
      chatWindow=new JTextArea();
      add(new JScrollPane(chatWindow));
      setSize(300,400);
      setVisible(true);   
    
    }
      
 
    // send a message to client
    private void sendMessage(String message){
        try {
            output.writeObject("SERVER - "+message);
            output.flush();          
            showMessage("\n SERVER - "+message);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    //ham hien thi mesage,udate chatwindow;
    private void showMessage(final String text){
        SwingUtilities.invokeLater(         
        new Runnable(){
        public void run(){
           chatWindow.append(text);  
              }       
          }                      
        );   
      }
  
    
}
