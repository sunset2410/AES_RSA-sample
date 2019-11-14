/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClient;
import JClientAES_work_with_file.MaHoaText;
import JClientAES_work_with_file.GiaiMaText;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class Chatrieng extends javax.swing.JFrame {
   private String myname,yourname;
   private String mykey_aes;
   public String yourkey_aes;
   private BigInteger MyPrivateKeyRSA;
   public BigInteger MyPublicKeyRSA,YourPublicKeyRSA;
   boolean sendKeyAES=false,receiveKeyAES=false,receiveKeyRSA=false;
    /**
     * Creates new form Chatrieng
     */
    public Chatrieng(String myname,String yourname) {
        initComponents();
        //lay hai tham so gan cho bien cua class;
        this.myname=myname;
        this.yourname=yourname;
        this.setTitle("My Name Is "+this.myname  +". I'm Chatting With "+ this.yourname);
        this.message_area.setEditable(false);
        //tao khoa aes ngau nhien;
        Random_generator_key_aes rd =new Random_generator_key_aes();
        this.mykey_aes=rd.randomString(); 
        //lay public key va private tu form chung;
        MyPrivateKeyRSA=JClient.client.getprivateKey();
        MyPublicKeyRSA=JClient.client.getpublicKey();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_message = new javax.swing.JTextField();
        btn_send = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        message_area = new javax.swing.JTextArea();
        btn_thoat = new javax.swing.JButton();
        btn_sendfile = new javax.swing.JButton();
        btn_paths = new javax.swing.JButton();
        txt_path = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_send.setText("Send");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        message_area.setBackground(new java.awt.Color(255, 153, 204));
        message_area.setColumns(20);
        message_area.setRows(5);
        jScrollPane1.setViewportView(message_area);

        btn_thoat.setText("Thoát");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });

        btn_sendfile.setText("Send File");
        btn_sendfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendfileActionPerformed(evt);
            }
        });

        btn_paths.setText("...");
        btn_paths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pathsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_sendfile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_path)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_paths))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_message, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_send)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_thoat)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sendfile)
                    .addComponent(btn_paths)
                    .addComponent(txt_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_send)
                        .addComponent(btn_thoat)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JClient.client.listchatrieng.remove(this.yourname);// khi dong cua so chat rieng thi remove luon ten nguoi do di
        //thong bao cho  phia server cua so chat rieng bi dong;
        JClient.client.sendMSG("15",myname,yourname);//gui yeu cau thoat cho server;
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        tf_message.setText(""); // xoa noi dung chat;
        
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
        // TODO add your handling code here:
         //send key AES
        if(!sendKeyAES){
             JClient.client.sendMSG("13",yourname,this.mykey_aes);//gui pas cho server;
             this.message_area.append(this.myname+": My key aes is "+this.mykey_aes+"\n"); //hien thi tren cua so chat cua minh;
             sendKeyAES=true;
           }
        String message=tf_message.getText();
        String string_aes=MaHoaText.MaHoaText(this.mykey_aes,message);
        JClient.client.sendMSG("3",yourname,string_aes); //sendMSG(String title,String from,String to,String msg)
        this.message_area.append(this.myname+":"+message+"\n"); //hien thi tren cua so chat cua minh;
        tf_message.setText("");//xoa noi dung nhap van ban da duco gui di de nguoi dung nhap van ban moi;
    }//GEN-LAST:event_btn_sendActionPerformed

    private void btn_sendfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendfileActionPerformed
        // TODO add your handling code here:
        String path_name=txt_path.getText();
     if(!path_name.equals("")){
        FileInputStream fin;
        //----------------- open input file
            try {
                fin = new FileInputStream(path_name);
            } catch (FileNotFoundException exc) {
                JOptionPane.showMessageDialog(this,"Bạn chọn sai đường dẫn của file muốn gửi hoặc file không tồn tại");
                return;
            }
        //--------------kiem tra kich thuoc byte;-------------------
        File file = new File(path_name);
        String filename=file.getName();//lay ten dịnh dang file;
        int size =(int) file.length();
        int[] array =new int[size];
        //-------------------------- coppy noi dung file vao mang array---------------------
        int i;
        int j=0;
                  
        try {
            do {
                i = fin.read();
                if (i != -1) {
                    array[j]=i;
                    j++;
                    }
            } while (i != -1);
                
        } catch (IOException exc) {
            System.out.println("File Error");
        }
        
        //----------send file--------------------
        JClient.client.sendMSG("20",yourname,filename);// gui title vaf ten nguoi can gui;
        JClient.client.sendMSG_int(size);// gui kich thuoc file;
        for(i=0;i<size;i++){
        JClient.client.sendMSG_int(array[i]);
        } 
        try {
            fin.close();   
        } catch (IOException ex) {
            Logger.getLogger(JClient.class.getName()).log(Level.SEVERE, null, ex);
        }
      }//end if;
     else{
         JOptionPane.showMessageDialog(this,"Bạn chưa chọn đường dẫn của file muốn gửi");
        }
    }//GEN-LAST:event_btn_sendfileActionPerformed

    private void btn_pathsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pathsActionPerformed
        // TODO add your handling code here:
       //lay duong dan file can gui;
        String path_name="";
        JFileChooser chooser=new  JFileChooser();
        int choose=-1;
        chooser.setDialogTitle("Open File");
        choose = chooser.showOpenDialog(null);
        if(choose==JFileChooser.APPROVE_OPTION){
            File file=chooser.getSelectedFile();//khai bao file duoc chon;
            path_name= file.getPath();   //lay duong dan cua file;   
            txt_path.setText(path_name);
         }
    }//GEN-LAST:event_btn_pathsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_paths;
    private javax.swing.JButton btn_send;
    private javax.swing.JButton btn_sendfile;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea message_area;
    private javax.swing.JTextField tf_message;
    private javax.swing.JTextField txt_path;
    // End of variables declaration//GEN-END:variables
}
