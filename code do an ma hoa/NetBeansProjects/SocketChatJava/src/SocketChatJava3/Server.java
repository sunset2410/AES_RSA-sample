
package SocketChatJava3;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame {
    
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;
    
    //ham main;
    public static void main(String[] args) {
        Server sk =new Server();
        sk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sk.startRunning();      
    }
    
   // constructure;
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
      
   // startRunning;
   public void startRunning(){
        
        try{
            server =new ServerSocket(6789,100);  
            while(true){
                try{
                    
                   waitForConnection();
                   setupStreams();
                   whileChatting();
                
                }catch(EOFException eofe){
                    showMessage("\n Server Ended connection");            
                }finally{
                    
                    closeCrap();                }
            
            }
            
        }catch(IOException ie){
            
            ie.printStackTrace();
        }
            
    }
    
    
    //wait for connection;
    private void  waitForConnection() throws IOException{
           
      showMessage("waitting For someone to connect \n");
           
      connection  =server.accept();
      showMessage("Now Connected"+ connection.getInetAddress().getHostName() );           
           
    }

    
   //setupstream;
    private void setupStreams() throws IOException{
        
       output =new ObjectOutputStream(connection.getOutputStream());
       
       output.flush();
       input=new ObjectInputStream(connection.getInputStream());
       showMessage("\n Streams are now setup " );
       
             
    }

   //while chatting;
    private void whileChatting() throws IOException{
        
      String message =" you are Connected";
      sendMessage(message);
      ableToType(true);
      do{
         try{
             
             message=(String)input.readObject();
             showMessage("\n "+message );
         }catch(ClassNotFoundException cnfe){
             
             showMessage("I dont know whatuser send ");
         } 
          
      }while(!message.equals("SERVER - END"));          
      
    }

    
    private void closeCrap(){
        
        showMessage("\n closing connection...\n");
        ableToType(false);
        
        try{
           output.close();
           input.close();
           connection.close();
           
        }catch(IOException ie){
            
           ie.printStackTrace();
        }
     }
    
    // send a message to client
    private void sendMessage(String message){
        
       try{
           
         output.writeObject("SERVER - "+message);
         output.flush();
         showMessage("\n SERVER - "+message);          
          
       }catch(IOException ie){
           
           chatWindow.append("i cant send message");
       } 
             
    }
    
    //update chat window
    private void showMessage(final String text){
        SwingUtilities.invokeLater(         
        new Runnable(){
        public void run(){
           chatWindow.append(text);  
              }       
          }                      
        );
        
      }
    
     private void ableToType(final boolean tof){
        SwingUtilities.invokeLater(         
        new Runnable(){
        public void run(){
           userText.setEditable(tof);
              }       
          }                      
        );
        
      }
    
    
    
}
