import java.util.ArrayList;

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
	
	public Trie() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}
    
    public boolean search(TrieNode root,String word){
                TrieNode temp = root;
        for (int i=0;i<word.length()-1;i++){
            if ((temp.children[word.charAt(i) - 'a']) == null){
                return false;
            }
            
            temp = temp.children[word.charAt(i) - 'a'];
        }
        if (temp.children[word.charAt(word.length()-1) - 'a'] != null){
            return true;
        }else{
            return false;
        }
    }
	
	
	public boolean patternMatching(ArrayList<String> input, String pattern) {
		// Complete this function
		// Return the output as specified in question
        for (int i=0;i<input.size();i++){
            String temp = input.get(i);
            for (int j=0;j<temp.length();j++){
                this.add(temp.substring(j));
            }
        }
        
        return search(this.root,pattern);
	}
}

//MAIN

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		Trie t = new Trie();
		int n = s.nextInt();
		ArrayList<String> input = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
			String word = s.next();
			input.add(word);
		}
		String pattern = s.next();
		System.out.println(t.patternMatching(input, pattern));
	}
}