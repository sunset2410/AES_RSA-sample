/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package work_with_file;

/**
 *
 * @author chieu
 */
public class Chose_Text {
    
    // ham main de test;
    public static void main(String[] args) {
        String input,output;
        input="tran_chieu_sinh_vien_dt12k54_hjk1234567891011121a"; //chuoi co 3 chuoi con;
        System.out.println(input);
        output=chose_array_string(input,3);
        System.out.println(output);
    }
    
    // Phuong Thuc chon tung chuoi 16 ki tu tu chuoi dau vao co do dai bat ki;
    public static String chose_array_string(String input,int i){
        
       String text16 ="";
       int leng_text,sochuoicon,a,delta;     
       leng_text = input.length();
       a=leng_text%16;
       sochuoicon=(a==0)?(leng_text/16):((leng_text/16)+1);
       delta =16-a;//chua so ki tu phai cho them khi thieu;
       
       if(a==0)
       {
       text16=input.substring(i*16, i*16+16);
       }
       
       if((a!=0)&&(i<sochuoicon-1)){
           text16=input.substring(i*16, i*16+16);
       }
       
       if((a!=0)&&(i==sochuoicon-1)){
           
           text16=input.substring(i*16);
          int j;
           for(j=1;j<=delta;j++){
               
              text16=text16+" ";  
           // text16=text16+'!';   
           }
           
       }
       
       // System.out.println("a="+a+"  sochuoicon="+sochuoicon+"delta="+delta);
       return text16;
   }

    
}