package MyPackage; 

public class hezka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h= MyConsole.readInt("enter a hezka");
		int p=1;
		
		int counter=1;
		while(counter<=h)
		{
			p= p*2;
			counter=counter+1;
		}
		System.out.println(p);


	}

}
