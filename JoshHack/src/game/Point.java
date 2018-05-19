package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class Point.
 */
public class Point {
	
	/** The x coordinate. */
	public int x;
	
	/** The y coordinate. */
	public int y;
	
	/** The z coordinate. */
	public int z;
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param z the z coordinate
	 */
	public Point(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return prime * result + z;
	}

	/**
	 * Compares two points.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Point)) {
			return false;
		}
		Point other = (Point) obj;
		return x == other.x && y == other.y && z == other.z;
	}

	/**
	 * Returns the eight tiles bordering the current tile.
	 *
	 * @return the list
	 */
	public List<Point> neighbors8(){
		List<Point> points = new ArrayList<>();
		
		for (int ox = -1; ox < 2; ox++){
			for (int oy = -1; oy < 2; oy++){
				if (ox == 0 && oy == 0) {
					continue;
				}
				
				points.add(new Point(x+ox, y+oy, z));
			}
		}

		Collections.shuffle(points);
		return points;
	}
}
