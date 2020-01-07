package MyPackage;

public class scuer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 //מדפיס ריבוע של כוכביות
		 int x= MyConsole.readInt("enter a number");
		for(int i=0; i<x; i++) {
			for(int j=0; j<x; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		 */

		/*
		  int x= MyConsole.readInt("enter a number");

		for(int i=1; i<=x; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		*/
		/*
		int x= MyConsole.readInt("enter a number");

		for(int i=1; i<=x; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		 */

		int x= MyConsole.readInt("enter a number");
		int sum=0;
		for(int i=1; i<=x; i++) {
			sum=i;
			for(int j=sum; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}

	}

}
