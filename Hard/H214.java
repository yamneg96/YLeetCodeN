package Hard;

public class H214 {
    public String shortestPalindrome(String s) {
        if (s.length() == 0) {
            return ""; // Handle empty string case
        }
        int left = 0;
        int right = s.length() - 1;
        for (int i = right; i >= 0; i--) {
            if (s.charAt(left) == s.charAt(i)) {
                left++; // Increment left if characters match
            }
        }
        if (left == s.length()) {
            // full string palindrome
            return s; // Return original string if it's already a palindrome
        }

        String palindromPrefix = s.substring(0, left); // Extract prefix that forms a palindrome
        String nonPalindromeSuffix = s.substring(left); // Extract suffix that is not a palindrome
        StringBuilder reversedSuffix = new StringBuilder(nonPalindromeSuffix).reverse(); // Reverse the non-palindrome suffix

        return reversedSuffix
                .append(shortestPalindrome(palindromPrefix)) // Recursively find shortest palindrome for the prefix
                .append(nonPalindromeSuffix) // Append the original non-palindrome suffix
                .toString();
    }

    public static void main(String[] args) {
        H214 h214 = new H214();
        System.out.println(h214.shortestPalindrome("aacecaaa"));
        System.out.println(h214.shortestPalindrome("abcd"));
    }
}