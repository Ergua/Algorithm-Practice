package ymj;

import java.util.*;

/**
 * Created by FYG on 17/8/23.
 */
public class MovieSchedule {
    class Movie {
        String name;
        List<Integer> time;
        Movie(String name) {
            this.name = name;
            time = new ArrayList<>();
        }

    }
    public List<String> schedule(List<Movie> input) {
        List<String> result = new ArrayList<>();
        List<Integer> time = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).time.size(); j++) {
                if (!time.contains(input.get(i).time.get(j))) {
                    time.add(input.get(i).time.get(j));
                }
            }
        }
        helper(result, time, input, 0, new StringBuilder());
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < time.size(); i++) {
//            for (int j = 0; j < input.size(); j++) {
//                if (input.get(j).time.contains(time.get(i))) {
//                    String temp = input.get(j).name + " " + time.get(i) + " ";
//                    sb.append(temp);
//                    break;
//                }
//            }
//        }
//        result.add(sb.toString());
        return result;
    }

    private void helper(List<String> result, List<Integer> time, List<Movie> input, int pos, StringBuilder sb) {
        if (pos == time.size()) {
            result.add(sb.toString());
            return;
        }

        for (int j = 0; j < input.size(); j++) {
            if (input.get(j).time.contains(time.get(pos))) {
                String temp = input.get(j).name + " " + time.get(pos) + " ";
                sb.append(temp);
                helper(result, time, input, pos + 1, sb);
                sb.delete(sb.length() - temp.length(), sb.length());
            }
        }
    }

    public static void main(String[] args) {
        MovieSchedule test = new MovieSchedule();
        List<Movie> list = new ArrayList<>();
        Movie a = test.new Movie("AAA");
        Movie b = test.new Movie("BBB");
        Movie c = test.new Movie("CCC");
        a.time.add(14);
        a.time.add(15);
        a.time.add(16);
        b.time.add(12);
        b.time.add(16);
        c.time.add(14);
        list.add(a);
        list.add(b);
        list.add(c);
        System.out.println(test.schedule(list));
    }
}
