import java.util.Scanner;

public class P3_DutyRosterRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] names = new String[n];

        for (int i = 0; i < n; i++)
            names[i] = sc.next();

        int k = sc.nextInt();
        k = k % n;

        String[] rotated = new String[n];

        for (int i = 0; i < n; i++)
            rotated[(i + k) % n] = names[i];

        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(rotated[i]);
            if (i < n - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}