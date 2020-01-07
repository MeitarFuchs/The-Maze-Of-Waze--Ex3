

public class Pixel {
	private int red;
	private int green;
	private int blue;

	public Pixel()
	{
		red=255;
		green=255;
		blue=255;
	}

	public Pixel(int r, int g, int b)
	{
		this.red=r;
		this.green=g;
		this.blue=b;
		if (red>255)
			this.red=255;
		if (green>255)
			this.green=255;
		if (blue>255)
			this.blue=255;
		if (red<0)
			this.red=0;
		if (green<0)
			this.green=0;
		if (blue<0)
			this.blue=0;
	}

	public Pixel(Pixel p)
	{
		this.red=p.red;
		this.green=p.green;
		this.blue=p.blue;
	}
	public int getRed()
	{
		return red;
	}

	public void setRed(int r)
	{
		this.red=r;
	}

	public int getGreen()
	{
		return green;
	}

	public void setGreen(int g)
	{
		this.green=g;
	}

	public int getBlue()
	{
		return blue;
	}

	public void setBlue(int b)
	{
		this.blue=b;
	}

	public String toString()
	{
		String s="";
		return s+=this.red +" , "+ this.green +" , "+ this.blue ;
	}
	public void addBrightness(int value) 
	{

		this.red+=value;
		this.green+=value;
		this.blue+=value;
		if (red<0)
			this.red=0;
		if (green<0)
			this.green=0;
		if (blue<0)
			this.blue=0;	
		if (red>255)
			this.red=255;
		if (green>255)
			this.green=255;
		if (blue>255)
			this.blue=255;

	}

}
