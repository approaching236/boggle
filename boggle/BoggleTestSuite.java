/*
 * Created on Jun 8, 2009
 *
 */
package boggle;

import junit.framework.TestCase;

/**
 * @author Vincent Grato
 *
 */
public class BoggleTestSuite extends TestCase {
	
	public void testRootConstructor() {
		LetterNode ln = new LetterNode();
		assertTrue(ln.children.isEmpty());
	}
	
	public void testAddedSomething() {
		LetterNode ln = new LetterNode();
		ln.add("word");
		assertEquals(1, ln.children.size());
	}
	
	public void testAddTwoWords() {
		LetterNode ln = new LetterNode();
		ln.add("aa");
		ln.add("ab");
		LetterNode temp = ln.getNodeByLetter('a');
		assertEquals(2, temp.children.size());
	}
	
	public void testLetterNode() {
		LetterNode ln = new LetterNode('w', true);
		assertEquals('w', ln.getLetter());
		assertTrue(ln.isWord());
	}
	
	public void testGetNodeByLetter() {
		LetterNode ln = new LetterNode();
		ln.add("word");
		assertEquals( 'w', ln.getNodeByLetter('w').getLetter());
	}
	
	public void testGetNode() {
		LetterNode wholeWord = new LetterNode();
		wholeWord.add("word");
		LetterNode ln = new LetterNode('d', true);
		assertEquals(wholeWord.getNode("word").getLetter(), ln.getLetter());
		assertEquals(wholeWord.getNode("word").isWord(), ln.isWord());
	}
	
	public void testBoardSizeAndValues() {
		int size = 3;
		Board board = new Board(size);
		Die die = new Die();
		die.setValues(board.board[size-1][size-1].getValues());
		for (int i = 0; i < die.getValues().length; i++) {
			assertTrue(Character.isLetter(die.getValues()[i]));
		}
		assertEquals(size, board.board.length);
		assertEquals(size, board.board[size - 1].length);
		
		size = 4;
		board = new Board(size);
		die = new Die();
		die.setValues(board.board[size-1][size-1].getValues());
		for (int i = 0; i < die.getValues().length; i++) {
			assertTrue(Character.isLetter(die.getValues()[i]));
		}
		assertEquals(size, board.board.length);
		assertEquals(size, board.board[size - 1].length);
	}
	
	public void testWordFinderBasics(){
		WordFinder wf = new WordFinder();
		assertEquals(wf.getBoard().getClass(), new Board(4).getClass());
	}
	
	
	/*
	 * Word Finder class tests
	 */
	
	public void testLocation() {
		Location l = new Location(0,1);
		assertEquals(l.getRow(), 0);
		assertEquals(l.getColumn(), 1);
	}
	
	public void testDirections() {
		Location l = new Location(1,1);
		System.out.println(l.getRight());
		assertTrue(l.getRight().equals(new Location(1,2)));
//		assertEquals(l.getRight(), new Location(1,2));
//		assertEquals(l.getBottomRight(), new Location(2,2));
//		assertEquals(l.getBottom(), new Location(2,1));
//		assertEquals(l.getBottomLeft(), new Location(2,0));
//		assertEquals(l.getLeft(), new Location(1,0));
//		assertEquals(l.getTopLeft(), new Location(0,0));
//		assertEquals(l.getTop(), new Location(0,1));
//		assertEquals(l.getTopRight(), new Location(0,2));
	}
	
	public static void main(String[] args) {
	}

}
