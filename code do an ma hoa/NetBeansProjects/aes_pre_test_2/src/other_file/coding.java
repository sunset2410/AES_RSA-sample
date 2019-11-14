package other_file;
 
import addvance_encrypt_standard.Main_Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import work_with_file.Doc_Ghi_File_Text;
import work_with_file.String_to_Hexa;
 
public class coding {
    
    public static void main(String[] args) throws IOException {
        String input_path="C:\\Users\\admin\\Desktop\\test\\b.pdf";
        String output_path="C:\\Users\\admin\\Desktop\\test\\b1.pdf";
        String key_path="C:\\Users\\admin\\Desktop\\test\\str_key.txt";
        
        coding(input_path,output_path,key_path);
        
             
    }
    
    
 
    public static void coding(String input_path,String output_path,String key_path) throws IOException {
        FileInputStream fin;
        FileOutputStream fout;
        try {
   //----------------- open input file---------------------------
            try {
                fin = new FileInputStream(input_path);
            } catch (FileNotFoundException exc) {
                System.out.println("khong tim thay file dau vao ");
                return;
            }
 
    //------------------- open output file------------------------
            try {
                fout = new FileOutputStream(output_path);
            } catch (FileNotFoundException exc) {
 
 
                System.out.println(" khong mo duoc file dau ra ");
                return;
            }
     } catch (ArrayIndexOutOfBoundsException exc) {
           System.out.println("Usage: CopyFile From To");
            return;
        }
 
      //------------//kiem tra kich thuoc byte cua file;
        File filename = new File(input_path);
        int size =(int) filename.length();
        int[] array =new int[size];   
      //-------------------------- lay noi dung file luu vao mang array------------
        int i;
        int j=0;                  
        try {
            do {
                i = fin.read();
                if (i != -1) {
                  //  fout.write(i+1);
                    array[j]=i;
                    j++;
                    }
            } while (i != -1);
            
        //----------------thuc hien ma hoa du lieu----------------
        int[] array16 =new int[16];
        int leng_array,sochuoicon,sodu,n;     
        leng_array = array.length;//thuc ra cung chinh bang size;
        sodu=leng_array%16;//la so phan tu se khong duoc ma hoa;
        sochuoicon=leng_array/16;//so chuoi  so duoc ma hoa;
        //System.out.println("sochuoicon="+sochuoicon);
        String str_key;
        str_key = Doc_Ghi_File_Text.DocFile(key_path); //chuoi chua key dau vao;
        int[] input_key = new int[16];
        input_key = String_to_Hexa.string_to_hexa(str_key);// chuoi key duoc doi sang hexa;
        int[][] input_block=new int[4][4];
        
                
         for(n=0;n<=sochuoicon-1;n++){
            array16=Chose_array16.Chose_array16(array,n);
            
         // chuyen tu mnag 1 chieu sang block 4x4 day la dau vao de ma hoa;
            for (i = 0; i <= 3; i++) {
                input_block[0][i] = array16[i*4];
                input_block[1][i] = array16[i*4+1];
                input_block[2][i] = array16[i*4+2];
                input_block[3][i] = array16[i*4+3];
            }
            // thuc hien ma hoa tung block 4x4;   

            Main_Cipher.cipher(input_block, input_key);

            //chuyen tu block 4x4 sang mang 1 chieu;
            for (i = 0; i <= 15; i++) {
                //code chuyen;
                array16[i] = input_block[i % 4][i / 4];
            }

          //thay cac gia tri da ma hoa vao khoi chua mau blue;  
          for(i=0;i<=15;i++){
              array[n*16+i]=array16[i];
          }  
            
        }
        
                   
            
        //----------------thuc hien ghi file----------------------
              
   
          for(i=0;i<size;i++){
              fout.write(array[i]);
          }
            
            
     
            
        } catch (IOException exc) {
            System.out.println("File Error");
        }
        fin.close();
        fout.close();
    }
}