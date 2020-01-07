package MyPackage;

import java.util.Arrays;

public class reshonyInA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int c= MyConsole.readInt("enter length");
		int []a =new int[c];
		int i=0, r=2;
		while(i<a.length)
		{
			boolean b=true; //מניחה ש r ראשוני 
			for (int j=0; j<i && b && a[j]<=Math.sqrt(r); j++) // רץ על כל המערך עד המקום הג'יי לא כולל מספיק לבדוק אם המספר מתחלק במספרים הקודמים לו הראשוניים כדי לדעת אם המספר ראשוני (אם לא מתחלק אז הוא ראשוני) ןאם זה קטן או שווה לשורש של המספר
				if (r%a[j]==0)
					b=false;
			if (b)
			{
				a[i]=r;
				i++;
			}
			r++;
		}
		System.out.println(Arrays.toString(a));
	}

}
