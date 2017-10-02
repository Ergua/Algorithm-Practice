package other;

import java.util.*;

/**
 * Created by FYG on 17/9/23.
 */
public class DragonChallenge {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> step = new ArrayList<>();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            try {
                int num = Integer.parseInt(line);
                if (num < 0) {
                    System.out.print("failure\n");
                    return;
                }
                step.add(num);
            } catch (NumberFormatException e) {
                System.out.print("failure\n");
                return;
            }
        }

        if (step.size() == 0) {
            System.out.println("out");
            return;
        }
        int start = 0, end = 0;
        ArrayList<Integer> result = new ArrayList<>();
        int longest = 0;
        while (end < step.size()) {
            int temp = -1;
            for (int i = start; i <= end; i++) {
                if (step.get(i) == 0) {
                    if (i == end && temp == -1) {
                        System.out.print("failure\n");
                        return;
                    }
                    continue;
                }
                if (i <= longest && i + step.get(i) > longest) {
                    longest = i + step.get(i);
                    temp = i;
                    if (longest > step.size() - 1) {
                        break;
                    }
                }
            }
            if (temp != -1) {
                result.add(temp);
            } else {
                System.out.print("failure\n") ;
            }
            start = end + 1;
            end = longest;
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + ", ");
        }
        System.out.print("out\n");
    }
}
