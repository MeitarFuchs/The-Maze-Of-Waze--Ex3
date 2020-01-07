package myMath;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import javax.swing.text.FlowView.FlowStrategy;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able {

	private List <Monom> listM=new ArrayList<Monom>();


	/**
	 * Zero (empty polynom)
	 */
	public Polynom() {
		this.listM=new ArrayList<Monom>();

	}
	/**
	 * init a Polynom from a String such as:
	 *  {"x", "3+1.4X^3-34x", "(2x^2-4)*(-1.2x-7.1)", "(3-3.4x+1)*((3.1x-1.2)-(3X^2-3.1))"};
	 * @param s: is a string represents a Polynom
	 */
	public Polynom(String s) {
		
		RecPolynom(s);

	}
	public void RecPolynom(String s)
	{
		
		int j=0;
		int start=0;
		String  Ms []=new String[s.length()];

		for( int i=0; i<Ms.length; i++)
		{
			Ms[i]="";
		}
		
		if (s.charAt(0)=='+'||s.charAt(0)=='-')
		{
			Ms[0]+=s.charAt(0);
			start++;
		}
		for( int i=start; i<s.length(); i++)
		{
			if(s.charAt(i)!='+' && s.charAt(i)!='-')
			{
				Ms[j]+=s.charAt(i);
				
			}
			else {
				if(s.charAt(i)=='+' || s.charAt(i)=='-')

				{
					j++;
					Ms[j]+=s.charAt(i);

				}
			}
		}
		
		j=j+1;// number of the strings in the array

		for( int i=0; i< j; i++)
		{
			
			Monom m=new Monom(Ms[i]);
			if (m.IsMonom(Ms[i])) 
			{
				listM.add(m);
			}
		}	

		Monom_Comperator MoComp=new Monom_Comperator();
		listM.sort(MoComp);

		listM.toString();

	}


	@Override
	public double f(double x) 
	{
		double sum=0;
		for(int i=0; i<listM.size(); i++)
		{
			sum+= listM.get(i).f(x);
		}
		return sum;
	}

	@Override
	public void add(Polynom_able p1) {

		Iterator <Monom> it = p1.iteretor(); // בטוח שזה עובר על מה שקיבלנו בפונקציה?
		while (it.hasNext()) 
		{
			boolean flagAdd=false;
			Monom tempM= (Monom)it.next();
			for (int i=0; i<listM.size(); i++)
			{
				//newCof=this.listM.get(i).get_coefficient()+tempM.get_coefficient();
				if (this.listM.get(i).get_power()== tempM.get_power())
				{
					this.listM.get(i).add(tempM);
					flagAdd=true;
				}

			}
			if (!flagAdd)
				this.listM.add(tempM);

		}

	}

	@Override
	public void add(Monom m1) 
	{
		Monom_Comperator MoComp=new Monom_Comperator();
		boolean flag=false;

		if (listM.isEmpty())
		{
			listM.add(0,m1);
		}
		else
		{	
			for(int i=0; i<listM.size(); i++)
			{
				if (listM.get(i).get_power()==m1.get_power())
				{			
					Monom newMo=new Monom(listM.get(i).get_coefficient()+m1.get_coefficient(), m1.get_power());
					listM.set(i , newMo);
					flag=true;
				}

			}
			if (!flag)
			{
				listM.add(m1);
				listM.sort(MoComp);
			}
		}

	}


	@Override
	public Iterator<Monom> iteretor() 
	{
		return listM.iterator();
	}

	@Override
	public void substract(Polynom_able p1) 
	{ //נקודת המוצא שכל פולינום הוא ארייליסט שממויינת גם לי החזקות מהקטן ולגדול ואין כפילויות של חזקות

		Iterator <Monom> it = p1.iteretor(); 
		while (it.hasNext()) 
		{
			boolean flagSub=false;
			Monom tempM= (Monom)it.next();
			tempM.multipy(Monom.MINUS1);
			for (int i=0; i<listM.size(); i++) 
			{
				if (this.listM.get(i).get_power() == tempM.get_power())
				{
					this.listM.get(i).add(tempM);
					flagSub=true;
				}
			}

			if (!flagSub)
			{
				this.listM.add(tempM);
			}
		}
	}

	@Override
	public void multiply(Monom m1) 
	{
		for (int i=0; i<listM.size() ; i++)
		{
			listM.get(i).multipy(m1);
		}
	}

	@Override
	public void multiply(Polynom_able p1) 
	{
		Polynom tempP=new Polynom();	
		Iterator <Monom>  it = p1.iteretor(); 

		while(it.hasNext())
		{
			Monom Mi= (Monom)it.next();
			Polynom copyP= (Polynom) this.copy();
			copyP.multiply(Mi);
			tempP.add(copyP);
		}

		Monom_Comperator MoComp=new Monom_Comperator();
		listM.sort(MoComp);

		this.listM=tempP.listM;
	}

	@Override
	public boolean equals(Polynom_able p1) 
	{
		boolean flag=false;
		Iterator <Monom> it = p1.iteretor(); 
		while (it.hasNext()) 
		{
			Monom tempM= (Monom)it.next();
			for (int i=0; i<listM.size(); i++)
			{
				if ((listM.get(i).equals(tempM)) )
					flag=true;
			}
			if (!flag)
				return false;
		}
		return true;
	}

	@Override
	public boolean isZero() 
	{
		for (int i=0; i<listM.size(); i++)
		{
			if (listM.get(i).get_coefficient()==0)
				return true;
		}
		return false;
	}

	@Override
	public double root(double x0, double x1, double eps) 
	{
		double x=0;
		double tempX;
		if (x0>x1)
		{	
			tempX=x0;
			x0=x1;
			x1=tempX;
		}

		if (f(x0)*f(x1)>0)
			throw new RuntimeException("not posible");	

		else
		{	
			x=(x0+x1)/2;
			while(Math.abs(f(x))>=eps)
			{
				if(f(x0)*f(x)<=0)
					x1=x;
				else
					x0=x;
				x=(x0+x1)/2;
			}
		}
		return x;	
	}

	@Override
	public Polynom_able copy() 
	{
		Polynom pnew= new Polynom();
		for (int i=0; i<listM.size(); i++)
		{
			pnew.add(new Monom (listM.get(i).toString()));
		}
		return pnew;
	}

	@Override
	public Polynom_able derivative() {

		Polynom pDiv= new Polynom();
		for (int i=0; i<listM.size(); i++)
		{
			pDiv.add(listM.get(i).derivative());
		}
		return pDiv;
	}

	@Override
	public double area(double x0, double x1, double eps) 
	{
		double area=0;
		double x=0;
		double tempX;
		if (x0>x1)
		{	
			tempX=x0;
			x0=x1;
			x1=tempX;
		}

		while(Math.abs(x1-x0)>eps)
		{
			x=x0+eps;
			if (f(x)>0)
				area+=(x-x0)*f(x);
			x0=x;
		}

		return area;
	}
	@Override
	public String toString() 
	{
		Monom_Comperator MoComp=new Monom_Comperator();
		listM.sort(MoComp);

		String sp="";
		String sM="";
		for (int i=0; i<listM.size(); i++)
		{
			Monom m = new Monom (listM.get(i));
			sM=m.toString();
			sp+=sM;

		}
		return sp;
	}
}
