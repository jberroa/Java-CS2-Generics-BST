
//Jorge Berroa 
//COP3503
//Generic's



class Node<Anytype>   			// This is our Node class and because we want our BST to hold any type of data we have to make this class 
{								// generic. To make this class generic we put the variable in the diamond parameter.
	Anytype data;				// our data used to be an int but because we want to hold anytpye of data we have to change the data type 
	Node<Anytype> left, right; // of data so instead of int data its Anytype data.

	Node(Anytype data)
	{
		this.data = data;
	}
}
public class GenericBST<Anytype extends Comparable<Anytype>> {
																	// in our GenericBST we want to be able to hold anytyoe of data so  
																	// if we want to make this possible we have to make this class generic 
																	// if we make GenericBST generic and its allowed to hold different 
																	// data then we have to extend comparable to make sure that incompatible data types
																	// are not stored in our BST.by extending comparable we cna prevetn that.
	
	private Node<Anytype> root;										// make the declaration of node with the diamond parameter anytype 
																	// and this will be my root of my BST that will hold what ever type as long as its comparable 
	
	
	
	public void insert(Anytype data)								// insert method with the parameter that takes a generic type.
	{
		root = insert(root, data);
	}

	private Node<Anytype> insert(Node<Anytype> root, Anytype data)          // this insert method returns a new node thats been added to the BST 
	{																		// it takes n a Node  and a data of Anytype.
																			// if the root is null create a new node if not check where the data can be placed 
		if (root == null)
		{
			return new Node<Anytype>(data);
		}
		else if (root.data.compareTo(data)>0)                               // in this if statement we had to use the compareto() method which determines if the data types are comaparble 																	// to each other and if they are comparable if they are it checks in what order they are compared  
		{																	//and based on that comparison it will return either positive or negative number depending on the order.
																			// like we are not allowing duplicates in our bst we do no have to worry about this case but if we were the compareto() method would return 0.
			root.left = insert(root.left, data);
		}
		else if (root.data.compareTo(data)<0)
		{	
			root.right = insert(root.right, data);
		}
		else
		{
			// Stylistically, I have this here to explicitly state that we are
			// disallowing insertion of duplicate values.
			;
		}

		return root;
	}

	public void delete(Anytype data)								// delete method deletes a node by calling the delete method that takes in root and the data that needs to be deleted 
	{
		root = delete(root, data);
	}

	private Node<Anytype> delete(Node<Anytype> root, Anytype data)			
	{
		if (root == null)
		{
			return null;
		}
		else if (root.data.compareTo(data)<0)
		{
			root.left = delete(root.left, data);
		}
		else if (root.data.compareTo(data)>0)
		{
			root.right = delete(root.right, data);
		}
		else
		{
			if (root.left == null && root.right == null)
			{
				return null;
			}
			else if (root.right == null)
			{
				return root.left;
			}
			else if (root.left == null)
			{
				return root.right;
			}
			else
			{
				root.data = findMax(root.left);
				root.left = delete(root.left, root.data);
			}
		}

		return root;
	}

	private Anytype findMax(Node<Anytype> root)  // this method finds the maax number by going all the way t o the right of root and returns the max
	{
		while (root.right != null)
		{
			root = root.right;
		}

		return root.data;
	}

	// Returns true if the value is contained in the BST, false otherwise.
	public boolean contains(Anytype data)
	{
		return contains(root, data);
	}

	private boolean contains(Node<Anytype> root, Anytype data) // checks if the bst contains the data 
	{
		if (root == null)
		{
			return false;
		}
		else if (root.data.compareTo(data)>0)
		{
			return contains(root.left, data);
		}
		else if (root.data.compareTo(data)<0)
		{
			return contains(root.right, data);
		}
		else
		{
			return true;
		}
	}

	public void inorder()
	{
		System.out.print("In-order Traversal:");
		inorder(root);
		System.out.println();
	}

	private void inorder(Node<Anytype> root)
	{
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(" " + root.data);
		inorder(root.right);
	}

	public void preorder()
	{
		System.out.print("Pre-order Traversal:");
		preorder(root);
		System.out.println();
	}

	private void preorder(Node<Anytype> root)
	{
		if (root == null)
			return;

		System.out.print(" " + root.data);
		preorder(root.left);
		preorder(root.right);
	}

	public void postorder()
	{
		System.out.print("Post-order Traversal:");
		postorder(root);
		System.out.println();
	}

	private void postorder(Node<Anytype> root)
	{
		if (root == null)
			return;

		postorder(root.left);
		postorder(root.right);
		System.out.print(" " + root.data);
	}

	public static void main(String [] args)
	{
		GenericBST<String> myTree = new GenericBST<String>();

			myTree.insert("f");

			myTree.insert("b");

			myTree.insert("a");

			myTree.insert("g");

			myTree.insert("i");

			myTree.insert("h");

			myTree.insert("d");

			myTree.insert("c");

			myTree.insert("e");

		
		myTree.preorder();
		System.out.println(" ");
		myTree.inorder();
	
		myTree.postorder();
	}
	public static double difficultyRating(){
		return 1.5; // This assignment was'nt bad at all. as long as you can grasp the concept you can apply it to this code. 
					// side note: I want to thank you for teaching us advance topics in this class i appreciate the time and dedication
					// you put towards teaching us advance material. Thank you for caring and actually wanting us to excel in our 
					// Academic careers.
	}
	public static double hoursSpent() 
	{
		return 2.8; // almost three hours had difficulty on the compareto() method but once i figured out all i needed was comments 
	}
}
