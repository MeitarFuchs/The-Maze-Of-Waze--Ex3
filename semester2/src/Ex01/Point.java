package Ex01;

public class Point {
	
		// variables
		private double xVal;
		private double yVal;

		// constructors
		public Point() {
			xVal = 0;
			yVal = 0;
		}

		public Point(double x, double y) {
			xVal = x;
			yVal = y;
		}

		public Point(Point p) {
			xVal = p.getX();
			yVal = p.getY();
		}
		
		// functions
		public double getX() {
			return xVal;
		}

		public double getY() {
			return yVal;
		}

		public void setX(double x) {
			xVal = x;
		}

		public void setY(double y) {
			yVal = y;
		}

		public void set(double x, double y) {
			xVal = x;
			yVal = y;
		}

		public String toString() {
			String answer = "xVal: " + xVal + " yVal: " + yVal;
			return answer;
		}

		public double disOrigina() {
			double dis = Math.sqrt(xVal*xVal + yVal*yVal);
			return dis;
		}

		public double distance(Point p) {
			double xDis = xVal - p.getX();
			double yDis = yVal - p.getY();
			double dis = Math.sqrt(xDis*xDis + yDis*yDis);
			return dis;
		}
	}
