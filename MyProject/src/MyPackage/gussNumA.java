package MyPackage;// בודק האם המספר 5 נמצא במערך

public class gussNumA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a= new int [10];
		boolean b=false;
		for (int i=0; i<a.length;i=i+1) {
			a[i]=(int)(Math.random()*10); 
			}
		
		for (int i=0; i<a.length && b==false ;i=i+1) {
			if (a[i]==5) 
				b=true;
		}
		if (b)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}

}
