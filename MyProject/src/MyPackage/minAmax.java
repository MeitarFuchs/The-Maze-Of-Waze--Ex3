package MyPackage;//יוצר מערך של 10 ומגריל מספרים בין 0 ל10 באופן רנדומאלי ואח"כ מוצא את הערך המקסימאלי והמינימאלי במערך

public class minAmax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] a= new int [10];
		for (int i=0; i<a.length;i=i+1) {
			a[i]=(int)(Math.random()*10); 
			}
		int max=a[0];
		int min=a[0];
		for (int i=0; i<a.length;i=i+1) {
			if (a[i]>max)
				max=a[i];
			if(a[i]<min)
				min=a[i];
		}
		System.out.println("The max is="+max);
		System.out.println("The min is="+min);
	}

}
