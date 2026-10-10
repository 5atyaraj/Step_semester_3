import java.util.Scanner;

public class P2_WordReverser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String reverse = new StringBuilder(s).reverse().toString();

        System.out.println(reverse);

        if (s.equals(reverse))
            System.out.println("palindrome");
        else
            System.out.println("not a palindrome");

        sc.close();
    }
}