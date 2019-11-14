/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addvance_encrypt_standard;

/**
 *
 */
public class Main_Inverse_Cipher {
    // ham man de test;
    public static void main(String[] args) {
      /*  int[][] block= {{0x39, 0x02, 0xdc,0x19},
                      {0x25, 0xdc, 0x11, 0x6a},
                      {0x84, 0x09, 0x85, 0x0b},
                      {0x1d, 0xfb, 0x97, 0x32}};
      
      int[] cipher_key={ 0x2b,0x7e,0x15,0x16,0x28,0xae,0xd2,0xa6,0xab,0xf7,0x15,0x88,0x09,0xcf,0x4f,0x3c }; */
        
        
                               int[][] block={ {0x78, 0x4d, 0x0a ,0x98},
                                               {0x74 ,0x55, 0xbf, 0x9c},
                                               {0x2e ,0x30, 0xbc ,0x9a},
                                               {0x5f,0x76 ,0xee,0x20 }};
      
     int[] cipher_key={ 0x31, 0x32, 0x33 ,0x34 ,0x35 ,0x36 ,0x37 ,0x38 ,0x39 ,0x61 ,0x62 ,0x63 ,0x64 ,0x65 ,0x66 ,0x67 };
        
        
      //hien thi du lieu truoc khi giai ma;
      Print_Block.print(block);
      block=Inverse_Cipher(block,cipher_key);
      // hien thi sau khi gai ma;
      Print_Block.print(block);
        
    }
    
    public static int[][] Inverse_Cipher(int[][] block,int[] cipher_key) {
        
      // thuc hien giai ma vong 0;
        getKeyExpansion.key_expansion(cipher_key);
        AddRoundKey.addRoundKey(block,ChoseRoundKey.chose_roundkey(10));
      //thuc hien giai ma vong 9 toi 1
        int i;
       for(i=9;i>=1;i--) 
       {
           
           Inverse_ShiftRows.inverse_shiftRows(block);
           Inverse_Subbyte.inverse_subbyte(block);
           AddRoundKey.addRoundKey(block,ChoseRoundKey.chose_roundkey(i));
           Inverse_Mix_Columns.inverse_mixColumns(block);
           
       }
       
      Inverse_ShiftRows.inverse_shiftRows(block);
      Inverse_Subbyte.inverse_subbyte(block);
      AddRoundKey.addRoundKey(block,ChoseRoundKey.chose_roundkey(0));
     
      return block;
   }
    
}