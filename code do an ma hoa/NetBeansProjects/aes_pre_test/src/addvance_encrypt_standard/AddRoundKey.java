/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addvance_encrypt_standard;

/**
 *
 * @author chieu
 */
public class AddRoundKey {
    
int[][] key = new int[4][4];// khoa co kich thuoc 128 bit gom mang 4 hang 4 cot moi phan tu dung 8 bit;
int[][] block = new int[4][4]; // khoi du lieu co kich thuoc 128 bit; 
int[][] keyExpansion = new int[4][44]; // mang chua khoa mo rong co kich thuoc 44 word;moi hoa la 4 word; 
   
public static void main(String[] args) {
    int[][] block =     {{0x32,0x88,0x31,0xe0},
                        {0x43,0x5a,0x31,0x37},
                        {0xf6,0x30,0x98,0x07},
                        {0xa8,0x8d,0xa2,0x34}};
    
    int[][] key ={ {0x2b,0x28,0xab,0x09},
                   {0x7e,0xae,0xf7,0xcf},
                   {0x15,0xd2,0x15,0x4f},
                   {0x16,0xa6,0x88,0x3c} };
    
    Print_Block.print(block); // goi phuong thuc in block tu class Print_Block;
    block = addRoundKey(block,key);
    Print_Block.print(block);
    
    }
    
    
    // phuong thuc thuc hien chuc nag addround key giua khoa va block;
public static int[][] addRoundKey(int[][] a,int[][] b){
int i,j;
for(i=0;i<4;i++)
for(j=0;j<4;j++){
a[i][j] = a[i][j] ^b[i][j];
}
return a;
}



}
    

