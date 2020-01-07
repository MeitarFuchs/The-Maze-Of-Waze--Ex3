package MyPackage;//מכניס מספרים באופן רנדומאלי בין 0 ל99 ואח"כ בודק מה הוא המספר הכי גדול במערך

public class maxInLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] a= new int [10];
		for (int i=0; i<a.length;i=i+1) {
			a[i]=(int)(Math.random()*100);  //Math.random()*100-50    : מחזיר מספר ממשי רנדומאלי בין מינוס 50 ל49
		}
		int max=a[0];
		for (int i=0; i<a.length;i=i+1) {
			if (a[i]>max)
				max=a[i];
		}
	}

}
