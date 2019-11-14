/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClientAES_Work_With_Image;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 *
 * @author chieu
 */
public class setData {
    
    public static void main(String[] args) {
        
        
    }
    
      //phuong thuc set du lieu;
    public static  void setData(Pixel[][] data,BufferedImage buffered_image) {
        int[] pixelValues = new int[3]; // a temporary array to hold r,g,b values
        WritableRaster wr = buffered_image.getRaster();

        if (data.length != wr.getHeight()) {
            throw new IllegalArgumentException("kich thuoc mnag khong phu hop");
        } else if (data[0].length != wr.getWidth()) {
            throw new IllegalArgumentException("kich thuoc mnag khong phu hop");
        }

        for (int row = 0; row < wr.getHeight(); row++) {
            for (int col = 0; col < wr.getWidth(); col++) {
                pixelValues[0] = data[row][col].red;
                pixelValues[1] = data[row][col].green;
                pixelValues[2] = data[row][col].blue;
                wr.setPixel(col, row, pixelValues);
                
              }
          }
        
        
        
     }
    
    
}
