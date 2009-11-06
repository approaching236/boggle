package boggle;

import java.util.Iterator;
import java.util.TreeSet;

public class LetterNode implements Comparable<LetterNode> {

	private char letter;
	private boolean isWord;
	public TreeSet<LetterNode> children;
	
	public LetterNode() {
		this.letter = '*';
		this.isWord = false;
		this.children = new TreeSet<LetterNode>();
	}
	
	public LetterNode(char c, boolean isWord) {
		this.letter = c;
		this.isWord = isWord;
		this.children = new TreeSet<LetterNode>();
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public char getLetter() {
		return letter;
	}

	/*
	 * will only make sense if used on root node, or in a recursive statement
	 */
	public boolean isWord(String word) {
		LetterNode test = getNode(word);
		return test.isWord();
	}
	
	public LetterNode getNode(String word) {
		LetterNode current = this.getNodeByLetter(word.charAt(0));
		if (current == null) {
			System.out.println("no such node");
			return null;
		}
		if (word.length() == 1) {
			return current;
		}
		return current.getNode(word.substring(1));
	}
	
	public void add(String word) {
		LetterNode toAddTo = getNodeByLetter(word.charAt(0));
		
		if (word.length() == 1) {
			if (toAddTo != null) {
				toAddTo.add(word.substring(1));
			} else {
				children.add(new LetterNode(word.charAt(0), true));
			}
		} else  {
			if (toAddTo == null) {
				LetterNode tempNode = new LetterNode(word.charAt(0), false);
				children.add(tempNode);
				tempNode.add(word.substring(1));
			} else {
				toAddTo.add(word.substring(1));
			}
		}
	}
	
	public LetterNode getNodeByLetter(char c) {
		Iterator<LetterNode> itr = this.children.iterator();
		
		while (itr.hasNext()) {
			LetterNode temp = (LetterNode) itr.next();
			if (temp.getLetter() == c) {
				return temp;
			}
		}
		return null;
	}

	public int compareTo(LetterNode arg0) {
		if (this.getLetter() > arg0.getLetter()) {
			return 1;
		} else if( this.getLetter() == arg0.getLetter()) {
			return 0;
		}
		return -1;
	}
}
