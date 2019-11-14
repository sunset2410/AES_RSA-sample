/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClientAES_swing;

import JClientAES_other_file.decoding;
import JClientAES_other_file.coding;
import JClientAES_Work_With_Image.GiaiMaAnh;
import JClientAES_Work_With_Image.MaHoaAnh;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import JClientAES_work_with_file.Doc_Ghi_File_Text;
import JClientAES_work_with_file.GiaiMaText;
import JClientAES_work_with_file.MaHoaText;
/**
 *
 * @author chieu
 */
public class swingAES extends javax.swing.JFrame {
    //thuoc tinh
        String path_name_key,path_name_input,path_name_output;
    /**
     * Creates new form swingAES
     */
    public swingAES() {
        initComponents();
        // xac dinh vi tri cho form;
        setLocation(300,10);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonGroup7 = new javax.swing.ButtonGroup();
        panel1 = new java.awt.Panel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        txt_Key = new javax.swing.JTextField();
        btn_Key = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_Input = new javax.swing.JButton();
        txt_Input = new javax.swing.JTextField();
        txt_Output = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_mahoa = new javax.swing.JButton();
        btn_giaima = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_Output = new javax.swing.JButton();
        label3 = new java.awt.Label();
        rd_other_file = new javax.swing.JRadioButton();
        rd_text = new javax.swing.JRadioButton();
        rd_image = new javax.swing.JRadioButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(51, 255, 102));

        label1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 0, 204));
        label1.setText("HA NOI UNIVERSITY OF SCIENCE AND TECHNOLOGY");

        label2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 0, 204));
        label2.setText("ADVANCED ENCRYPT STANDARD");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/JClientAES_swing/BKHNICON.PNG"))); // NOI18N
        jLabel1.setText("jLabel1");

        btn_Key.setBackground(new java.awt.Color(255, 255, 255));
        btn_Key.setForeground(new java.awt.Color(255, 0, 51));
        btn_Key.setText("....");
        btn_Key.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KeyActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Key");

        btn_Input.setForeground(new java.awt.Color(255, 0, 0));
        btn_Input.setText("....");
        btn_Input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InputActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Output");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Input");

        btn_mahoa.setForeground(new java.awt.Color(255, 0, 51));
        btn_mahoa.setText("MÃ HÓA");
        btn_mahoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mahoaActionPerformed(evt);
            }
        });

        btn_giaima.setForeground(new java.awt.Color(255, 0, 0));
        btn_giaima.setText("GIẢI MÃ");
        btn_giaima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_giaimaActionPerformed(evt);
            }
        });

        btn_reset.setForeground(new java.awt.Color(255, 0, 51));
        btn_reset.setText("RESET");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_exit.setForeground(new java.awt.Color(255, 0, 0));
        btn_exit.setText("EXIT");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        btn_Output.setForeground(new java.awt.Color(255, 0, 51));
        btn_Output.setText("....");
        btn_Output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OutputActionPerformed(evt);
            }
        });

        label3.setText("label3");

        buttonGroup7.add(rd_other_file);
        rd_other_file.setText("other file");

        buttonGroup7.add(rd_text);
        rd_text.setText("text");

        buttonGroup7.add(rd_image);
        rd_image.setText("image");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txt_Input, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                                    .addComponent(txt_Output)
                                                    .addComponent(txt_Key, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(18, 18, 18)
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(btn_Input, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                                    .addComponent(btn_Output, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btn_Key, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                                .addGap(8, 8, 8))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(btn_mahoa)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                                .addComponent(btn_giaima)
                                                .addGap(26, 26, 26)
                                                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(93, 93, 93))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rd_image)
                                    .addComponent(rd_text)
                                    .addComponent(rd_other_file))))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Key, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Key, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Input, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Output, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Output, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(rd_image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mahoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_giaima, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rd_text, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rd_other_file)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_KeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KeyActionPerformed

        
        // TODO add your handling code here:
        JFileChooser chooser=new  JFileChooser();
        int choose=-1;
        chooser.setDialogTitle("Open File");
        choose = chooser.showOpenDialog(null);
        
        if(choose==JFileChooser.APPROVE_OPTION){
            //khai bao file duoc chon;
            File file=chooser.getSelectedFile();
            
             //lay duong dan cua file;
            path_name_key= file.getPath();
            txt_Key.setText(path_name_key);
           // txt_Key.setText("C:\\Users\\chieu\\Desktop\\str_input.txt");
            
            
         }
       
        
        
    }//GEN-LAST:event_btn_KeyActionPerformed

    private void btn_InputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InputActionPerformed
        // TODO add your handling code here:        
        JFileChooser chooser=new  JFileChooser();
        int choose=-1;
        chooser.setDialogTitle("Open File");
        choose = chooser.showOpenDialog(null);
        
        if(choose==JFileChooser.APPROVE_OPTION){
            //khai bao file duoc chon;
            File file=chooser.getSelectedFile();
            
            
             //lay duong dan cua file;
            path_name_input= file.getPath();
            txt_Input.setText(path_name_input);
            
         }    
    }//GEN-LAST:event_btn_InputActionPerformed

    
    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_mahoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mahoaActionPerformed
           
      if(rd_image.isSelected()){
            // ma hoa anh
           try{
                String path_key = txt_Key.getText();
                String path_input = txt_Input.getText();
                String path_output = txt_Output.getText();    
                
                MaHoaAnh.mahoaanh(path_input, path_output, path_key);
                JOptionPane.showMessageDialog(null,"Mã Hóa Ảnh Thành Công");
           }catch(Exception e)
           {
               
               JOptionPane.showMessageDialog(null,"Không Mã Hóa Được!");
           }
          
            }
            
          //------------------------  
        if(rd_text.isSelected()){
            
            try{
                // ma hoa text;
                String str1 = txt_Key.getText();
                String str2 = txt_Input.getText();
                String str3 = txt_Output.getText();
                String str_key, str_input, str_output = "";

                str_key = Doc_Ghi_File_Text.DocFile(str1); //chuoi chua key dau vao;
                str_input = Doc_Ghi_File_Text.DocFile(str2);
                System.out.println("Chuoi truoc khi ma hoa la:" + str_input);
                str_output = MaHoaText.MaHoaText(str_key, str_input);
                //ghi chuoi da duoc  ma hoa vao file str_output.txt;
                System.out.println("Chuoi sau khi ma hoa la:" + str_output);
                
                //thay doi ki tu \n thanh \r\n trong chuoi sau ma hoa de ghi file
                String str_out = str_output.replaceAll("\n", "\r\n"); 
                Doc_Ghi_File_Text.GhiFile(str_out, str3);// ghi chuoi da  ma hoa vao file str_output.txt;
                JOptionPane.showMessageDialog(null,"Mã Hóa Text Thành Công");
                
                }catch(Exception e)
                {
                 JOptionPane.showMessageDialog(null,"Không Mã Hóa Được!");   
                }
                
            } 
          
          //------------------------
        if(rd_other_file.isSelected()){
            
            try{
                String path_key = txt_Key.getText();
                String path_input = txt_Input.getText();
                String path_output = txt_Output.getText(); 
                coding.coding(path_input, path_output, path_key);
                JOptionPane.showMessageDialog(null,"Mã Hóa File Thành Công");
            }
            catch(Exception e){
                
                JOptionPane.showMessageDialog(null, "Không Mã Hóa Được!");
            }
            
        }  
          
          
    }//GEN-LAST:event_btn_mahoaActionPerformed

    private void btn_giaimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_giaimaActionPerformed
        
        if(rd_image.isSelected()){
            
            try{
                // giai ma anh;
                String path_key = txt_Key.getText();
                String path_input = txt_Input.getText();
                String path_output = txt_Output.getText();   
                GiaiMaAnh.giaimaanh(path_input, path_output, path_key);
                JOptionPane.showMessageDialog(null,"Giải Mã Ảnh Thành Công");
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(null,"Không Giải Mã Được!");
                }
                
            }
        
        //--------------------
        if(rd_text.isSelected()){
            
            try{
            // giai ma text;
                String str1 = txt_Key.getText();
                String str2 = txt_Input.getText();
                String str3 = txt_Output.getText();   
                String str_key, str_input, str_output = "";

        //doc chuoi text tu file txt;
        str_key = Doc_Ghi_File_Text.DocFile(str1); //chuoi chua key dau vao;
        str_input = Doc_Ghi_File_Text.DocFile(str2);
        System.out.println("chuoi truoc khi giai ma la:" + str_input);
        // goi phuong thuc giai ma;
        str_output = GiaiMaText.GiaiMaText(str_key, str_input);
        //ghi chuoi da duoc  giai ma vao file str_output.txt;
        System.out.print("chuoi sau khi giai ma la:" + str_output);
        
        //thay doi ki tu \n thanh \r\n trong chuoi sau giai ma de ghi file
        String str_out = str_output.replaceAll("\n", "\r\n"); 
        Doc_Ghi_File_Text.GhiFile(str_out, str3);// ghi chuoi da giai ma vao file str_output.txt;
        JOptionPane.showMessageDialog(null,"Giải Mã Text Thành Công");
        
         }catch(Exception e){
             
           JOptionPane.showMessageDialog(null,"Không Giải Mã Được!");  
         }
        
        }
        
       //--------------- 
        
        if(rd_other_file.isSelected()){
            
                try{
                String path_key = txt_Key.getText();
                String path_input = txt_Input.getText();
                String path_output = txt_Output.getText(); 
                decoding.decoding(path_input, path_output, path_key);
                JOptionPane.showMessageDialog(null,"Giải Mã Thành Công");
                
            }
            catch(Exception e){
                
                JOptionPane.showMessageDialog(null, "Không Giải Mã Được!");
            }
            
                              
                
        }
        
        
        
        
    }//GEN-LAST:event_btn_giaimaActionPerformed

    private void btn_OutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OutputActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser=new  JFileChooser();
        int choose=-1;
        chooser.setDialogTitle("Save File");
        choose = chooser.showSaveDialog(null);
        
        if(choose==JFileChooser.APPROVE_OPTION){
            //khai bao file duoc chon;
            File file=chooser.getSelectedFile();
            
            
             //lay duong dan cua file;
            path_name_output= file.getPath();
            txt_Output.setText(path_name_output);
            
         }
        
        
        
    }//GEN-LAST:event_btn_OutputActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        
        txt_Key.setText("");
        txt_Input.setText("");
        txt_Output.setText("");
        
    }//GEN-LAST:event_btn_resetActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(swingAES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(swingAES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(swingAES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(swingAES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new swingAES().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Input;
    private javax.swing.JButton btn_Key;
    private javax.swing.JButton btn_Output;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_giaima;
    private javax.swing.JButton btn_mahoa;
    private javax.swing.JButton btn_reset;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Panel panel1;
    private javax.swing.JRadioButton rd_image;
    private javax.swing.JRadioButton rd_other_file;
    private javax.swing.JRadioButton rd_text;
    private javax.swing.JTextField txt_Input;
    private javax.swing.JTextField txt_Key;
    private javax.swing.JTextField txt_Output;
    // End of variables declaration//GEN-END:variables
}
