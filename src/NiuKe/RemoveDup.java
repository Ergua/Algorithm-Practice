package NiuKe;

/**
 * Created by FYG on 17/8/11.
 */
import java.util.*;

public class RemoveDup{
    public String removeDup(int[] input) {
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = input.length - 1; i >= 0; i--) {
            if (!set.contains(input[i])) {
                sb.insert(0, input[i] + " ");
                set.add(input[i]);
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        RemoveDup test = new RemoveDup();
        System.out.print(test.removeDup(input));
    }
}
