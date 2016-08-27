package practice.dev.ds;

public class TrieMain {
	
	public static void main(String[] args) {
		
        Trie t=new Trie();
        t.insert("vishnu");
        t.insert("vishnu");
        t.insert("vishnu");
        t.insert("vishnu");
        t.insert("agarwal");
        t.insert("agarwal");
        t.insert("vishal");
        t.insert("vishal");
        t.insert("vishal");
        t.insert("vishal");
        t.insert("vish");
        t.insert("vish");
        t.insert("vish");
        t.insert("vikash");
        t.insert("vijay");
        t.insert("vimal");
        t.insert("agara");
        t.insert("agara");
        t.insert("agara");
        t.insert("agara");
        t.insert("agara");
        t.insert("agara");
        t.searchWithPrefix("vi");
        
        /*
			OUTPUT will be:
			
			vish
			vishal
			vishnu
			vimal
			vijay
			vikash
         */
        
    }
}
