package gameClient;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import Server.Game_Server;
import Server.game_service;
import dataStructure.DGraph;
import dataStructure.node_data;
import gui.GameGui_Std;

public class AutoMyGameGui 
{	
	GameAlgorithms gameAlgo=new GameAlgorithms();

	public AutoMyGameGui(int level) 
	{
		try 
		{
			startTheGame(level);
		}
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
	}

	public void startTheGame(int level) throws JSONException //throws InterruptedException, JSONException
	{
		game_service game= Game_Server.getServer(level); 
		String stringGraph= game.getGraph(); 
		DGraph Dg= new DGraph();
		Dg.init(stringGraph);

		gameAlgo.buildFruitList(game);
		gameAlgo.buildRobotList(game,Dg);

		GameGui_Std GuiStd= new GameGui_Std();
		GuiStd.drawGame(Dg, this.gameAlgo.getFruitList(), this.gameAlgo.getRobotList());

		game.move();
		moveRobot(game, Dg);

	}

	public void moveRobot(game_service game, DGraph Dgraph) 
	{
		game.move();
		List<String> log = game.move();
		System.out.println("move stringggggggggggggggggg:  "+game.move());
		if(log!=null) 
		{
			long t = game.timeToEnd();
			for(int i=0;i<log.size();i++) 
			{
				String robot_json = log.get(i);
				try {
					JSONObject line = new JSONObject(robot_json);
					JSONObject currRobot = line.getJSONObject("Robot");
					int rid = currRobot.getInt("id");
					int src = currRobot.getInt("src");
					int dest = currRobot.getInt("dest");
					node_data destNode;
					if(dest==-1) 
					{	
						destNode = gameAlgo.bestNextNode(Dgraph.getNode(src));
						game.chooseNextEdge(rid, destNode.getKey());
						System.out.println("Turn to node: "+destNode.getKey()+"  time to end:"+(t/1000));
						System.out.println("currRobot in moveRobot"+currRobot);
					}
				} 
				catch (JSONException e)
				{e.printStackTrace();}
			}
		}
	}



	public static void main(String[] args) throws JSONException 
	{

		int level=2;
		AutoMyGameGui myGame=new AutoMyGameGui(level);

		//		String infoGame = game.toString(); //info game in the level you choose
		//		GameM.buildRobotList(game);
		//		System.out.println("robot list size:   " + GameM.robotList.size());
		//
		//		GameM.buildFruitList(game);
		//		System.out.println("fruit list size:   " + GameM.fruitList.size());
		//
		//		System.out.println("infoGame:   "+infoGame);
		//		JSONObject line;
		//		try
		//		{
		//			line = new JSONObject(infoGame);
		//			JSONObject ttt = line.getJSONObject("GameServer");
		//
		//
		//
		//		}
		//		catch (JSONException e) 
		//		{e.printStackTrace();}
		//
		//
		//		//update the bord- how???
		//
		//		game.startGame();
		//		while(game.isRunning()) 
		//		{
		//			//game.moveRobots(game,Dg);
		//		}
		//		String results = game.toString();
		//		System.out.println("Game Over: "+results);
	}



}
