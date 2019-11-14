package Server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server extends JFrame implements ActionListener{
	
	private JButton close_bt;
	public JTextArea user_area;
	private ServerSocket server_socket;
	public Hashtable<String, ClientConnect> listUser;// chua danh sach cac user;
	
        // ham khoi tao cho doi tuong Server;
	public Server(){
		super("Chat Room : Server");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				try {
					//gởi tin nhắn tới tất cả client
					server_socket.close();
					System.exit(0);
				    } catch (IOException e1) {
					e1.printStackTrace();
				         }
			      }	
		          });
		setSize(400, 400);
		addItem();
		setVisible(true);
	  }
	
        
        // ham addItem;them cac dieu khien vao form server;
	private void addItem() {
		setLayout(new BorderLayout());
		
		add(new JLabel("Trạng thái của server : \n"),BorderLayout.NORTH);
		//add(new JPanel(),BorderLayout.EAST);
		//add(new JPanel(),BorderLayout.WEST);
		
		user_area = new JTextArea(10,20);
		user_area.setEditable(false);
		add(new JScrollPane(user_area),BorderLayout.CENTER);
		
		close_bt = new JButton("Close Server");
		close_bt.addActionListener(this);
		add(close_bt,BorderLayout.SOUTH);

		user_area.append("Máy chủ đã được mở.\n");
	}
	
        // ham go tao danh sach nguoi dung va accept Socket;
	private void go(){
		try {
			listUser = new Hashtable<String, ClientConnect>();
			server_socket = new ServerSocket(1991);
			user_area.append("Máy chủ bắt đầu phục vụ\n");
			while(true){
				Socket client = server_socket.accept();
				new ClientConnect(this,client);
			}
		} catch (IOException e) {
                        user_area.append("Không thể khởi động máy chủ\n");
		         }
	}
	
        // phuong thuc main;
	public static void main(String[] args) {
		new Server().go();
	}

        
	public void actionPerformed(ActionEvent e) {
			try {
				server_socket.close();
			} catch (IOException e1) {
				user_area.append("Không thể dừng được máy chủ\n");
			}
			System.exit(0);
	           }
	
        
        // gui tin nhanh tu from voi noi dung la msg;
	public void sendAll(String from, String msg){
		Enumeration e = listUser.keys(); // lay danh sach tat ca cac key;
		String name=null;
		while(e. hasMoreElements()){
			name=(String) e.nextElement();
			//System.out.println(name);
			if(name.compareTo(from)!=0) listUser.get(name).sendMSG("3",msg);
		}
	}
        
	public void sendAllUpdate(String from){
		Enumeration e = listUser.keys();
		String name=null;
		while(e. hasMoreElements()){
			name=(String) e.nextElement();
			//System.out.println(name);kiem tra neu name khac from thi gui cho name;
			if(name.compareTo(from)!=0) listUser.get(name).sendMSG("4",getAllName());
		}
	}
	
        // lay tat ca  danh sach key cua hast table;danh sach nay duco luu toan bo trong name
	public String getAllName(){
		Enumeration e = listUser.keys();
		String name="";
		while(e. hasMoreElements()){
			name+=(String) e.nextElement()+"\n";
		}
		return name;
	}

}
