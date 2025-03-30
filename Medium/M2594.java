import java.util.Arrays;
public class M2594 {
  public static boolean canRepairAll(int[] ranks, int cars, long time) {
    int repairedCars = 0;
    for (int rank : ranks) {
        // Calculate max cars this mechanic can repair within 'time'
        repairedCars += (int) Math.sqrt(time / rank);
        if (repairedCars >= cars) return true; // Enough cars repaired
    }
    return false;
}

public static long repairCars(int[] ranks, int cars) {
    Arrays.sort(ranks); // Sorting helps assign lower-ranked mechanics first

    long low = 1, high = (long) ranks[0] * (long) cars * cars, ans = high;

    while (low <= high) {
        long mid = low + (high - low) / 2;

        if (canRepairAll(ranks, cars, mid)) {
            ans = mid;  // Try a smaller max time
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}

// Test Cases
public static void main(String[] args) {
    System.out.println(repairCars(new int[]{4, 2, 3, 1}, 10)); // Output: 16 ✅
    System.out.println(repairCars(new int[]{5, 1, 8}, 6));      // Output: 16 ✅
}
}
