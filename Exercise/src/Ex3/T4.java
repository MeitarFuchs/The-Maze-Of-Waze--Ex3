package Ex3;
//כתוב תוכנה הקולטת מספר שלם n והמחשבת את איבר n של סדרה פיבונצ'י:  

public class T4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n= MyConsole.readInt("enter n");

		int a=1;
		int a1=1;
		int a2=1;
		System.out.print("1"+"  ");
		
		for(int i=1; i<=n; i++)
		{
			a=a1-a;
			a2=a1+a;
			a1=a2;
			System.out.print(a2+"  ");
		}





	}

}
