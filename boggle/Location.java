package boggle;

/*
 * Creates a board location. This class has no knowledge of a "correct
 * location"
 * 
 * @param i	The row of this location
 * @param j The column of this location
 * @see Board
 */

public class Location implements Comparable{

	private int row, column;
	
	public Location(int i, int j) {
		this.row = i;
		this.column = j;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int x) {
		this.row = x;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int y) {
		this.column = y;
	}

	public Location getRight() {
		return new Location(row, column + 1);
	}

	public Location getBottomRight() {
		return new Location(row + 1, column + 1);
	}
	
	public Location getBottom() {
		return new Location(row + 1, column);
	}
	
	public Location getBottomLeft() {
		return new Location(row + 1, column - 1);
	}
	
	public Location getLeft() {
		return new Location(row, column - 1);
	}
	
	public Location getTopLeft() {
		return new Location(row - 1, column - 1);
	}
	
	public Location getTop() {
		return new Location(row - 1, column);
	}
	
	public Location getTopRight() {
		return new Location(row - 1, column + 1);
	}

	public int compareTo(Object arg0) {
		Location l = (Location) arg0;
		return (l.getRow() == this.row && l.getColumn() == this.column) ? 0 : 1;
	}
}
