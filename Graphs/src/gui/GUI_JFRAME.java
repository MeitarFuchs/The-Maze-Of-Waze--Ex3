package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics2D;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;


public class GUI_JFRAME extends JFrame implements ActionListener, MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private graph Dg= new DGraph();
	private Graph_Algo Ag = new Graph_Algo();
	private int mc;

	public GUI_JFRAME(graph graph)
	{
		if (graph==null)
			throw new RuntimeException("the graph is null");
		this.Dg= new DGraph((DGraph) graph);
		this.mc=this.Dg.getMC();
		this.Ag.init(this.Dg);
		initGUI(graph);
	}



	private void initGUI(graph graph) 
	{
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);

		this.Dg=graph;

		MenuBar menuBar = new MenuBar();

		Menu file = new Menu("file");
		menuBar.add(file);
		this.setMenuBar(menuBar);
		Menu graph_algo = new Menu("graph algo");
		menuBar.add(graph_algo);

		MenuItem item1 = new MenuItem("save to file");
		item1.addActionListener(this);
		MenuItem item2 = new MenuItem("load from file");
		item2.addActionListener(this);

		MenuItem item3 = new MenuItem("Paint my Graph Algo");
		item3.addActionListener(this);
		MenuItem item4 = new MenuItem("Is the graph Conncect?");
		item4.addActionListener(this);

		file.add(item1);
		file.add(item2);
		graph_algo.add(item3);
		graph_algo.add(item4);

		this.addMouseListener(this);

		Thread t=new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				int curr_mc=0;
				while (true){
					synchronized(this)
					{
						if (Dg.getMC()!=curr_mc)
						{
							repaint();
							curr_mc=Dg.getMC();
							//stats_lbl.set
						}
					}
				}
			}
		}
				);
		
		t.start();
		
		
	}

	public void paint(Graphics dg)
	{
		super.paint(dg);

		if (dg!=null)
		{// paint nodes
			Iterator<node_data> itNode = Dg.getV().iterator(); 
			while (itNode.hasNext())
			{
				node_data nd = itNode.next();
				//draw nodes
				dg.setColor(Color.blue);
				((Graphics) dg).fillOval((int)nd.getLocation().x(), (int)nd.getLocation().y(), 10, 10);
				//write the key node
				dg.setColor(Color.BLUE);
				dg.drawString(""+  nd.getKey() , (int)nd.getLocation().x()+1 , (int)nd.getLocation().y()+1 );

				if (Dg.edgeSize()!=0)
				{// if there are edge - paint edge
					Iterator<edge_data> itEdge = Dg.getE(nd.getKey()).iterator(); 
					while (itEdge.hasNext()) 
					{
						edge_data ed = (edge_data) itEdge.next();
						//draw the edges
						dg.setColor(Color.PINK);
						Point3D pSrc=new Point3D((int)nd.getLocation().x(), (int)nd.getLocation().y());
						node_data destNode = Dg.getNode(ed.getDest());
						Point3D pDest= new Point3D((int)destNode.getLocation().x(), (int)destNode.getLocation().y());
						(dg).drawLine(pSrc.ix(), pSrc.iy(),pDest.ix(), pDest.iy());
						//write the w edge
						String wString = "";
						wString+=String.valueOf(ed.getWeight());
						dg.drawString(wString, ((int)pSrc.ix()+pDest.ix())/2 , ((int)pSrc.iy()+pDest.iy())/2 );

						dg.setColor(Color.YELLOW);
						dg.fillOval((int)(0.9*pDest.ix()+0.1*pSrc.ix()) , (int)(0.9*pDest.iy()+0.1*pSrc.iy()) , 10 , 10 );
					}

				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Graph_Algo guiAlgoGraph=new Graph_Algo();
		String str = e.getActionCommand();
		JFileChooser chooser;

		if(str.equals("Paint my Graph Algo"))
		{
			initGUI(this.Dg);				
		}

		if(str.equals("save to file"))
		{


			guiAlgoGraph=new Graph_Algo();	
			guiAlgoGraph.init(this.Dg);

			chooser= new JFileChooser(FileSystemView.getFileSystemView());
			chooser.setDialogTitle("Save graph to a file now..");
			int userChoose = chooser.showSaveDialog(null);

			if (userChoose == JFileChooser.APPROVE_OPTION) 
			{
				System.out.println("Saved as a file:   " + chooser.getSelectedFile().getAbsolutePath());
				guiAlgoGraph.save(chooser.getSelectedFile().getAbsolutePath());
			}		

		}
		if(str.equals("load from file"))
		{
			guiAlgoGraph=new Graph_Algo();
			JFileChooser folder=new JFileChooser(FileSystemView.getFileSystemView());

			int userChoose = folder.showOpenDialog(null);
			if(userChoose == JFileChooser.APPROVE_OPTION)
			{
				System.out.println("the file that choosen to open is:   " + folder.getSelectedFile().getName());
				guiAlgoGraph.init(folder.getSelectedFile().getAbsolutePath());
				this.Dg=guiAlgoGraph.copy();
				initGUI(Dg);	
			}
		}

		if(str.equals("Is the graph Conncect?")) 
		{
			if(guiAlgoGraph.getMyGraph()==null) 
				System.out.println("your graph is null");
			else
			{
				Graph_Algo AlgoG = new Graph_Algo();
				JFrame isCon = new JFrame();		
				AlgoG.init(this.Dg);

				if (AlgoG.isConnected()) 
				{ 
					JOptionPane.showMessageDialog(isCon ,"The graph is Connect!!!");
					System.out.println("The graph is Connect!!!");
				}
				else 
				{ 
					JOptionPane.showMessageDialog(isCon ,"The graph isn't Connect!!!");				
					System.out.println("The graph isn't Connect!!!");
				}
			}
		}

		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");

	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{;	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{;	}

	@Override
	public void mouseExited(MouseEvent e)
	{;	}


	@Override
	public void mousePressed(MouseEvent arg0) 
	{;	}


}



