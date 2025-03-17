import java.util.HashMap;

public class E2206 {
    public static boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Check if all counts are even
        for (int count : freq.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    // Test Cases
    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{3, 2, 3, 2, 2, 2})); // Output: true
        System.out.println(divideArray(new int[]{1, 2, 3, 4}));       // Output: false
    }
}
