package Ex3;
//תוכנה הקולטת מספר שלם n ומחשבת את ערך של  n!. ( for ע"י שימוש בלולאת )  

public class T1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a= MyConsole.readInt("enter a number");
		int prodact=1;
		
		for(int i=1; i<=a; i++)
		{
			prodact= prodact*i;
			
		}
		System.out.println(prodact);

	}

}
