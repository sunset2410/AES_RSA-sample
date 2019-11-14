/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addvance_encrypt_standard;

/**
 *
 * @author chieu
 */
public class Chose_Round_Key {
    public static int[]temp_key =new int[4];
    
    
    //ham main;
    public static void main(String[] args) {
        
       int[] cipher_key={ 0x2b,0x7e,0x15,0x16,0x28,0xae,0xd2,0xa6,0xab,0xf7,0x15,0x88,0x09,0xcf,0x4f,0x3c };
       getKeyExpansion.key_expansion(cipher_key);
       int[] a=new int[4];
       a=chose_roundkey(15);
      
       System.out.println("gia tri cua roudkey da chon la:");
      
        System.out.print("\n" +Integer.toHexString(a[0])+" "+ Integer.toHexString(a[1])+ " " +
              Integer.toHexString(a[2])+" "+Integer.toHexString(a[3]));
       
       
    }
    
    
    // ham chon khoa;
    public static int[] chose_roundkey(int j)
    {
        
        temp_key[0]= getKeyExpansion.temp_key_expansion[0][j];
        temp_key[1]= getKeyExpansion.temp_key_expansion[1][j];
        temp_key[2]= getKeyExpansion.temp_key_expansion[2][j];
        temp_key[3]= getKeyExpansion.temp_key_expansion[3][j];
        
        return temp_key;
        
    }
    
}
