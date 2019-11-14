package RAS;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
public class RAS_generator_key {
    
    private static final int KEYSIZE = 8192;
    public static void main(String[] args) {
    generateKey("C:\\Users\\admin\\Desktop\\Ma hóa RAS\\RSA_privatekey.txt","C:\\Users\\admin\\Desktop\\Ma hóa RAS\\RSA_publickey.txt");
        }
    
    public static void generateKey(String privateKey, String publicKey) {
    try {
    KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");
    SecureRandom random = new SecureRandom();
    pairgen.initialize(KEYSIZE, random);
    KeyPair keyPair = pairgen.generateKeyPair();
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(publicKey));
    out.writeObject(keyPair.getPublic());
    out.close();
    out = new ObjectOutputStream(new FileOutputStream(privateKey));
    out.writeObject(keyPair.getPrivate());
    out.close();
    } catch (IOException e) {
    System.err.println(e);
    } catch (GeneralSecurityException e) {
    System.err.println(e);
        }
    }
}