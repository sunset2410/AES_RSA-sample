
package JClientAES_addvance_encrypt_standard;
import java.util.Scanner;
import java.lang.*;
import java.io.*;
/**
 *
 * @author chieu
 */
public class shiftrows {
int[][] key = new int[4][4];// khoa co kich thuoc 128 bit gom mang 4 hang 4 cot moi phan tu dung 8 bit;
int[][] block = new int[4][4]; // khoi du lieu co kich thuoc 128 bit; 
int[][] keyExpansion = new int[4][44]; // mang chua khoa mo rong co kich thuoc 44 word;moi hoa la 4 word; 
 
// ham chinh;
public static void main(String[] args) {
      int[][] block =  {{0x32,0x88,0x31,0xe0},
                        {0x43,0x5a,0x31,0x37},
                        {0xf6,0x30,0x98,0x07},
                        {0xa8,0x8d,0xa2,0x34}};
      
Print_Block.print(block);
shiftRows(block);
Print_Block.print(block);


    }
   

   // ham dich 1;
public static int[][] shiftRows(int[][] data){
int[] row1Shift = {data[1][1], data[1][2], data[1][3], data[1][0]};
int[] row2Shift = {data[2][2], data[2][3], data[2][0],data[2][1]};
int[] row3Shift = {data[3][3], data[3][0], data[3][1], data[3][2]};
// data[0] giu nguyen;
data[1] = row1Shift;
data[2] = row2Shift;
data[3] = row3Shift;
return data;
}


/*
// ham dich 2;
public static int[][] shiftRows(int[][] data){
int[][] test;
int i,j;
test=data;
for(i=1;i<=3;i++)
for(j=0;i<=3;j++)
{
    data[i][j]=0;
}
   
data[1][0]=test[1][1];data[1][1]=test[1][2];data[1][2]=test[1][3];data[1][3]=test[1][0];
data[2][0]=test[2][2];data[2][1]=test[2][3];data[2][2]=test[2][0];data[2][3]=test[2][1];
data[3][0]=test[3][3];data[3][1]=test[3][0];data[3][2]=test[3][1];data[3][3]=test[3][2];
return data;
}

*/


/*
   //ham in gia tri block;
public static void print(int[][] data){
System.out.println("gia tri block o he hexa:\n");
int i = 0;
for(i=0;i<data.length;i++){
    //System.out.println("Hexa: " + Integer.toHexString(number));
System.out.println(Integer.toHexString(data[i][0])+ " " + Integer.toHexString(data[i][1]) + " " +
        Integer.toHexString(data[i][2]) + " " + Integer.toHexString(data[i][3]));
}      
}
   */
   
}