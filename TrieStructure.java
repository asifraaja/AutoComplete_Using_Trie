
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
Implementation of Trie Data Structure in java 
*/

public class TrieStructure{
	public static void main(String args[]) throws IOException{
		Trie trie = new Trie(' ');	// Creates a root trie node
		FileReader fis= new FileReader("/Users/m0a00pf/Documents/Eclipse/Trainings/OOPs/input.txt");	// reads data from a file
		BufferedReader br = new BufferedReader(fis);
		String str;
		while((str = br.readLine())!=null) {
			trie.insert(str);						// inserts the data into the trie Structure
			System.out.println(str);
		}
		System.out.println("List is "+trie.autoSuggest("ra"));	// a autoSuggest feature
	}
}


