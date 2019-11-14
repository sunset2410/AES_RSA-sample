
package Work_With_Image;
import addvance_encrypt_standard.Main_Cipher;
import addvance_encrypt_standard.Main_Inverse_Cipher;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import work_with_file.Doc_Ghi_File_Text;
import work_with_file.String_to_Hexa;



public class GiaiMaAnh {
    
    public static BufferedImage bi;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String path1= "C:\\Users\\chieu\\Desktop\\people2.png";  //luu anh truoc giai ma;
        String path2= "C:\\Users\\chieu\\Desktop\\people3.png"; //luu anh sau giai;
        String path3= "C:\\Users\\chieu\\Desktop\\key.txt";
       
        giaimaanh(path1,path2,path3);
        
        
    }
    
    
    public static void giaimaanh(String input_path,String output_path,String key_path){
        
         //doc anh vao;
        bi=Doc_Ghi_Anh.Doc_Anh(bi,input_path);
        
        //kiem tra kich thuoc cua anh;
        int w = bi.getWidth();
        int h = bi.getHeight();
        
        // lay du lieu vao 1 mang pixel;
        Pixel[][] data=new Pixel[h][w];    
        data=getData.getData(bi);
        
        //hien thi  thong tin ve kich thuoc anh;
        System.out.println("h="+h+"w="+w);
         System.out.println("pixel truoc gai ma:");
         System.out.println(data[0][0].red+" " + data[0][0].green+" "+data[0][0].blue);
         
        //khai bao 3 mang chua gia tri cua 3 mau r,g,b roi lay gia tri cho chung;
        int i,j;
        int[][] arr_blue =new int[h][w]; //h ung coi so hang cua anh ,w ung voi so cot cua anh;
        int[][] arr_red=new int[h][w];
        int[][] arr_green=new int[h][w];
        for(i=0;i<=h-1;i++)
        for(j=0;j<=w-1;j++){
            
            arr_blue[i][j]=data[i][j].blue;
            arr_red[i][j]=data[i][j].red;
            arr_green[i][j]=data[i][j].green;
            
        }
  
        //chuyen tu mang 2 chieu ra 3 mang 1 chieu;moi mnag chua 1 mau;
        int[] arr_b=new int[h*w];
        int[] arr_g=new int[h*w];
        int[] arr_r=new int[h*w];
        
        for(i=0;i<=h*w-1;i++){
            arr_b[i]=arr_blue[i/w][i%w];
            arr_r[i]=arr_red[i/w][i%w];
            arr_g[i]=arr_green[i/w][i%w];
            
        }
        
        
        //-------------------------bat dau khoi thuc hien giai ma -----------------------------------------------
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        
        int[] array16 =new int[16];
        int leng_array,sochuoicon,sodu,n;     
        leng_array = arr_b.length;
        sodu=leng_array%16;//la so phan tu se khong duoc ma hoa;
        sochuoicon=leng_array/16;//so chuoi  so duoc ma hoa;
        System.out.println("sochuoicon="+sochuoicon);
        String str2 = key_path;
        String str_key;
        str_key = Doc_Ghi_File_Text.DocFile(str2); //chuoi chua key dau vao;
        int[] input_key = new int[16];
        int[][] input_block=new int[4][4];
        input_key = String_to_Hexa.string_to_hexa(str_key);
        int[] input_array = new int[16];
        
        
        //--------------------giai ma  mau blue;----------------------------------
        for(n=0;n<=sochuoicon-1;n++){
            input_array=Chose_array16.Chose_array16(arr_b,n);
            
         // chuyen tu mnag 1 chieu sang block 4x4 day la dau vao de ma hoa;
            for (i = 0; i <= 3; i++) {
                input_block[0][i] = input_array[i*4];
                input_block[1][i] = input_array[i*4+1];
                input_block[2][i] = input_array[i*4+2];
                input_block[3][i] = input_array[i*4+3];
            }
            // thuc hien giai ma  tung block 4x4;   

            Main_Inverse_Cipher.Inverse_Cipher(input_block, input_key);

            //chuyen tu block 4x4 sang mang 1 chieu;
            for (i = 0; i <= 15; i++) {
                //code chuyen;
                input_array[i] = input_block[i % 4][i / 4];
            }

          //thay cac gia tri da giai ma  vao khoi chua mau blue;  
          for(i=0;i<=15;i++){
              arr_b[n*16+i]=input_array[i];
          }  
            
        }
        
        
        
          //--------------------ma hoa mau red;----------------------------------
        for(n=0;n<=sochuoicon-1;n++){
            input_array=Chose_array16.Chose_array16(arr_r,n);
            
         // chuyen tu mnag 1 chieu sang block 4x4 day la dau vao de ma hoa;
            for (i = 0; i <= 3; i++) {
                input_block[0][i] = input_array[i*4];
                input_block[1][i] = input_array[i*4 + 1];
                input_block[2][i] = input_array[i*4 + 2];
                input_block[3][i] = input_array[i*4 + 3];
            }
            // thuc hien ma hoa tung block 4x4;   

            
            Main_Inverse_Cipher.Inverse_Cipher(input_block, input_key);

            //chuyen tu block 4x4 sang mang 1 chieu;
            for (i = 0; i <= 15; i++) {
                //code chuyen;
                input_array[i] = input_block[i % 4][i / 4];
            }

          //thay cac gia tri da ma hoa vao khoi chua mau blue;  
          for(i=0;i<=15;i++){
              arr_r[n*16+i]=input_array[i];
          }  
            
        }
        
        
          //--------------------ma hoa mau green;----------------------------------
        for(n=0;n<=sochuoicon-1;n++){
            input_array=Chose_array16.Chose_array16(arr_g,n);
            
         // chuyen tu mnag 1 chieu sang block 4x4 day la dau vao de ma hoa;
            for (i = 0; i <= 3; i++) {
                input_block[0][i] = input_array[i * 4];
                input_block[1][i] = input_array[i * 4 + 1];
                input_block[2][i] = input_array[i * 4 + 2];
                input_block[3][i] = input_array[i * 4 + 3];
            }
            // thuc hien ma hoa tung block 4x4;   

           Main_Inverse_Cipher.Inverse_Cipher(input_block, input_key);

            //chuyen tu block 4x4 sang mang 1 chieu;
            for (i = 0; i <= 15; i++) {
                //code chuyen;
                input_array[i] = input_block[i % 4][i / 4];
            }

          //thay cac gia tri da ma hoa vao khoi chua mau blue;  
          for(i=0;i<=15;i++){
              arr_g[n*16+i]=input_array[i];
          }  
            
        }
        
        
        // ------------------------ket thuc khoi thuc hien ma hoa---------------------------------
        ///////////////////////////////////////////////////////////////////////////////////////////
        
        
         //chuyen tu 3 mang 1 chieu ra 3 mang 2 chieu;moi mnag chua 1 mau;

        
        for(i=0;i<=h*w-1;i++){
            arr_blue[i/w][i%w]=arr_b[i];
            arr_red [i/w][i%w]=arr_r[i];
            arr_green[i/w][i%w]=arr_g[i];
            
        }
        
        
        // gan du lieu vao mang data la mang ma moi 1 phan tu la 1 pixel;
           
        for(i=0;i<=h-1;i++)
        for(j=0;j<=w-1;j++){
            
            data[i][j].blue=arr_blue[i][j];
            data[i][j].red=arr_red[i][j];
            data[i][j].green=arr_green[i][j];
            
        }
        
         System.out.println("pixel truoc sau giai ma:");
         System.out.println(data[0][0].red+" " + data[0][0].green+" "+data[0][0].blue);
        
        //ghi du lieu tu 1 mnag pixel vao buffered_image;
      //  BufferedImage bout = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        setData.setData(data, bi);
        
        //ghi anh ra file anh;
        Doc_Ghi_Anh.Ghi_Anh(bi,output_path );
        
    }
    
       
}
