public class LLL {
	Node head;
	int size;

	public LinkedList(){
		head=null;
		size=0;
	}

	//פונקציה המוסיפה נוד חדש
	public void add(String s){
		// אם אין כלום ברשימה המקושרת נוסיף בראש נוד חדש
		if(head==null){
			head=new Node(s); //נעשה נוד חדש כאשר אנחנו רוצים מקום חדש בזיכרון
		}
		else{
			// אחרת, נתקדם בשרשרת עד שנגיע לאיבר האחרון
			Node n=head;
			while(n.next!=null){
				n=n.next;
			}
			// כאשר האיבר האחרון יצביע על מקום ריק נוסיף נוד חדש
			n.next=new Node(s);
		}
		size++;
	}

	//פונקציה מוחקת
	public boolean remove(String d){
		Node n=head;
		Node p=head;
	
		// אם הרשימה ריקה אין מה למחוק
		if(head==null)
			return false;
		//אם זה לא האיבר האחרון ברשימה
		while(n!=null){
			// אם המידע של האיבר הוא מה שאנחנו רוצים למחוק
			if(n.data.equals(d)){
				//אם זה הראש
				if(n==head){
					// נחליף את הראש לאיבר הבא
					head=n.next;
					// מקטינים את גודל הרשימה ב-1
					size--;
					return true;// אם יש כמה נודים זהים ואנחנו רוצים למחוק את כולם נוריד את כל ההחזרות בתוך הלולאה
				}
				// אם מצאנו את הנוד שאנו רוצים למחוק והוא לא הראש
				// מעבירים את החץ מהאיבר שלפני האיבר הנמחק לאיבר הבא שאחרי הנחק
				p.next=n.next;
				// מחקנו איבר, אז נוריד ב-1 את גודל הרשימה
				size--;
				return true;
			}
			// אם לא מצאנו את מה שאנחנו רוצים למחוק אז נקדם את המשתנים לאיבר הבא
			p=n;
			n=n.next;
		}
		// אם לא מצאנו איבר התואם למה שאנחנו רוצים למחוק
		return false;
	}


	public String toString(){
		String ans = "[";
		Node n = head;
		while(n != null){
			ans = ans + n.data + ", ";
			n = n.next;
		}
		ans = ans + "]";
		return ans;
	}

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add("hello");
		l.add("sskk");
		l.add("sdd");
		l.add("aa");
		System.out.println(l.toString());
		System.out.println(l.remove("sskk"));
		System.out.println(l.toString());

		System.out.println(l.remove("sdd"));
		System.out.println(l.toString());

		System.out.println(l.remove("aa"));


		System.out.println(l.toString());
		System.out.println(l.remove("hello"));


		System.out.println(l.toString());

	}

	private class Node{
		String data;
		Node next;
		public Node(String d){
			this.data=d;
			this.next=null;
		}
	}

}

public class MyLinkedList {
	private Node head , tail;
    private int size;
    
	public  MyLinkedList() {
	 head= new Node();
	 tail = new Node ();
	}
 
	public void add(int a) {
		Node newnode = new Node(a);
		if (head==null) {
			head=newnode;
			tail=newnode;
		}
		else {
			tail.setNext(newnode);
			tail=newnode;
		}
	}
	 public boolean contains(int c) {
		 Node save = head ;
		 while (save!=null) {
		 if (save.getA()==c)
			 return true;
		 else save=save.getNext();
	 }
		 return false;
}
	 public int addin(int d) {
		 Node add= head;
		 for (int i=0 ;i<d; i++) 
			 add=add.getNext();
			 return add.getA();
	 } 
	 public void addStart(int e) {
		 Node add1= new Node (e);
		 if (head==null) {
			 head= add1;
			 tail=add1;
		 }
		 else {
		 add1.setNext(head);
		 head=add1;
		 } 
	 }
	 
	 public void addMiddle(int t, int size) {
		 Node add2 = new Node (t);
		 Node save= head;
		for (int i=0;i<size;i++) {
			save=save.getNext();
		}
		save.setNext(add2);
		add2.setNext(save.getNext());	 
		 
	 }
	 }


public class Node {
	private int a;
	private Node next;

	public Node() {
		a=0;
		next=null;
	}

	public Node (Node other) {
		this.a=other.a;
		this.next=other.next;
	}

	public Node (int b) {
		a=b;
		next=null;
	}
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Node getNext() { 
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}


}