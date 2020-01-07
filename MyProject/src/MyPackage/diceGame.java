package MyPackage;

public class diceGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []c =new int[6];
		while(c[0]==0 || c[1]==0 || c[2]==0 || c[3]==0 || c[4]==0 || c[5]==0) 
		{
			int r =(int)(Math.random()*6)+1; 
			for (int i=0; i<c.length;i=i+1) {
				if (r==c[i])
					c[i]+=1;
			}
		}
		System.out.println();
	}
}
