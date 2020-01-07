package Ex3;
//כתוב תוכנה הקולטת שני מספרים שלמים m ו-n( ומחשבת את ה n בחזקת m)

public class T3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int m= MyConsole.readInt("enter number");
		int n= MyConsole.readInt("enter the hezka");
		int p=1;
		
		for(int i=1; i<=n; i++)
		{
			p= p*m;
	
		}
		System.out.println(p);


	}
		
		
	}

