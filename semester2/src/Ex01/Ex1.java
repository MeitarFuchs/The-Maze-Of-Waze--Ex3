package Ex01;

public class Ex1 {

	public static int maximumX(Point []vertices) 
	{ 
		return theFirstVerify( vertices,0,vertices.length-1);
	}

	public static int theFirstVerify(Point []vertices,int s ,int e) 
	{  
		int middle =(s+e)/2;                                
		if (vertices[middle].getX() < vertices[middle+1].getX()) 
			return theFirstVerify(vertices,middle+1,e-1 );
		else 
			if (vertices[middle].getX() < vertices[middle-1].getX())
				return theFirstVerify(vertices,s,middle-1 );
		
		return middle;
	}

	public static int maximumY(Point []vertices) 
	{	
		return theSecendVerify( vertices ,0 ,vertices.length-1);
	}

	public static int theSecendVerify(Point []vertices,int s ,int e) 
	{
		int middle =(s+e)/2;
		if (vertices[middle].getY() < vertices[middle+1].getY()) 		
			return theSecendVerify(vertices,middle+1,e ); 
		else 
			if (vertices[middle].getY() < vertices[middle-1].getY()) 
				return theSecendVerify(vertices,s,middle-1 ); 

		return middle;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] vertices = { new Point(-2, 6), new Point(0, 10), new Point(6, 14), new Point(12, 12), new Point(14, 6),
				new Point(10, 2), new Point(4, 0) };
		System.out.println("index of maximum x is: " + Ex1.maximumX(vertices) + ", and the maximum value is: "
				+ vertices[Ex1.maximumX(vertices)].getX());
		System.out.println("index of maximum y is: " + Ex1.maximumY(vertices) + ", and the maximum value is: "
				+ vertices[Ex1.maximumY(vertices)].getY());
		Point[] vertices2 = { new Point(22, -10), new Point(28, 2), new Point(40, 8), new Point(45, 15),
				new Point(50, 4), new Point(56, -2), new Point(70, -5), new Point(48, -6), new Point(36, -12) };
		System.out.println("index of maximum x is: " + Ex1.maximumX(vertices2) + ", and the maximum value is: "
				+ vertices2[Ex1.maximumX(vertices2)].getX());
		System.out.println("index of maximum y is: " + Ex1.maximumY(vertices2) + ", and the maximum value is: "
				+ vertices2[Ex1.maximumY(vertices2)].getY());
	}


}
