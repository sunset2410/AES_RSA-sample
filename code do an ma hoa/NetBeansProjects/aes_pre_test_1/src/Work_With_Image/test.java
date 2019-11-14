/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_With_Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author chieu
 */
public class test {
    
    public static BufferedImage bi;
    public static void main(String[] args) {
        
        String path1= "C:\\Users\\chieu\\Desktop\\a2.png"; //luu anh truoc ma hoa;
        String path2= "C:\\Users\\chieu\\Desktop\\a3.png";  //luu anh sau ma hoa;
       
        //doc anh vao;
        
        File file = new File(path1);


        try {
            bi = ImageIO.read(file);
        } catch (IOException e) {

            System.out.println("khong the load duco anh;");
            
        }
        
        
        //kiem tra kich thuoc cua anh;
        int w = bi.getWidth(); //so cot;
        int h = bi.getHeight(); //sohang;
        
        // lay du lieu vao 1 mang pixel;
        Pixel[][] data=new Pixel[h][w];    
        data=getData.getData(bi);
        
        //hien thi  thong tin ve kich thuoc anh;
        System.out.println("h="+h+"w="+w);
        System.out.println("pixel truoc ma hoa:");
        System.out.println(data[0][0].blue+" " + data[0][0].green+" "+data[0][0].red);
        System.out.println(data[1][1].blue+" " + data[1][1].green+" "+data[1][1].red);
       
        
         //ghi du lieu tu 1 mnag pixel vao buffered_image;
        //BufferedImage bout = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        setData.setData(data, bi);
        
        //ghi anh ra file anh;
        //Doc_Ghi_Anh.Ghi_Anh(bi, path2);
        
         File file2 = new File(path2);

        try {

            ImageIO.write(bi, "png", file2);
        } catch (IOException e) {

            System.out.println("khong the ghi duco anh;");
        }
        
        
        
    }
    
}
