import java.util.Scanner;

public class Q2 {
    
    // Method to find length of a string without using length()
    public static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Reached end of string
        }
        return count;
    }

    // Method to split the string into words without using split()
    public static String[] customSplit(String s) {
        int len = getLength(s);

        // Count words by counting spaces (words = spaces + 1 if string not empty)
        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (c == ' ') {
                inWord = false;
            }
        }

        // Store indexes of spaces (plus -1 at start and len at end for easier extraction)
        int[] spaceIndexes = new int[wordCount + 1];
        int index = 0;
        spaceIndexes[index++] = -1; // to mark before the first character
        
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index] = len; // mark end of string

        // Extract words between the spaces
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            int start = spaceIndexes[i] + 1;
            int end = spaceIndexes[i + 1];
            StringBuilder word = new StringBuilder();
            for (int j = start; j < end; j++) {
                word.append(s.charAt(j));
            }
            words[i] = word.toString();
        }
        
        return words;
    }

    // Method to compare two String arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1 == null || arr2 == null) return false;
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String input = scanner.nextLine();

        // Use built-in split() method
        String[] builtinWords = input.trim().split("\\s+");

        // Use custom split() method
        String[] customWords = customSplit(input);

        // Compare results
        boolean isEqual = compareStringArrays(builtinWords, customWords);

        System.out.println("\nBuilt-in split() output:");
        for (String w : builtinWords) {
            System.out.println("[" + w + "]");
        }

        System.out.println("\nCustom split() output:");
        for (String w : customWords) {
            System.out.println("[" + w + "]");
        }

        System.out.println("\nAre both arrays equal? " + isEqual);

        scanner.close();
    }
}
