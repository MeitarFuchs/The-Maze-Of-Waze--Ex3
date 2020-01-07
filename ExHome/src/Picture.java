

public class Picture {

	private String name;
	private Pixel [][] P;
	private int H; // אורך
	private int W; // רוחב

	public Picture(String picName, int height, int width)
	{
		P =new Pixel [height][width];
		this.name=picName;
		this.W=width;   
		this.H=height;   

		for (int i=0; i<P.length; i++)  
		{
			for (int j=0; j<P[i].length; j++)
			{
				this.P[i][j]= new Pixel();
			}
		}	
	}
	public Picture (String picName, String filename)
	{
		P= PictureIO.readPictureFromFile(filename);
		this.name=picName;
		this.W=P.length;   
		this.H=P[0].length;   

	}

	public Picture (Picture pic)
	{
		P =new Pixel [pic.H][pic.W];
		this.name=pic.name;
		this.W=pic.W;
		this.H=pic.H; 
		for (int i=0; i<pic.H; i++)  
		{
			for (int j=0; j<pic.W; j++)
			{
				this.P[i][j]= new Pixel(pic.P[i][j]); 
			}
		}	
	}

	public void output()		
	{
		PictureIO.writePictureToFile(name, P);
	}

	public Pixel getPixel(int x, int y)
	{
		return this.P[x][y];			
	}

	public void setPixel(int x, int y, Pixel p)
	{
		this.P[x][y]= new Pixel(p); 
	}

	public void addBrightness(int value)
	{
		for (int i=0; i<P.length; i++)  
		{
			for (int j=0; j<P[i].length; j++)
			{
				this.P[i][j].addBrightness(value); 
			}
		}	
	}


	public void cropPicture(int x, int y, int height, int width)
	{			
		int newW=0;
		int newH=0;
		Pixel [][]newP =new Pixel [height][width];
		for (int i=x; i<height+x; i++)  
		{
			for (int j=y; j<width+y; j++)
			{
				newP[newH][newW]= this.P[i][j]; 
				newW++;
			}
			newH++;
			newW=0;
		}	
		this.P=newP;
	}


}
