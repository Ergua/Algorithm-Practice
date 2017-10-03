package other;
import java.util.*;

/**
 * Created by FYG on 17/10/2.
 */
public class Ibmmianjing2 {
    public String solution(int N, int p, int q) {
        if (N <= 0 || p < 1 || q < 1 || p == q) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            boolean contained = containsNum(i, p, q);
            if (i % p != 0 && i % q != 0 && !contained) {
                sb.append(i);
                if (i != N) {
                    sb.append(",");
                }
            } else {
                if (i % p == 0 || i % q == 0) {
                    sb.append("OUT");
                }
                if (contained) {
                    sb.append("THINK");
                }
                if (i != N) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    public boolean containsNum(int num, int p, int q) {
        while (num > 0) {
            int temp = num % 10;
            if (temp == p || temp == q) {
                return true;
            } else {
                num /= 10;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Ibmmianjing2 test = new Ibmmianjing2();
        System.out.println(test.solution(7, 2, 3));
    }


}
