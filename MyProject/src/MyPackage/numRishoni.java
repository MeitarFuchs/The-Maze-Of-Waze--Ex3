package MyPackage;//בודק אם המספר ראשוני
//מריץ מ-2 עד 10000 ומדפיס את כל הראשונים

public class numRishoni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		int a=MyConsole.readInt("enter number");
		boolean b=true;
		for(int i=2; b && i<a; i++)//אפשרות נוספת לחישוב זה לעשות לולאה שבודקת עד השורש של המספר   (Math.sqrt(a))
		{
			if (a%i==0)
				b=false;
		}
		System.out.println(b);
		*/
		
		//מדפיס את כל המספרים הראשוניים מ-2 עד 10000

		int a=2;
		boolean b=true;
		for(a=2; a<=10000; a=a+1)
		{
			b=true;
			for(int i=2; b && i<a; i++)
			{
				if (a%i==0)
				b=false;// המספר לא ראשוני
			}
			if (b)
				System.out.println(a);
		}
		
	}

}
