import java.lang.Math;

public class VernamCipher {
    public static void main(String args[]) {
        String str = new String("KC");
        char[] arText = str.toCharArray();
        String cipher = new String("College");
        char[] arCipher = cipher.toCharArray();
        char[] encoded = new char[7];
        System.out.println("Encoded to be..");
        for (int i = 0; i < arText.length; i++) {
            encoded[i] = (char) (arText[i] ^ arCipher[i]);
            System.out.println(encoded[i]);
        }
        System.out.println("\nDecoded to be..");
        for (int i = 0; i < encoded.length; i++) {
            char tem = (char) (encoded[i] ^ arCipher[i]);
            System.out.println(tem);
        }
    }
}