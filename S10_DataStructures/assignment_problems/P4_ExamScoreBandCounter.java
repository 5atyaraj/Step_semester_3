import java.util.Scanner;

class BandCounter {
    int countInBand(int[] scores, int low, int high) {
        int left = 0, right = scores.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (scores[mid] < low)
                left = mid + 1;
            else
                right = mid;
        }

        int first = left;
        left = 0;
        right = scores.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (scores[mid] <= high)
                left = mid + 1;
            else
                right = mid;
        }

        return left - first;
    }
}

public class P4_ExamScoreBandCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++)
            scores[i] = sc.nextInt();

        int low = sc.nextInt();
        int high = sc.nextInt();

        BandCounter obj = new BandCounter();
        System.out.println(obj.countInBand(scores, low, high));

        sc.close();
    }
}