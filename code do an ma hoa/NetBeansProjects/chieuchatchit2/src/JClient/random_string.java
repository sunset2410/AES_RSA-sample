/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JClient;
import java.util.Random;

/**
 *
 * @author admin
 */
public class random_string {
    public static void main(String[] args) { 
    random_string class1=new random_string();    
    System.out.println(class1.randomString()); 
        
    }
    
    public String randomString(){
    char[] chars = "abcdefghijklmnopqrstuvwxyz123456789ABCDEFGHIKLMNOPQRSTUVWXYZ".toCharArray();
    StringBuilder subString = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i <16; i++) {
    char c = chars[random.nextInt(chars.length)];
    subString.append(c);
    }
    String output = subString.toString();
    return output;
    }
    
    
    
}
