package JServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnect extends Thread {
	public Socket socket_client; // socket;
	public JServer server; // server khai bao 1 the hien cua class jserver;
	private String nickName;  // nickname;
	private DataOutputStream dos; // dataouputstream;
	private DataInputStream dis;  //datainputstream;
	private boolean run_flag;
	
        //ham khoi tao gom tham so dau vao la server va client;
	public ClientConnect(JServer server, Socket socket_client){
		try {
			this.server=server;
			this.socket_client=socket_client;
                        // cai dat du lieu cho socket de nhan va gui;
			dos= new DataOutputStream(socket_client.getOutputStream());//data output Stream voi socket client; 
			dis= new DataInputStream(socket_client.getInputStream()); // data input Stream cua socket client;
			run_flag=true; // cho co gia tri true;
			this.start(); // khi start no se chay het cac lenh trong ham run rui thread tu huy;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	     }
        
        
        
        // viet lai phuong thuc run cua class thread;
	public void run(){
		// xữ lý đăng nhập;before chatting
		String msg=null;
		while(run_flag){
                    nickName=getMSG(); // lay ten nick ma phia client vua gui ;
                    // kiem tra neu nickname =0 thi logout; thuc ra không cần vì phía client truoc khi gui da kiem tra rui
                    if(nickName.compareTo("0")==0){ 
			logout();
			}
                    else {
                        //kiem tra xem trong list user da co key nao ten la nick hay chua ham se tra ve true( neu da co nick nay rui) va false (neu chua ton tai);
			if(checkNick(nickName)){ // nick nay da co rui.
				sendMSG("0"); // gui thong bao nick da co gui dung de ben client biet va khong cho dang nhap;
				}
			else{  //nick co the su dung va cho ket noi;
				server.user_area.append(nickName+" đã kết nối với server \n"); //thong bao them client ket noi tren cua so server ;
				server.sendAll(nickName,nickName+" đã vào server \n");//gui cho cac client biet
				server.listUser.put(nickName, this);//add them nick vao listUser;
				server.sendAllUpdate(nickName);//gui update danh sach online cho các client tru client co ten :nickname;
				sendMSG("10"); //gui xac nhan la nick hop le chi can gui 1 so khac o la dc;
				diplayAllUser();
                                //  while chatting;
				while(run_flag){
					int stt = Integer.parseInt(getMSG());
					switch(stt){
						case 0://neu mesage="0" thi chung to client do mun thoat nen ta se remove ra khoi list;
							run_flag=false;
							server.listUser.remove(this.nickName);
							exit(); //goi ham exit() de huy ket noi voi client nay dong thoi cac client khac update duoc danh sach online moi.
							break;
						case 1: //neu mesage="1" thi chung to client se tiep tuc gui tin nhan;ta lay tin nhan sau luu vao msg roi chuan bi gui cho tat ca;
                                                        //tru nguoi co ten clientconnect la nickname vi chinh nguoi nay vua gui cho server gui nen ta khong gui lai nua.
							msg = getMSG(); // lay noi dung tin nhan tu socket;
							server.sendAll(nickName,nickName+" : "+msg);// gui noi dung chat cho cac client khac tru client co ten nickname;
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
        
        // send ca kieu mesage va noi dung chat;ham nay dua tren ham tren sendMSG;
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
