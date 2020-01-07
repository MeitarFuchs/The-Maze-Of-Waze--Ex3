package myMath;

public class Asimetry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int c= MyConsole.readInt("enter length");
		int []a =new int[c];
		for (int i=0; i<a.length;i=i+1) 
			a[i]=(int)(Math.random()*10); 
			
		boolean b=true;
		for(int i=0, j=a.length-1; i<a.length &&  j>=0; i++, j--) {
			if (a[i]!=a[j])
				b=false;
		}
		if(b)
			System.out.println("simetri");
		else 
			System.out.println("no simetri");
	}

}
