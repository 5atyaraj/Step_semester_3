import java.util.*;

public class P5_PairTargetSum {

    static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            if (set.contains(target - x))
                return true;

            set.add(x);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] a = {2, 7, 11, 15};
        int[] b = {3, 4, 6};

        System.out.println(hasPairWithSum(a, 9));
        System.out.println(hasPairWithSum(b, 20));
    }
}
