public class BinaryTree {
	static Node root;
	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if (root == null) {
			root = newNode;
		} 
		else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				}
				else 
				{ 
					focusNode = focusNode.rightChild;
					if (focusNode == null) 
					{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}	
	/**
	 * finds a specific Node with a specific data in the Tree. 
	   If value is not found it prints Saying not found
	 * @param data
	 * @param nodeFinder
	 */
	public void locateNode(int data , Node nodeFinder)
	{
		if(nodeFinder == null)
		{
			System.out.println("Not in this Tree, try another one");
		}
		else if(nodeFinder.key == data)
		{
			System.out.println("BINGO!! We found it");
		}
		else if(data > nodeFinder.key)
		{
			locateNode(data , nodeFinder.rightChild);
		}
		else{
			locateNode(data , nodeFinder.leftChild);
		}
	}
	public int getSize(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		else
		{
			return getSize(node.leftChild)+ 1 + getSize(node.rightChild);
		}
			
	}
		public int countAvg(Node node)
		{
			if(node == null)
			{
				return 0;
			}
			else
				return (node.key+countAvg(node.leftChild)+countAvg(node.rightChild)) / getSize(node);
		}
		int totalNodes;
		int sum;
		void countNodes(Node anode)
		{
			sum += anode.key;
			totalNodes += 1;
		}
		double findAvg(Node anode)
		{
			if(anode == null)
				return 0;
			countNodes(anode);
			if(anode.leftChild!=null)
				findAvg(anode.leftChild);
			if(anode.rightChild!= null)
				findAvg(anode.rightChild);
			return (double) sum/totalNodes;
		}
		
	
		public int countLeaves(Node node)//recursive method that counts the leaf nodes
		{
			if(node == null)
			{
				return 0;
			}
			else if(node.leftChild == null && node.rightChild == null)
			{
				return 1;
			}
			else
			{
				return countLeaves(node.leftChild) + countLeaves(node.rightChild);
			}
			
		}
	
		public void inOrderTraverseTree(Node focusNode)
		{
			if(focusNode != null) {
				inOrderTraverseTree(focusNode.leftChild);
				System.out.println(focusNode.key + " " + focusNode.name);
				inOrderTraverseTree(focusNode.rightChild);
				
			}
		}
		
		public void preorderTraverseTree(Node focusNode)
		{
		 if(focusNode != null) 
		 {
			 System.out.println(focusNode.key + " " + focusNode.name);
			 preorderTraverseTree(focusNode.leftChild);
			 preorderTraverseTree(focusNode.rightChild);
		 }
		}
		
		public void postOrderTraverseTree(Node focusNode) {
		if(focusNode != null) 
		{
		 postOrderTraverseTree(focusNode.leftChild);
		 postOrderTraverseTree(focusNode.rightChild);
		 System.out.println(focusNode.key + " " + focusNode.name);
		 }
		}
		public static void main(String[] args) {
			 BinaryTree theTree = new BinaryTree();
			 theTree.addNode(50, "a");
			 theTree.addNode(49, "b");
			 theTree.addNode(51, "c");
			 theTree.addNode(30, "John");
			 theTree.addNode(40, "Ellen");
			 System.out.println("Looking for the Node with 85 in it");
			 theTree.locateNode(85, theTree.root);
			 System.out.println("Now looking for the Node with 100000 in it");
			 theTree.locateNode(100000, theTree.root);
			 System.out.println("In ordered Traversal ");
			 theTree.inOrderTraverseTree(root);
			 System.out.println("--------------");
			 System.out.println("Post ordered traversal");
			 theTree.postOrderTraverseTree(root);
			 System.out.println("--------------");
			 System.out.println("Pre ordered traversal order");
			 theTree.preorderTraverseTree(root);
			 System.out.println("--------------");
			 System.out.println(theTree.countLeaves(root));
			 System.out.println("--------------");
			 System.out.println(theTree.countAvg(root));
			 System.out.println("--------------");
			 System.out.println(theTree.getSize(root));
			 System.out.println("--------------");
			 System.out.println(theTree.findAvg(root));
			}
}
