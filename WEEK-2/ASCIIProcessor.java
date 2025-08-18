import java.util.*;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\n--- Character Analysis ---");
        for (char ch : input.toCharArray()) {
            int ascii = (int) ch;
            System.out.print("Char: '" + ch + "' | ASCII: " + ascii);

            String type = classifyCharacter(ch);
            System.out.print(" | Type: " + type);

            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                System.out.print(" | Upper: " + upper + " (" + (int) upper + ")");
                System.out.print(" | Lower: " + lower + " (" + (int) lower + ")");
                System.out.print(" | Diff (A-a): " + Math.abs('A' - 'a'));
            }
            System.out.println();
        }

        // Toggle case demo
        System.out.println("\n--- Toggle Case Demo ---");
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                System.out.println(ch + " -> " + toggleCase(ch));
            }
        }

        // Caesar Cipher demo
        System.out.println("\n--- Caesar Cipher Demo (Shift = 3) ---");
        String ciphered = caesarCipher(input, 3);
        System.out.println("Encrypted: " + ciphered);
        System.out.println("Decrypted: " + caesarCipher(ciphered, -3));

        // ASCII Table demo
        System.out.println("\n--- ASCII Table (65 to 90) ---");
        displayASCIITable(65, 90);

        // String to ASCII array
        System.out.println("\n--- String to ASCII Array ---");
        int[] asciiArray = stringToASCII(input);
        System.out.println(Arrays.toString(asciiArray));

        // ASCII array back to String
        System.out.println("\n--- ASCII Array to String ---");
        System.out.println(asciiToString(asciiArray));

        scanner.close();
    }

    // Method to classify character type
    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        else if (Character.isLowerCase(ch)) return "Lowercase Letter";
        else if (Character.isDigit(ch)) return "Digit";
        else return "Special Character";
    }

    // Method to convert case using ASCII manipulation
    public static char toggleCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + 32); // Upper to Lower
        } else if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - 32); // Lower to Upper
        } else {
            return ch; // Non-letters unchanged
        }
    }

    // Method to implement Caesar cipher
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append((char) ('A' + (ch - 'A' + shift + 26) % 26));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) ('a' + (ch - 'a' + shift + 26) % 26));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Method to create ASCII table for a range
    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char) i);
        }
    }

    // Method to convert string to ASCII array
    public static int[] stringToASCII(String text) {
        int[] asciiValues = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            asciiValues[i] = (int) text.charAt(i);
        }
        return asciiValues;
    }

    // Method to convert ASCII array back to string
    public static String asciiToString(int[] asciiValues) {
        StringBuilder result = new StringBuilder();
        for (int val : asciiValues) {
            result.append((char) val);
        }
        return result.toString();
    }
}
