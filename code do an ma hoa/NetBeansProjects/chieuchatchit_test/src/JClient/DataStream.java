package JClient;
import java.io.DataInputStream;
import java.io.IOException;

public class DataStream extends Thread {
	private boolean runable; // bien co de xac dinh dung chuong trinh hay khong?;
	private DataInputStream dis;  //data input stream;
	private JClient client; // khai bao 1 the hien cua class Client;
	
        // ham khoi tao cua datastream co tham so dau vao la client va dis;
	public DataStream(JClient client,DataInputStream dis){
		this.runable=true;
		this.client=client;
		this.dis=dis;		
		this.start();
	}
        
        // viet lai phuong thuc run cua class thread duoc extends them vao;
        @Override
	public void run(){
		String msg1,msg2,msg3;
		while(runable){//runable ==true
			//lay du lieu ve mesage1 va mesage2;
			msg1=client.getMSG();  
			msg2=client.getMSG();
                        msg3=client.getMSG();
                        client.CheckChatRieng(msg1,msg2,msg3);// kiem tra co chat rieng hay khong?;
                        client.showMSG(msg1,msg2,msg3); //hien thi noi dung mesage len cua so chat hoac cua so onlien;
                        client.ShowMessageChatRieng(msg1, msg2, msg3);
                        client.ReceiveKey(msg1, msg2, msg3);
                        client.ResetKey(msg1, msg2);
                        client.UpdateKeyRSA(msg1, msg2);
                        client.ReceiveFile(msg1, msg2, msg3);
						  
		        }
                
                if(!runable){ // runable ==false;
                 try {
			dis.close();
		     } catch (IOException e) {
			e.printStackTrace();
		               }
                     }
	   }
        
        
        
        
        // phuong thuc dung Thread;
	public void stopThread(){
		this.runable=false;
	       }
        
}
