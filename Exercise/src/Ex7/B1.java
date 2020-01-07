package Ex7;

public class B1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printNiven();
		String s="dafagahajaaka";
		char c=	MostC(s);
		System.out.println(c);
		int [] a= {5,6,7,8,9};
		int count;
		count=largeThenAvg(a);
		System.out.println("there are   "+ count +"numbers up from the avg");
	}

	public static void printNiven()
	{
		int sum=0;
		for (int n=100; n<1000; n++)
		{
			sum=0;
			while(n!=0)
			{
				sum+=n%10;
				n=n/10;
			}
			if (n%sum==0)
				System.out.print(n +" ");
		}
	}

	public static char MostC(String s)
	{
		int count=0;
		int max=0;
		char temp;
		char maxC='c';
		for(int j=0; j<s.length(); j++)
		{
			temp=s.charAt(j);
			for(int i=0; i<s.length();i++)
			{
				if (s.charAt(i)==(temp))
					count++;
			}
			if (count>max)
			{
				max=count;
				maxC=s.charAt(j); 
			}
			count=0;
		}
		return maxC;
	}

	public static int largeThenAvg(int [] a)
	{
		double avg;
		int countM=0;
		avg=avgA(a);
		for	(int i=0; i<a.length; i++)
		{
			if (a[i]>avg)
				countM++;
		}
		return countM;
	}

	public static double avgA(int[]a)
	{
		int sum=0;
		double avg=0;
		for	(int i=0; i<a.length; i++)
		{
			sum+=a[i];	
		}
		avg=sum/(a.length);
		return avg;
	}

	public static int [] either(int [] a1, int [] a2)
	{
		int g= (a1.length)+(a1.length);
		int []a3=new int [g];
		boolean b=true;
		int z=0;
		for	(int i=0; i<a1.length && b ; i++)
		{
			b=true;
			for	(int j=0; j<a2.length && b; j++)
			{
				if (a1[i]==a2[j])
					b=false;
			}
			if (b)
			{
				a3[z]=a1[i];
				z++;
			}
		}

		for	(int i=0; i<a2.length && b ; i++)
		{
			b=true;
			for	(int j=0; j<a1.length && b; j++)
			{
				if (a2[i]==a1[j])
					b=false;
			}
			if (b)
			{
				a3[z]=a2[i];
				z++;
			}
		}
		int countT=1;
		boolean bT=true;
		for	(int i=0; i<a3.length && bT ; i++)
		{
			if ( a3[i] != (null))
			{
				countT++;				
			}
			else
				bT=false;
		}
		int [] newA=new int [countT];
		for (int i=0; i<newA.length; i++)
		{
			newA[i]=a3[i];
		}
		return newA;
	}  
}
