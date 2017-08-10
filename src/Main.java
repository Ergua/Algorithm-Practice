import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        ArrayList<Integer> out = new ArrayList<>();
        System.out.println(out == null);

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(-100);
        a.add(8);
        List<Integer> b = new ArrayList<>();
        b.add(11);
        b.add(-1);
        b.add(8);
        List<Integer> c = new ArrayList<>();
        c.addAll(a);
        c.addAll(b);
        Collections.sort(c);
        System.out.println(c);
    }
}
