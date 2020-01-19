package gameClient;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.node_data;

import utils.Point3D;

public class Robot 
{
	
	private int r_id;
	private int src;
	private int dest;
	private double value;
	private double speed;
	private Point3D location;
	private node_data robotNode=null;
	private edge_data robotEdge;
	private List<node_data> robotWay;
	//private Point3D next;
	//private static int countID=0;
	//private DGraph g;
	
	

	public Robot() 
	{
		this.r_id=-1;
		this.src=0;
		this.dest=0;
		this.location=null;
		this.speed=0;
		this.value=0;
		this.robotNode=null;
		this.robotEdge=null;
	}
	
	
	
	public Robot(int r_id, int src, Point3D location) 
	{
		this.r_id=r_id;
		this.src=src;
		this.dest=0;
		this.location=location;
		this.speed=0;
		this.value=0;
		this.robotNode=null;
		this.robotEdge=null;
	}
	public Robot(int r_id, int src, int dest,Point3D location, node_data robotNode, edge_data robotEdge) 
	{
		this.r_id=r_id;
		this.src=src;
		this.dest=dest;
		this.location=location;
		
		this.robotNode=robotNode;
		this.robotEdge=robotEdge;
		this.speed=0;
		this.value=0;
	}
	public Robot(int r_id, int src, int dest,Point3D location, node_data robotNode, edge_data robotEdge, double speed, double value) 
	{
		this.r_id=r_id;
		this.src=src;
		this.dest=dest;
		this.location=location;
		
		this.robotNode=robotNode;
		this.robotEdge=robotEdge;
		this.speed=speed;
		this.value=value;
	}
	public Robot(int r_id, int src, int dest,Point3D location, double speed, double value) 
	{
		this.r_id=r_id;
		this.src=src;
		this.dest=dest;
		this.location=location;
		this.speed=speed;
		this.value=value;
		this.robotNode=null;
		this.robotEdge=null;
	}
	
	public Robot initRobotFromLine(String json_sRobot) //get line that discrib robot , build it and return thr robot
	{
		Robot tempR = new Robot();
		try 
		{
			JSONObject line = new JSONObject(json_sRobot);
			JSONObject robot = line.getJSONObject("Robot");
			tempR.setR_id(robot.getInt("id"));
			tempR.setSrc(robot.getInt("src"));
			tempR.setDest(robot.getInt("dest"));
			tempR.setValue( robot.getDouble("value"));
			
			String location = robot.getString("pos");
			String [] arrPoint = location.split(",");
			double xP= Double.parseDouble(arrPoint[0]);
			double yP= Double.parseDouble(arrPoint[1]);
			double zP= Double.parseDouble(arrPoint[2]);
			
			Point3D cuurntPoint = new Point3D(xP,yP,zP);
			tempR.setLocation(cuurntPoint);
			
			tempR.setSpeed (robot.getInt("speed"));
			
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		return tempR;
		
	}
	
	
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public Point3D getLocation() {
		return location;
	}
	public void setLocation(Point3D location) {
		this.location = location;
	}
	public node_data getRobotNode() {
		return robotNode;
	}
	public void setRobotNode(node_data robotNode) {
		this.robotNode = robotNode;
	}
	public edge_data getRobotEdge() {
		return robotEdge;
	}
	public void setRobotEdge(edge_data robotEdge) {
		this.robotEdge = robotEdge;
	}
	public List<node_data> getRobotWay() {
		return robotWay;
	}
	public void setRobotWay(List<node_data> robotWay) {
		this.robotWay = robotWay;
	}
	
	
	
	

}
