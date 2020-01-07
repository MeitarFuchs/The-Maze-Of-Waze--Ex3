import java.io.File;
import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.Scanner;

public class RunME {
	
	public static String f1() {
	    File file = new File("V2VsbCBEb25lISAKVGFrZSBIFNjcmVlbiBTaG90IG9mIHRoaXMgZmlsZSBhbmQgc2VuZCB1cyBvbiBoYW5nb3V0cyA="); 
	    Scanner sc;
	    String ret = "";
		try {
			sc = new Scanner(file);
		    
		    while (sc.hasNextLine()) 
		    	 ret += sc.nextLine(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static String f2(String s) {
		int x = 0;
		for (int j = 0; j < 11; j++) {
			if (x%2 == 0)
				x = x + 2;
		}
		return s.substring(0,x) + "B" + s.substring(x,s.length());
	}
	
	public static void f3(String s) {
		 byte[] decodedBytes = Base64.getDecoder().decode(s);
		 System.out.println(new String(decodedBytes));
	}
	
 public static void main(String[] args) {
	 		f3(f2(f1()));
 		}
	}
