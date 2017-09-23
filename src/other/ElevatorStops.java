package other;

import java.util.HashSet;

/**
 * Created by FYG on 17/9/21.
 */
public class ElevatorStops {
    public int stops(int[] A, int[] B, int M, int X, int Y) {
        int result = 0;
        int num = 0;
        int totalWeight = 0;
        int curPeople = 0;
        boolean flag = false;
        HashSet<Integer> set = new HashSet<>();
        while (num < A.length) {
            if (totalWeight + A[num] <= Y && curPeople + 1 <= X) {
                totalWeight += A[num];
                curPeople++;
                set.add(B[num]);
                if (num == A.length - 1) {
                    flag = true;
                }
                num++;
            } else {
                flag = true;
            }

            if (flag) {
                set.add(0);
                result += set.size();
                set = new HashSet<>();
                totalWeight = 0;
                curPeople = 0;
                flag = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ElevatorStops test = new ElevatorStops();
        int[] A = {60, 80, 40};
        int[] B = {2, 3, 5};
        System.out.println(test.stops(A, B, 5, 2, 200));
    }
}
