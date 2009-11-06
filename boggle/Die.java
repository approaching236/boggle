package boggle;

import java.util.Random;

public class Die {
	private char[] letters;
	private char displaying;
	Random r;
	
	public Die() {
		r = new Random();
		
	}
	
	public void setValuesRandom() {
		this.letters = new char[6];
		for (int i = 0; i < 6; i++) {
			letters[i] = (char)(r.nextInt(26)+65);
		}
		roll();
	}
	
	public void setValues(char[] l) {
		if (l.length !=6) {
			System.out.println("die must have 6 letters \"not counting Qu\"");
		}
		this.letters = new char[6];
		System.arraycopy(l, 0, this.letters, 0, 6);
		roll();
	}
	
	public void roll() {
		displaying = letters[r.nextInt(6)];
	}
	
	public char getDisplay() {
		return this.displaying;
	}
	
	public char[] getValues() {
		return this.letters;
	}
}
