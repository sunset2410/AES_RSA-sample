/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RAS;
import java.math.*;
/**
 *
 * @author admin
 */
public class Songuyento {
    
public static void main(String[] args) {

        // create 2 BigInteger objects
        BigInteger bi1, bi2;

        bi1 = new BigInteger("4");

        // assign nextProbablePrime value of bi1 to bi2
	bi2 = bi1.nextProbablePrime(); //lay so nguyen to sau so bi1;

        String str = "Next probable prime after " + bi1 +" is " +bi2;

	// print bi2 value
	System.out.println( str );
    }
}
    

