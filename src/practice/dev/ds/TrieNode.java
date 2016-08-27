package practice.dev.ds;

/***
 * 
Search all the words for a given prefix in Dictionary
TRIE is best suitable Structure to maintain a Dictionary. Suppose we want to get the words which has given word as prefix.
To provide this functionality, Our TRIE Node will slightly different from what we have seen in previous post.  
Trie will have one more attribute to store the actual word.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {
    char data;
    boolean is_end_of_string;
    Map<Character, TrieNode> nodes;
    String actualWord;

    public TrieNode(char data) {
        this.data = data;
        is_end_of_string = false;
        nodes = new HashMap<Character, TrieNode>();
    }

    public TrieNode children(char data) {
        return nodes.get(data);
    }
    private Map<Character, TrieNode> getAllchildren() {
        return nodes;
    }

    public boolean isChildExist(char c) {
        return children(c) != null;
    }

    public void insert(String s) {
        if (s == null || s.trim().length() == 0) {
            return;
        }
        TrieNode current = this;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!current.isChildExist(c)) {
                TrieNode node = new TrieNode(c);
                current.nodes.put(c, node);
            }
            current = current.children(c);
        }
        current.actualWord=s;
        current.is_end_of_string = true;
    }

    public boolean search(String s) {
        TrieNode current = getLastNode(s);
        return current!=null?current.is_end_of_string:false;
    }

    private TrieNode getLastNode(String s) {
        TrieNode current = this;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!current.isChildExist(c)) {
                return null;
            }
            current = current.children(c);
        }
        return current;
    }

    public List<String> searchWithPrefix(String s) {
        List<String> retval=new ArrayList<String>();
        TrieNode current = getLastNode(s);
        if(current!=null){
            if(current.is_end_of_string){
                retval.add(s);
            }
            current.getAllChildrens(retval);
            
        }
        return retval;
    }
    private void getAllChildrens(List<String> retval){
        TrieNode current=this;
        Map<Character, TrieNode> nodes=current.getAllchildren();
        Collection< TrieNode> sets=nodes.values();
        for (TrieNode trieNode : sets) {
            if(trieNode.is_end_of_string){
                retval.add(trieNode.actualWord);
            }
            trieNode.getAllChildrens(retval);
        }
    }

}
