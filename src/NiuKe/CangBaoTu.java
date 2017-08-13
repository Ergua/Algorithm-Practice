package NiuKe;
import java.util.*;
/**
 * Created by FYG on 17/8/11.
 */
public class CangBaoTu {
    public boolean helper(String s, String t, StringBuilder sb, int pos) {
        if (sb.length() == t.length()) {
            System.out.println(sb.toString());
            return sb.toString().equals(t);
        }

        for (int i = pos; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (helper(s, t, sb, i + 1)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        CangBaoTu test = new CangBaoTu();
        boolean result = test.helper(s, t, new StringBuilder(), 0);
        if (result) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}
