/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClientAES_addvance_encrypt_standard;

/**
 *
 * @author chieu
 */
public class Print_Block_Key {
    
    public static void main(String[] args) {
        
    }
    
    
    public static void print_block_key(int[][] data){
System.out.println("gia tri block o he hexa:\n");
int i,j;
for(i=0;i<4;i++)
{
for(j=0;j<44;j++){
    
       if((data[i][j])<16) System.out.print("0");
       //System.out.println("Hexa: " + Integer.toHexString(number));
       System.out.print(Integer.toHexString(data[i][j])+ " ");
       
       
              }  

      System.out.print("\n" );
}

}
    
}
