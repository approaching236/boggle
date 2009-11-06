package boggle;

import java.util.*;


public class WordNode implements Comparable{
	String word = null;	
	TreeSet<WordNode> children;
	
	//creates the root node
	WordNode() {
		this.word = null;
		children = new TreeSet<WordNode>();
	}
	
	//adds subsequent nodes
	WordNode(String word) {
		this.word = word;
		children = new TreeSet<WordNode>();
	}
	
	public void test() {
		children.add(new WordNode("ap"));
		children.add(new WordNode("zz"));
		children.add(new WordNode("ac"));
		children.add(new WordNode("ab"));
	}
	
	public void add(WordNode word) {
		Iterator it1 = children.iterator(); //iterator of this node's children
		boolean found = false;
		
		while(it1.hasNext()){
			WordNode current = (WordNode)it1.next();
			//if this child's first letter matches the new wordNode's first letter,
			
			if (current.getWord().charAt(0) == word.getWord().charAt(0)) {
				found = true;
				word.setWord(word.getWord().substring(1));
				current.add(word);	//call this function on that child
			} else if (current.compareTo(word) > 0) {
				// stop looking once you are past the letter you are looking for (if you are at p looking for a)
				break;
			}
			//System.out.println(it1.next().toString());
		}
		if (found != true || (found != true && this.word == null)) {
			System.out.println("totally added: "+word.getWord());
			children.add(word);	//add to this node's children because there wasn't an approprite node to call
		}
		
	}
	
	public void listChildren() {
		Iterator it1 = children.iterator();
		while(it1.hasNext()){
			WordNode current = (WordNode)it1.next();
		      System.out.println(current.getWord());
		    }
	}
	
	public void listSubTree() {
		Iterator it1 = children.iterator();
		while(it1.hasNext()){
			WordNode current = (WordNode)it1.next();
			if (current.hasChildren()) {
				current.listSubTree();
			}
			System.out.println(current.getWord());
		}
	}
	
	public boolean hasChildren() {
		return children.size() == 0 ? false : true;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public int compareTo(Object word) {
		if (this.getWord().compareToIgnoreCase(((WordNode)word).getWord()) < 0) {
			return -1;
		} else if (this.getWord().compareToIgnoreCase(((WordNode)word).getWord()) == 0) {
			return 0;
		}
		return 1;
	}

	public boolean isWord(String word) {
		
		return true;
	}
}
