package xdatastructures.tree;


import java.util.*;


public class BT_LL {
	BinaryNode root;


	// inserts a new node at deepest place in Tree
	void insert(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		if (root == null) {
			root = node;
			System.out.println("Successfully inserted new node at Root !");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				presentNode.setLeft(node);
				System.out.println("Successfully inserted new node !");
				break;
			}else if (presentNode.getRight() == null) {
				presentNode.setRight(node);
				System.out.println("Successfully inserted new node !");
				break;
			} else {
					queue.add(presentNode.getLeft());
					queue.add(presentNode.getRight());
			}//end of else-if
		}//end of loop
	}//end of method


	// Search for a given value in binary tree
	void search(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.getValue() == value) {
				System.out.println("Value-"+value+" is found in Tree !");
				return;
			}else {
				if (presentNode.getLeft()!=null)
					queue.add(presentNode.getLeft());
				if (presentNode.getRight()!=null)
				queue.add(presentNode.getRight());
			}
		}//end of loop
		System.out.println("Value-"+value+" is not found in Tree !");
	}//end of method

	
	// delete node from binary tree
	void deleteNodeOfBinaryTree(int value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			// if node is found then copy deepest node here and delete deepest node.
			if (presentNode.getValue() == value) {
				presentNode.setValue(getDeepestNode().getValue());
				DeleteDeepestNode();
				System.out.println("Deleted the node !!");
				return;
			}else {
				if (presentNode.getLeft() != null)
					queue.add(presentNode.getLeft());
				if (presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
		}//end of while loop
		System.out.println("Did not find the node!!");
	}


	//Delete deepest node
	public void DeleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				previousNode.setRight(null);
				return;
			}else if ((presentNode.getRight() == null)) {
				presentNode.setLeft(null);
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		}//end of while loop
	}//end of method



	// get last node of last level of binary tree
	public BinaryNode getDeepestNode() {
		// make an empty queue. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
		return presentNode;
	}//end of method

	public static int findDepthMinimum(BinaryNode root) {
		if (root == null)
			return 0;
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		int minimumTreeDepth = 0;
		while (!queue.isEmpty()) {
			minimumTreeDepth++;
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				BinaryNode currentNode = queue.poll();
				// check if this is a leaf node
				if (currentNode.left == null && currentNode.right == null)
					return minimumTreeDepth;
				// insert the children of current node in the queue
				if (currentNode.left != null)
					queue.add(currentNode.left);
				if (currentNode.right != null)
					queue.add(currentNode.right);
			}
		}
		return minimumTreeDepth;
	}

	public static int findDepthMaximumOrHieght(BinaryNode root) {
		if (root == null)
			return 0;
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		int maximumTreeDepth = 0;
		while (!queue.isEmpty()) {
			maximumTreeDepth++;
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				BinaryNode currentNode = queue.poll();
				// insert the children of current node in the queue
				if (currentNode.left != null)
					queue.add(currentNode.left);
				if (currentNode.right != null)
					queue.add(currentNode.right);
			}
		}
		return maximumTreeDepth;
	}

	public static int findHeight(BinaryNode root) {
		//Base case, leaf nodes have 0 height
		if (root == null)
			return -1;
		else {
			return 1 +
					Math.max(
							findHeight(root.getLeft()),
							findHeight(root.getRight()));
			// Find Height of left subtree right subtree
			// Return greater height value of left or right subtree (plus 1)
		}
	}

	public static boolean hasPath(BinaryNode root, int sum) {
		if (root == null)
			return false;

		// if the current node is a leaf and its value is equal to the sum, we've found a path
		if (root.value == sum && root.left == null && root.right == null)
			return true;

		// recursively call to traverse the left and right sub-tree
		// return true if any of the two recursive call return true
		return hasPath(root.left, sum - root.value)
				||
				hasPath(root.right, sum - root.value);
	}

	public static List<List<Integer>> findPaths(BinaryNode root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<Integer>();
		findPathsRecursive(root, sum, currentPath, allPaths);
		return allPaths;
	}

	private static void findPathsRecursive(BinaryNode currentNode,
										   int sum,
										   List<Integer> currentPath,
										   List<List<Integer>> allPaths) {
		if (currentNode == null)
			return;

		// add the current node to the path
		currentPath.add(currentNode.value);

		// if the current node is a leaf and its value is equal to sum, save the current path
		if (currentNode.value == sum && currentNode.left == null && currentNode.right == null) {
			allPaths.add(new ArrayList<Integer>(currentPath));
		} else {
			// traverse the left sub-tree
			findPathsRecursive(currentNode.left, sum - currentNode.value, currentPath, allPaths);
			// traverse the right sub-tree
			findPathsRecursive(currentNode.right, sum - currentNode.value, currentPath, allPaths);
		}

		// remove the current node from the path to backtrack,
		// we need to remove the current node while we are going up the recursive call stack.
		currentPath.remove(currentPath.size() - 1);
	}

	public static int findSumOfPathNumbers(BinaryNode root) {
		return findRootToLeafPathNumbers(root, 0);
	}

	private static int findRootToLeafPathNumbers(BinaryNode currentNode, int pathSum) {
		if (currentNode == null)
			return 0;

		// calculate the path number of the current node
		pathSum = 10 * pathSum + currentNode.value;

		// if the current node is a leaf, return the current path sum.
		if (currentNode.left == null && currentNode.right == null) {
			return pathSum;
		}

		// traverse the left and the right sub-tree
		return findRootToLeafPathNumbers(currentNode.left, pathSum) +
				findRootToLeafPathNumbers(currentNode.right, pathSum);
	}

	public static boolean findPathWithSequence(BinaryNode root, int[] sequence) {
		if (root == null)
			return sequence.length == 0;

		return findPathRecursive(root, sequence, 0);
	}

	private static boolean findPathRecursive(BinaryNode currentNode, int[] sequence, int sequenceIndex) {

		if (currentNode == null)
			return false;

		if (sequenceIndex >= sequence.length || currentNode.value != sequence[sequenceIndex])
			return false;

		// if the current node is a leaf, add it is the end of the sequence, we have found a path!
		if (currentNode.left == null && currentNode.right == null && sequenceIndex == sequence.length - 1)
			return true;

		// recursively call to traverse the left and right sub-tree
		// return true if any of the two recusrive call return true
		return findPathRecursive(currentNode.left, sequence, sequenceIndex + 1)
				|| findPathRecursive(currentNode.right, sequence, sequenceIndex + 1);
	}

		// pre-order traversal of binary tree
	void preOrder(BinaryNode node) {
		if (node == null)
			return;
		System.out.print(node.getValue() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}//end of method



	// post-order traversal of binary tree
	void postOrder(BinaryNode node) {
		if (node == null)
			return;
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}//end of method



	// in-order traversal of binary tree
	void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRight());
	}//end of method



	// level order traversal of binary tree
	void levelOrder() {
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}// end of method

	public static List<List<Integer>> traverseLevel(BinaryNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>(levelSize);
			for (int i = 0; i < levelSize; i++) {
				BinaryNode currentNode = queue.poll();
				// add the node to the current level
				currentLevel.add(currentNode.value);
				// insert the children of current node in the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
			result.add(currentLevel);
		}

		return result;
	}

	public static List<List<Integer>> traverseLevelReverse(BinaryNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>(levelSize);
			for (int i = 0; i < levelSize; i++) {
				BinaryNode currentNode = queue.poll();
				// add the node to the current level
				currentLevel.add(currentNode.value);
				// insert the children of current node to the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
			// append the current level at the beginning
			result.add(0, currentLevel);
		}

		return result;
	}

	// 1st level from left -> right, then right -> left, then again same as before and so on
	public static List<List<Integer>> traverseLevelZigZag(BinaryNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean leftToRight = true;
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> currentLevel = new LinkedList<>();
			for (int i = 0; i < levelSize; i++) {
				BinaryNode currentNode = queue.poll();

				// add the node to the current level based on the traverse direction
				if (leftToRight)
					currentLevel.add(currentNode.value);
				else
					currentLevel.add(0, currentNode.value);

				// insert the children of current node in the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
			result.add(currentLevel);
			// reverse the traversal direction
			leftToRight = !leftToRight;
		}

		return result;
	}

	public static List<BinaryNode> traverseOnlyRightViewNodes(BinaryNode root) {
		List<BinaryNode> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				BinaryNode currentNode = queue.poll();
				// if it is the last node of this level, add it to the result
				if (i == levelSize - 1)
					result.add(currentNode);
				// insert the children of current node in the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
		}

		return result;
	}

	public static List<Double> findLevelAverages(BinaryNode root) {
		List<Double> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			double levelSum = 0;
			for (int i = 0; i < levelSize; i++) {
				BinaryNode currentNode = queue.poll();
				// add the node's value to the running sum
				levelSum += currentNode.value;
				// insert the children of current node to the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
			// append the current level's average to the result array
			result.add(levelSum / levelSize);
		}

		return result;
	}

	// Delete Tree
	void deleteTree() {
		root = null;
		System.out.println("Binary Tree has been deleted successfully");
	}


	public static void deleteZeroSumSubtree(BinaryNode root) {

		if (root == null) {
			return;
		}

		if (0 == deleteZeroSumSubtreeRec(root)) {
			root = null;
		}
	}

	private static int deleteZeroSumSubtreeRec(BinaryNode root) {

		if (root == null) {
			return 0;
		}

		int sum_left  = deleteZeroSumSubtreeRec(root.left);
		int sum_right = deleteZeroSumSubtreeRec(root.right);

		if (sum_left == 0) {
			root.left = null;
		}

		if (sum_right == 0) {
			root.right = null;
		}

		return root.getValue() + sum_left + sum_right;
	}

	public static boolean treesMirror(BinaryNode root1, BinaryNode root2)
	{
		List<Integer> tree1Traversal = new LinkedList<>();
		exploreTLR(root1, tree1Traversal);
		List<Integer> tree2Traversal = new LinkedList<>();
		exploreTRL(root2, tree2Traversal);
		return tree1Traversal.equals(tree2Traversal);
	}


	private static void exploreTLR(BinaryNode root, List<Integer> traversal)
	{
		if(root!=null)
		{
			traversal.add(root.getValue());
			exploreTLR(root.getLeft(), traversal);
			exploreTLR(root.getRight(), traversal);
		}
	}

	private static void exploreTRL(BinaryNode root, List<Integer> traversal)
	{
		if(root!=null)
		{
			traversal.add(root.getValue());
			exploreTLR(root.getRight(), traversal);
			exploreTLR(root.getLeft(), traversal);
		}
	}

	public static BinaryNode findSuccessorLevelOrder(BinaryNode root, int key) {
		if (root == null)
			return null;

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryNode currentNode = queue.poll();
			// insert the children of current node in the queue
			if (currentNode.left != null)
				queue.offer(currentNode.left);
			if (currentNode.right != null)
				queue.offer(currentNode.right);

			// break if we have found the key
			if (currentNode.value == key)
				break;
		}

		return queue.peek();
	}

	public static List<Integer> getLevelOrderTraversalWithSibling(BinaryNode root)
	{
		populateSiblingPointers(root);
		List<Integer> l = new ArrayList<Integer>();
		while(root != null) {
			l.add(root.value);
			root = root.next;
		}
		return l;
	}


	private static void populateSiblingPointers(BinaryNode root) {
		if(root == null)
			return;

		ArrayDeque<BinaryNode> queue = new ArrayDeque<BinaryNode>();
		queue.addLast(root);
		BinaryNode prev = null;

		while(!queue.isEmpty()){
			BinaryNode temp = queue.removeFirst();
			if(prev != null) {
				prev.next = temp;
			}
			prev = temp;
			if(temp.left != null){
				queue.addLast(temp.left);
			}
			if(temp.right != null){
				queue.addLast(temp.right);
			}
		}
		prev.next = null;
	}


	public static List<Integer> getLevelOrderUsingNextSameLevel(BinaryNode root) {

		populateSiblingPointers2(root);

		List<Integer> output = new ArrayList<Integer>();
		while (root != null) {
			BinaryNode head = root;
			BinaryNode next_head = null;
			while (head != null) {
				output.add(head.value);

				if (next_head == null) {
					next_head = head.left != null ?
								head.left :
								head.right;
				}
				head = head.next;
			}
			root = next_head;
		}
		return output;
	}

	private static void populateSiblingPointers2(BinaryNode root) {
		if (root == null) {
			return;
		}
		root.next = null;
		do {
			root = connectNextLevel(root);
		} while (root != null);
	}

	private static BinaryNode connectNextLevel(BinaryNode head) {
		BinaryNode current = head;
		BinaryNode nextLevelHead = null;
		BinaryNode prev = null;

		while (current != null) {
			if(current.left != null && current.right != null){
				if(nextLevelHead == null){
					nextLevelHead = current.left;
				}
				current.left.next = current.right;

				if(prev != null){
					prev.next = current.left;
				}
				prev = current.right;
			}
			else if(current.left != null){
				if(nextLevelHead == null){
					nextLevelHead = current.left;
				}
				if(prev != null){
					prev.next = current.left;
				}
				prev = current.left;
			}
			else if(current.right != null){
				if(nextLevelHead == null){
					nextLevelHead = current.right;
				}

				if(prev != null){
					prev.next = current.right;
				}
				prev = current.right;
			}
			current = current.next;
		}

		if(prev != null){
			prev.next = null;
		}

		return nextLevelHead;
	}



	private static class NodeDepthPair {
		BinaryNode node;
		int depth;
		NodeDepthPair(BinaryNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public static boolean isBalanced(BinaryNode treeRoot) {

		// a tree with no nodes is superbalanced, since there are no leaves!
		if (treeRoot == null) {
			return true;
		}

		// we short-circuit as soon as we find more than 2
		List<Integer> depths = new ArrayList<>(3);

		// Stack
		Deque<NodeDepthPair> nodes = new ArrayDeque<>();
		nodes.push(new NodeDepthPair(treeRoot, 0));

		while (!nodes.isEmpty()) {
			// pop a node and its depth from the top of our stack
			NodeDepthPair nodeDepthPair = nodes.pop();

			BinaryNode node = nodeDepthPair.node;
			int depth = nodeDepthPair.depth;

			// case: we found a leaf
			if (node.left == null && node.right == null) {

				// we only care if it's a new depth
				if (!depths.contains(depth)) {
					depths.add(depth);

					// two ways we might now have an unbalanced tree:
					//   1) more than 2 different leaf depths
					//   2) 2 leaf depths that are more than 1 apart
					if (depths.size() > 2
							||
							(depths.size() == 2
									&&
									Math.abs(depths.get(0) - depths.get(1)) > 1)) {
						return false;
					}
				}

				// case: this isn't a leaf - keep stepping down
			} else {
				if (node.left != null) {
					nodes.push(new NodeDepthPair(node.left, depth + 1));
				}
				if (node.right != null) {
					nodes.push(new NodeDepthPair(node.right, depth + 1));
				}
			}
		}

		return true;
	}
	
	

}//end of class