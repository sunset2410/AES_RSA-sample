/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package work_with_file;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author chieu
 */
public class Doc_Ghi_File_Text {
    
    public static void main(String[] args){
        String path="C:\\Users\\chieu\\Desktop\\str_input.txt";
        String str1="tran van"+ "\r\n" +"chieu"+"\r\n"+"lopdientu\r\n12";
        String str;
        //Goi Phuong Thuc Doc File
        str=DocFile(path);
        System.out.println("Chuoi Ki Tu Chua Trong File La:"+str);   
        
       GhiFile(str1,path);
    }
    
    //Phuong Thuc Ghi File txt;
    public static void GhiFile(String str,String path) {
        try{ 
        FileOutputStream fos =new FileOutputStream(path,false);
        Writer out =new OutputStreamWriter (fos,"UTF8");
        out.write(str);
        out.close();
        fos.flush();
        fos.close();
        }
        catch(Exception e){
           System.out.println("khong the ghi file"); 
        }
    }
    
    
    
    // Phuong Thuc Doc File txt;
    public static String DocFile(String path){
        String str="";
        String str1="";
        
        try{
        FileInputStream  fos =new FileInputStream(path);
        Reader r =new java.io.InputStreamReader(fos,"UTF8");
        BufferedReader reader =new BufferedReader(r);
        String line = null;
        while((line=reader.readLine())!=null)
        {
            str=str+line+"\n"; //luu dan vao chuoi str;
           
        }
        reader.close();
        fos.close();
        }catch(Exception e){
            
            System.out.println("khong the ghi file"); 
        }
        //System.out.println(str);
        str1=str.substring(0,str.length()-1); //thao tac nay de lay bot 1 ki tu xuong dong thua o torng chuoi str;
        return str1;
        
    }
    
    
}
