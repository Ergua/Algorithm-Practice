package other;

/**
 * Created by FYG on 17/10/2.
 */
public class Ibmmianjing3 {
    int count = 0;
    public String solution(String[] input, String prefix) {
        Node root =  new Node(' ');
        for (String s : input) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (node.children[c - 'A'] == null) {
                    node.children[c - 'A'] = new Node(c);
                }
                node = node.children[c - 'A'];
            }
            node.isEnd = true;
        }

        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.children[prefix.charAt(i) - 'A'] == null) {
                return "<NONE>";
            } else {
                node = node.children[prefix.charAt(i) - 'A'];
            }
        }

        StringBuilder sb = new StringBuilder();

        helper(node, sb, prefix);
        return sb.toString();
    }

    public void helper(Node node, StringBuilder sb, String prefix) {
        if (node.isEnd) {
            sb.append(prefix);
            sb.append("\n");
            count++;
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                helper(node.children[i], sb, prefix + node.children[i].val);
                if (count == 3) return;
            }
        }
    }

    public static void main(String[] args) {
        Ibmmianjing3 test = new Ibmmianjing3();
        String[] in = {"ABC", "ABCD", "AZ"};
        System.out.println(test.solution(in, "A"));
    }
}



class Node {
    Node[] children = new Node[26];
    char val;
    boolean isEnd;
    Node(char c) {
        this.val = c;
    }
}
