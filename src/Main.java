import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(num[i])) {
                set.add(num[i]);
                result.add(num[i]);
            }
        }

        Collections.sort(result, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        System.out.println(result.size());
        String res = "";
        for (int i = 0; i < result.size(); i++) {
            res = res + " " + result.get(i);
        }
        System.out.println(res.trim());


    }

}