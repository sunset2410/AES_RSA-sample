package test;
 
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
//----------------- open input file---------------------------
            try {
                fin = new FileInputStream("C:\\Users\\admin\\Desktop\\test\\b.pdf");
            } catch (FileNotFoundException exc) {
                System.out.println("khong tim thay file dau vao ");
                return;
            }
 
//------------------- open output file------------------------
            try {
                fout = new FileOutputStream("C:\\Users\\admin\\Desktop\\test\\b1.pdf");
            } catch (FileNotFoundException exc) {
 
 
                System.out.println(" khong mo duoc file dau ra ");
                return;
            }
     } catch (ArrayIndexOutOfBoundsException exc) {
           System.out.println("Usage: CopyFile From To");
            return;
        }
 
//------------//kiem tra kich thuoc byte cua file;
        File filename = new File("C:\\Users\\admin\\Desktop\\test\\b.pdf");
        int size =(int) filename.length();
        int[] array =new int[size];   
//-------------------------- lay noi dung file luu vao mang array------------
        int i;
        int j=0;
        
           
        try {
            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i+1);
                    System.out.print(" "+i+" "); 
                    array[j]=i;
                    j++;
                    }
            } while (i != -1);
            
           
              
   
            System.out.println();
            System.out.println("so phan tu la:"+size);
            
            for(j=0;j<size;j++){
                System.out.print(array[j]+" ");
            }
            
            System.out.print("so phan tu la:"+array.length);
            
        } catch (IOException exc) {
            System.out.println("File Error");
        }
        fin.close();
        fout.close();
    }
}