import java.util.Objects;

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: creates a plot company object
 * Due: 11/2/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Ryan Jones
*/
public class Plot {
	private int x; 
	private int y; 
	private int width; 
	private int depth; 

	// Default constructor
	public Plot() {
		y = 0;
		x = 0;
		width = 1;
		depth = 1;
	}

	// constructor
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	// Copy constructor
	public Plot(Plot plot) {
		x = plot.x;
		y = plot.y;
		width = plot.width;
		depth = plot.depth;
	}

	// Checks if this plot overlaps with another
	public boolean overlaps(Plot plot) {
		return !(plot.x + plot.width <= this.x || plot.x >= this.x + this.width || plot.y + plot.depth <= this.y
				|| plot.y >= this.y + this.depth);
	}

	// Checks if this plot encompasses another
	public boolean encompasses(Plot plot) {
		return plot.x + plot.width <= this.x + this.width && plot.x >= this.x
				&& plot.y + plot.depth <= this.y + this.depth && plot.y >= this.y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	// Checks if two Plot objects are equal
	public boolean equals(Plot obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Plot other = (Plot) obj;
		return depth == other.depth && width == other.width && x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return x + "," + y + "," + width + "," + depth; // Format: "x,y,width,depth"
	}
}
