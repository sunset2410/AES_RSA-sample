package JServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClientConnect extends Thread {
	public Socket socket_client; // socket;
	public JServer server; // server khai bao 1 the hien cua class jserver;
	private String nickName,pass;  // nickname;
	private DataOutputStream dos; // dataouputstream;
	private DataInputStream dis;  //datainputstream;
	private boolean run_flag;
        //
        private Statement st=null;
        private ResultSet rs=null;
        public  Connection conn;
	
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
                    pass=getMSG();//lay pass de kiem tra;
                    // kiem tra neu nickname =0 thi logout; thuc ra không cần vì phía client truoc khi gui da kiem tra rui
                    if(nickName.compareTo("0")==0){ 
			logout();
			}
                    else {
                        //kiem tra xem trong list user da co key nao ten la nick hay chua ham se tra ve true( neu da co nick nay rui) va false (neu chua ton tai);
			if(checkNickOnLine(nickName)){ // nick nay da co rui.
				sendMSG("0"); // gui thong bao nick da co gui dung de ben client biet va khong cho dang nhap;
                                }
                        else if(checkNickOnSQL(nickName,pass)){  //nick co the su dung va cho ket noi;
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
                                            case 2://client muon nho server kiem tra nick chat rieng;    
                                                msg = getMSG();//lay nickchatrieng tu socket;
                                                if(checkNickOnLine(msg))  sendMSG("11"," "," ");// 11 la ton tai online;    
                                                if(!checkNickOnLine(msg)) sendMSG("12"," "," ");//12 la khong ton tai tren danh sach online;                                    
                                                break;                                           
                                            case 3://client chi muon gui cho 1 nguoi duy nhat;
                                                String to=getMSG();
                                                String message=getMSG();
                                                String from=nickName;
                                                server.listUser.get(to).sendMSG("7",nickName,message);                                    
                                                break;
                                            case 13:
                                                // server nhan va gui pass di;
                                               String a=getMSG();//lay dia chi nguoi can gui;
                                               String key=getMSG();
                                               server.listUser.get(a).sendMSG("14",nickName,key); 
                                               //nhan va gui tin nhan;
                                               String b=getMSG();//lay ki tu 3;
                                               String c=getMSG();//lay yourname
                                               String d=getMSG();//lay noi dung cua message;
                                               server.listUser.get(c).sendMSG("7",nickName,d); 
                                               break;
                                            case 15:
                                               String a1= getMSG();
                                               String a2=getMSG();
                                               server.listUser.get(a2).sendMSG("16",nickName," ");  
                                               break;
                                            case 20:
                                                //----------recieve file-------------------- 
                                                String topeople=getMSG();
                                                String filename=getMSG();//lay ten dinh dang file;
                                                int size=getMSG_int(); //lay kich thuoc file;
                                                int[] array=new int[size];
                                                for(int i=0;i<size;i++){
                                                    array[i]=getMSG_int();
                                                   } 
                                                server.listUser.get(topeople).sendMSG("21",nickName,filename);
                                                server.listUser.get(topeople).sendMSG_int(size);
                                                for(int i=0;i<size;i++){
                                                server.listUser.get(topeople).sendMSG_int(array[i]);
                                                   } 
                                               break;
                                                
						}
					}
                                        // end while;
                                
                                
				}else{
                                sendMSG("0");
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
	private boolean checkNickOnLine(String nick){
	       return server.listUser.containsKey(nick);	
	}
        
    private boolean checkNickOnSQL(String nick,String pass){
            boolean kq=false;
        try {        
            String url = "sun.jdbc.odbc.JdbcOdbcDriver";   
            Class.forName(url); //khia bao driver;
            conn=DriverManager.getConnection("jdbc:odbc:DBSJ","","");
            st=conn.createStatement();
            String sql= "select * from thongtintaikhoan where username= '"+nick+"' and password ='"+pass+"' ";
            rs=st.executeQuery(sql); 
           if(rs!=null){
            if(rs.next()){
                kq=true;
            }else{
                kq=false;
              }        
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
            
            return kq;
        }
        
         //ghi du lieu kieu int;
        private void sendMSG_int(int data){
		try {
			dos.writeInt(data);
			dos.flush();
		    } catch (IOException e) {
			e.printStackTrace();
		        }
	         }
        // nhan du lieu kieu int;
        public int getMSG_int(){
		int data=0;
		try {
			data=dis.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
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
        
        
        
         // send ca kieu mesage va noi dung chat;ham nay dua tren ham tren sendMSG;day la ham sendMSG 2 tham so dau vao;
	public void sendMSG(String title,String from,String msg){
		sendMSG(title);
		sendMSG(from);
		sendMSG(msg);
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
		sendMSG("5",name,"");
		
	}
}
