package basicDataStructure;

/**
 * Created by FYG on 17/7/17.
 */
import java.util.HashMap;

public class TrieNode {
    public HashMap<Character, TrieNode> children;
    public char val;
    //public boolean isEnd;
    public String definition;
    public int count = 0;
    public TrieNode() {}
    public TrieNode(char c) {
        this.val = c;
    }
}
