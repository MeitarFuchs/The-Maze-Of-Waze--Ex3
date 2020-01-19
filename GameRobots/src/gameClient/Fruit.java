package gameClient;

import org.json.JSONObject;

import dataStructure.edge_data;
import utils.Point3D;

public class Fruit 
{
	private int type;
	private double value;
	private Point3D location;
	private boolean isRobotOnMe; //tag if there is robot on this currnt fruit
	private edge_data edgeOfFruit;
	
	
	public Fruit() 
	{
		this.type=-1; // to check what is the deafult type
		this.value=0;
		this.location=null;
		this.isRobotOnMe=false;
		this.edgeOfFruit=null;
		
	}
	
	public Fruit(int type, double value, Point3D location) 
	{
		this.type=type;
		this.value=value;
		this.location=location;	
		this.isRobotOnMe=false;
		this.edgeOfFruit=null;
	}
	
	public Fruit initFruit(String strFruit)
	{
		Fruit ansFruit=new Fruit();
		if(!strFruit.isEmpty())
		{
			try{

				JSONObject obj = new JSONObject(strFruit);
				JSONObject fruit = (JSONObject) obj.get("Fruit");
				int value = fruit.getInt("value");
				this.value = value;
				int type = fruit.getInt("type");
				this.type = type;
				String pos = fruit.getString("pos");
				String[] point = pos.split(",");
				double x = Double.parseDouble(point[0]);
				double y = Double.parseDouble(point[1]);
				double z = Double.parseDouble(point[2]);
				this.location = new Point3D(x, y, z);
				ansFruit=new Fruit(type, value, location);
			}

			catch (Exception e) {

				e.printStackTrace();

			}

		}
		return ansFruit;
	

	}
	
	
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Point3D getLocation() {
		return location;
	}
	public void setLocation(Point3D location) {
		this.location = location;
	}
	public boolean isRobotOnMe() {
		return isRobotOnMe;
	}
	public void setRobotOnMe(boolean isRobotOnMe) {
		this.isRobotOnMe = isRobotOnMe;
	}
	public edge_data getEdgeOfFruit() {
		return edgeOfFruit;
	}
	public void setEdgeOfFruit(edge_data edgeOfFruit) {
		this.edgeOfFruit = edgeOfFruit;
	}
	
	
	
}
