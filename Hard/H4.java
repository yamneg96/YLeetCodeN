package Hard;

public class H4 {
      public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len3 = len1 + len2;
        int[] nums3 = new int[len3];
        int i = 0, j = 0, k = 0;
        //Merging the arrays.
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        while (i < len1) {
            nums3[k++] = nums1[i++];
        }
        while (j < len2) {
            nums3[k++] = nums2[j++];
        }
        // Sorting the merged array.
        for (int m = 0; m < len3 - 1; m++) {
            for (int n = m + 1; n < len3; n++) {
                if (nums3[m] > nums3[n]) {
                    int temp = nums3[m];
                    nums3[m] = nums3[n];
                    nums3[n] = temp;
                }
            }
        }
        if(len3 % 2 == 0){
            int mid = len3 / 2;
            ans = (nums3[mid] + nums3[mid-1]) / 2.0;
        }else{
            int mid = len3 / 2;
            ans = nums3[mid];
        }

        return ans;
    }

    public static void main(String[] args){
        int [] nums1 = {1, 3};
        int [] nums2 = {2};

        double ans = findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);

        int [] nums3 = {1, 2};
        int [] nums4 = {3, 4};
        double ans2 = findMedianSortedArrays(nums3, nums4);
        System.out.println(ans2);
    }
}
