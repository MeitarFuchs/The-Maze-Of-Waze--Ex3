package myMath;

public class MonomTestOur {
	
	public static void main(String[] args) {

		TestMonom1();
	}
	
	
	public static void TestMonom1(){
		System.out.println("*** Test Monom ****" );
		String[] good_Form = {"0", "-x", "5","x","2.5x^3", "-3.9x^4", "-5x^8", "9x"};
		Monom multy = new Monom ("2.5X^3");
		Monom add1 = new Monom ("-3.9x^4");
		Monom f1 =  new Monom ("-5x^8"); 
		Monom deriva = new Monom ("-x");
		Monom Zero = new Monom ("0");
		Monom monom1 = new Monom("-1.9999999999x");
		Monom monom2 = new Monom("-2x");
		String[] bad_Form = {"3..7"};
		Monom t = new Monom("-3.9x^4");
		add1.add(t);
		System.out.println("Add: " + add1);
		System.out.println( "Equal Monom: " + multy.equals(t));
		System.out.println("check equals if the diffrents is eps or less:   "+monom1.equals(monom2));
		double e= f1.f(3);
		System.out.println("The value of the Monom at a point 3: " + e);
		multy.multipy(t);
		System.out.println("Multiply of Monom:" + multy.toString());
		System.out.println( " the derivative of the Monom is: " + deriva.derivative().toString());
		boolean b = Zero.isZero();
		System.out.println("the Monom is zero?: " + b);
		System.out.println("*** End of test Monom ****" );
	//	System.out.println("***Now check Bad example ****" );
	//	Monom m = new Monom("your are not the good form of Monom:" +bad_Form[0].toString());
		
	}
}
