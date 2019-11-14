package read_file;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
class read_and_replace_file {
 
    public static void main(String args[]) throws IOException {
        FileInputStream fin;
        FileOutputStream fout;
        try {
//----------------- open input file
            try {
                fin = new FileInputStream("C:\\Users\\admin\\Desktop\\test\\c.pptx");
            } catch (FileNotFoundException exc) {
                System.out.println("khong tim thay file dau vao ");
                return;
            }
 
//------------------- open output file-------------
            try {
                fout = new FileOutputStream("C:\\Users\\admin\\Desktop\\test\\c1.pptx");
            } catch (FileNotFoundException exc) {
 
 
                System.out.println(" khong mo duoc file dau ra ");
                return;
            }
     } catch (ArrayIndexOutOfBoundsException exc) {
           System.out.println("Usage: CopyFile From To");
            return;
        }
 
 //--------------kiem tra kich thuoc bute;-------------------
        File filename = new File("C:\\Users\\admin\\Desktop\\test\\c.pptx");
        int size =(int) filename.length();
        int[] array =new int[size];   
        
        
//-------------------------- coppy file---------------------
        int i;
        int j=0;
                  
        try {
            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i);
                    System.out.print(" "+i+" "); 
                    array[j]=i;
                    j++;
                    }
            } while (i != -1);
                
        } catch (IOException exc) {
            System.out.println("File Error");
        }
        System.out.print("so phan tu la:"+array.length);
        fin.close();
        fout.close();
       /* 
        // in ra tat ca gia tri cu file       
        for(j=0;j<size;j++){
        System.out.print(array[j]+" ");
            }
            
        System.out.print("so phan tu la:"+array.length);
        */
    }
}