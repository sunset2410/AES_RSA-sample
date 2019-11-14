/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//Thuật toán RSA áp dụng trên các số nguyên lớn (BigInteger trong Java)
package RAS;
import java.math.BigInteger;
import java.security.SecureRandom;
/**
 *
 * @author admin
 */
public class RSA_generator_key1 {
private final static SecureRandom random = new SecureRandom();
private BigInteger privateKey_d;
private BigInteger publicKey_e;
private BigInteger modulus;
public static final int KEY_SIZE =1024; 
    
//Constructor. Tạo khóa bí mật và khóa công khai có chiều dài KEY_SIZE
public RSA_generator_key1() {
BigInteger p = BigInteger.probablePrime(KEY_SIZE, random); //chon so nguyen to.
BigInteger q = BigInteger.probablePrime(KEY_SIZE, random);
if(p.equals(q)){
    q=q.nextProbablePrime(); //kiem tra q phai khac p;
   }
BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)); //tich (p-1)(q-1);
modulus = p.multiply(q); //p.q;
//publicKey_e = new BigInteger("70001");
publicKey_e = BigInteger.probablePrime(KEY_SIZE, random); //chon public_key;
    // Đảm bảo rằng e và phi là nguyên tố cùng nhau thi ucln cua e và phi phai la 1;
    while (!publicKey_e.gcd(phi).equals(BigInteger.ONE)) {
    publicKey_e = publicKey_e.nextProbablePrime();
    }
    
    privateKey_d = publicKey_e.modInverse(phi); //tinh private_key dua vao phi;
    
}   
public BigInteger getmodulus(){
    return modulus;
}

public BigInteger getprivateKey(){
    return privateKey_d;
}

public BigInteger getpublicKey(){
    return publicKey_e;
}
//ham ma hóa
/* c = m^e mod n */ 
public BigInteger encrypt(BigInteger message,BigInteger publicKey_e ,BigInteger modulus) {
return message.modPow(publicKey_e, modulus);
}

// hàm giải mã;
/* m = c^d mod n */
public BigInteger decrypt(BigInteger encrypted,BigInteger privateKey_d ,BigInteger modulus) {
return encrypted.modPow(privateKey_d, modulus);
}

// hàm main;
public static void main(String[] args) {
RSA_generator_key1 key = new RSA_generator_key1();
// VD1: Tạo một sốnguyên lớn ngẫu nhiên để mã hóa và giải mã
//BigInteger message = new BigInteger(KEY_SIZE - 1, random);

//VD2: Tạo một thông điệp bằng cách biến đổi chuỗi thông điệp sang số nguyên lớn.
//ma hóa;
System.out.println("public_key"+key.publicKey_e+"\n");
System.out.println("private_key"+key.privateKey_d+"\n");
String s = "A23DFGRTHVFCEGTh";
System.out.println("chuoi ki tu can ma hoa:"+s+"\n");
byte[] bytes = s.getBytes();
BigInteger message = new BigInteger(bytes); 
BigInteger encrypt = key.encrypt(message,key.publicKey_e,key.modulus);
byte[] byte2=encrypt.toByteArray();

String a=new String(byte2);
System.out.println("key sau khi ma hoa rsa"+a+"\n");

//giai ma;
byte[] byte3 = a.getBytes();
BigInteger b=new BigInteger(byte3);
BigInteger decrypt = key.decrypt(b,key.privateKey_d,key.modulus);

System.out.println("message = " + message+ "\n");
System.out.println("encrypted = " + encrypt+ "\n");
System.out.println("decrypted = " + decrypt+ "\n");
//System.out.println(decrypt.toString()); // chuyen tu biginteger sang string;
//System.out.println(new BigInteger(decrypt.toString()));  // chuyen tu string sang biginterger;
byte[] byte4=decrypt.toByteArray();
String d= new String(byte4);
System.out.println(d);

}


}
