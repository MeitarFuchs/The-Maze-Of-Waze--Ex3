package gameClient;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import utils.Point3D;

public class Fruit 
{
//	private ArrayList<Fruit> f = new ArrayList<>();
//	private DGraph dg = new DGraph();
	private int type;
	private double value;
	private Point3D location;

	
	public Fruit(int type, double value, Point3D location) 
	{
		this.type = type;
		this.value = value;
		this.location = location;
	}

	public Fruit()
	{
		this.type = 0;
		this.value = 0;
		this.location = null;
	}


	public static ArrayList<Fruit>  initFromListSFruit(List <String> ls){
		ArrayList <Fruit> tempFruitList =new ArrayList<>();
		for (String  s:ls) 
		{
			tempFruitList.add(initFromJsonFile(s));
		}
		return tempFruitList;
	}


	public static Fruit initFromJsonFile(String str) 
	{
		Fruit currFruit=new Fruit();
		try {
			JSONObject obj = new JSONObject(str);
			JSONObject fruit = obj.getJSONObject("Fruit");
			int type;
			double value;
			String location_s;
			Point3D location;
			value = fruit.getDouble("value");
			location_s = fruit.getString("pos");
			location = new Point3D(location_s);
			type = fruit.getInt("type");
			currFruit = new Fruit( type,value, location);

		} 
		catch (Exception E) 
		{
			E.printStackTrace();
		}
		return currFruit;

	}

//	public ArrayList<Fruit> getFru() {
//		return f;
//	}
//
//	public void setF(ArrayList<Fruit> f) {
//		this.f = f;
//	}
	
	

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Point3D getLocation() {
		return location;
	}

	public void setLoc(Point3D location) {
		this.location = location;
	}
	public int getType(){
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}



}
