public class M2401{
  public static int longestNiceSubarray(int[] nums) {
    int left = 0, bitwiseAND = 0, maxLen = 0;

    for (int right = 0; right < nums.length; right++) {
        // Remove elements from the left until the AND condition is satisfied
        while ((bitwiseAND & nums[right]) != 0) {
            bitwiseAND ^= nums[left]; // Remove leftmost element from bitwiseAND
            left++;
        }

        // Add the new number
        bitwiseAND |= nums[right];

        // Update max length
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
  }

  // Test Cases
  public static void main(String[] args) {
    System.out.println(longestNiceSubarray(new int[]{1, 3, 8, 48, 10})); // Output: 3
    System.out.println(longestNiceSubarray(new int[]{3, 1, 5, 11, 13})); // Output: 1
  }
}