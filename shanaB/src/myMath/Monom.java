
package myMath;

import java.util.Comparator;
import java.util.function.DoubleToLongFunction;

import org.w3c.dom.traversal.TreeWalker;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{

	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator(); // החוזה
	public static Comparator<Monom> getComp() {return _Comp;}
	public Monom(double a, int b){
		this.set_coefficient(a); // מקדם
		this.set_power(b); // jzev
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());    //העתקה עמוקה של מונום למונום
	}

	public double get_coefficient() {
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */

	public boolean isZero() {return this.get_coefficient() == 0;}
	// ***************** add your code below **********************

	public boolean IsMonom(String s)
	{
		int i=0;
		boolean flagPoint=false;

		if (s.length()==1)
		{	
			if (s.charAt(0)=='0')
				return true;
		}
		
		if (i<s.length()&&(s.charAt(i)=='+'|| s.charAt(i)=='-'))
		{
			i++;
		}

		if (i<s.length())
		{
			if((s.charAt(i)=='x') ||( s.charAt(i)=='X'))
			{
				i++;
			}

			else 
			{ //נראה יש לך מקדם
				while (i<s.length() && (s.charAt(i)!= 'x' && s.charAt(i)!='X'))
				{ 
					if ((s.charAt(i)>57 || s.charAt(i)<48) && s.charAt(i)!='.')
					{ 
						return false;
					}

					else 
					{
						if (s.charAt(i)=='.')
						{ 
							if (flagPoint==false)
							{
								flagPoint=true;
								i++;
								if (i<s.length() && (s.charAt(i)>57 || s.charAt(i)<48))
									return false;
							}
							else 
								if (flagPoint)
								{
									return false;
								}
						}

						else 
						{
							if (s.charAt(i)<=57 || s.charAt(i)>=48)
							{
								i++;
							}
						}
					}
				}
			}

			if (i<s.length() && ((s.charAt(i)=='x')|| (s.charAt(i)=='X')))
			{	
				i++;
			}

			if (i<s.length()) 
			{
				if (s.charAt(i)!='^') 
				{
					return false;
				}	
				else 
					i++;
			}


			if (i<s.length())
			{
				//newPow="";
				for (int j=i; j<s.length(); j++)
				{
					if (s.charAt(i)<= 57 && s.charAt(i)>=48) 
					{
						//newPow+=s.charAt(i);
					}
					else 
					{
						return false;
					}
				}
			}
		}
		return true;
	}


	public Monom(String s) 
	{
		int i=0;
		String newCof="+";
		String newPow="";

		boolean theNumIsNegtiv=false;
		if (!IsMonom(s))
		{
			throw new RuntimeException("not monom");
		}
		else {

			if (i<s.length()&&(s.charAt(i)=='+'|| s.charAt(i)=='-'))
			{
				if (s.charAt(i)=='-')
				{
					theNumIsNegtiv=true;
				}
				i++;
			}

			if (i<s.length())
			{
				if((s.charAt(i)=='x') ||( s.charAt(i)=='X'))
				{
					newCof+='1';
					newPow+='1';
					i++;
				}
				else 
				{ // מקדם
					while (i<s.length() && (s.charAt(i)!= 'x' && s.charAt(i)!='X'))
					{ 
						newCof+=s.charAt(i);
						i++;

					}

				}
			}


			if (i<s.length() && ((s.charAt(i)=='x')|| (s.charAt(i)=='X')))
			{	
				newPow="1";
				i++;
			}

			if (i<s.length()) 
			{
				i++;
			}


			if (i<s.length())
			{
				newPow="";
				for (int j=i; j<s.length(); j++)
				{
					newPow+=s.charAt(i);
				}
			}

			if (!newCof.equals("+1"))
			{
				if (theNumIsNegtiv)
					this.set_coefficient((Double.parseDouble(newCof))*(-1));
				else
					this.set_coefficient((Double.parseDouble(newCof)));
			}
			else
			{
				if (theNumIsNegtiv)
					this.set_coefficient(-1);
				else
					this.set_coefficient(1);
			}

			if (newPow.equals(""))
			{
				this.set_power(0);
			}
			else
			{
				this.set_power(Integer.parseInt(newPow));
			}
		}

	}


	public boolean equals(Monom m1)
	{
		double myCof=this.get_coefficient();
		double m1Cof=m1.get_coefficient();

		if (this.get_power()!=m1.get_power())
			return false;
		if (this.get_coefficient()==0 && m1.get_coefficient()==0)
			return true;

		if ((Math.abs(myCof-m1Cof))>Monom.EPSILON)
			return false;

		return true;
	}

	public void add(Monom m) {

		if (this.get_power()==m.get_power())
			this.set_coefficient(this.get_coefficient()+ m.get_coefficient());
		else
		{
			throw new RuntimeException("the pows don't equal");
		}

	}   

	public void multipy(Monom d) { //הכפלת מונומים

		this.set_coefficient(this.get_coefficient()*d.get_coefficient());
		this.set_power(this.get_power()+d.get_power());

	}
	public Monom derivative() { // נגזרת
		if(this.get_power()==0) {return getNewZeroMonom();}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);// חרת תחזיר מונום חדש 
	}
	public double f(double x) { //מציב x בפונקיצה
		double ans=0;
		int p = this.get_power();
		double cof=this.get_coefficient();
		ans = (cof)*(Math.pow(x, p));
		return ans;
	} 
	public String toString()
	{
		String ans = "";

		if (isZero())//this.get_coefficient()==0
			return "+0";

		if (this.get_coefficient()>0)
			ans+='+';

		ans+=this.get_coefficient();
		ans+='x';
		ans+='^';
		ans+=this.get_power();	

		return ans;
	}
	// you may (always) add other methods.

	//****************** Private Methods and Data *****************


	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}

	private static Monom getNewZeroMonom() {return new Monom(ZERO);}
	private static Monom getNewMinus1Monom() {return new Monom(MINUS1);}
	private double _coefficient; 
	private int _power;


}
