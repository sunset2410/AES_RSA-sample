/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package work_with_file;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author chieu
 */
public class MaHoaText_GiaiMaText {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String str1 = "C:\\Users\\chieu\\Desktop\\key.txt";
        String str2 = "C:\\Users\\chieu\\Desktop\\str_input.txt";
        String str3 = "C:\\Users\\chieu\\Desktop\\str_output.txt";
        String str4 = "C:\\Users\\chieu\\Desktop\\str_inputgoc.txt";
        String str_key, str_input, str_output = "";

        /////////// -----------------------DOC FILE CAN Ma Hoa---------------------------------------;
        str_key = Doc_Ghi_File_Text.DocFile(str1); //chuoi chua key dau vao;
        str_input = Doc_Ghi_File_Text.DocFile(str2);//chuoi can ma hoa;
        // kiem tra gia tri chuoi hexa cua chuoi key;
        System.out.println("Khoa Dau Vao La :" + str_key);// in ra khoa;
        int[] value0 = new int[str_key.length()];
        value0 = String_to_Hexa.string_to_hexa(str_key);
        System.out.println("gia tri chuoi hexa cua chuoi key la:" + str_key.length() + " phan tu");
        for (int i = 0; i <= value0.length - 1; i++) {
            System.out.print(Integer.toHexString(value0[i]) + " ");
            if (((i % 16) == 15)) {
                System.out.print("|");
            }
        }
        System.out.println("\n");


        // kiem tra gia tri chuoi hexa cua chuoi String truoc khi ma hoa;
        System.out.println("Chuoi Goc La :" + str_input + "\n"); // in ra chuoi truoc ma hoa;
        int[] value1 = new int[str_input.length()];
        value1 = String_to_Hexa.string_to_hexa(str_input);
        System.out.println("gia tri chuoi hexa cua chuoi dau vao la:" + str_input.length() + " phan tu");
        for (int i = 0; i <= value1.length - 1; i++) {
            System.out.print(Integer.toHexString(value1[i]) + " ");
            if (((i % 16) == 15)) {
                System.out.print("|");
            }
        }
        System.out.println("\n");

        
        // ------------------thuc hien  ma hoa;------------------
        str_output = MaHoaText.MaHoaText(str_key, str_input);
        
       
        // kiem tra gia tri chuoi hexa cua chuoi String sau khi ma hoa ;
        System.out.println("Chuoi Sau Ma Hoa La :" + str_output + "\n"); // chuoi sau ma hoa;
        int[] value2 = new int[str_output.length()];
        value2 = String_to_Hexa.string_to_hexa(str_output);
        System.out.println("gia tri chuoi hexa cua chuoi sau khi ma hoa la:" + str_output.length() + " phan tu");
        for (int i = 0; i <= value2.length - 1; i++) {
            System.out.print(Integer.toHexString(value2[i]) + " ");
            if (((i % 16) == 15)) {
                System.out.print("|");
            }
        }
        System.out.println("\n");
        

         //ghi chuoi da duoc  ma hoa vao file str_output.txt;
        //thay doi ki tu \n thanh \r\n o trong ki tu sau ma hoa de ghi vao fie;
         String str_out = "";
         str_out = str_output.replaceAll("\n", "\r\n");
         Doc_Ghi_File_Text.GhiFile(str_out, str3);
         
         

        ////////////-------------------------DOC FILE CAN Giai Ma-----------------------------
        str_key = Doc_Ghi_File_Text.DocFile(str1);
        str_input = Doc_Ghi_File_Text.DocFile(str3);

        
        // kiem tra gia tri chuoi hexa cua chuoi truoc giai ma;
        System.out.println("Chuoi Truoc Giai Ma La :" + str_input);// in ra chuoi truoc giai ma;
        int[] value3 = new int[str_input.length()];
        value3 = String_to_Hexa.string_to_hexa(str_input);
        System.out.println("gia tri chuoi hexa cua chuoi truoc giai ma la:" + str_input.length() + " phan tu");
        for (int i = 0; i <= value3.length - 1; i++) {
            System.out.print(Integer.toHexString(value3[i]) + " ");
            if (((i % 16) == 15)) {
                System.out.print("|");
            }
        }
        System.out.println("\n");

        
        
        //------------------thuc hien giai ma;---------------
        str_output = GiaiMaText.GiaiMaText(str_key, str_input);
        
        

        // kiem tra gia tri chuoi hexa cua chuoi String sau khi giai ma;
        System.out.println("Chuoi Sau Khi Giai Ma La:" + str_output + "\n");
        int[] value4 = new int[str_output.length()];
        value4 = String_to_Hexa.string_to_hexa(str_output);
        System.out.println("gia tri chuoi hexa cua chuoi sau khi giai ma la:" + str_output.length() + " phan tu");
        for (int i = 0; i <= value4.length - 1; i++) {
            System.out.print(Integer.toHexString(value4[i]) + " ");
            if (((i % 16) == 15)) {
                System.out.print("|");
            }
        }
        System.out.println("\n");
        
        
        // Ghi chuoi da duoc giai ma vao file str_inputgoc.txt;
        //thay doi ki tu \n thanh \r\n trong chuoi sau giai ma de ghi file
        str_out = str_output.replaceAll("\n", "\r\n"); 
        Doc_Ghi_File_Text.GhiFile(str_out, str4);// ghi chuoi da giai ma vao file str_inputgoc.txt;


    }
}
