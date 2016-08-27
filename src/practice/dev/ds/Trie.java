package practice.dev.ds;

import java.util.List;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String s) {
        if (s == null || s.trim().length() == 0) {
            return;
        }
        root.insert(s);
    }

    public boolean search(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        return root.search(s);
    }
    public void searchWithPrefix(String s) {
        List<String> list=root.searchWithPrefix(s);
        for (String string : list) {
            System.out.println(string);
        }
        
    }
}
