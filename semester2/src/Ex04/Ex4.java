package Ex04;

import java.util.HashMap;
import java.util.HashSet;

public class Ex4 {

//func3
	public static void  statistics(String str) 
	{
		int maxTime=0;             // count the times that the word appear
		int IndexOfLongW=0;       //save the Index of LongestWord    
		int MaxL=0;              // save the Word with the MaxLength    

		HashSet<String> hashMore = new HashSet<>();
		HashMap<String,Integer> hashOneTime = new HashMap<>();

		String [] st = str.split(",");          //  String array  
		String MaxS ="";                       // save the max word 
		int k = 0;
		while( k<st.length ) 
		{
			if(st[k].length()> MaxL) 
			{ 
				IndexOfLongW= k;               // now the word at k is the longest word
				MaxL= st[k].length();         // now we save the length of the word at k
			}

			if( hashOneTime.containsKey(st[k]) ) // if more than one time
			{	   
				int count = (hashOneTime.get(st[k])+1);    // save the time that st[k] appears
				hashOneTime.put(st[k],count);             // put the word if it appear just one time
				hashMore.add(st[k]);                     // put the word if it appear more than one time

				if(maxTime < count) 
				{ 
					maxTime= count;                     // put the new max value in value
					MaxS =st[k];                       // the string s get the most repetitive word
				} 
			}
			
			else 
			{
				hashOneTime.put(st[k],1);
			}
			
			k++;
		}

		System.out.println("How much words:" + " " + st.length);
		System.out.println("How much different words:" + "  " + hashOneTime.size());

		System.out.println("The Number of words that repeat:" + " " +hashMore.size());
		System.out.println("The most repetitive word:" +" "+ MaxS + ", appears - " + maxTime + "times");
		System.out.println("The longest word:"+ " " +st[IndexOfLongW] + " , and it's length is: " + st[IndexOfLongW].length());

	}


//func4
	public static boolean isSubset (int []a1, int []a2) 
	{
		boolean flag;
		int countIn=0;
		int k=0;
		
		BinarySearchTree BST =new BinarySearchTree();
		
		while(countIn<a1.length) 
		{
			BST.insert(a1[countIn]);
			countIn++;
		}

		while(k<a2.length) 
		{
			flag=BST.search(BST.root , a2[k]);
			k++;
			if(flag!=true) 
				return false;
		}

		return true;
	}
	
	
}





