import java.util.HashMap;
import java.util.Map;

public class M2537 {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long total = 0;
        long countPairs = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int curr = nums[right];
            int prevFreq = freq.getOrDefault(curr, 0);
            countPairs += prevFreq; // Every new element adds 'prevFreq' new pairs

            freq.put(curr, prevFreq + 1);

            // Shrink window from the left if we already have enough pairs
            while (countPairs >= k) {
                total += nums.length - right; // All subarrays [left..right], ..., [left..n-1] are good

                int leftVal = nums[left];
                int leftFreq = freq.get(leftVal);
                freq.put(leftVal, leftFreq - 1);
                countPairs -= leftFreq - 1; // Removing 1 occurrence removes (leftFreq - 1) pairs

                left++;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        M2537 sol = new M2537();

        int[] nums1 = {1, 1, 1, 1, 1};
        int k1 = 10;
        System.out.println("Output (Test 1): " + sol.countGood(nums1, k1)); // Expected: 1

        int[] nums2 = {3, 1, 4, 3, 2, 2, 4};
        int k2 = 2;
        System.out.println("Output (Test 2): " + sol.countGood(nums2, k2)); // Expected: 4

        int[] nums3 = {1, 2, 3, 1, 2, 3, 1};
        int k3 = 3;
        System.out.println("Output (Test 3): " + sol.countGood(nums3, k3)); // Custom example

        int[] nums4 = {1000000000, 1000000000, 1000000000, 1000000000};
        int k4 = 6;
        System.out.println("Output (Test 4): " + sol.countGood(nums4, k4)); // Expected: 1
    }
}
