/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClientAES_work_with_file;

/**
 *
 * @author chieu
 */
public class String_to_Hexa {
    //public static int[] cipher=new int[10000]; //phai khai bao truoc so phan tu cua mnag;

    public static void main(String[] args) {
        String str = "�Ābcd.";
        int[] cipher = new int[100];
        cipher = string_to_hexa(str); //goi ham chuyen chuoi sang hexa;

        System.out.println("chuoi ki dau vao la:" + str);
        System.out.println("chuoi hexa cua chuoi ki tu tren la:");
        int i;
        for (i = 0; i < str.length(); i++) {
            System.out.print(Integer.toHexString(cipher[i]) + " "); //in duoi dang hexa;
            //System.out.print(cipher[i]+" ");  //in duoi dang thap phan;
        }

    }

    //Phuong Thuc chuyen tu String sang Hexa;
    public static int[] string_to_hexa(String str) {

        int[] cipher = new int[str.length()]; //mang chua hexa;
        int i;
        for (i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            cipher[i] = (int) ch;
            // System.out.println((int)'A');
            // System.out.println((char)65);
        }
        return cipher;
    }
}
