package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import Server.game_service;
import utils.Range;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.node_data;
import gameClient.Fruit;
import gameClient.Robot;
import utils.Point3D;
import utils.StdDraw;

public class GameGui_Std 
{

	public void repaintGame(DGraph g ,ArrayList<Fruit> fruitL,ArrayList<Robot> robotL)
	{
		paintGame(g,fruitL);
		paintRobots(robotL);
	}
	public void drawGame(DGraph g,ArrayList<Fruit> fruitL) 
	{
		StdDraw.setCanvasSize(800,800);		
		paintGame(g,fruitL);
	}
	public void drawGame(DGraph g,ArrayList<Fruit> fruitL,ArrayList<Robot> robotL) 
	{
		StdDraw.setCanvasSize(800,800);		
		paintGame(g,fruitL);
		paintRobots(robotL);

	}

	public void paintRobots(ArrayList<Robot> robotL)
	{
		//draw robots
		for (int i=0; i<robotL.size(); i++)
		{
			Robot currRobot= new Robot();
			currRobot=robotL.get(i);
			StdDraw.setPenColor(Color.ORANGE);     

			//	StdDraw.filledCircle((currRobot.getLocation().x()) ,(currRobot.getLocation().y() ),0.00029);
			StdDraw.picture(currRobot.getLocation().x(), currRobot.getLocation().y(),"bob.png",0.0027,0.0017);
		}

	}






	private void paintGame(DGraph g,ArrayList<Fruit> fruitL)
	{
		//System.out.println("wellcom to draw graph");
		double r_minx=Integer.MAX_VALUE;
		double r_maxx=Integer.MIN_VALUE;

		ArrayList<node_data> ndArrList = new ArrayList<node_data>(g.getV());
		for (int i = 0; i < ndArrList.size(); i++) 
		{
			if (r_maxx < ndArrList.get(i).getLocation().x())
				r_maxx = ndArrList.get(i).getLocation().x();
			if (r_minx > ndArrList.get(i).getLocation().x())
				r_minx = ndArrList.get(i).getLocation().x();
		}
		for (int i=0; i<fruitL.size();i++)
		{
			if (r_maxx < fruitL.get(i).getLocation().x())
				r_maxx = fruitL.get(i).getLocation().x();
			if (r_minx > fruitL.get(i).getLocation().x())
				r_minx = fruitL.get(i).getLocation().x();
		}

		//		for (int i=0; i<robotL.size();i++)
		//		{
		//			if (r_maxx < robotL.get(i).getLocation().x())
		//				r_maxx = robotL.get(i).getLocation().x();
		//			if (r_minx > robotL.get(i).getLocation().x())
		//				r_minx = robotL.get(i).getLocation().x();
		//		}
		double r_miny=Integer.MAX_VALUE;
		double r_maxy=Integer.MIN_VALUE;
		for (int i = 0; i < ndArrList.size(); i++) {
			if (r_maxy < ndArrList.get(i).getLocation().y())
				r_maxy = ndArrList.get(i).getLocation().y();
			if (r_miny > ndArrList.get(i).getLocation().y())
				r_miny = ndArrList.get(i).getLocation().y();
		}
		for (int i=0; i<fruitL.size();i++)
		{
			if (r_maxy < fruitL.get(i).getLocation().y())
				r_maxy = fruitL.get(i).getLocation().y();
			if (r_miny > fruitL.get(i).getLocation().y())
				r_miny = fruitL.get(i).getLocation().y();
		}
		//		for (int i=0; i<robotL.size();i++)
		//		{
		//			if (r_maxy < robotL.get(i).getLocation().y())
		//				r_maxy = robotL.get(i).getLocation().y();
		//			if (r_miny > robotL.get(i).getLocation().y())
		//				r_miny = robotL.get(i).getLocation().y();
		//		}
		Range ansX = new Range(r_minx,r_maxx);
		Range ansY = new Range(r_miny,r_maxy);

		StdDraw.setXscale(ansX.get_min()-0.005 , ansX.get_max()+0.002);
		StdDraw.setYscale(ansY.get_min()-0.005,ansY.get_max()+0.002);

		//System.out.println("after scale");

		Iterator<node_data> it = g.getV().iterator();
		while (it.hasNext())
		{
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.setPenRadius(0.07);

			node_data srcN = (node_data) it.next();
			Point3D pS = srcN.getLocation();

			StdDraw.filledCircle(pS.x(),pS.y(),0.00008);

			StdDraw.text(pS.x(),pS.y(),""+(srcN.getKey()),0);
			Collection<edge_data> edgeCO = g.getE(srcN.getKey());
			if (edgeCO != null) 
			{
				Iterator<edge_data> itEdge = edgeCO.iterator();
				while (itEdge.hasNext()) 
				{
					edge_data src = (edge_data) itEdge.next();
					StdDraw.setPenColor(Color.PINK);
					StdDraw.setFont(new Font("David", 1, 12));
					node_data dest = g.getNode(src.getDest());
					StdDraw.setPenRadius(0.003);
					StdDraw.line(pS.x(), pS.y(), dest.getLocation().x(), dest.getLocation().y());
					String p1=String.format("%.3f",src.getWeight());

					StdDraw.setFont(new Font("David", 1, 15));
					StdDraw.textRight((pS.x() + dest.getLocation().x())/2 ,(pS.y() + dest.getLocation().y())/2 ,"" + Double.parseDouble(p1));
					StdDraw.setPenColor(Color.cyan);
					StdDraw.filledCircle((pS.x() *0.1) + (0.9 * dest.getLocation().x()) ,(pS.y() * 0.1) +
							(0.9* dest.getLocation().y()),0.00010);
				}
			}
		}

		StdDraw.setPenRadius(6);
		//draw fruit list
		for (int i=0; i<fruitL.size(); i++)
		{
			Fruit currFruit= new Fruit();
			//System.out.println("currFruit.getType():   "+currFruit.getType());
			currFruit=fruitL.get(i);

			if (currFruit.getType()==1)//apple-red   1
				StdDraw.setPenColor(Color.RED);
			else
				StdDraw.setPenColor(Color.YELLOW);//banana-yellow        1

			StdDraw.filledCircle((currFruit.getLocation().x()) ,(currFruit.getLocation().y() ),0.00018);
		}


	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public void initGameGUI(DGraph DgraphGame)//****
//	{
//		double min_x=Integer.MAX_VALUE;
//
//		double max_x=Integer.MIN_VALUE;
//
//		double min_y=Integer.MAX_VALUE;
//
//		double max_y=Integer.MIN_VALUE;
//
//		StdDraw.enableDoubleBuffering();
//		if(!StdDraw.getIsPaint()) 
//		{
//			StdDraw.setCanvasSize(800, 600);
//			StdDraw.setIsPaint();
//		}
//
//		if(DgraphGame != null)
//		{
//			//scale
//			Collection<node_data> nodes = DgraphGame.getV();
//			for (node_data nd : nodes) 
//			{
//				Point3D pNd = nd.getLocation();
//
//				if(pNd.x() > max_x) 
//					max_x = pNd.x();
//
//				if(pNd.x() < min_x) 
//					min_x = pNd.x();
//
//				if(pNd.y() > max_y) 
//					max_y = pNd.y();
//
//				if(pNd.y() < min_y) 
//					min_y = pNd.y();
//			}
//		}
//
//		//scale canvas
//		StdDraw.setXscale(min_x , max_x);
//		StdDraw.setYscale(min_y, max_y);
//
//		//StdDraw.setGraphGUI(this);
//
//
//		Iterator<node_data> it = DgraphGame.getV().iterator();
//		while (it.hasNext())
//		{
//			StdDraw.setPenColor(Color.BLACK);
//			StdDraw.setPenRadius(0.07);
//
//			node_data srcN = (node_data) it.next();
//			Point3D pS = srcN.getLocation();
//
//			StdDraw.filledCircle(pS.x(),pS.y(),0.00008);
//
//			StdDraw.text(pS.x(),pS.y(),""+(srcN.getKey()),0);
//			Collection<edge_data> edgeCO = DgraphGame.getE(srcN.getKey());
//			if (edgeCO != null) 
//			{
//				Iterator<edge_data> itEdge = edgeCO.iterator();
//				while (itEdge.hasNext()) 
//				{
//					edge_data src = (edge_data) itEdge.next();
//					StdDraw.setPenColor(Color.PINK);
//					StdDraw.setFont(new Font("David", 1, 12));
//					node_data dest = DgraphGame.getNode(src.getDest());
//					StdDraw.setPenRadius(0.003);
//					StdDraw.line(pS.x(), pS.y(), dest.getLocation().x(), dest.getLocation().y());
//					String p1=String.format("%.3f",src.getWeight());
//
//					StdDraw.setFont(new Font("David", 1, 15));
//					StdDraw.textRight((pS.x() + dest.getLocation().x())/2 ,(pS.y() + dest.getLocation().y())/2 ,"" + Double.parseDouble(p1));
//					StdDraw.setPenColor(Color.cyan);
//					StdDraw.filledCircle((pS.x() *0.1) + (0.9 * dest.getLocation().x()) ,(pS.y() * 0.1) +
//							(0.9* dest.getLocation().y()),0.00010);
//				}
//			}
//		}
//
//		StdDraw.show();
//
//	}
//
//	public void paint(game_service game,DGraph DgraphGame,ArrayList<Fruit> fruitList, ArrayList<Robot>robotList)
//	{
//		StdDraw.clear();
//		StdDraw.setPenRadius(0.0006);
//
//		//draw nodes
//		Collection<node_data> nodeCo = DgraphGame.getV();
//		for(node_data nd: nodeCo) 
//		{
//			StdDraw.setPenColor(Color.blue);
//
//			Collection<edge_data> edgeCo = DgraphGame.getE(nd.getKey());
//			Point3D pNd = nd.getLocation();
//
//			StdDraw.filledCircle(pNd.x(),pNd.y(),0.00008);
//
//			StdDraw.text(pNd.x(),pNd.y()+0.00016,""+ nd.getKey());
//
//			for(edge_data ed: edgeCo) 
//			{	
//				//draw edges
//				StdDraw.setPenColor(Color.PINK);
//				node_data nodeDest = DgraphGame.getNode(ed.getDest());
//				Point3D pNodeDest = nodeDest.getLocation();
//
//				StdDraw.line(pNd.x(), pNd.y(), pNodeDest.x() , pNodeDest.y());
//
//				double midx = (pNd.x() + pNodeDest.x())/2;
//				double midy = (pNd.y() + pNodeDest.y())/2;
//
//				StdDraw.text((midx+ pNodeDest.x())/2 , (midy+pNodeDest.y())/2+0.00015, ""+ ""+ed.getWeight()); //df2.format
//				StdDraw.setPenColor(Color.green);
//				StdDraw.filledCircle((midx+ pNodeDest.x())/2 , (midy+pNodeDest.y())/2, 0.00006);
//
//			}
//
//		}
//
//		//get from the server again fruits and robots
//
//		Iterator<String> itFruit = game.getFruits().iterator();
//
//		//clear fruits collection if needed
//
//		if(fruitList!= null)
//		{
//			fruitList.clear();
//		}
//
//		else
//		{
//			fruitList = new ArrayList<Fruit>();
//		}
//
//		//set all fruits in their places
//
//		while(itFruit.hasNext())
//		{
//			String stringFruit = itFruit.next();
//			Fruit currFruit= new Fruit();
//			currFruit.initFruit(stringFruit);
//			fruitList.add(currFruit);
//			findFruitEdge(currFruit, DgraphGame);
//
//		}
//
//		//draw a banana
//
//		if(!fruitList.isEmpty())
//		{
//
//			for(Fruit f : fruitList) 
//			{
//
//				findFruitEdge(f,DgraphGame);
//
//				Point3D p = f.getLocation();
//
//
//				if (f.getType()==1)//apple-red   1
//					StdDraw.setPenColor(Color.RED);
//				else
//					StdDraw.setPenColor(Color.YELLOW);//banana-yellow      
//
//				StdDraw.filledCircle((f.getLocation().x()) ,(f.getLocation().y() ),0.00018);
//			}
//
//		}
//
//	
//
//		//clear robots collection if needed
//
//		if(robotList!= null)
//		{
//
//			robotList.clear();
//
//		}
//		else{
//
//			robotList = new ArrayList<Robot>();
//
//		}
//
//		initRob(game, DgraphGame, robotList);
//
//		//draw robots
//
//		if(!robotList.isEmpty()){
//
//			for(Robot r : robotList) {
//
//				Point3D p = r.getLocation();
//
//				StdDraw.picture(p.x(), p.y(), "bob.png", 0.0007, 0.0007);		
//
//			}
//
//		}
//
//		StdDraw.show();
//
//	}
//
//
//	private void initRob(game_service game, DGraph DgraphGame, ArrayList<Robot> robotList) 
//	{
//		List<String> robotsServer = game.getRobots();
//		for (String s : robotsServer)
//		{
//			Robot rob = new Robot();
//			rob.setDGraph(DgraphGame);
//			rob.initRobots(s);
//			robotList.add(rob);
//		}
//	}
//
//
//	public void findFruitEdge(Fruit f, DGraph DgraphGame) 
//	{
//		Collection<node_data> nodeCo = DgraphGame.getV();
//
//		for(node_data nd : nodeCo) {
//
//			Collection<edge_data> edgeCo = DgraphGame.getE(nd.getKey());
//
//			for(edge_data ed: edgeCo) {
//
//				Point3D pEdSrc =DgraphGame.getNode(ed.getSrc()).getLocation();
//
//				Point3D pEdDest =DgraphGame.getNode(ed.getDest()).getLocation();
//
//				//check if the fruit is on the edge
//
//				if(Math.abs((pEdSrc.distance2D(pEdDest)-(Math.abs((f.getLocation().distance2D(pEdSrc)))+(Math.abs((f.getLocation().distance2D(pEdDest))))))) <= 0.0000001){
//
//					int lowNode=nd.getKey();
//					int highNode=ed.getDest();
//
//					if(nd.getKey()>ed.getDest()) {
//
//						lowNode= ed.getDest();
//
//						highNode= nd.getKey();
//
//					}
//
//					if(f.getType()==1) {
//
//						edge_data edFruit = DgraphGame.getEdge(lowNode, highNode);
//						if(edFruit!= null) 
//							f.setEdgeOfFruit(edFruit);
//
//					}
//
//					//the reverse edge is the way to eat the fruit
//					if(f.getType()==-1) 
//					{
//						edge_data edFruit = DgraphGame.getEdge(highNode,lowNode);
//						if(edFruit!= null)
//							f.setEdgeOfFruit(edFruit);
//					}
//				}
//
//			}
//
//		}
//
//	}
//





}
