package Ex3;
//(כתוב תוכנה המקבלת מספר טבעי ומדפיסה משולש שווי-שוקיים וישר-זווית של כוכביות. (הקלט הוא מספר הכוכביות בכל אחד מניצבי המשולש

public class T2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x= MyConsole.readInt("enter a number");

		for(int i=1; i<=x; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();

		}

	}
}
