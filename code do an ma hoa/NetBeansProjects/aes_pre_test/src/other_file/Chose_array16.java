/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package other_file;

/**
 *
 * @author chieu
 */
public class Chose_array16 {
    
    public static void main(String[] args) {
        
        int[] input={1,21,31,31,3,31,31,31,31,31,31,31,31,3,31,16,2,4,43,4,3,53,5,54,5,4,6,4,6,7,3,4,6,8,9};
        int[] array16=new int[16];
        array16=Chose_array16(input,0);
        
        for(int i=0;i<=15;i++){
            System.out.print(array16[i]+" ");
        }
        
    }
    
    
    // Phuong Thuc chon tung chuoi 16 ki tu tu chuoi dau vao co do dai bat ki;
    public static int[] Chose_array16(int[] input,int i){
        
       int[] array16 =new int[16];
       int leng_array,sochuoicon,a,sodu;     
       leng_array = input.length;
       sodu=leng_array%16;
       sochuoicon=leng_array/16;
       int j;
       for(j=0;j<=15;j++){
           array16[j]=input[i*16+j];
       }
        
       return array16;
   }
    
    
}
