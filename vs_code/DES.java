import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class DES {
    private Cipher ecipher;
    private Cipher dcipher;

    public DES(SecretKey key) {
        try {
            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String str) {
        try {
            byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);
            byte[] enc = ecipher.doFinal(utf8);
            return Base64.getEncoder().encodeToString(enc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decrypt(String str) {
        try {
            byte[] dec = Base64.getDecoder().decode(str);
            byte[] utf8 = dcipher.doFinal(dec);
            return new String(utf8, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("\nEncrypting string using DES Algorithm\n");

        try {
            SecretKey key = KeyGenerator.getInstance("DES").generateKey();
            DES encrypter = new DES(key);

            String original = "KC College";
            String encrypted = encrypter.encrypt(original);
            String decrypted = encrypter.decrypt(encrypted);

            System.out.println("Original: " + original);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
