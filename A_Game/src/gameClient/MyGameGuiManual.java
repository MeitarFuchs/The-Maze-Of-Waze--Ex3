package gameClient;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;

import Server.game_service;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;

public class MyGameGuiManual  extends Thread implements MouseListener {

	    private DGraph g = new DGraph();
	    private ArrayList<Fruit> fruitList = new ArrayList<>();
	    private ArrayList<Robot> robotList = new ArrayList<>();
	    private game_service game;
	    private StdDrawGUI G;
	    private node_data n;
	    private Robot r;
	    
	    
	public void setNode(node_data node){
	    this.n=node;
	}
	    public MyGameGuiManual(game_service game, DGraph g) {
	        this.game = game;
	        this.g = g;
	    }
	    private node_data getRobot(double x,double y) throws JSONException {

	    this.robotList=Robot.initListSRobot(this.game.getRobots());

	        for (Robot algo:this.robotList) {
	            double nX = algo.getPos().x();
	            double nY = algo.getPos().y();
	            if ((x < nX + 0.0004) && (x > nX - 0.0004))
	                if ((y < nY + 0.0004) && (y > nY - 0.0004)){
	                    Point3D ansP = new Point3D(nX, nY, 0);
	                    node_data ans = new NodeData(ansP);
	                    this.r = algo;
	                    return ans;
	                }
	        }
	        return null;
	    }




	    public void moveRobotManual(game_service game, DGraph g) throws JSONException {
	        this.game = game;
	        this.g = g;
	        int size = this.g.HashMapNode.size();
	        String [] have_point = new String[size];
	        for (int i = 0; i <size ; i++) {
	            have_point[i]=""+this.g.HashMapNode.get(i).getKey();
	        }
	        int How_Many_Robot = Robot.howManyRobot(this.game.toString());
	        for (int i = 0; i <How_Many_Robot ; i++) {
	            String put_Robot = (String) JOptionPane.showInputDialog(null, "Choose a point you want to put the Robot", "You have: "+How_Many_Robot+" Robot to put",JOptionPane.INFORMATION_MESSAGE,null,have_point,have_point[0]);
	            int point = Integer.parseInt(put_Robot);
	            node_data loc = this.g.getNode(point);
	            this.n=loc;
	            game.addRobot(loc.getKey());
	            StdDraw.picture(loc.getLocation().x(), loc.getLocation().y(),
	                    "bob.png", 0.0008, 0.0006);
	            StdDraw.show();
	        }
	        if(StdDraw.isMousePressed()){
	            System.out.println("isMousePressed");
	        }
	        this.start();


	    }








	    @Override
	    public void mouseClicked(MouseEvent mouseEvent) {
	        System.out.println("mouseClicked");
	    }

	    @Override
	    public void mousePressed(MouseEvent mouseEvent) {
	        System.out.println("mousePressed");

	    }

	    @Override
	    public void mouseReleased(MouseEvent mouseEvent) {
	        System.out.println("mouseReleased");

	    }

	    @Override
	    public void mouseEntered(MouseEvent mouseEvent) {

	    }

	    @Override
	    public void mouseExited(MouseEvent mouseEvent) {

	    }
	    private void fruit_GUI()
	    {
	    this.fruitList=Fruit.initFromListSFruit(this.game.getFruits());
	    //StdDraw.clear();
	        for (Fruit f:this.fruitList) {
	            if (f.getType() == -1) {
	                StdDraw.picture(f.getLocation().x(), f.getLocation().y(), "banana.png", 0.0008, 0.0006);
	            } else {
	                StdDraw.picture(f.getLocation().x(), f.getLocation().y(), "apple.png", 0.0008, 0.0006);
	            }
	            StdDraw.disableDoubleBuffering();

	        }

	    }

	    public void run() 
	    {
	        this.game.startGame();
	        JOptionPane.showMessageDialog(null, "Attention!, if you press out of graph this game will end !");
	        StdDraw.uptadeGraph(this.g);
	        fruit_GUI();

	        StdDraw.show();
	        while (this.game.isRunning()) {
	            //StdDraw.uptadeGraph(this.g);
	            //StdDraw.show();

	            fruit_GUI();
	            try {
	                StdDraw.R_GUI(this.game, this.robotList);
	            } catch (JSONException e) {
	                e.printStackTrace();
	            }
	            StdDraw.show();
	            //   System.err.println(this.game.timeToEnd()/1000);
	            if (StdDraw.isMousePressed()) {
	                double x = StdDraw.mouseX();
	                double y = StdDraw.mouseY();
	                System.out.println("bla" + x);
	                StdDraw.uptadeGraph(this.g);
	                StdDraw.show();
	                try {
	                    node_data location_Robpot = getRobot(x, y);
	                } catch (JSONException e) {
	                    e.printStackTrace();
	                }
	                if (where_Press == null) {
	                    JOptionPane.showMessageDialog(null, "your point out of graph , GoodBye see you later");
	                    StdDraw.setCanvasSize(1200, 1300);
	                    return;
	                } else {
	                    int id_Robot=0;
	                    try {
	                        this.robotList=Robot.initListSRobot(this.game.getRobots());
	                    } catch (JSONException e) {
	                        e.printStackTrace();
	                    }
	                    for (Robot r:this.robotList) {
	                        if(r.getSrc()==where_Press.getKey()){
	                             id_Robot=r.getId();
	                            System.out.println("this Robot you press is: "+id_Robot);
	                             break;
	                        }
	                    }


	                    StdDraw.uptadeGraph(this.g);
	                    StdDraw.show();
	                    //System.out.println(where_Press.getKey() + "  this is node  ");
	                    moveRobots(this.game, this.g, where_Press,id_Robot);
	                }
	                fruit_GUI();
	                StdDraw.uptadeGraph(this.g);
	                StdDraw.show();
	                try {
	                    StdDraw.uptadeGraph(this.g);
	                    StdDraw.show();
	                    sleep(10);
	                    StdDraw.uptadeGraph(this.g);
	                    StdDraw.show();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	public void moveRobot(){
	    double x;
	    double y;
	    JFrame jf = new JFrame();
	        x = StdDraw.mouseX();
	        y = StdDraw.mouseY();
	        node_data n = wherePress(x, y,this.g);
	        if (n == null) {
	            JOptionPane.showMessageDialog(jf, "Please press again");

	    }
	        else {
	        x = StdDraw.mouseX();
	        y = StdDraw.mouseY();
	        node_data nextNode = wherePress(x, y,this.g);
	            for (edge_data e : this.GraphGame.getE(this.r.getSrc())) {
	                if (nextNode.getKey() == e.getDest()) {
	                    this.server.chooseNextEdge(this.r.getId(), nextNode.getKey());
	                }
	            }

	            JOptionPane.showMessageDialog(jf, "The Robot can't move their");
	        }
	        this.b = false;
	    }
	}
	    static void moveRobots(game_service game, DGraph gg,node_data n,int idRobot) {
	        List<String> log = game.move();
	        if(log!=null) {
	            long t = game.timeToEnd();
	            for(int i=0;i<log.size();i++) {
	                String robot_json = log.get(i);
	                try {
	                    JSONObject line = new JSONObject(robot_json);
	                    JSONObject ttt = line.getJSONObject("Robot");
	                    int rid = ttt.getInt("id");
	                    int src = ttt.getInt("src");
	                    int dest = ttt.getInt("dest");
	                    if(dest==-1) {
	                        if (StdDraw.isMousePressed()) {
	                            node_data l = wherePress(StdDraw.mouseX(), StdDraw.mouseY(), gg);
	                            if (l == null) {
	                                dest = -1;
	                            } else {
	                                dest = l.getKey();
//	                                nextNode( gg, src,n);
	                            }
	                        }
	                        System.out.println("desssttttt:"+dest);
	                        game.chooseNextEdge(idRobot, dest);
	                       // System.out.println("src is :"+ src);
	                        System.out.println("Turn to node: "+dest+"  time to end:"+(t/1000));
	                        System.out.println(ttt);
	                    }
	                    game.move();

	                }
	                catch (JSONException e) {e.printStackTrace();}
	            }
	        }
	    }
	    private static int nextNode(DGraph g, int src,node_data n) {
	       /* int ans = -1;
	        Collection<edge_data> ee = g.getE(src);
	        Iterator<edge_data> itr = ee.iterator();
	        int s = ee.size();
	        int r = (int)(Math.random()*s);
	        int i=0;
	        while(i<r) {itr.next();i++;}
	        ans = itr.next().getDest();*/
	        return n.getKey();
	    }
	    public static node_data wherePress(double x, double y, DGraph g) {

	        for(node_data n : g.getV()){
	            double nX = n.getLocation().x();
	            double nY = n.getLocation().y();
	            if((x<nX+0.0005) && (x>nX-0.0005))
	                if ((y<nY+0.0005) && (y>nY-0.0005))
	                    return n;
	        }
	        return null;
	    }
	}


