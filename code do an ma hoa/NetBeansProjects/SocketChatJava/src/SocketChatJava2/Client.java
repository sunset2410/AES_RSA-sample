
package SocketChatJava2;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame {
    
    private JTextField userText;
    private JTextArea chatWindow;
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private static ServerSocket server;
    private static Socket connection; 
    private static String message="";
    private static String ip;
    
    public static void main(String[] args) throws IOException {
       String IPServer=JOptionPane.showInputDialog("Nhập Địa Chỉ IP Của Server:");
       Client cl =new Client(IPServer);
       cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       try{
       //connect to server;
       cl.showMessage(" Attempting connection \n");
       connection =new Socket(InetAddress.getByName(ip),6789);
       cl.showMessage("connect to "+connection.getInetAddress().getHostName());
       //setup streams;
       output =new ObjectOutputStream(connection.getOutputStream());
       output.flush();
       input=new ObjectInputStream(connection.getInputStream());
       cl.showMessage("\n stream are now good to go...");
       // whileChatting;
           do{
             message=(String)input.readObject();
             cl.showMessage("\n "+message );
            }while(true); 
       }catch(Exception e){
           e.printStackTrace();
       }finally{
         cl.showMessage("\n closing crap down...");
         output.close();
         input.close();
         connection.close();
       }
           
  }
    
    
    // ham khoi tao;
    public Client(String host){
        
        super("Phần Mềm Chát - Phía Client");
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
    
      //update chat window; ham show mesage;
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
    
    
    
    
    

