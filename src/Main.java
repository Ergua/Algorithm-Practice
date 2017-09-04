import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int result = 0;

        StringBuilder sb = new StringBuilder("asadad");
        System.out.print(sb.toString());
        //result = result + x * Math.min((n - n / d) / a, (m - m / c) / b);
        //while ((n / d) >= 0 && (m / c) >= 0) {
        //
        //}

        for (int i = 0; i * d <= n; i++) {
            for (int j = 0; j * c <= m ; j++) {
                int allColor = i * z;
                int allWhite = j * y;
                int combine = Math.min((n - i * d) / a, (m - j * c) / b) * x;
                result = Math.max(result, allColor + allWhite + combine);
            }
        }

        System.out.println(result);
    }
}
