public class StringBufferDemo {
    public static void main(String[] args) {
        // Create a StringBuffer
        StringBuffer sb = new StringBuffer("Java");

        // Append text
        sb.append(" Programming");
        System.out.println("1. After append: " + sb);

        // Insert text
        sb.insert(5, "Language ");
        System.out.println("2. After insert: " + sb);

        // Replace text
        sb.replace(5, 13, "is a ");
        System.out.println("3. After replace: " + sb);

        // Delete a part of the string
        sb.delete(5, 9);
        System.out.println("4. After delete: " + sb);

        // Reverse the string
        sb.reverse();
        System.out.println("5. After reverse: " + sb);

        // Get length and capacity
        System.out.println("6. Length: " + sb.length());
        System.out.println("7. Capacity: " + sb.capacity());

        // Reset back to normal for clarity
        sb.reverse();
        System.out.println("8. Back to normal: " + sb);

        // Set character at index
        sb.setCharAt(0, 'j');
        System.out.println("9. After setCharAt: " + sb);
    }
}
