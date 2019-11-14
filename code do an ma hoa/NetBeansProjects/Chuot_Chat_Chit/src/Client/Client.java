package Client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener{
    private JButton send_bt,clear_bt,exit_bt,login_bt,logout_bt;
    private JPanel p_login,p_chat; //p_login chua phan dang nhap va pchat chua cac dieu khine khi chat;
    private JTextField jtf_nick,jtf_nick1,jtf_message;
    private JTextArea msg_area,online_area;
    private Socket client_sk;
    private DataStream dataStream;
    private DataOutputStream dos;
    private DataInputStream dis;
    
    // ham khoi tao cho client;
	public Client(){
		super("Chat: Client");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				exit();
			}	
		});
		setSize(600, 400);
		addItem();
		setVisible(true);
	      }
        
        
        
//-----[ Tạo giao diện ]--------// tao dao dien bang add them cac dieu khien;
	private void addItem() {
		setLayout(new BorderLayout());	
                //nut thoat;
		exit_bt = new JButton("Thoát"); 
		exit_bt.addActionListener(this);
                //nut send
		send_bt = new JButton("Send");
		send_bt.addActionListener(this);
                //nut xoa;
		clear_bt = new JButton("Xóa");
		clear_bt.addActionListener(this);
                //nut dang nhap;
		login_bt= new JButton("Đăng nhập");
		login_bt.addActionListener(this);
                //nut Logout
		logout_bt= new JButton("Logout");
		logout_bt.addActionListener(this);
		
		p_chat = new JPanel();
		p_chat.setLayout(new BorderLayout());
                
		// tao p1 de luu label nick textfiled nick va button thoat;
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jtf_nick = new JTextField(20);
		p1.add(new JLabel("Nick chát:"));
		p1.add(jtf_nick);
		p1.add(exit_bt);
		
                // tao p2
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		
		JPanel p22 = new JPanel();
		p22.setLayout(new FlowLayout(FlowLayout.CENTER));
		p22.add(new JLabel("Danh sách online"));
		p2.add(p22,BorderLayout.NORTH);
		
		online_area = new JTextArea(10,10);
		online_area.setEditable(false);
		p2.add(new JScrollPane(online_area),BorderLayout.CENTER);
		p2.add(new JLabel("     "),BorderLayout.SOUTH);
		p2.add(new JLabel("     "),BorderLayout.EAST);
		p2.add(new JLabel("     "),BorderLayout.WEST);
		
		msg_area = new JTextArea(10,20);
		msg_area.setEditable(false);
		
                // tao p3 de chua label tin nhan, textfield message,send_bt va clear_bt;
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.add(new JLabel("Tin nhắn"));
		jtf_message = new JTextField(30);
		p3.add(jtf_message);
		p3.add(send_bt);
		p3.add(clear_bt);
		//---------------------------
		p_chat.add(new JScrollPane(msg_area),BorderLayout.CENTER);
		p_chat.add(p1,BorderLayout.NORTH);
		p_chat.add(p2,BorderLayout.EAST);
		p_chat.add(p3,BorderLayout.SOUTH);
		p_chat.add(new JLabel("     "),BorderLayout.WEST);		
		p_chat.setVisible(true); // ban dau khi chua dang nhap thi panel nay bi an di;
		add(p_chat,BorderLayout.CENTER);
		//-------------------------
		p_login = new JPanel();
		p_login.setLayout(new FlowLayout(FlowLayout.CENTER));
		p_login.add(new JLabel("Nick chát : "));
		jtf_nick1=new JTextField(20);
		p_login.add(jtf_nick1);
		p_login.add(login_bt);
		p_login.add(logout_bt);	
		add(p_login,BorderLayout.NORTH);
                
	}
        
        
//---------[ Socket ]-----------//	
	private void go() {
		try {
			client_sk = new Socket("localhost",1991);// tao socket ket noi toi host;
                        // set up luong du lieu tu socket;
			dos=new DataOutputStream(client_sk.getOutputStream());
			dis=new DataInputStream(client_sk.getInputStream());
		
			//client.close();
		   } catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Lỗi kết nối, xem lại mạng hoặc room chưa san sang.","Message Dialog",JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		             }
	         }
        
        
	// phuong thuc main;
	public static void main(String[] args) {
		Client client = new Client(); // khoi tao 1 the hien cu doi tuong client;
                client.go(); // thuc hien goi phuong thuc go() cua  doi tuong client;
	}
        
        // ghi du lieu va data output sream; thuc chat la gui du lieu vao socket; gui du lieu cho server;
	private void sendMSG(String data){
		try {
			dos.writeUTF(data);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		        }
	    }
        
        // nhan du lieu tu data input stream;thuc chat la lay du lieu tu server;lay du lieu tu socket
	private String getMSG(){
		String data=null;
		try {
			data=dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
        // nhan du lieu theo title va body;
	public void getMSG(String msg1, String msg2){
		int stt = Integer.parseInt(msg1); // ep kieu msg1 sang kieu integer de so sanh;
		switch (stt) {
		// tin nhắn của những người khác; hien thi then tin nhan cua nhung client vua gui;
		case 3:
			this.msg_area.append(msg2); // stt=3 hien thi len cua so chat;
			break;
		// update danh sách o phan nhung client online
		case 4:
			this.online_area.setText(msg2); //stt=4 hien thi len cua so online chat;
			break;
		// server đóng cửa
		case 5:
			dataStream.stopThread();  //stt=5 dong thread;
			exit();
			break;
		// bổ sung sau
		default:
			break;
		}
	}
        
        
//----------------------------------------------
	private void checkSend(String msg){
		if(msg.compareTo("\n")!=0){ //kiem tra message phai khac ki tu xuong dong;
			this.msg_area.append("Tôi : "+msg); //hien thi noi dung chat cua ban than va gui di;
			sendMSG("1");
			sendMSG(msg);
		}
	}
        
        
        //kiem tra dang nhap;
	private boolean checkLogin(String nick){
		if(nick.compareTo("")==0) //kiem tra nick phai khac rong;neu bang rong thi tra ve gia tri fasle;
			return false;
		else if(nick.compareTo("0")==0){ // neu nick bnag 0 cung tra ve gia tri false nen dang hap loi;
			return false;
		}
		else{
			sendMSG(nick);
			int sst = Integer.parseInt(getMSG());
			if(sst==0)
				 return false;
			else return true;
		      }
	         }

        //ham thoat;
	private void exit(){
		try {
			sendMSG("0");
			dos.close();
			dis.close();
			client_sk.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.exit(0);
	}
       
        
        
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit_bt){ //bat su kien an exit_bt;
			dataStream.stopThread();
			exit();
		}
		else if(e.getSource()==clear_bt){ //bat su kien an clear_bt;
			jtf_message.setText("");
		}
		else if(e.getSource()==send_bt){  // bat su kien an send_bt;
			checkSend(jtf_message.getText()+"\n");
			jtf_message.setText("");
		}
		else if(e.getSource()==login_bt){ // bat su kien an login_bt;dang nhap
			if(checkLogin(jtf_nick1.getText())){
				p_chat.setVisible(true); // hien panel chat;
				p_login.setVisible(true); // an panel dang nhap di;
				jtf_nick.setText(jtf_nick1.getText());
				jtf_nick.setEditable(true);
				this.setTitle(jtf_nick1.getText());
				msg_area.append("Đã đăng nhập thành công\n");
				dataStream = new DataStream(this, this.dis); // ham khoi tao cua datastream co tham so dau vao la client va dis;
                                // data_input_stream de nhan du lieu tu socket;
			}
			else{
				JOptionPane.showMessageDialog(this,"Đã tồn tại níck này trong room, bạn vui lòng nhập lại.","Message Dialog",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource()==logout_bt){ // bats u kien an nut logout;
			exit();
		}
	}
        


}
