package ymj;

/**
 * Created by FYG on 17/8/22.
 */
public class Concatenate {
    public String concatenate(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            String tail = s1.substring(i);
            if (s2.startsWith(tail)) {
                sb.append(s1.substring(0, i));
                sb.append(s2);
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Concatenate test = new Concatenate();
        System.out.println(test.concatenate("hello","loop"));
    }
}
