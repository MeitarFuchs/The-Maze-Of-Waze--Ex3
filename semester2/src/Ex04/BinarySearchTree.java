package Ex04;

public class BinarySearchTree { 

			/* Class containing left and right child of current node and key value*/
			class Node { 
				int key; 
				Node left, right; 

				public Node(int item) { 
					key = item; 
					left = right = null; 
				} 
			} 

			// Root of BST 
			Node root; 

			// Constructor 
			BinarySearchTree() { 
				root = null; 
			} 

			// This method mainly calls insertRec() 
			void insert(int key) { 
			root = insertRec(root, key); 
			} 
			
			/* A recursive function to insert a new key in BST */
			Node insertRec(Node root, int key) { 

				/* If the tree is empty, return a new node */
				if (root == null) { 
					root = new Node(key); 
					return root; 
				} 

				/* Otherwise, recur down the tree */
				if (key < root.key) 
					root.left = insertRec(root.left, key); 
				else if (key > root.key) 
					root.right = insertRec(root.right, key); 

				/* return the (unchanged) node pointer */
				return root; 
			} 

			// This method mainly calls InorderRec() 
			void inorder() { 
			inorderRec(root); 
			} 

			// A utility function to do inorder traversal of BST 
			void inorderRec(Node root) { 
				if (root != null) { 
					inorderRec(root.left); 
					System.out.println(root.key); 
					inorderRec(root.right); 
				} 
			} 
			public boolean search(Node root, int key) 
			{ 
				// Base Cases: root is null or key is present at root 
				if (root==null) return false;
					if(root.key==key) return true; 

				// val is greater than root's key 
				if (root.key > key) 
					return search(root.left, key); 

				// val is less than root's key 
				return search(root.right, key); 
			}


		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

	}

