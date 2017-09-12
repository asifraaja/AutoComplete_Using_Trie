import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Trie{
	private TrieNode root;
	
	public Trie(char c){
		root = new TrieNode(c);
	}


	public TrieNode getTrieNode() {
		TrieNode copyRoot = root;
		return copyRoot;
	}

	/*
		get a character
		If character in the root
			go to that node
			get next character
		else
			create a node for that character
			add that node into the childlist of parent node
		mark the last node as end
	*/
	
	public void insert(String val){
		TrieNode current = root;
		for(char c : val.toCharArray()){
			TrieNode temp = current.exsists(c);
			if(temp!=null){
				current = temp;
			}else {
				TrieNode new1 = new TrieNode(c);
				current.childList.add(new1);
				for(int i = 0;i<current.childList.size();i++) {
					if(current.childList.get(i) == new1) {
						current = current.childList.get(i);
					}
				}
			}
		}
		current.isEnd = true;
	}

	/*
		get a character
		If character exsists() then
			if current node is end node then
				return true
			else
				get next character
		return false
	*/
	
	public boolean find(String val) {
		TrieNode current = root;
		boolean flag = false;
		for(char c:val.toCharArray()) {
			TrieNode temp = current.exsists(c);
			if(temp!=null){
				System.out.println(temp.c);
				current = temp;
				if(current.isEnd) {
					flag = true;
				}else {
					flag = false;
				}
			}
		}
		return flag;
	}
	
	public void print(TrieNode baseRoot) {
		if(baseRoot == null) {
			return ;
		}
		TrieNode current = baseRoot;
		for(TrieNode node:current.childList) {
			System.out.print(node.c+"-->");
			print(node);
		}
		System.out.println();
	}
	
	public void autoSuggestUtil(TrieNode node,String str,List<String> list) {	
		str = str + node.c;
		String copy = str;
		if(node.isEnd) {
			list.add(str);
			str = copy;
		}
		for(TrieNode myNode : node.childList) {
			autoSuggestUtil(myNode,str,list);
		}
	}
	
	public List<String> autoSuggest(String str){
		String matchFound = " ";
		str = str.toLowerCase();
		List<String> list = new ArrayList<String>();
		TrieNode current = root;
		for(char c : str.toCharArray()) {
			TrieNode temp = current.exsists(c);
			if(temp != null) {
				matchFound += c;
				current = temp;
			}else{
				if(matchFound.equals(" ")){
					System.out.println("No matches found for \'"+str+"\' at all");
					return null;
				}else{
					System.out.println("No matches found for ' "+str +" ' ");
					break;
				}
			}
		}
		for(TrieNode node:current.childList) {
			String myStr = matchFound;
			autoSuggestUtil(node,myStr,list);
		}
		
		return list;
	}
}