/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketChatJava;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author admin
 */
public class Client extends JFrame {
    
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection; 
    private String message="";
    private String ip;
    
    
    public Client(String host){
        
        super("Client Susan IM");
        ip= host;
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
      add(new JScrollPane(chatWindow),BorderLayout.CENTER);
      setSize(300,400);
      setVisible(true);   
               
      } 
    
    public void startRunning(){
        try{
           connectToServer();
           setupStreams();
           whileChatting();
        
        }catch(EOFException eofe){            
        showMessage("client terminated connnection");
        } catch(IOException ie){
            
           ie.printStackTrace();
        }finally{
            closeCrap();       }      
        
    }  
    
    
    private void connectToServer() throws IOException{
        
      showMessage(" Attempting connection \n");
      connection =new Socket(InetAddress.getByName(ip),1234);
      showMessage("connect to "+connection.getInetAddress().getHostName());
    }
    
    
     private void setupStreams() throws IOException{
        
       output =new ObjectOutputStream(connection.getOutputStream());
       
       output.flush();
       input=new ObjectInputStream(connection.getInputStream());
       showMessage("\n stream are now good to go...");
       
             
       }

    
    private void whileChatting() throws IOException{
            
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
        
        showMessage("\n closing crap down...");
        ableToType(false);
        
        try{
           output.close();
           input.close();
           connection.close();
           
        }catch(IOException ie){
            
           ie.printStackTrace();
        }
     }
    
    //send message to server;
     private void sendMessage(String message){
        
       try{
           
         output.writeObject("CLIENT - "+message);
         output.flush();
         showMessage("\n CLIENT - "+message);          
          
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
    
    
    
    
    

