package datastructures.tree;

import java.util.LinkedList;
import java.util.List;

public class BST_LL_Main {

	public BST_LL_Main() {
	}

	public static void main(String[] args) {

		BST_LL tree1 = new BST_LL();
		tree1.insert(6);
		tree1.insert(4);
		tree1.insert(9);
		tree1.insert(2);
		tree1.insert(5);
		tree1.insert(8);
		tree1.insert(12);
		BinaryNode tree1Root = tree1.root;



		System.out.println(BST_LL.get_list(tree1Root));

//		List<Integer> treeTraversal = BST_LL.inorderUsingIterator(tree1.root);
//		System.out.println(treeTraversal);



//		BST_LL tree2 = new BST_LL();
//		tree2.insert(6);
//		tree2.insert(4);
//		tree2.insert(9);
//		tree2.insert(2);
//		tree2.insert(5);
//		tree2.insert(8);
//		tree2.insert(12);
//		BinaryNode tree2RootNode = tree2.root;



		;
//		System.out.println(BST_LL
//				.checkTreeEqual2(tree1.root, tree2.root));

		//Constructor
//		BinarySearchTreeByLinkedList tree = new BinarySearchTreeByLinkedList();
//		tree.insert(8);
//		tree.insert(5);
//		tree.insert(10);
//		tree.insert(9);
//		tree.insert(11);
//		tree.insert(4);
//		tree.insert(6);
//		BinaryNode tree1RootNode = tree.root;
//
//
//		List<Integer> treeTraversal = new LinkedList<>();
//		tree.serializeBinaryTree(tree1RootNode, treeTraversal);
//
//		BinaryNode tree2RootNode = tree.deserializeBinaryTree(treeTraversal);
//
//		List<Integer> treeTraversal2 = new LinkedList<>();
//		tree.serializeBinaryTree(tree2RootNode, treeTraversal2);
//
//		boolean equal = BinarySearchTreeByLinkedList.checkTreeEqual(tree1RootNode, tree2RootNode);
//
//		System.out.println(equal);
//
//		List<Integer> treeTraversal = new LinkedList<>();
//		tree.inTraverse(tree.root, treeTraversal);
//		System.out.println(treeTraversal);



//		tree.findPath(tree.root, 4);
//		tree.findPath(tree.root, 9);
//		System.out.println();
//		System.out.println("nodes invvoled : "+tree.visitedNodes);
//		System.out.println("steps : "+tree.steps);

//		tree.printTreeGraphically();
		
//		//Searching non-existing value in Tree
//		System.out.println("\n\nSearching for value on BST...");
//		tree.searchForValue(80);
//
//		//Searching existing value in Tree
//		System.out.println("\nSearching for value on BST...");
//		tree.searchForValue(60);
//
//
//		//Deleting Node from Tree
//		tree.deleteNodeOfBST(80); //Node does not exists
//		tree.printTreeGraphically();
		
		/*tree.deleteNodeOfBST(57); //Node is having 0 Child
		tree.printTreeGraphically();
		
		tree.deleteNodeOfBST(60); //Node is having 1 Child
		tree.printTreeGraphically();
		
		tree.deleteNodeOfBST(50); //Node is having 2 Child
		tree.printTreeGraphically();

		//Deleting entire Tree
		tree.deleteTree();
		
		//Traversing Tree
		tree.levelOrderTraversal();
*/
	}//end of method

}//end of class
