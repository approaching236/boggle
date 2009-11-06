package boggle;

import java.util.Random;

public class Board {
	Die[] [] board;
	private int size;
	
	public Board(int size) {
		this.size = size;
		board = new Die[size] [size]; 
		
		for (int j = 0; j < size; j++) {
			for (int k = 0; k < size; k++) {
				board[j][k] = new  Die();
				board[j][k].setValuesRandom();
			}
		}
	}
	
	public void setStandardBoard() {
		board[0][0].setValues(new char[]{'A','O','B','B','J','O'});
		board[0][1].setValues(new char[]{'I','T','Y','D','S','T'});
		board[0][2].setValues(new char[]{'N','E','G','W','H','E'});
		board[0][3].setValues(new char[]{'O','U','T','I','C','M'});
		
		board[1][0].setValues(new char[]{'V','D','L','Y','R','E'});
		board[1][1].setValues(new char[]{'N','E','E','S','I','U'});
		board[1][2].setValues(new char[]{'V','E','T','W','H','R'});
		board[1][3].setValues(new char[]{'Z','L','N','R','H','N'});
		
		board[2][0].setValues(new char[]{'D','I','E','L','X','R'});
		board[2][1].setValues(new char[]{'O','O','T','T','A','W'});
		board[2][2].setValues(new char[]{'T','T','L','R','E','Y'});
		board[2][3].setValues(new char[]{'S','O','E','I','S','T'});
		
		board[3][0].setValues(new char[]{'N','A','E','G','A','E'});
		board[3][1].setValues(new char[]{'A','C','H','O','P','S'});
		board[3][2].setValues(new char[]{'H','I','M','N','U','Q'});
		board[3][3].setValues(new char[]{'K','P','S','F','F','A'});
	}
	
	public void showBoard() {
		for (int j = 0; j < this.size; j++) {
			for (int k = 0; k < this.size; k++) {
				System.out.print(board[j][k].getDisplay() + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void shuffle() {
		Random r = new Random();
		int j, k, s, t;
		for (int i = 0; i < 100; i++) {
			j = r.nextInt(4);
			k = r.nextInt(4);
			
			s = r.nextInt(4);
			t = r.nextInt(4);
			Die temp = new Die();
			temp.setValues(board[j][k].getValues());
			board[j][k].setValues(board[s][t].getValues());
			board[s][t].setValues(temp.getValues());
		}
	}
	
	public int getSize() {
		return this.size;
	}
}
