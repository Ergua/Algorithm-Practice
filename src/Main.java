import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            list.add(in.nextInt());
        }
        int start = 0, end = list.size() - 1;
        int result = helper(list, start, end);

        System.out.println(result);
    }

    public static int helper(ArrayList<Integer> list, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return list.get(start);
        }
        int temp = Integer.MAX_VALUE;
        if (list.get(start) == list.get(end)) {
            temp = helper(list, start + 1, end - 1) + list.get(start) * 2;
        }

        return Math.min(temp, Math.min(helper(list, start + 1, end) + list.get(start) * 2, helper(list, start, end - 1) + list.get(end) * 2));
    }
}