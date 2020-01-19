package gameClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import Server.game_service;
import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.node_data;
import utils.Point3D;

public class GameAlgorithm 
{


	private game_service game=null;
	private DGraph graph=new DGraph(); //may be just a graph

	private ArrayList<Fruit> fruitList = new ArrayList<Fruit>(); 
	private ArrayList<Robot> robotList ;

	public GameAlgorithm()
	{
		this.game=null;
		this.graph=null;
		this.fruitList=null;
		this.robotList=null;
	}
	public GameAlgorithm(game_service g)
	{
		this.game=g;
	}



	public void buildFruitList(game_service game) 
	{
		this.fruitList=new ArrayList<Fruit>();

		List<String> log = game.getFruits();
		if(log!=null) 
		{
			for(int i=0;i<log.size();i++) 
			{
				String fruit_json = log.get(i);
				try 
				{
					JSONObject lineFruit = new JSONObject(fruit_json);
					JSONObject currntFruit = lineFruit.getJSONObject("Fruit");

					int type = currntFruit.getInt("type");
					double value = currntFruit.getDouble("value");
					String location = currntFruit.getString("pos");
					String [] arrPoint = location.split(",");
					double xP= Double.parseDouble(arrPoint[0]);
					double yP= Double.parseDouble(arrPoint[1]);
					double zP= Double.parseDouble(arrPoint[2]);
					Point3D cuurntPoint = new Point3D(xP,yP,zP);

					//System.out.println("type:  "+type+" value:  "+value+ "  cuurntPoint:  "+cuurntPoint);
					Fruit newFruit = new Fruit(type ,value ,cuurntPoint); //create the new fruit
					this.fruitList.add(i, newFruit); //add to the this list


				} 
				catch (JSONException e) 
				{	e.printStackTrace();   }
				catch (Exception e) 
				{	e.printStackTrace();   }

			}
		}

		//System.out.println("finish build fruit list and the size is:  "+this.fruitList.size());
	}
	public int howManyRobots(game_service game) throws JSONException
	{

		String robot_json = game.toString();
		JSONObject lineRobot = new JSONObject(robot_json);
		JSONObject currntRobot = lineRobot.getJSONObject("GameServer");
		int sizeRobots= currntRobot.getInt("robots");
		return sizeRobots;
	}

	public void buildRobotList(game_service game, DGraph dg) throws JSONException 
	{	
		this.robotList=new ArrayList<Robot>();
		int sizeRobots=howManyRobots(game);
		this.fruitList=new ArrayList<Fruit>();

		for(int i=0; i<sizeRobots; i++)
		{
			Robot newRobot = new Robot(); //create the new robot
			newRobot.setR_id(i);
			this.robotList.add(i,newRobot); //add to the this list	
		}
		startNodeRobot(dg);
	}

	public  void startNodeRobot (DGraph dg)
	{
		boolean flag=false;
		for (int i=0; i<robotList.size(); i++)
		{
			Fruit currFruit= new Fruit();
			Robot currRobot= robotList.get(i);
			if (i<this.fruitList.size())
				currFruit= fruitList.get(i);
			if (currFruit.getLocation()!=null)
			{
				edge_data currEdge=theEdgeOfTheFruit(currFruit, dg);
				NodeData nodeSrcEdge= (NodeData) dg.getNode(currEdge.getSrc());
				nodeSrcEdge.sethasFruit(1);
				currRobot.setLocation(nodeSrcEdge.getLocation());
				currRobot.setSrc(nodeSrcEdge.getKey());
			}
			else
			{
				Iterator<node_data> itNode = this.graph.getV().iterator(); 
				while (itNode.hasNext() && !flag)
				{
					NodeData currNode= (NodeData)  itNode.next();
					if (currNode.gethasFruit()==0 && !flag)
					{
						flag=true;
						currNode.sethasFruit(1);
						currRobot.setLocation(currNode.getLocation());
						currRobot.setSrc(currNode.getKey());
					}
				}
				flag=false;
			}
		}
		//paintRobot(this.robotList);
	}
	public edge_data theEdgeOfTheFruit(Fruit f,DGraph g) 
	{
		edge_data edgeFruit = new EdgeData(); // edgeFruit=null
		Point3D pCurrFruit = f.getLocation();
		boolean foundEdge=false;

		Iterator<node_data> itN = g.getV().iterator(); 
		while (itN.hasNext() && !foundEdge) 
		{
			node_data nd = itN.next();
			Point3D pNodeSrc = nd.getLocation(); // node src location
			Iterator<edge_data> itE = g.getE(nd.getKey()).iterator(); 
			while (itE.hasNext() && !foundEdge) 
			{
				edge_data ed = itE.next();
				Point3D pNodeDest = g.getNode(ed.getDest()).getLocation();
				double srcToF= pNodeSrc.distance3D(pCurrFruit);
				double destToF= pNodeDest.distance3D(pCurrFruit);
				double srcToDest= pNodeSrc.distance3D(pNodeDest);
				double abs= Math.abs((srcToF+destToF)-srcToDest);
				double eps=0.0000001;
				if (abs<=eps)
				{
					foundEdge=true;
					edgeFruit=ed;
				}
			}			
		}
		return edgeFruit;
	}

	public game_service getGame() {
		return game;
	}
	public void setGame(game_service game) {
		this.game = game;
	}
	public DGraph getGraph() {
		return graph;
	}
	public void setGraph(DGraph graph) {
		this.graph = graph;
	}
	public ArrayList<Fruit> getFruitList() {
		return fruitList;
	}
	public void setFruitList(ArrayList<Fruit> fruitList) {
		this.fruitList = fruitList;
	}
	public ArrayList<Robot> getRobotList() {
		return robotList;
	}
	public void setRobotList(ArrayList<Robot> robotList) {
		this.robotList = robotList;
	}





}
