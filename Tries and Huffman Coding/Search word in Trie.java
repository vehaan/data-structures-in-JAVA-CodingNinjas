class TrieNode{

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}


public class Trie {

	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
		count = 0;
	}	

	private boolean add(TrieNode root, String word){
		if(word.length() == 0){
			if (!root.isTerminating) {
				root.isTerminating = true;
				return true;
			} else {
				return false;
			}
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		return add(child, word.substring(1));

	}

	public void add(String word){
		if (add(root, word)) {
			this.count++;
		}
	}

	public boolean search(String word){
		// add your code here
        TrieNode temp = root;
        for (int i=0;i<word.length()-1;i++){
            if ((temp.children[word.charAt(i) - 'a']) == null){
                return false;
            }
            
            temp = temp.children[word.charAt(i) - 'a'];
        }
        if (temp.children[word.charAt(word.length()-1) - 'a'] != null && temp.children[word.charAt(word.length()-1) - 'a'].isTerminating == true){
            return true;
        }else{
            return false;
        }
	}

	
}

//MAIN

import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		Trie t = new Trie();
		int choice = s.nextInt();
		
		while(choice != -1) {
			String word;
			switch(choice) {
				case 1 : // insert
					word = s.next();
					t.add(word);
					break;
				case 2 : // search
					word = s.next();
					System.out.println(t.search(word));
					break;
				default :
						return;
			}
			choice = s.nextInt();
		}
	}

}