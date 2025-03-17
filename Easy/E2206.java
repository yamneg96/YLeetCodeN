import java.util.Scanner;

public class E2206{
  public static boolean divideArray(int[] nums) {
    int len = nums.length;
    int n = len / 2;
    int newarr[] = new int[len];

    if(len % 2 != 0){
      return false;
    }
    else{
      for (int i=0; i<len; i++){
        if((nums[i] < nums[i++]) && i++ <= len){
          newarr[i] = nums[i];
          //  System.out.println(newarr[i]);
          //  System.out.println(nums[i]);
          //  System.out.println(i);

        }
      }
      return true;
    }
}

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the length of the array: ");
    int n = input.nextInt();
    int[] nums = new int[n];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      nums[i] = input.nextInt();
    }
    boolean result = divideArray(nums);
    System.out.println(result);
    input.close();

    // int[] nums = {1, 2, 3, 4, 5, 6};
    // boolean result = divideArray(nums);
    // System.out.println(result);
      
  }
}