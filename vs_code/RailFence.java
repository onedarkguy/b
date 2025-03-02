class RailFence {
    public static void main(String[] args) {
        String input = "Good afternoon everybody";
        String cipherText = encryptRailFence(input);
        System.out.println("Cipher text: " + cipherText);
    }

    public static String encryptRailFence(String text) {
        StringBuilder row1 = new StringBuilder();
        StringBuilder row2 = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0)
                row1.append(text.charAt(i));
            else
                row2.append(text.charAt(i));
        }

        return row1.toString() + row2.toString();
    }
}
