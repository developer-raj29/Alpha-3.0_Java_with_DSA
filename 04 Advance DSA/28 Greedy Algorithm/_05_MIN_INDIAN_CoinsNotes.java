import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class _05_MIN_INDIAN_CoinsNotes {
    public static void main(String[] args) {
        Integer Coins_Notes[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

        Arrays.sort(Coins_Notes, Comparator.reverseOrder());

        int CountOfCoins = 0;
        int Amount = 590;

        ArrayList<Integer> Ans = new ArrayList<>();

        for (int i = 0; i < Coins_Notes.length; i++) {
            if (Coins_Notes[i] <= Amount) {
                while (Coins_Notes[i] <= Amount) {
                    CountOfCoins++;
                    Ans.add(Coins_Notes[i]);
                    Amount -= Coins_Notes[i];
                }
            }
        }
        System.out.println("MINMUM Coins and Notes are Used: " + CountOfCoins);

        for (int i = 0; i < Ans.size(); i++) {
            System.out.print(Ans.get(i) + ", "); // 500, 50, 20, 20
        }
        System.out.println();
    }
}
