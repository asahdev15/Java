package xdatastructures.tree;


import java.util.*;

public class BST_LL {

	BinaryNode root;

	public BinaryNode getRoot() {
		return root;
	}

	// Constructor
	BST_LL() {
		root = null;
	}

	// creates a new blank new node
	public static BinaryNode createNewNode(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		return node;
	}



	// Search a node in BST
	void searchForValue(int value) {
		searchForValue(root, value);
	}


	// Search a node in BST
	BinaryNode searchForValue(BinaryNode node, int value) {
		if (node == null) {
			System.out.println("Value: " + value + " not found in BST.");
			return null;
		} else if (node.getValue() == value) {
			System.out.println("Value: " + value + " found in BST.");
			return node;
		} else if (value < node.getValue()) {
			return searchForValue(node.getLeft(), value);
		} else {
			return searchForValue(node.getRight(), value);
		}
	}// end of method

	//Either returns the Node with that value or return null
	public BinaryNode searchIterative(BinaryNode node, int value) {
		if (node == null)
			return null;
		BinaryNode currentNode = node;
		while (currentNode != null) {
			if (value == currentNode.getValue())
				return currentNode;
			if (value < currentNode.getValue())
				currentNode = currentNode.left;
			else
				currentNode = currentNode.right;
		}
		System.out.println(value + " Not found in the Tree!");
		return null;
	}



	public static void preOrderTraversal(BinaryNode root, List<Integer> traversal) {
		if (root == null) return;
		traversal.add(root.value);
		preOrderTraversal(root.left, traversal);
		preOrderTraversal(root.right, traversal);
	}

	public static void inOrderTraversal(BinaryNode root, List<Integer> traversal) {
		if (root == null) return;
		inOrderTraversal(root.left, traversal);
		traversal.add(root.value);
		inOrderTraversal(root.right, traversal);
	}

	public static void inOrderIterative(BinaryNode root, List<Integer> traversal)
	{
		if(root == null)
			return ;
		Stack<BinaryNode> stk = new Stack<>();
		BinaryNode tmp = root;
		while(!stk.empty() || tmp != null)
		{
			if(tmp != null)
			{
				stk.push(tmp);
				tmp = tmp.left;
				continue;
			}
			BinaryNode popped = stk.pop();
			traversal.add(popped.getValue());
			tmp = popped.right;
		}
	}

	public static List<Integer> inOrderUsingIterator(BinaryNode root) {
		List<Integer> nodes = new LinkedList<>();
		BST_InOrder_Iterator iter = new BST_InOrder_Iterator(root);
		while (iter.hasNext()) {
			nodes.add(iter.getNext().getValue());
		}
		return nodes;
	}

	public static void postOrderTraversal(BinaryNode root, List<Integer> traversal) {
		if (root == null) return;
		postOrderTraversal(root.left, traversal);
		postOrderTraversal(root.right, traversal);
		traversal.add(root.value);
	}

	// Level order traversal of BST
	void levelOrderTraversal() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		System.out.println("\nPrinting Level order traversal of Tree...");
		if (root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}// end of method


	// Using one queue
	public static String levelOrderTraversalOneLine(
			BinaryNode root) {

		if (root == null) {
			return "";
		}

		String result = "";

		Queue<BinaryNode> current_queue =
				new ArrayDeque<BinaryNode>();

		BinaryNode dummyNode = new BinaryNode();

		current_queue.add(root);
		current_queue.add(dummyNode);

		while (!current_queue.isEmpty()) {
			BinaryNode temp = current_queue.poll();
			result += String.valueOf(temp.getValue()) + " ";

			if (temp.left != null) {
				current_queue.add(temp.left);
			}

			if (temp.right != null) {
				current_queue.add(temp.right);
			}

			if (current_queue.peek() == dummyNode) {
				System.out.println();

				current_queue.remove();

				if (!current_queue.isEmpty()) {
					current_queue.add(dummyNode);
				}
			}
		}
		return result;
	}




	// Insert values in BST
	void insert(int value) {
		root = insert(root, value);
	}

	// Helper Method
	BinaryNode insert(BinaryNode currentNode, int value) {
		if (currentNode == null) {
			return createNewNode(value);
		} else if (value <= currentNode.getValue()) {
			currentNode.setLeft(insert(currentNode.getLeft(), value));
			return currentNode;
		} else {
			currentNode.setRight(insert(currentNode.getRight(), value));
			return currentNode;
		}
	}

	//Iterative Function to insert a value in BST
	public boolean insertIterative(int value) {
		//If Tree is empty then insert Root with the given value inside Tree
		if (root == null) {
			root = createNewNode(value);
			return true;
		}
		//Starting from root
		BinaryNode currentNode = root;
		//Traversing the tree untill valid position to insert the value
		while (currentNode != null) {
			BinaryNode leftChild = currentNode.getLeft();
			BinaryNode rightChild = currentNode.getRight();
			//If the value to insert is less than root value then move to left subtree
			//else move to right subtree of root
			//and before moving check if the subtree is null, if it's then insert the value.
			if (value < currentNode.getValue()) {
				if (leftChild == null) {
					leftChild = createNewNode(value);
					currentNode.setLeft(leftChild);
					return true;
				}
				currentNode = leftChild;
			} else {
				if (rightChild == null) {
					rightChild = createNewNode(value);
					currentNode.setRight(rightChild);
					return true;
				}
				currentNode = rightChild;
			} //end of else
		} //end of while
		return false;
	}


	// Deleting a node from BST
	public void deleteNodeOfBST(int value) {
		System.out.println("\n\nDeleting " + value + " from BST...");
		deleteNodeOfBST(root,value);
	}


	// Helper Method for delete
	public BinaryNode deleteNodeOfBST(BinaryNode root, int value) {
		if (root == null) {
			System.out.println("Value not found in BST");
			return null;
		}
		if (value < root.getValue()) {
			root.setLeft(deleteNodeOfBST(root.getLeft(), value));
		} else if (value > root.getValue()) {
			root.setRight(deleteNodeOfBST(root.getRight(), value));
		} else {
			// If currentNode is the node to be deleted

			if (root.getLeft() != null && root.getRight() != null) {
				// if nodeToBeDeleted have both children
				BinaryNode temp = root;
				// Finding minimum element from right subtree
				BinaryNode minNodeForRight = minimumElement(temp.getRight());
				// Replacing current node with minimum node from right subtree
				root.setValue(minNodeForRight.getValue());
				// Deleting minimum node from right now
				root.setRight(deleteNodeOfBST(root.getRight(), minNodeForRight.getValue()));
			} else if (root.getLeft() != null) {
				// if nodeToBeDeleted has only left child
				root = root.getLeft();
			} else if (root.getRight() != null) {
				// if nodeToBeDeleted has only right child
				root = root.getRight();
			} else
				// if nodeToBeDeleted do not have child (Leaf node)
				root = null;
		}
		return root;
	}// end of method


	//3 conditions for delete
	//1.node is leaf node.
	//2.node has 1 child.
	//3.node has 2 children.
	boolean deleteIterative(int value, BinaryNode currentNode) {
		if (root == null) {
			return false;
		}

		BinaryNode parent = null; //To Store parent of currentNode
		while(currentNode != null && (currentNode.getValue() != value)) {
			parent = currentNode;
			if (currentNode.getValue() > value)
				currentNode = currentNode.getLeft();
			else
				currentNode = currentNode.getRight();
		}

		if(currentNode == null) {
			return false;
		}
		else if(currentNode.getLeft() == null && currentNode.getRight() == null) {
			//1. Node is Leaf Node
			//if that leaf node is the root (a tree with just root)
			if(root.getValue() == currentNode.getValue()){
				this.root = null;
				return true;
			}
			else if(currentNode.getValue() < parent.getValue()){
				parent.setLeft(null);
				return true;
			}
			else{
				parent.setRight(null);
				return true;
			}
		} else if(currentNode.getRight() == null) {

			if(root.getValue() == currentNode.getValue()){
				this.root = currentNode.getLeft();
				return true;
			}
			else if(currentNode.getValue() < parent.getValue()){
				parent.setLeft(currentNode.getLeft());
				return true;
			}
			else{

				parent.setRight(currentNode.getLeft());
				return true;
			}

		}
		else if(currentNode.getLeft() == null) {

			if(root.getValue() == currentNode.getValue()){
				this.root = currentNode.getRight();
				return true;
			}
			else if(currentNode.getValue() < parent.getValue()){
				parent.setLeft(currentNode.getRight());
				return true;
			}
			else{
				parent.setRight(currentNode.getRight());
				return true;
			}

		}
		else {
			//Find Least Value Node in right-subtree of current Node
			BinaryNode leastNode = minimumElementIterative(currentNode.getRight());
			//Set CurrentNode's Data to the least value in its right-subtree
			int temp = leastNode.getValue();
			deleteIterative(temp, root);
			currentNode.setValue(temp);
			//Delete the leafNode which had the least value
			return true;
		}

	}

	// Get minimum element in binary search tree - its the left most value
	public static BinaryNode minimumElement(BinaryNode root) {
		if (root.getLeft() == null)
			return root;
		else
			return minimumElement(root.getLeft());
	}// end of method

	//Helper function to find least value node in right-subtree of currentNode
	private BinaryNode minimumElementIterative(BinaryNode currentNode) {
		BinaryNode temp = currentNode;
		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		return temp;
	}

	private static int maximumElementIterative(BinaryNode rootNode){
		BinaryNode curr = rootNode;
		while(curr.right != null){
			curr = curr.right;
		}
		return curr.value;
	}

	public void deleteTree() {
		root = null;
	}


	public static void serializeBinaryTree(BinaryNode node, List<Integer> serializeList){
		if(node!=null)
		{
			serializeList.add(node.getValue());
			serializeBinaryTree(node.getLeft(), serializeList );
			serializeBinaryTree(node.getRight(), serializeList );
		}else{
			serializeList.add(null);
		}
	}

	static int index = 0;
	public static BinaryNode deserializeBinaryTree(List<Integer> serializeList)
	{
		if(index > serializeList.size() || serializeList.get(index) == null)
		{
			index++;
			return null;
		}
		BinaryNode node = createNewNode(serializeList.get(index++));
		node.setLeft(deserializeBinaryTree(serializeList));
		node.setRight(deserializeBinaryTree(serializeList));
		return node;
	}

	public static boolean checkTreeEqual(BinaryNode root1, BinaryNode root2)
	{
		List<Integer> tree1Traversal = new LinkedList<>();
		inOrderTraversal(root1, tree1Traversal);

		List<Integer> tree2Traversal = new LinkedList<>();
		inOrderTraversal(root2, tree2Traversal);
		return tree1Traversal.equals(tree2Traversal);
	}

	public static boolean checkTreeEqual2
			(BinaryNode root1, BinaryNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 != null && root2 != null) {
			return ((root1.getValue() == root2.getValue()) &&
					checkTreeEqual2(root1.left, root2.left) &&
					checkTreeEqual2(root1.right, root2.right));
		}

		return false;
	}




	public static int findSecondLargest(BinaryNode rootNode){
		if (rootNode == null
			||
			(rootNode.left == null
			&&
			rootNode.right == null))
		{
			throw new IllegalArgumentException("Tree must have at least 2 nodes");
		}
		BinaryNode curr = rootNode;
		while(true){
			if( curr.right == null
				&&
				curr.left != null){
				return maximumElementIterative(curr.left);
			}
			if( curr.right !=null
				&&
				curr.right.left == null
				&&
				curr.right.right == null){
				return curr.value;
			}
			curr = curr.right;
		}
	}



	public static Integer findKthMaxValue(BinaryNode root, int k )
	{
		List<Integer> tree1Traversal = new ArrayList<>();
		inOrderTraversal(root, tree1Traversal);
		return tree1Traversal.get(tree1Traversal.size()-k);
	}


	static int currentCount = 0;
	public static BinaryNode findKthMaxValue2(BinaryNode node, int k) {
		if (node == null) {
			return null;
		}

		BinaryNode result = findKthMaxValue2(node.right, k);
		if(result != null) {
			return result;
		}

		currentCount++;
		if(k == currentCount) {
			return node;
		}

		result = findKthMaxValue2(node.left, k);
		if(result != null) {
			return result;
		}

		return null;
	}


	public ArrayList<BinaryNode> visitedNodes = new ArrayList<>();
	public int steps = 0;
	void findPath(BinaryNode currentNode, int seachValue) {
		if(!visitedNodes.contains(currentNode))
		{
			visitedNodes.add(currentNode);
			steps++;
		}
		else{
			steps--;
		}
		if (currentNode.value == seachValue) {
			return ;
		} else if (seachValue < currentNode.getValue()) {
			findPath(currentNode.getLeft(), seachValue);
		} else {
			findPath(currentNode.getRight(), seachValue);
		}
	}

	public static List<Integer> findAncestors(BinaryNode root, int k) {
		List<Integer> ancesstors = new ArrayList<>();
		BinaryNode tempNode = root;
		boolean nodeFound = false;
		while(tempNode != null){
			if(k < tempNode.getValue()){
				ancesstors.add(tempNode.getValue());
				tempNode = tempNode.getLeft();
			} else if (k > tempNode.getValue()){
				ancesstors.add(tempNode.getValue());
				tempNode = tempNode.getRight();
			} else {
				nodeFound = true;
				break;
			}
		}
		if(nodeFound){
			return ancesstors;
		}
		return new ArrayList<>();
	}



	//Helper recursive function to traverse tree and append all the nodes
	// at k distance into result StringBuilder
	public static void
	findKDistanceApartNodes(BinaryNode root, int k, List<Integer> result) {
		if (root == null)
			return ;
		if (k == 0)
		{
			result.add(root.getValue());
		}
		else
		{
			//Decrement k at each step till you reach at the leaf node
			// or when k == 0 then append the Node's data into result string
			findKDistanceApartNodes(root.getLeft(), k - 1, result);
			findKDistanceApartNodes(root.getRight(), k - 1, result);
		}
	}




	public static boolean isBST_Valid_WithBounds_Rec(BinaryNode root) {
		return isBstRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBstRec(BinaryNode root, int min_value, int max_value) {
		if (root == null) {
			return true;
		}
		if (root.getValue() < min_value || root.getValue() > max_value) {
			return false;
		}
		return isBstRec(root.left, min_value, root.getValue())
				&&
				isBstRec(root.right, root.getValue(), max_value);
	}

	public static boolean isBST_Valid_WithBounds_Iterative(BinaryNode root) {
		Deque<NodeBounds> stck = new ArrayDeque<>();
		stck.push(new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		while (!stck.isEmpty()) {
			NodeBounds nb = stck.pop();
			BinaryNode node = nb.node;
			int lowerBound = nb.lowerBound;
			int upperBound = nb.upperBound;
			if (node.value <= lowerBound || node.value >= upperBound)
				return false;
			if (node.left != null)
				stck.push(new NodeBounds(node.left, lowerBound, node.value));
			if (node.right != null)
				stck.push(new NodeBounds(node.right, node.value, upperBound));
		}
		return true;
	}

	private static class NodeBounds {
		BinaryNode node;
		int lowerBound;
		int upperBound;
		NodeBounds(BinaryNode node, int lowerBound, int upperBound) {
			this.node = node;
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
	}


	static BinaryNode prev = null;
	public static boolean isBstWithPrevPointer(BinaryNode root) {
		if (root == null) {
			return true;
		}
		if (!isBstWithPrevPointer(root.left)) {
			return false;
		}
		if (prev != null && prev.getValue() >= root.getValue()) {
			return false;
		}
		prev = root;
		if (!isBstWithPrevPointer(root.right)) {
			return false;
		}
		return true;
	}





	public static void mirrorBinaryTree(BinaryNode root) {
		if (root == null) {
			return;
		}
		// We will do a post-order traversal of the binary tree.
		if (root.left != null) {
			mirrorBinaryTree(root.left);
		}
		if (root.right != null) {
			mirrorBinaryTree(root.right);
		}
		// Let's swap the left and right nodes at current level.
		BinaryNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}



	public static List<Integer> get_list(BinaryNode head) {
		head = convertToLinkedList(head);
		List<Integer> r = new ArrayList<Integer>();
		if (head == null) {
			return r;
		}
		BinaryNode temp = head;
		do {
			r.add(temp.getValue());
			temp = temp.right;
		} while (temp != head);
		return r;
	}

	private static BinaryNode convertToLinkedList(BinaryNode root) {

		if (root == null) {
			return null;
		}

		BinaryNode list1 = convertToLinkedList(root.left);
		BinaryNode list2 = convertToLinkedList(root.right);

		root.left = root.right = root;

		BinaryNode result = concatenateLists(list1, root);
		result = concatenateLists(result, list2);

		return result;
	}

	// merge(fuse) two sorted linked lists
	private static BinaryNode concatenateLists(BinaryNode head1, BinaryNode head2) {
		if (head1 == null) {
			return head2;
		}

		if (head2 == null) {
			return head1;
		}

		// use left for previous.
		// use right for next.
		BinaryNode tail1 = head1.left;
		BinaryNode tail2 = head2.left;

		tail1.right = head2;
		head2.left = tail1;

		head1.left = tail2;
		tail2.right = head1;
		return head1;
	}

	

	void printTreeGraphically() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		
		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);
		
		System.out.println("\nPrinting Level order traversal of Tree...");
		if(root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		
		while (!queue.isEmpty()) {
			if(CurrentLevel == level.peek()) { //if we are in the same level
				if(queue.peek()==null) {
					queue.add(null);level.add(CurrentLevel+1);
				}else {
					queue.add(queue.peek().getLeft());level.add(CurrentLevel+1);
					queue.add(queue.peek().getRight());level.add(CurrentLevel+1);
					previousLevelWasAllNull = false;
				}
				System.out.print(queue.remove() + "  ");level.remove();
			}else { //level has changed
				System.out.println("\n");
				CurrentLevel++;
				if(previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}//end of loop
	}//end of method



	public BinaryNode bstFromPreorder(int[] preorder) {
		return createNode(preorder, 0, preorder.length-1);
	}

	private BinaryNode createNode(int[] preorder, int i, int j){
		if(i > j)
			return null;
		if(i == j){
			BinaryNode node =  new BinaryNode();
			node.value = preorder[i];
		}

		BinaryNode node =  new BinaryNode();
		node.value = preorder[i];

		int m = i;
		while(m<j && preorder[m+1] < preorder[i]){
			m++;
		}
		if(m>i){
			node.left = createNode(preorder, i+1, m);
		}
		if(m+1<=j){
			node.right = createNode(preorder, m+1, j);
		}
		return node;
	}
	
}// end of class