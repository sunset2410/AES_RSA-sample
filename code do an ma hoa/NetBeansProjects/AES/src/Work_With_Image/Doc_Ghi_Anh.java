package Work_With_Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Doc_Ghi_Anh {
 
    public static void main(String[] args) {
        
           
        }


    
    // phuong thuc doc anh;
    public static BufferedImage Doc_Anh(BufferedImage bi,String path){
         //doc anh vao
        File file = new File(path);


        try {
            bi = ImageIO.read(file);
        } catch (IOException e) {

            System.out.println("khong the load duco anh;");
        }
        return bi;
        
    }
    
    
    // phuong thuc ghi anh;
    public static void Ghi_Anh(BufferedImage bout,String path){
        
        File file2 = new File(path);

        try {

            ImageIO.write(bout, "png", file2);
        } catch (IOException e) {

            System.out.println("khong the ghi duco anh;");
        }
        
        
    }
  
}
