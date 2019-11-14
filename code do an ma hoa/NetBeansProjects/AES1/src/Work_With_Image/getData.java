/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_With_Image;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

/**
 *
 * @author chieu
 */
public class getData {
    
    public static void main(String[] args) {
        
    }
    
    //phuong thuc lay du lieu;
    public static Pixel[][] getData(BufferedImage buffered_image) {
        Raster r = buffered_image.getRaster();
        Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
        int[] array3 = new int[3]; //mang 3 phan tu de chua gia tri 3 mau cua 1 pixel;

        for (int row = 0; row < r.getHeight(); row++) {
            for (int col = 0; col < r.getWidth(); col++) {
                array3 = r.getPixel(col, row, array3); //lenh lay gia tri pixel tu raster;
                Pixel newPixel = new Pixel(array3[0], array3[1], array3[2]);
                data[row][col] = newPixel;
            }
        }

        return data;
    }
}
