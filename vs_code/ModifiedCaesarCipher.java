import java.io.*;

class ModifiedCaesarCipher {
    public String Encrypt(int shift, String line) {
        String result = "";
        int offset;
        for (int i = 0; i < line.length(); i++) {
            offset = ((int) line.charAt(i) + shift) % 256;
            result += (char) (offset);
        }
        return result;
    }

    public String Decrypt(int shift, String line) {
        String result = "";
        int offset;
        for (int i = 0; i < line.length(); i++) {
            offset = ((int) line.charAt(i) - shift) % 256;
            if (offset < 0) {
                offset += 256;
            }
            result += (char) (offset);
        }
        return result;
    }

    public static void main(String args[])
            throws IOException {
        ModifiedCaesarCipher b = new ModifiedCaesarCipher();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        System.out.println("Menu:\n1: Encryption\n2: Decryption");
        choice = Integer.parseInt(br.readLine());
        System.out.println("Enter the shift");
        int shift = Integer.parseInt(br.readLine());
        System.out.println("Enter the line");
        String line = br.readLine();
        System.out.println("Result: ");
        switch (choice) {
            case 1: {
                System.out.println(b.Encrypt(shift, line));
                break;
            }
            case 2: {
                System.out.println(b.Decrypt(shift, line));
                break;
            }
            default: {
                System.out.println("Invalid choice");
            }
        }
    }
}
