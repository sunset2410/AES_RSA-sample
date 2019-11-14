/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class JServer extends javax.swing.JFrame {

    private ServerSocket server_socket;
    public Hashtable<String, ClientConnect> listUser;// chua danh sach cac user;
    /**
     * Creates new form JServer
     */
    
    // ham khoi tao cua class;
    public JServer() {
        initComponents();
        setVisible(true);
        user_area.setEditable(false); //set cho khong the sua duoc user_area
        user_area.append("Máy chủ đã được mở.\n");
    }

    
    // ham go tao danh sach nguoi dung va accept Socket;
	private void go(){
		try {
			listUser = new Hashtable<String, ClientConnect>(); //tao list chua cac clientConnect cua cac user
			server_socket = new ServerSocket(1991); //tao serversocket voi cong chon la 1991;
			user_area.append("Máy chủ bắt đầu phục vụ\n"); //thong bao may chu mo tren user_area;
                        // tao vong lap lang nghe va chap nhan ket noi tu client;
			while(true){
				Socket socket_client = server_socket.accept(); // chap nhan ket noi serversocket;
				ClientConnect clientconnect = new ClientConnect(this,socket_client); //tao 1 ket noi moi
			}
		} catch (IOException e) {
                        user_area.append("Không thể khởi động máy chủ\n"); // bat loi;
		         }
	   }
	
        
        
         // gui tin nhanh tu from voi noi dung la msg;
	public void sendAll(String from, String msg){
		Enumeration e = listUser.keys(); // lay danh sach tat ca cac key trong list user;
		String name=null;
		while(e. hasMoreElements()){
			name=(String) e.nextElement();
			//lay ten tu hastable neu name != from thi moi gui;nghia la khong gui cho from;
			if(name.compareTo(from)!=0) listUser.get(name).sendMSG("3",msg); //gui duoi dinh dang hien thi tren cua so chat;
		}
	}
        
        //ham thuc hien gui dang dach online cho cac client;
	public void sendAllUpdate(String from){
		Enumeration e = listUser.keys();
		String name=null;
                String all_name =getAllName();
		while(e. hasMoreElements()){
			name=(String) e.nextElement();
			//kiem tra neu name khac from thi gui cho name;
                        
			if(name.compareTo(from)!=0) listUser.get(name).sendMSG("4",all_name); // gui duoi dang hien thi tren cua so online;
		}
	}
	
        // lay tat ca  danh sach key cua hast table;danh sach nay duco luu toan bo trong name de chuan bi gui ;
	public String getAllName(){
		Enumeration e = listUser.keys();
		String all_name="";
		while(e. hasMoreElements()){
		all_name+=(String) e.nextElement()+"\n";
		}
		return all_name;
	}

        
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        close_bt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        close_bt.setText("Close Server");
        close_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btActionPerformed(evt);
            }
        });

        user_area.setColumns(20);
        user_area.setRows(5);
        jScrollPane1.setViewportView(user_area);

        jLabel1.setText("Chat Room Server");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(close_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(close_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void close_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btActionPerformed
         try {
                //gởi tin nhắn tới tất cả client
                server_socket.close();
		System.exit(0);
	    } catch (IOException e1) {
		e1.printStackTrace();
		}                       
         
    }//GEN-LAST:event_close_btActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       JServer server1=new JServer();
       server1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       server1.go(); // chay phuong thucserver1.go(); go() cua doi tuong kieu Server;
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close_bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea user_area;
    // End of variables declaration//GEN-END:variables
}