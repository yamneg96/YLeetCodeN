public class H2179 {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Map from value to index in nums2
        int[] indexInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            indexInNums2[nums2[i]] = i;
        }

        // Map nums1 to positions in nums2
        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = indexInNums2[nums1[i]];
        }

        Fenwick leftTree = new Fenwick(n);
        Fenwick rightTree = new Fenwick(n);

        // Initially, all values are in the right tree
        for (int i = 0; i < n; i++) {
            rightTree.update(mapped[i], 1);
        }

        long goodTriplets = 0;
        for (int i = 0; i < n; i++) {
            int mid = mapped[i];
            rightTree.update(mid, -1);  // Remove current from right

            long leftLess = leftTree.query(mid - 1);
            long rightGreater = rightTree.query(n - 1) - rightTree.query(mid);

            goodTriplets += leftLess * rightGreater;

            leftTree.update(mid, 1); // Add current to left
        }

        return goodTriplets;
    }

    // Binary Indexed Tree (Fenwick Tree)
    class Fenwick {
        long[] tree;
        int n;

        public Fenwick(int size) {
            n = size;
            tree = new long[n + 1];
        }

        public void update(int index, int delta) {
            index++;  // Convert to 1-based index
            while (index <= n) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        public long query(int index) {
            index++;  // Convert to 1-based index
            long sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    // Main method to test the examples
    public static void main(String[] args) {
      H2179 sol = new H2179();

        int[] nums1 = {2, 0, 1, 3};
        int[] nums2 = {0, 1, 2, 3};
        System.out.println("Output (Example 1): " + sol.goodTriplets(nums1, nums2)); // 1

        int[] nums3 = {4, 0, 1, 3, 2};
        int[] nums4 = {4, 1, 0, 2, 3};
        System.out.println("Output (Example 2): " + sol.goodTriplets(nums3, nums4)); // 4
    }
}
