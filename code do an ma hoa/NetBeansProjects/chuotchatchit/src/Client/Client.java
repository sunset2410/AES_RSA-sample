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
import java.net.UnknownHostException;

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
    private JPanel p_login,p_chat;
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
		exit_bt = new JButton("Thoát"); //
		exit_bt.addActionListener(this);
		send_bt = new JButton("Gởi");
		send_bt.addActionListener(this);
		clear_bt = new JButton("Xóa");
		clear_bt.addActionListener(this);
		login_bt= new JButton("Đăng nhập");
		login_bt.addActionListener(this);
		logout_bt= new JButton("Thoát");
		logout_bt.addActionListener(this);
		
		p_chat = new JPanel();
		p_chat.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jtf_nick = new JTextField(20);
		p1.add(new JLabel("Níck chát : "));
		p1.add(jtf_nick);
		p1.add(exit_bt);
		
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
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.add(new JLabel("Tin nhắn"));
		jtf_message = new JTextField(30);
		p3.add(jtf_message);
		p3.add(send_bt);
		p3.add(clear_bt);
		
		p_chat.add(new JScrollPane(msg_area),BorderLayout.CENTER);
		p_chat.add(p1,BorderLayout.NORTH);
		p_chat.add(p2,BorderLayout.EAST);
		p_chat.add(p3,BorderLayout.SOUTH);
		p_chat.add(new JLabel("     "),BorderLayout.WEST);
		
		p_chat.setVisible(false);
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
			client_sk = new Socket("localhost",1991);
			dos=new DataOutputStream(client_sk.getOutputStream());
			dis=new DataInputStream(client_sk.getInputStream());
		
			//client.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Lỗi kết nối, xem lại mạng hoặc room chưa mở.","Message Dialog",JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		             }
	                 }
	// phuong thuc main;
	public static void main(String[] args) {
		new Client().go();
	}
        
        // ghi du lieu va data output sream;
	private void sendMSG(String data){
		try {
			dos.writeUTF(data);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		        }
	            }
        
        // nhan du lieu tu data input stream;
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
		int stt = Integer.parseInt(msg1);
		switch (stt) {
		// tin nhắn của những người khác; hien thi then tin nhan cua nhung client vua gui;
		case 3:
			this.msg_area.append(msg2);
			break;
		// update danh sách o phan nhung client online
		case 4:
			this.online_area.setText(msg2);
			break;
		// server đóng cửa
		case 5:
			dataStream.stopThread();
			exit();
			break;
		// bổ sung sau
		default:
			break;
		}
	}
        
        
//----------------------------------------------
	private void checkSend(String msg){
		if(msg.compareTo("\n")!=0){
			this.msg_area.append("Tôi : "+msg);
			sendMSG("1");
			sendMSG(msg);
		}
	}
        //kiem tra dang nhap;
	private boolean checkLogin(String nick){
		if(nick.compareTo("")==0)
			return false;
		else if(nick.compareTo("0")==0){
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
        //
        
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit_bt){
			dataStream.stopThread();
			exit();
		}
		else if(e.getSource()==clear_bt){
			jtf_message.setText("");
		}
		else if(e.getSource()==send_bt){
			checkSend(jtf_message.getText()+"\n");
			jtf_message.setText("");
		}
		else if(e.getSource()==login_bt){
			if(checkLogin(jtf_nick1.getText())){
				p_chat.setVisible(true);
				p_login.setVisible(false);
				jtf_nick.setText(jtf_nick1.getText());
				jtf_nick.setEditable(false);
				this.setTitle(jtf_nick1.getText());
				msg_area.append("Đã đăng nhập thành công\n");
				dataStream = new DataStream(this, this.dis);
			}
			else{
				JOptionPane.showMessageDialog(this,"Đã tồn tại níck này trong room, bạn vui lòng nhập lại.","Message Dialog",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource()==logout_bt){
			exit();
		}
	}


}
