package ymj;

import java.util.*;

/**
 * Created by FYG on 17/8/3.
 */
public class TopColor {
    public List<String> findTop(String[][] image) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        if (image == null || image.length == 0) {
            return result;
        }
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                map.put(image[i][j], map.getOrDefault(image[i][j], 0) + 1);
            }
        }
        int top = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > top) {
                top = entry.getValue();
                result = new ArrayList<String>();
                result.add(entry.getKey());
            } else if (entry.getValue() == top) {
                result.add(entry.getKey());
            }
        }
        System.out.println(result);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        TopColor test = new TopColor();
        String[][] in = {{"red", "blue", "black"},
                        {"red", "blue", "black"},
                        {"black", "red", "blue"}};
        System.out.println(test.findTop(in));
    }
}
