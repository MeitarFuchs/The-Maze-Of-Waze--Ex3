package myMath;

public class PolynomTestOur {

	public static void main(String[] args) {

		TestPolynom1();
		TestPolynom2();
	}

	public static void TestPolynom1(){
		String[] MonomSt= {"0","-2","+x", "5","-1x^2", "6.5x^3"};
		Polynom mulPo = new Polynom("2+x+x^2");
		Polynom addPo= new Polynom("2-x+2x^3");
		Polynom subPo= new Polynom("6+2x^3");
		double x=3;

		Polynom p5 = new Polynom();
		for (int j = 0; j<MonomSt.length; j++)
		{
			Monom m=new Monom(MonomSt[j]);
			p5.add(m);
		}
		System.out.println("p5:  "+p5.toString());
		for (int i = 0; i<MonomSt.length; i++) {

			System.out.println ("Now the i is:" + i);
			Monom tempM = new Monom (MonomSt[i]);
			Polynom p1 = new Polynom();
			p1.add(tempM);
			System.out.println("The polynom after we add tempMonom is :    " + p1.toString());
			p1.f(x);	
			System.out.println("The f(x) at the value of the x :   "+p1.f(i));
			p1.add(addPo);
			System.out.println("the poly after add poly 2-x+2x^3:  " + p1.toString());
			p1.substract(subPo);
			System.out.println("The poly after substract:  " + p1.toString());
			p1.multiply(mulPo);
			System.out.println("The poly after multiply in Polynom in 2+x+x^2: "  + p1.toString());
			Polynom_able copyPo = p1.copy();
			System.out.println("The copy1 of the orginal our polynom   " + copyPo.toString());
			System.out.println("If the polynoms are equals?:   " + p1.equals(copyPo));
			System.out.println("If the polymon is ZERO?:   " + p1.isZero());
		}

		System.out.println("*************end Test1***************");
	}

	public static void TestPolynom2(){
		Polynom p = new Polynom("6+2.2x-4x^2");
		Polynom newPo = new Polynom();
		newPo=(Polynom)p.copy();
		System.out.println("The orginal our polynom:  " + p.toString());

		System.out.println("The dertivite our polynom:  " +(p.derivative()).toString());

		System.out.println("the area:   " +p.area(-2,2,Monom.EPSILON));
		System.out.println("the root:  "  +p.root(-2,1,Monom.EPSILON) );
		System.out.println("the value of our eps:   "+Monom.EPSILON);

		newPo=(Polynom)p.copy();
		System.out.println("The copy2 of the orginal our polynom:  " + newPo.toString());

		Monom m1 = new Monom("-1.9999999999");
		Monom m2 = new Monom("-2");
		System.out.println("check equals if the diffrents is eps ro less:   "+m1.equals(m2));
		System.out.println("*************end Test2***************");
	}
}
