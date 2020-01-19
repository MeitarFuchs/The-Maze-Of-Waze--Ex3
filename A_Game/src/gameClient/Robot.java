package gameClient;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


import org.json.JSONException;
import org.json.JSONObject;

import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.node_data;
import utils.Point3D;

public class Robot 
{
	
	  public static final double EPS1 = 0.001, EPS2 = EPS1 * EPS1, EPS = EPS2;
	    private int id;
	    private int src;
	    private int dest;
	    private double value;
	    private double speed;
	    private Point3D pos;
	   // private String pic;
	   // private double rank;


	    /**
	     *
	     * @param p
	     * @param src
	     * @param dest
	     * @return true if the fruit is on the edge
	     */
	    public static boolean isonedge(Point3D p, Point3D src, Point3D dest) 
	    {
	        boolean ans = false;
	        double dist = src.distance2D(dest);
	        double d1 = src.distance2D(p) + p.distance2D(dest);
	        if (dist > d1 - EPS2) {
	            ans = true;
	        }
	        return ans;
	    }
	    public Robot(){
	        //this.pic=" ";
	       // this.rank=0;
	        
	        this.id=0;
	        this.src=0;
	        this.dest=0;
	        this.pos=null;
	    }

	    public Robot(int id,Point3D p){
	        this.id=id;
	      //  this.pic=pic;
	        this.pos=p;
	       // this.rank=rank;
	    }
	    public Robot(int id,int src, int dset, Point3D p, double value, double speed){
	        this.id=id;
	        this.src=src;
	        this.dest=dest;
	        this.value=value;
	        		this.speed=speed;
	      //  this.pic=pic;
	        this.pos=p;
	       // this.rank=rank;
	    }
	    public static int howManyRobot(String s) throws JSONException {
	        JSONObject obj = new JSONObject(s);
	        JSONObject array_robots = obj.getJSONObject("GameServer");
	       int num = array_robots.getInt("robots");
	       return num;
	    }
	    public static List<Robot> initListSRobot (List <String> str) throws JSONException {
	     List <Robot> robotList = new LinkedList<>();
	        for (String s:str) {
	        	robotList.add(initFromjsonFile(s));
	        }
	        return robotList;
	    }
	    
	    public static Robot initFromjsonFile(String s) throws JSONException {
	      
	        JSONObject obj = new JSONObject(s);
	        JSONObject array_robots = obj.getJSONObject("Robot");
	        int id = array_robots.getInt("id");
	        int src =array_robots.getInt("src");
	        int dest = array_robots.getInt("dest");
	        double value =array_robots.getInt("value");
	        double speed =array_robots.getInt("speed");
	        String ps =array_robots.getString("pos");
	        Point3D p = new Point3D(ps);
	        Robot r= new Robot(id, src, dest, p, value, speed);
	        r.src=src;
	        r.id=id;
	        r.pos=p;
	        r.value=value;
	        r.speed=speed;
	        return r;
	    }
	    public void setSrc(int src){
	        this.src=src;
	    }
	public int getSrc(){
	        return this.src;
	}
	    /**
	     *
	     * @param p
	     * @param s
	     * @param d
	     * @param g
	     * @return init point 3d and send to check if the fruit is on the edge
	     */
	    public static boolean isonedge(Point3D p, int s, int d, DGraph g) 
	    {
	    Point3D src =g.getNode(s).getLocation();
	    Point3D dest =g.getNode(d).getLocation();
	    return isonedge(p,src,dest);
	    }
	    public static node_data placeRobot(Fruit a, DGraph g){
	        Point3D p= Point3D.ORIGIN;
	        Iterator it = (Iterator) g.getV().iterator();
	        if (it!=null){
	        while (it.hasNext())
	        {
	            node_data n = (node_data) it.next();
	            List <edge_data> e = new LinkedList<>(g.getE(n.getKey())) ;
	            Iterator iter_edge = e.iterator();
	            while (iter_edge.hasNext()) {
	                edge_data eg = (edge_data) iter_edge.next();
	                node_data src = (node_data) g.getNode(eg.getSrc());
	                node_data dest = (node_data) g.getNode(eg.getDest());
	                double dis = Math.sqrt(Math.pow(src.getLocation().x() - dest.getLocation().x(), 2) +
	                        Math.pow(src.getLocation().y() - dest.getLocation().y(), 2));
	                double dis1 = Math.sqrt(Math.pow(src.getLocation().x() - a.getLocation().x(), 2) +
	                        Math.pow(src.getLocation().y() - a.getLocation().y(), 2));
	                double dis2 = Math.sqrt(Math.pow(a.getLocation().x() - dest.getLocation().x(), 2) +
	                        Math.pow(a.getLocation().y() - dest.getLocation().y(), 2));
	                if ((dis2 + dis1) - dis <= EPS1) {
	                    return src;
	                }
	            }
	        }}
	        return (node_data) g.HashMapNode.get(0);

	    }

	    /**
	     *
	     * @param p
	     * @param e
	     * @param type
	     * @param g
	     * @return check if the robot can to eat the fruit
	     */
	    public static  boolean isonedge(Point3D p , edge_data e, int type , DGraph g)
	    {
	        int src = g.getNode(e.getSrc()).getKey();
	        int dest =g.getNode(e.getDest()).getKey();
	        if(type<0 && dest>src){
	            return false;
	        }
	        if (type>0 && src>dest )
	            return false;
	        return isonedge(p,src,dest,g);
	    }

	    public static double getEPS1() {
	        return EPS1;
	    }

	    public static double getEPS2() {
	        return EPS2;
	    }

	    public static double getEPS() {
	        return EPS;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public Point3D getPos() {
	        return pos;
	    }

	    public void setPos(Point3D pos) {
	        this.pos = pos;
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

	   

	  
}
