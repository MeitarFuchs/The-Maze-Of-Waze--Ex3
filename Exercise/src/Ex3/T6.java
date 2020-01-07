package Ex3;
/*כתוב תוכנה הקולטת מספר שלם ובדקת האם הוא מושלם. 
ספר   נקרא מספר מושלם אם כסום של כל המחלקים שלו (כולל 1 ולא כולל מספר עצמו) 
שווה למספר עצמו.
 */
public class T6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sumM=0;
		int n= MyConsole.readInt("enter n");

		for(int i=1; i<n; i++)
		{
			if(n%i==0)
				sumM+=i;
		}
		if (sumM==n)
		{
			System.out.println("you'r number is perfect!");
		}
		else 
			System.out.println("try again text time");
	}

}
