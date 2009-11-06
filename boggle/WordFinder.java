package boggle;

public class WordFinder {
	private LetterNode words;
	private Board board;
	
	public WordFinder() {
		this.words = new LetterNode();
		this.board = new Board(4);
		board.setStandardBoard();
		board.shuffle();
		board.showBoard();
	}

	public static void load() {
		/* TODO have this load in wordlist.txt (
		 * a copy of /usr/share/dict/american-english)
		 */
		
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public String getNextWord() {
		for (int i = 0; i < this.board.getSize(); i++) {
			
		}
		return "omg";
	}
	
	public void showBoard() {
		this.board.showBoard();
	}

}
