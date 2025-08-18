import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter a sentence with mixed formatting
        System.out.println("Enter a sentence with mixed formatting (include spaces, digits, punctuation): ");
        String input = scanner.nextLine();

        // 1. trim() - Remove extra spaces
        String trimmed = input.trim();
        System.out.println("\n1. Trimmed text: " + trimmed);

        // 2. replace() - Replace all spaces with underscores
        String replacedSpaces = trimmed.replace(" ", "_");
        System.out.println("2. Spaces replaced with underscores: " + replacedSpaces);

        // 3. replaceAll() - Remove all digits using regex
        String noDigits = trimmed.replaceAll("\\d", "");
        System.out.println("3. Digits removed: " + noDigits);

        // 4. split() - Split sentence into words array
        String[] words = trimmed.split("\\s+"); 
        System.out.println("4. Words split into array: " + Arrays.toString(words));

        // 5. join() - Rejoin words with " | " separator
        String joined = String.join(" | ", words);
        System.out.println("5. Rejoined with separator: " + joined);

        // Additional Processing
        System.out.println("\n--- Additional Processing ---");
        System.out.println("6. Without punctuation: " + removePunctuation(trimmed));
        System.out.println("7. Capitalized words: " + capitalizeWords(trimmed));
        System.out.println("8. Reversed word order: " + reverseWordOrder(trimmed));
        
        System.out.println("9. Word frequency count:");
        countWordFrequency(trimmed);

        scanner.close();
    }

    // Method to remove punctuation
    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }

    // Method to capitalize each word
    public static String capitalizeWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }
        return result.toString().trim();
    }

    // Method to reverse word order
    public static String reverseWordOrder(String text) {
        String[] words = text.split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    // Method to count word frequency
    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().replaceAll("\\p{Punct}", "").split("\\s+");
        Map<String, Integer> freqMap = new LinkedHashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println("   " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
