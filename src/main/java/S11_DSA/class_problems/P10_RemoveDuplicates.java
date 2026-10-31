public class P10_RemoveDuplicates {

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};

        int k = removeDuplicates(nums);

        System.out.println("length = " + k);
        System.out.print("nums[0.." + (k - 1) + "] = [");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);

            if (i < k - 1)
                System.out.print(", ");
        }

        System.out.println("]");
    }
}
