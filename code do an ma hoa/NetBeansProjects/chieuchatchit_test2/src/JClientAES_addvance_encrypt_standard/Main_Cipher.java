/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClientAES_addvance_encrypt_standard;

/*
 */
public class Main_Cipher {
    //ham main de test;
    public static void main(String[] args) {
        
         /*int[][] block =    {{0x32,0x88,0x31,0xe0},
                            {0x43,0x5a,0x31,0x37},
                            {0xf6,0x30,0x98,0x07},
                            {0xa8,0x8d,0xa2,0x34}};
        int[] cipher_key={ 0x2b,0x7e,0x15,0x16,0x28,0xae,0xd2,0xa6,0xab,0xf7,0x15,0x88,0x09,0xcf,0x4f,0x3c };
        */
        
        int[][] block =    {{0x6f,0x20,0x20,0x63},
                            {0x20,0x70,0x73,0x75},
                            {0x76,0x68,0x61,0x61},
                            {0x69,0x75,0x0a,0x20}};
        int[] cipher_key={ 0x31, 0x32, 0x33 ,0x34 ,0x35 ,0x36 ,0x37 ,0x38 ,0x39 ,0x61 ,0x62 ,0x63 ,0x64 ,0x65 ,0x66 ,0x68 };
        
        
        //hien thi du lieu truoc ma hoa;
        Print_Block.print(block);
        //goi ham cipher;
        block=cipher(block,cipher_key);
        // hien thi du lieu sau khi da ma hoa;      
        Print_Block.print(block);
    }
    
    
    //ham cipher;
    public static int[][] cipher(int[][] block,int[] cipher_key) {
        // thuc hien ma hoa vong 0;
        getKeyExpansion.key_expansion(cipher_key);
        AddRoundKey.addRoundKey(block,ChoseRoundKey.chose_roundkey(0));
        int i;
        
        // thuc hien ma hoa vong 1 toi 9;
        for(i=1;i<=9;i++)
        {
            Subbyte.subbyte(block);
            Shift_Rows.shiftRows(block);
            Mix_Columns.mixColumns(block);
            AddRoundKey.addRoundKey(block,ChoseRoundKey.chose_roundkey(i));
            
        }
        // thuc hien ma hoa vong 10;
        Subbyte.subbyte(block);
        Shift_Rows.shiftRows(block);
        AddRoundKey.addRoundKey(block,ChoseRoundKey.chose_roundkey(10));
        return block;
    }
            
    
}
