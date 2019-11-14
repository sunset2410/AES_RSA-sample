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
public class RSA_DEMO {
private final static SecureRandom random = new SecureRandom();
private BigInteger privateKey_d;
private BigInteger publicKey_e;
private BigInteger modulus;
public static final int KEY_SIZE = 1025; 
    
//Constructor. Tạo khóa bí mật và khóa công khai có chiều dài KEY_SIZE
public RSA_DEMO() {
BigInteger p = BigInteger.probablePrime(KEY_SIZE, random); //chon so nguyen to.
BigInteger q = BigInteger.probablePrime(KEY_SIZE, random);
if(p==q){
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
    System.out.println("p="+p);
    System.out.println("q="+q);
    
}    

//ham ma hóa
/* c = m^e mod n */ 
BigInteger encrypt(BigInteger message) {
return message.modPow(publicKey_e, modulus);
}

// hàm giải mã;
/* m = c^d mod n */
BigInteger decrypt(BigInteger encrypted) {
return encrypted.modPow(privateKey_d, modulus);
}

// hàm main;
public static void main(String[] args) {
RSA_DEMO key = new RSA_DEMO();
// VD1: Tạo một sốnguyên lớn ngẫu nhiên để mã hóa và giải mã
//BigInteger message = new BigInteger(KEY_SIZE - 1, random);

//VD2: Tạo một thông điệp bằng cách biến đổi chuỗi thông điệp sang số nguyên lớn.
String s = "truong dai hoc nach khoa ha noi, dien tu vien thong 12 k54";
System.out.println(s+"\n");
byte[] bytes = s.getBytes();
BigInteger message = new BigInteger(bytes); 
BigInteger encrypt = key.encrypt(message);
BigInteger decrypt = key.decrypt(encrypt);
System.out.println("public_key"+key.publicKey_e+"\n");
System.out.println("private_key"+key.privateKey_d+"\n");
System.out.println("message = " + message+ "\n");
System.out.println("encrypted = " + encrypt+ "\n");
System.out.println("decrypted = " + decrypt+ "\n");
byte[] byte2=decrypt.toByteArray();
String d= new String(decrypt.toByteArray());
System.out.println(d);

}


}
