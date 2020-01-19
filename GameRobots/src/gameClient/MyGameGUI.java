package gameClient;

import javax.swing.JOptionPane;

import org.json.JSONException;

import Server.Game_Server;
import dataStructure.DGraph;
import dataStructure.node_data;
import gui.GameGui_Std;
import utils.StdDraw;
public class MyGameGUI 
{
	
	GameGui_Std GuiStd=new GameGui_Std();
	private GameAlgorithm gameAlgo=new GameAlgorithm();
	private boolean automatic=false;
	
	
	public MyGameGUI() throws JSONException
	{
		String[] choiceNumLevel = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		Object selectedNumLevel = JOptionPane.showInputDialog(null, "Choosenum of game", "Message", JOptionPane.INFORMATION_MESSAGE, null, choiceNumLevel, choiceNumLevel[0]);
		int level= Integer.parseInt((String) selectedNumLevel);
		this.gameAlgo.setGame(Game_Server.getServer(level));		

		this.gameAlgo= new GameAlgorithm( this.gameAlgo.getGame())	;
		String[] chooseTypeGame = {"Automatic game","Manual game"};
		Object typeSelectedGame = JOptionPane.showInputDialog(null, "Choose game mode", "Message", JOptionPane.INFORMATION_MESSAGE, null, chooseTypeGame, chooseTypeGame[0]);

		//StdDraw.gameAutoGui= this;

		if (typeSelectedGame=="Automatic game")
		{
			this.automatic=true;

			String stringGraph= gameAlgo.getGame().getGraph(); 
			DGraph Dg= new DGraph();
			Dg.init(stringGraph);
			this.gameAlgo.setGraph(Dg);
			
			this.gameAlgo.buildFruitList(gameAlgo.getGame());
			this.gameAlgo.buildRobotList(gameAlgo.getGame(),this.gameAlgo.getGraph());
			
			for(int i=0; i<this.gameAlgo.getRobotList().size(); i++) //add the robots to service
			{
				System.out.println("add to service");
				Robot r=this.gameAlgo.getRobotList().get(i);
				node_data nd= this.gameAlgo.getGraph().getNode(r.getSrc());
				this.gameAlgo.getGame().addRobot(nd.getKey());
			}
			
			
			this.gameAlgo.setGraph(Dg);
			GuiStd.drawGame(this.gameAlgo.getGraph(), this.gameAlgo.getFruitList(), this.gameAlgo.getRobotList());


			StdDraw.show();
			
			
		}
	}
	
	public static void main(String[] args) throws JSONException 
	{
		MyGameGUI myGame=new MyGameGUI();
	}

}
