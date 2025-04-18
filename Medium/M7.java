package Medium;

import java.util.Scanner;

// Reverse Integer: Given a 32-bit signed integer, reverse digits of an integer.
public class M7 {
    public int reverse(int x) {
        StringBuilder builder = new StringBuilder(Integer.toString(x));
        String number = builder.reverse().toString();
        // Handle negative numbers
        if (number.charAt(number.length() - 1) == '-') {
            number = "-" + number.substring(0, number.length() - 1);
        }
        try {
            return Integer.parseInt(number);
        } catch (Exception e) { // Catch potential overflow exceptions
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        M7 obj = new M7();
        int result = obj.reverse(n);
        System.out.println(result);
        input.close();
    }
}