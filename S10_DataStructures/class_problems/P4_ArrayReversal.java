import java.util.Scanner;

public class P4_ArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] a = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int left = 0, right = n - 1;

        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            left++;
            right--;
        }

        System.out.print("Reversed array: ");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");

        sc.close();
    }
}