import java.util.Arrays;

public class P5_DiceThrowTally {

    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int v : rolls)
            count[v]++;

        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++)
            System.out.print(i + ":" + count[i] + "  ");

        int[] result = new int[rolls.length];
        int k = 0;

        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < count[i]; j++)
                result[k++] = i;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        int[] rolls2 = {6, 3, 2, 5, 3};

        System.out.println("Sample Input:");
        int[] result1 = diceSort(rolls1);
        System.out.println("\nSorted: " + Arrays.toString(result1));

        System.out.println("\nOwn Input:");
        int[] result2 = diceSort(rolls2);
        System.out.println("\nSorted: " + Arrays.toString(result2));
    }
}
