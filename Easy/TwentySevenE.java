import java.util.Scanner;
public class TwentySevenE {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter Array Length: ");
    int n = input.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
        nums[i] = input.nextInt();
    }
    int result = removeDuplicates(nums);
    System.out.print(result + ", nums = [");
    for (int i = 0; i < result; i++) {
        System.out.print(nums[i]);
        if (i < result - 1) {
            System.out.print(",");
        }
    }
    System.out.print("]");
    input.close();
}

public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }

    int k = 1; // First element is always unique
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) {
            nums[k] = nums[i]; // Place the unique element
            k++;
        }
    }
    return k;
}
}