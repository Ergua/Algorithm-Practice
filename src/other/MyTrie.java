package other;

/**
 * Created by FYG on 17/7/17.
 */

/**
 * Implement a Trie tree with basic functions
 *
 */

 import java.util.HashMap;
 import basicDataStructure.TrieNode;

public class MyTrie {
    TrieNode root;
    public MyTrie() {
        this.root = new TrieNode();
    }

    public void insert(String word, String define) {
        if (search(word) != null) {
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children == null) {
                node.children = new HashMap<Character, TrieNode>();
            }
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode(c));
            }
            node.count++;
            node = node.children.get(c);
        }
        //node.isEnd = true;
        node.definition = define;
    }

    public String search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children == null || !node.children.containsKey(c)) {
                return null;
            }
            node = node.children.get(c);
        }
        //return node.isEnd;
        return node.definition;
    }

    public boolean startWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children == null || !node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }

    public void remove(String word) {
        if (search(word) != null) {
            TrieNode node = root;
//			helper(word, node, word.length(), 0);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.count == 1) {
                    node.children.remove(c);
                    return;
                } else {
                    node.count--;
                    node = node.children.get(c);
                }
            }
            node.definition = null;
        }
    }

//	public void helper(String word, TrieNode node, int length, int level) {
//		if (level == length) {
//			if (node.children == null) {
//
//			}
//		}
//	}

    public static void main(String[] args) {
        MyTrie test = new MyTrie();
        test.insert("lala", "dajiji");
        test.insert("word", "zi");
        test.insert("work", "gongzuo");
        System.out.println(test.search("work"));
        System.out.println(test.startWith("wor"));
        test.remove("work");
        System.out.println(test.search("work"));
        System.out.println(test.search("word"));
        test.remove("word");
        System.out.println(test.search("word"));
        System.out.println(test.search("afdwegbuicnxjkx"));
    }
}

