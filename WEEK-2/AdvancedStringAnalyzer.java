import java.util.*;

public class AdvancedStringAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ADVANCED STRING ANALYZER ===");

        // Ask user for two strings
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        // Perform all comparisons
        System.out.println("\n--- Comparison Results ---");
        performAllComparisons(str1, str2);

        // Performance Analysis
        System.out.println("\n--- Performance Analysis ---");
        String[] sampleInputs = {"Java", "Programming", "is", "fun", "and", "challenging"};
        long start = System.nanoTime();
        String inefficient = "";
        for (String s : sampleInputs) {
            inefficient += s; // Bad practice: creates new String every loop
        }
        long end = System.nanoTime();
        System.out.println("Inefficient concatenation time: " + (end - start) + " ns");

        start = System.nanoTime();
        String efficient = optimizedStringProcessing(sampleInputs);
        end = System.nanoTime();
        System.out.println("Optimized (StringBuilder) time: " + (end - start) + " ns");

        // Memory Analysis
        System.out.println("\n--- Memory Usage Analysis ---");
        analyzeMemoryUsage(str1, str2, inefficient, efficient);

        // Demonstrate intern()
        System.out.println("\n--- String Pool and intern() Demo ---");
        demonstrateStringIntern();

        scanner.close();
    }

    // Method to calculate string similarity percentage using Levenshtein distance
    public static double calculateSimilarity(String str1, String str2) {
        int distance = levenshteinDistance(str1, str2);
        int maxLen = Math.max(str1.length(), str2.length());
        if (maxLen == 0) return 100.0;
        return ((double) (maxLen - distance) / maxLen) * 100;
    }

    // Helper: Levenshtein distance
    private static int levenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                                  Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    // Perform all comparison types
    public static void performAllComparisons(String str1, String str2) {
        System.out.println("1. Reference equality (==): " + (str1 == str2));
        System.out.println("2. Content equality (equals): " + str1.equals(str2));
        System.out.println("3. Case-insensitive equality: " + str1.equalsIgnoreCase(str2));
        System.out.println("4. Lexicographic comparison (compareTo): " + str1.compareTo(str2));
        System.out.println("5. Case-insensitive compareTo: " + str1.compareToIgnoreCase(str2));
        System.out.printf("6. Similarity: %.2f%%\n", calculateSimilarity(str1, str2));
    }

    // Analyze string memory usage (approximation: 2 bytes per char)
    public static void analyzeMemoryUsage(String... strings) {
        for (String s : strings) {
            int bytes = s.length() * 2;
            System.out.println("\"" + s + "\" -> approx. " + bytes + " bytes (" + s.length() + " chars)");
        }
    }

    // Optimize string operations with StringBuilder
    public static String optimizedStringProcessing(String[] inputs) {
        StringBuilder sb = new StringBuilder();
        for (String s : inputs) {
            sb.append(s);
        }
        return sb.toString();
    }

    // Demonstrate intern()
    public static void demonstrateStringIntern() {
        String a = new String("Hello");
        String b = new String("Hello");
        System.out.println("a == b (before intern): " + (a == b));

        String c = a.intern();
        String d = b.intern();
        System.out.println("c == d (after intern): " + (c == d));
    }
}
