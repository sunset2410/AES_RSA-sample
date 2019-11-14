package Server;

import JServer.JServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnect extends Thread {
	public Socket socket_client; // socket;
	public Server server; // server khai bao 1 the hien cua class server;
	private String nickName;  // nickname;
	private DataOutputStream dos; // dataouputstream;
	private DataInputStream dis;  //datainputstream;
	private boolean run;
	
        //ham khoi tao gom tham so dau vao la server va client;
	public ClientConnect(Server server, Socket socket_client){
		try {
			this.server=server;
			this.socket_client=socket_client;
			dos= new DataOutputStream(socket_client.getOutputStream());//data output Stream voi socket client; 
			dis= new DataInputStream(socket_client.getInputStream()); // data input Stream cua socket client;
			run=true;
			this.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	     }

    public ClientConnect(JServer aThis, Socket client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
        
        // viet lai phuong thuc run cua class thread;
	public void run(){
		// xữ lý đăng nhập
		String msg=null;
		while(run){
                    nickName=getMSG(); // lay ten nick;
                    // kiem tra neu nickname =0 thi logout;
                    if(nickName.compareTo("0")==0){
			logout();
			}
                    else {
                        //kiem tra xem trong list user da co key nao ten la nick hay chua ham se tra ve true neu co va false neu chu co;
			if(checkNick(nickName)){ 
				sendMSG("0");
				}
			else{
				server.user_area.append(nickName+" đã kết nối với room\n"); //thong bao them client ket noi tren cua so server ;
				server.sendAll(nickName,nickName+" đã vào room \n");//gui cho cac client biet
				server.listUser.put(nickName, this);//add them nick vao listUser;
				server.sendAllUpdate(nickName);
				sendMSG("1");
				diplayAllUser();
                                
				while(run){
					int stt = Integer.parseInt(getMSG());
					switch(stt){
						case 0:
							run=false;
							server.listUser.remove(this.nickName);
							exit();
							break;
						case 1:
							msg = getMSG();
							server.sendAll(nickName,nickName+" : "+msg);
							break;
						}
					}
                                        // end while;
                                
                                
				}
			}
		}
	}
        
        
        // dong socket dong datainputstream va dataoutputstream;
	private void logout() {
		try {
			dos.close();
			dis.close();
			socket_client.close();
		} catch (IOException e) {
			e.printStackTrace();
		   }		
	     }
        
        // thong bao 1 client da thoat
	private void exit(){
		try {
			server.sendAllUpdate(nickName);
			dos.close();
			dis.close();
			socket_client.close();
			server.user_area.append(nickName+" đã thoát\n"); // thong bao tren cua so cua server;
			server.sendAll(nickName,nickName+" đã thoát\n");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
        
        //kiem tra xem trong list user da co key nao ten la nick hay chua ham se tra ve true neu co va false neu chu co;
	private boolean checkNick(String nick){
	       return server.listUser.containsKey(nick);	
	}
         
        // ghi du lieu dang String vao dataoutputstream;
	private void sendMSG(String data){
		try {
			dos.writeUTF(data);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	     }
        
        // send ca ten nick va noi dung chat;ham nay dua tren ham tren sendMSG;
	public void sendMSG(String msg1,String msg2){
		sendMSG(msg1);
		sendMSG(msg2);
	}
        
        
        // phuong thuc doc du lieu tu datainputstream;co kieu gia tri tra ve la string;  thuc chat day la ham lay du lieu;
	private String getMSG(){
		String data=null;
		try {
			data=dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	  }
        
        
        // lay tat ca  danh sach key cua hast table rui hien thi tat ca cac user
	private void diplayAllUser(){
		String name = server.getAllName();
		sendMSG("4");
		sendMSG(name);
	}
}
