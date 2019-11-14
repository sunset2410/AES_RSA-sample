/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClientAES_addvance_encrypt_standard;


public class getKeyExpansion {
    
//int[] key = new int[16];// khoa co kich thuoc la mang 16 so;
//int[][] block = new int[4][4]; // khoi du lieu co kich thuoc 128 bit; 
//public static int[][] keyExpansion = new int[4][44]; // mang chua khoa mo rong co kich thuoc 44 word;moi hoa la 4 word; 
public static int[] Rcon_table = {0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1b,0x36};
public static int[][] temp_key_expansion =new int[4][44];
public static int[] Rcon = new int[4];
public static int[] xor_word= new int[4];
public static int[] value=new int[4];


// ham chinh de test;
    public static void main(String[] args) {
    /*    
    int[][] block =         {{0x32,0x88,0x31,0xe0},
                            {0x43,0x5a,0x31,0x37},
                            {0xf6,0x30,0x98,0x07},
                            {0xa8,0x8d,0xa2,0x34}};
    */
    
    int[] cipher_key={ 0x2b,0x7e,0x15,0x16,0x28,0xae,0xd2,0xa6,0xab,0xf7,0x15,0x88,0x09,0xcf,0x4f,0x3c };
    //int[] temp= { 0xcf,0x4f,0x3c,0x09 };
    //Print_Block.print(block); // goi phuong thuc in block tu class Print_Block;
    key_expansion(cipher_key);
    Print_Block_Key.print_block_key(temp_key_expansion);
    
    
   /* 
    
    System.out.println("GIA TRI temp ban dau:"+Integer.toHexString(temp[0])+" "+ Integer.toHexString(temp[1])+ " " +
              Integer.toHexString(temp[2])+" "+Integer.toHexString(temp[3]));
    subword(temp);
    System.out.println("GIA TRI temp sau subword:"+Integer.toHexString(temp[0])+" "+ Integer.toHexString(temp[1])+ " " +
              Integer.toHexString(temp[2])+" "+Integer.toHexString(temp[3]));
   rotword(temp);
    System.out.println("GIA TRI temp sau rotword:"+Integer.toHexString(temp[0])+" "+ Integer.toHexString(temp[1])+ " " +
              Integer.toHexString(temp[2])+" "+Integer.toHexString(temp[3]));
    Rcon(1);
    System.out.println("GIA TRi cua rcon:" +Integer.toHexString(Rcon[0])+" "+ Integer.toHexString(Rcon[1])+ " " +
              Integer.toHexString(Rcon[2])+" "+Integer.toHexString(Rcon[3]));
    xor_word=xor_word(temp,Rcon);
    System.out.println("GIA TRI temp sau xorword:"+Integer.toHexString(xor_word[0])+" "+ Integer.toHexString(xor_word[1])+ " " +
              Integer.toHexString(xor_word[2])+" "+Integer.toHexString(xor_word[3]));
   */
    
    
    }
    
    
    
    
    // ham mo rong khoa;
    public static void  key_expansion(int[] key_cipher)      
    {
       
       int i,j;
      
        // du ra gia tri 4 tu khoa dau tien w[0] toi w[3];
        for(i=0;i<=3;i++)
        {
            temp_key_expansion[0][i]=key_cipher[i*4];
            temp_key_expansion[1][i]=key_cipher[i*4+1];
            temp_key_expansion[2][i]=key_cipher[i*4+2];
            temp_key_expansion[3][i]=key_cipher[i*4+3];
        }
        
        
        
        
        // tinh w[4] toi w[33];
       for(i=4;i<=43;i++)
        {
        
            int[] temp=new int[4]; 
            temp[0]=temp_key_expansion[0][i-1] ;
            temp[1]=temp_key_expansion[1][i-1] ;
            temp[2]=temp_key_expansion[2][i-1] ;
            temp[3]=temp_key_expansion[3][i-1] ;
            
            if((i%4)==0) 
                  
            {
                int[] a,b;// =new int[4];
                a=rotword(temp);
                
              //  System.out.println("GIA TRI sau rotword:"+Integer.toHexString(a[0])+" "+ Integer.toHexString(a[1])+ " " +
             // Integer.toHexString(a[2])+" "+Integer.toHexString(a[3]));
               
                b=subword(a);
                
               // System.out.println("GIA TRIsau subword:"+Integer.toHexString(b[0])+" "+ Integer.toHexString(b[1])+ " " +
              //Integer.toHexString(b[2])+" "+Integer.toHexString(b[3]));
                
                xor_word=xor_word(b,Rcon(i/4));
                
                temp[0]=xor_word[0];
                temp[1]=xor_word[1];
                temp[2]=xor_word[2];
                temp[3]=xor_word[3];
                
            }
            
           // int[] value=new int[4];
            value[0]= temp_key_expansion[0][i-4] ;
            value[1]=temp_key_expansion[1][i-4] ;
            value[2]=temp_key_expansion[2][i-4] ;
            value[3]=temp_key_expansion[3][i-4] ;
            //
            
             xor_word= xor_word(value,temp);
             temp_key_expansion[0][i]= xor_word[0];
             temp_key_expansion[1][i]= xor_word[1];
             temp_key_expansion[2][i]= xor_word[2];
             temp_key_expansion[3][i]= xor_word[3];
             
            
        } // end for;
        
        
        
   } //end key_expansion;
    
    
    
         // ham subword thay the 1 cot w[i] trong buoc sinh khoa;   
        public static int[] subword(int[] temp)
        {
            
           int[][] s_box = {
{0x63, 0x7C, 0x77, 0x7B, 0xF2, 0x6B, 0x6F,0xC5, 0x30, 0x01, 0x67, 0x2B, 0xFE, 0xD7, 0xAB, 0x76},
{0xCA, 0x82, 0xC9, 0x7D, 0xFA, 0x59, 0x47,0xF0, 0xAD, 0xD4, 0xA2, 0xAF, 0x9C, 0xA4, 0x72, 0xC0},
{0xB7, 0xFD, 0x93, 0x26, 0x36, 0x3F, 0xF7,0xCC, 0x34, 0xA5, 0xE5, 0xF1, 0x71, 0xD8, 0x31, 0x15},
{0x04, 0xC7, 0x23, 0xC3, 0x18, 0x96, 0x05,0x9A, 0x07, 0x12, 0x80, 0xE2, 0xEB, 0x27, 0xB2, 0x75},
{0x09, 0x83, 0x2C, 0x1A, 0x1B, 0x6E, 0x5A,0xA0, 0x52, 0x3B, 0xD6, 0xB3, 0x29, 0xE3, 0x2F, 0x84},
{0x53, 0xD1, 0x00, 0xED, 0x20, 0xFC, 0xB1,0x5B, 0x6A, 0xCB, 0xBE, 0x39, 0x4A, 0x4C, 0x58, 0xCF},
{0xD0, 0xEF, 0xAA, 0xFB, 0x43, 0x4D, 0x33,0x85, 0x45, 0xF9, 0x02, 0x7F, 0x50, 0x3C, 0x9F, 0xA8},
{0x51, 0xA3, 0x40, 0x8F, 0x92, 0x9D, 0x38,0xF5, 0xBC, 0xB6, 0xDA, 0x21, 0x10, 0xFF, 0xF3, 0xD2},
{0xCD, 0x0C, 0x13, 0xEC, 0x5F, 0x97, 0x44,0x17, 0xC4, 0xA7, 0x7E, 0x3D, 0x64, 0x5D, 0x19, 0x73},
{0x60, 0x81, 0x4F, 0xDC, 0x22, 0x2A, 0x90,0x88, 0x46, 0xEE, 0xB8, 0x14, 0xDE, 0x5E, 0x0B, 0xDB},
{0xE0, 0x32, 0x3A, 0x0A, 0x49, 0x06, 0x24,0x5C, 0xC2, 0xD3, 0xAC, 0x62, 0x91, 0x95, 0xE4, 0x79},
{0xE7, 0xC8, 0x37, 0x6D, 0x8D, 0xD5, 0x4E,0xA9, 0x6C, 0x56, 0xF4, 0xEA, 0x65, 0x7A, 0xAE, 0x08},
{0xBA, 0x78, 0x25, 0x2E, 0x1C, 0xA6, 0xB4,0xC6, 0xE8, 0xDD, 0x74, 0x1F, 0x4B, 0xBD, 0x8B, 0x8A},
{0x70, 0x3E, 0xB5, 0x66, 0x48, 0x03, 0xF6,0x0E, 0x61, 0x35, 0x57, 0xB9, 0x86, 0xC1, 0x1D, 0x9E},
{0xE1, 0xF8, 0x98, 0x11, 0x69, 0xD9, 0x8E,0x94, 0x9B, 0x1E, 0x87, 0xE9, 0xCE, 0x55, 0x28, 0xDF},
{0x8C, 0xA1, 0x89, 0x0D, 0xBF, 0xE6, 0x42,0x68, 0x41, 0x99, 0x2D, 0x0F, 0xB0, 0x54, 0xBB, 0x16},
};
         
       
           
           
         int i=0,row,column;
         int current;
    
         for(i=0;i<4;i++)
             {
               current=temp[i];
               row=current/16;
               column=current%16;
               temp[i]=s_box[row][column];
             }
              
            return temp;
        }
        
        
        
        
        // ham thuc hien chuc nang subword;
        public static int[] rotword(int[] temp)
        {
            int[] a=new int[4];
            // khong dung a=temp duoc;??? vi chua biet mang temp co bao nhieu phan tu;
            a[0]=temp[0];
            a[1]=temp[1];
            a[2]=temp[2];
            a[3]=temp[3];
            
            temp[0]=a[1];
            temp[1]=a[2];
            temp[2]=a[3];
            temp[3]=a[0];
            return temp;
        }
        
        
        
        
        //ham thuc hien chuc nagn Rcon;
        public static int[] Rcon(int i)
        {
            
            Rcon[0]=Rcon_table[i-1];
            Rcon[1]=0x00;
            Rcon[2]=0x00;
            Rcon[3]=0x00;
            return Rcon;
        }
        
        
        
        
         // ham thuc hien chuc nag xor 2 word trong buoc sinh khoa;
        public static int[] xor_word(int[] a , int[]b)
        {
            int i;
            for(i=0;i<4;i++){
            xor_word[i] = a[i]^b[i];
                    }
            return xor_word;
        }
        
        
  
        
    }
        
        
        
        

 
    
    

    
    
 
    
    
    
    

