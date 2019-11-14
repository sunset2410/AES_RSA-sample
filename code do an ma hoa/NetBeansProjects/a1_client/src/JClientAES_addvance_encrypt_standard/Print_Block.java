/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClientAES_addvance_encrypt_standard;

/**
 *
 * @author chieu
 */
public class Print_Block {
    public static void main(String[] args) {
        
        int [][] block = {{0x32,0x88,0x31,0xe0},
                         {0x43,0x5a,0x31,0x37},
                         {0xf6,0x30,0x98,0x07},
                         {0xa8,0x8d,0xa2,0x34}};
        
        print(block);
        
        
    }
    
    
public static void print(int[][] data){
System.out.println("gia tri block o he hexa:\n");
int i = 0;
for(i=0;i<data.length;i++){
    
        
         //System.out.println("Hexa: " + Integer.toHexString(number));
        System.out.println(Integer.toHexString(data[i][0])+ " " + Integer.toHexString(data[i][1]) + " " +
        Integer.toHexString(data[i][2]) + " " + Integer.toHexString(data[i][3]));
}      
}
    
}
