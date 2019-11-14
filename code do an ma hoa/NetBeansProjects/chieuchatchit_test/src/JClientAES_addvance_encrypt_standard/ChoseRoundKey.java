/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClientAES_addvance_encrypt_standard;

/**
 *
 * @author chieu
 */
public class ChoseRoundKey {
    public static int[][]temp_key =new int[4][4];
    
    
    //ham main;
    public static void main(String[] args) {
        
       int[] cipher_key={ 0x2b,0x7e,0x15,0x16,0x28,0xae,0xd2,0xa6,0xab,0xf7,0x15,0x88,0x09,0xcf,0x4f,0x3c };
       getKeyExpansion.key_expansion(cipher_key);
       int[][] a=new int[4][4];
       a=chose_roundkey(10);
  
       
      System.out.println("gia tri cua roudkey da chon la:");
      int i;
      for(i=0;i<=3;i++){
        System.out.print("\n" +Integer.toHexString(a[i][0])+" "+ Integer.toHexString(a[i][1])+ " " +
              Integer.toHexString(a[i][2])+" "+Integer.toHexString(a[i][3]));
                  }
       
    }
    
    
    // ham chon khoa;
    public static int[][] chose_roundkey(int j)
    {
        int i;
        for(i=0;i<=3;i++){
            
        temp_key[i][0]= getKeyExpansion.temp_key_expansion[i][4*j];
        temp_key[i][1]= getKeyExpansion.temp_key_expansion[i][4*j+1];
        temp_key[i][2]= getKeyExpansion.temp_key_expansion[i][4*j+2];
        temp_key[i][3]= getKeyExpansion.temp_key_expansion[i][4*j+3];
        
        }
        return temp_key;
        
    }
    
}
