/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClientAES_work_with_file;

import JClientAES_addvance_encrypt_standard.Main_Inverse_Cipher;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author chieu
 */
public class GiaiMaText {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String str2 = "C:\\Users\\chieu\\Desktop\\key.txt";
        String str3 = "C:\\Users\\chieu\\Desktop\\str_inputgoc.txt";
        String str4 = "C:\\Users\\chieu\\Desktop\\str_output.txt";
        String str_key, str_input, str_output = "";

        //doc chuoi text tu file txt;
        str_key = Doc_Ghi_File_Text.DocFile(str2); //chuoi chua key dau vao;
        str_input = Doc_Ghi_File_Text.DocFile(str4);
        System.out.println("chuoi truoc khi giai ma la:" + str_input);
        // goi phuong thuc giai ma;
        str_output = GiaiMaText.GiaiMaText(str_key, str_input);
        //ghi chuoi da duoc  giai ma vao file str_output.txt;
        System.out.print("chuoi sau khi giai ma la:" + str_output);
        
        //thay doi ki tu \n thanh \r\n trong chuoi sau giai ma de ghi file
        String str_out = str_output.replaceAll("\n", "\r\n"); 
        Doc_Ghi_File_Text.GhiFile(str_out, str3);// ghi chuoi da giai ma vao file str_output.txt;
        
    }

    // Phuong thuc giai ma text;
    public static String GiaiMaText(String str_key, String str_input) {
        String str_input_block, str_output = "";
        int[][] input_block = new int[4][4];
        int[] input_key = new int[16];
        int i, sochuoi_16, n, a, leng_text;

        leng_text = str_input.length();
        a = leng_text % 16;
        sochuoi_16 = (a == 0) ? (leng_text / 16) : ((leng_text / 16) + 1);

        // thuc hien ma hoa tung chuoi con;
        for (n = 0; n <= sochuoi_16 - 1; n++) {

            str_input_block = Chose_Text.chose_array_string(str_input, n); //lay chuoi thu i tu text dau vao;
            int[] input_array = new int[16];
            //chuyen chuoi sang hexa;
            input_array = String_to_Hexa.string_to_hexa(str_input_block); //chuyen sang hexa


            // -----------------doi ki tu 256 thanh ki tu 13;---------------------
            for (i = 0; i <= 15; i++) {
                if (input_array[i] == 256) {
                    input_array[i] = 13;
                }
            }


            input_key = String_to_Hexa.string_to_hexa(str_key); //day la khoa dau vao de ma khoa;
            // chuyen tu mnag 1 chieu sang block 4x4 day la dau vao de ma hoa;
            for (i = 0; i <= 3; i++) {
                input_block[0][i] = input_array[i * 4];
                input_block[1][i] = input_array[i * 4 + 1];
                input_block[2][i] = input_array[i * 4 + 2];
                input_block[3][i] = input_array[i * 4 + 3];
            }
            // thuc hien giai ma block 4x4;   

            Main_Inverse_Cipher.Inverse_Cipher(input_block, input_key);

            //chuyen tu block 4x4 sang mang 1 chieu;
            for (i = 0; i <= 15; i++) {
                //code chuyen;
                input_array[i] = input_block[i % 4][i / 4];
            }

            //chuyen tu so sang chuoi;
            str_input_block = Hexa_to_String.hexa_to_string(input_array);
            str_output = str_output + str_input_block;

        }


       

        return str_output;
    }
}
