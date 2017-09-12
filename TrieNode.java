import java.util.LinkedList;
import java.util.List;

/*
	Trie Node containing,
	1. character/alphabet it is holding
	2. is it an end i.e., is it a complete word 
	3. list of other trie nodes it contains
	-----------------------	
	|char	|	end(T/F)	|
	|----------------------	|
	|a|b|c|d|e|........x|y|z|						
	----------------------
*/
public class TrieNode{
	char c;
	boolean isEnd;
	List<TrieNode> childList;
	
	public TrieNode(char c){
		this.c = c;
		isEnd = false;
		childList = new LinkedList<TrieNode>();
	}
	
	/* 
		If the character is already present in the list then
			don't create a new node
			just move to that node
	*/
	public TrieNode exsists(char c){
		for(TrieNode node : childList) {
			if(node.c == c) {
				return node;
			}
		}
		return null;
	}
	
	public void print() {
		for(TrieNode node:childList) {
			System.out.println(node.c + " "+node.isEnd + node.childList);
		}
	}
}