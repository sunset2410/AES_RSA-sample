package test;
import java.util.*;
import java.math.BigInteger;

class RSA{ 
    public static void main(String[] args){
    /* Creating two random number generators, each with a different seed */
    Random rand1 = new Random(System.currentTimeMillis());
    Random rand2 = new Random(System.currentTimeMillis()*10);
    int asciiVal = Integer.parseInt("89");
    int pubKey = Integer.parseInt("10"); /* public key is at least a
    certain value input by the user */
    /* returns a BigInteger that is not prime with probability less than 2^(-100)
    */
    BigInteger bigB_p = BigInteger.probablePrime(32, rand1); //p
    BigInteger bigB_q = BigInteger.probablePrime(32, rand2); //q
    BigInteger bigB_n = bigB_p.multiply(bigB_q); // p.q
    BigInteger bigB_p_1 = bigB_p.subtract(new BigInteger("1")); //p-1
    BigInteger bigB_q_1 = bigB_q.subtract(new BigInteger("1")); //q-1
    BigInteger bigB_p_1_q_1 = bigB_p_1.multiply(bigB_q_1); // (p-1)*(q-1)
    
    // generating the correct public key
    while (true){
        BigInteger BigB_GCD = bigB_p_1_q_1.gcd(new BigInteger(""+pubKey));
        if (BigB_GCD.equals(BigInteger.ONE)){
        break;
            }
        pubKey++;
        }
    
    BigInteger bigB_pubKey = new BigInteger(""+pubKey);
    BigInteger bigB_prvKey = bigB_pubKey.modInverse(bigB_p_1_q_1);
    System.out.println("bigB_p: "+bigB_p);
    System.out.println("bigB_q: "+bigB_q);
    System.out.println(" public key : "+"n="+bigB_n+"  e="+bigB_pubKey);
    System.out.println(" private key: "+"n="+bigB_n+"  d="+bigB_prvKey);
    /* encrypting an ASCII integer value using the public key and decrypting
        the cipher value using the private key and extracting the ASCII value back */
    System.out.println("truoc khi ma hoa:"+ asciiVal);
    BigInteger bigB_val = new BigInteger(""+asciiVal);
    BigInteger bigB_cipherVal = bigB_val.modPow(bigB_pubKey, bigB_n);
    System.out.println("ciphertext: "+bigB_cipherVal);
    BigInteger bigB_plainVal = bigB_cipherVal.modPow(bigB_prvKey, bigB_n);
    int plainVal = bigB_plainVal.intValue();
    System.out.println("plaintext: "+plainVal);
    }
}