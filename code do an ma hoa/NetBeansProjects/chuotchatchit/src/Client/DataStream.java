package Client;

import java.io.DataInputStream;
import java.io.IOException;

public class DataStream extends Thread {
	private boolean run; // bien co de xac dinh dung chuong trinh;
	private DataInputStream dis;  //data input stream;
	private Client client; // khai bao 1 the hien cua class Client;
	
        // ham khoi tao cua datastream co tham so dau vao la client va dis;
	public DataStream(Client client,DataInputStream dis){
		run=true;
		this.client=client;
		this.dis=dis;		
		this.start();
	}
        
        // viet lai phuong thuc run cua class thread duoc extends them vao;
	public void run(){
		String msg1,msg2;
		while(run){
			try {
				msg1=dis.readUTF();
				msg2=dis.readUTF();
				client.getMSG(msg1,msg2);
			} catch (IOException e) {
				e.printStackTrace();
			     }
		        }
		try {
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
        
        // phuong thuc dung Thread;
	public void stopThread(){
		this.run=false;
	     }
}
