public class StringPerformanceDemo {
    public static void main(String[] args) {
        int iterations = 100000; // number of concatenations

        // Test 1: Improved String concatenation using char array
        long start = System.currentTimeMillis();
        char[] chars = new char["Java".length() + iterations];
        "Java".getChars(0, "Java".length(), chars, 0);
        for (int i = "Java".length(); i < chars.length; i++) {
            chars[i] = 'X';
        }
        String str = new String(chars);
        long end = System.currentTimeMillis();
        System.out.println("String += time: " + (end - start) + " ms");

        // Test 2: Efficient StringBuilder with pre-sizing
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("Java".length() + iterations);
        for (int i = 0; i < iterations; i++) {
            sb.append("X");
        }
        String result = sb.toString();
        end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + " ms");

        // Test 3: Efficient StringBuffer with pre-sizing
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("Java".length() + iterations);
        for (int i = 0; i < iterations; i++) {
            sbf.append("X");
        }
        String resultBuffer = sbf.toString();
        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + " ms");
    }
}
