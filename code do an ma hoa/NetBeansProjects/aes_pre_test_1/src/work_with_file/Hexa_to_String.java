/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package work_with_file;

/**
 *
 * @author chieu
 */
public class Hexa_to_String {
    
    public static void main(String[] args) {
       String str="";
       int[] cipher = {0xfffd,0x62,0x63,0x18,0x64}; 
       str=hexa_to_string(cipher);
       System.out.println("chuoi hexa dau vao la:");
       for(int i=0;i<cipher.length;i++){
           System.out.print(cipher[i]+" ");
       }
               
       System.out.println("\n day chuoi ki tu ung voi day hexa dau vao :");
       System.out.println(str);
    }
    
    
    // Phuong Thuc chuyen Tu Hexa Sang String
    public static String hexa_to_string(int[] cipher) {
        
        String str ="";
        int i;
        for(i=0;i<cipher.length;i++){
          // short value;
          // value=(short)cipher[i];
          //char ch=(char)value;
          char ch=(char)cipher[i];
            
           str=str+ch;
           //System.out.print(ch);
           // System.out.println((int)'A');
           // System.out.println((char)65);
        }
       return str; 
    }
    
    
}
