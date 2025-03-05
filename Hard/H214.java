package Hard;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class H214 {
  public String shortestPalindrome(String s) {
    if(s.length()== 0) {
        return "";
    }
    int left = 0;
    int right = s.length()-1;
    for(int i=right;i>=0;i--) {
        if(s.charAt(left)== s.charAt(i)) {
            left ++;
        }
    }
    if(left == s.length()) {
        //full string palindrome
        return s;
    }

    String palindromPrefix = s.substring(0, left);
    String nonPalindromeSuffix = s.substring(left);
    StringBuilder reversedSuffix = new StringBuilder(nonPalindromeSuffix).reverse();

    return reversedSuffix
            .append(shortestPalindrome(palindromPrefix))
            .append(nonPalindromeSuffix)
            .toString();
  }
  public static void main(String[] args) {
    H214 h214 = new H214();
    System.out.println(h214.shortestPalindrome("aacecaaa"));
    System.out.println(h214.shortestPalindrome("abcd"));
  }
}
