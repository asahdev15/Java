package datastructures.lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LinkedList {


	public static void main(String args[]) {

		List<Character> list = new java.util.LinkedList<>();
		list.add(0,'a');
		list.add(0,'a');
		System.out.println(list);
	}


	private Node reverseList(Node head, int start, int end){
		int size = getSize(head);
		Node prevNode = getIndexedNode(head, start, size);
		Node startNode = getIndexedNode(head, start+1, size);
		Node endNodeNext = getIndexedNode(head, end+1, size);

		Node prev = prevNode;
		Node curr = startNode;
		Node temp = curr;
		int count = end-start;
		while( count > 0 ){
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			count--;
		}


		startNode.next = endNodeNext;
		if(prevNode!=null){
			prevNode.next = prev;
		}
		if(prevNode!=null){
			return head;
		}
		return curr;
	}

	private Node getIndexedNode(Node head, int i, int size){
		if(i<0 || i>=size){
			return null;
		}
		int count = 0 ;
		Node curr = head;
		while(curr!=null && count<i){
			curr = curr.next;
			count++;
		}
		return curr;
	}

	private int getSize(Node head){
		int size = 0 ;
		Node curr = head;
		while(curr!=null){
			curr = curr.next;
			size++;
		}
		return size;
	}






	public static boolean isEmpty(Node head) {
		return head == null;
	}

	public static Node insertAtHead(Node head, int value) {
		Node newNode = new Node();
		newNode.data = value;
		newNode.next = head;
		return newNode;
	}

	public static Node insertAtEnd(Node head, int value) {
		Node newNode = new Node();
		newNode.data = value;
		if (isEmpty(head)) {
			return newNode;
		}
		//Iterative to the last element
		Node lastNode = getLastNode(head);
		lastNode.next = newNode;
		return head;
	}

	public static Node insertAfter(Node head, int newValue, int searchValue) {
		Node temp = searchNode(head, searchValue);
		if(temp != null)
		{
			Node newNode = new Node();
			newNode.data = newValue;
			newNode.next = temp.next;
			temp.next = newNode;
		}
		return head;
	}

	public static Node getLastNode(Node head)
	{
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	public static Node searchNode(Node head, int value) {
		Node temp = head;
		while (temp != null && temp.data!=value) {
			temp = temp.next;
		}
		return temp;
	}

	public static Node deleteAtHead(Node head) {
		if (head != null) {
			head = head.next;
		}
		return head;
	}

	public static Node delete(Node head, int value) {
		if (isEmpty(head)) {
			return head;
		}
		Node previousNode = null;
		Node currentNode = head;
		if (currentNode.data == value) {
			return deleteAtHead(head);
		}
		while (currentNode != null) {
			if (value == currentNode.data) {
				previousNode.next = currentNode.next;
			}
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		return head;
	}

	public static int length(Node head) {
		int count = 0;
		Node current = head;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	private static void printlist(Node head){
		List<Integer> items = new java.util.LinkedList<>();
		Node curr = head;
		while(curr!=null){
			items.add(curr.data);
			curr = curr.next;
		}
		System.out.println("Items : " + items);
	}

	public static Node reverse(Node head) {
		Node prev = null; //To keep track of the previous element, will be used in swapping links
		Node current = head; //firstElement
		Node next = null;
		//While Traversing the list, swap links
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		//Linking Head Node with the new First Element
		return prev;
	}

	public static Node reverse(Node head, int p, int q) {
		if (p == q)
			return head;

		// after skipping 'p-1' nodes, current will point to 'p'th node
		Node current = head;
		Node previous = null;
		for (int i = 0; current != null && i < p - 1; ++i) {
			previous = current;
			current = current.next;
		}

		// we are interested in three parts of the LinkedList, part before index 'p', part between 'p' and 
		// 'q', and the part after index 'q'
		Node lastNodeOfFirstPart = previous; // points to the node at index 'p-1'
		// after reversing the LinkedList 'current' will become the last node of the sub-list
		Node lastNodeOfSubList = current;
		Node next = null; // will be used to temporarily store the next node
		// reverse nodes between 'p' and 'q'
		for (int i = 0; current != null && i < q - p + 1; i++) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		// connect with the first part
		if (lastNodeOfFirstPart != null)
			lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
		else // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
			head = previous;

		// connect with the last part
		lastNodeOfSubList.next = current;

		return head;
	}

	public static boolean detectLoopViaHashSet(Node head){
		//Used to store nodes which we already visited
		HashSet< Node > visitedNodes = new HashSet < Node > ();
		Node currentNode = head;
		//Traverse the list and put each node in a HashSet and if a node appears twice in the map
		//then it means there is a loop in the list
		while (currentNode != null) {
			if (visitedNodes.contains(currentNode))
				return true;
			visitedNodes.add(currentNode); //Insert a node in HashSet
			currentNode = currentNode.next;
		}
		return false;
	}

	public boolean detectLoopViaPointers(Node headNode){
		Node slowPtr = headNode;
		Node fastPtr = headNode;
		while (slowPtr != null && fastPtr != null && fastPtr.next != null)
		{
			slowPtr = slowPtr.next;       // traverse the list with jumps of 1 step at a time
			fastPtr = fastPtr.next.next;  // traversing the list with jumps of 2 steps
			if (slowPtr == fastPtr)       // Two pointers meet at a single node
				return true;
		}
		return false;
	}

	public static Node findCycleStart(Node head) {
		int cycleLength = findCycleLength(head);

		return findStart(head, cycleLength);
	}

	private static Node findStart(Node head, int cycleLength) {
		Node pointer1 = head, pointer2 = head;
		// move pointer2 ahead 'cycleLength' nodes
		while (cycleLength > 0) {
			pointer2 = pointer2.next;
			cycleLength--;
		}

		// increment both pointers until they meet at the start of the cycle
		while (pointer1 != pointer2) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}

		return pointer1;
	}

	public static int findCycleLength(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) // found the cycle
				return calculateLength(slow);
		}
		return 0;
	}

	private static int calculateLength(Node slow) {
		Node current = slow;
		int cycleLength = 0;
		do {
			current = current.next;
			cycleLength++;
		} while (current != slow);
		return cycleLength;
	}

	public static Node findMiddle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void removeDuplicates(Node head) {
		if (!isEmpty(head) && head.next != null) {
			Node prevNode = head;
			Node currentNode = head;
			HashSet < Integer > visitedNodes = new HashSet < Integer > ();
			//If List is not empty and there is more than 1 element in List
			while (currentNode != null) {
				Integer value = new Integer(currentNode.data);
				if (visitedNodes.contains(value)) {
					//currentNode is a duplicate as its value is already in the HashSet
					//so connect prevNode with currentNode's next element to remove it
					prevNode.next = currentNode.next;
					currentNode = currentNode.next;
				}else {
					visitedNodes.add(currentNode.data); //Visiting currentNode for first time
					prevNode = currentNode;
					currentNode = currentNode.next;
				}
			}
		}
	}

	public static Node find_nth_from_last(Node head, int n) {
		if (head == null || n < 1) {
			return null;
		}
		// We will use two pointers where both are 'n' nodes apart.
		Node pointer1 = head;
		Node pointer2 = head;
		while (pointer2 != null && n > 0) {
			pointer2 = pointer2.next;
			n--;
		}
		// Check out-of-bounds
		if (n != 0) {
			return null;
		}
		// When tail pointer reaches the end of
		// list, head is pointing at nth node.
		while (pointer2 != null) {
			pointer2 = pointer2.next;
			pointer1 = pointer1.next;
		}
		return pointer1;
	}

	public static Node swap_nth_nodeWithHEAD(Node head, int n) {
		if (head == null || n == 1) {
			return head;
		}
		Node prev = null;
		Node current = head;
		for (int count = 1; current != null && count < n; ++count) {
			prev = current;
			current = current.next;
		}
		if (current == null) {
			return head;
		}
		// current is pointing to nth node and Let's swap nth node with head.
		prev.next = head;
		Node temp = head.next;
		head.next = current.next;
		current.next = temp;
		return current;
	}

	//Returns List (in String) containing union of list1 and list2
	public static Node union(Node list1head, Node list2head) {
		//Return other List if one of them is empty
		if (isEmpty(list1head))
			return list2head;
		else if (isEmpty(list2head))
			return list1head;

		Node start = getLastNode(list1head);
		//Link last element of first list to the first element of second list
		start.next = list2head;
		//Remove duplicates
		removeDuplicates(list1head);
		return list1head;
	}

	//Returns List (in String) containing intersection of list1 and list2
	public static String intersection(LinkedList list1, LinkedList list2) {
		String result = "";
		//We use HashSet to store values of nodes which we already visited
		HashSet < Integer > visitedNodes = new HashSet < Integer > ();
		Node currentNode = list1.headNode;
		//Traversing list1 and adding all unique nodes in hash set
		while (currentNode != null) {
			Integer value = new Integer(currentNode.data);
			if (!visitedNodes.contains(value))
				visitedNodes.add(value); //Visiting currentNode for first time
			currentNode = currentNode.next;
		}
		Node start = list2.headNode;
		//Traversing list 2 and only adding those nodes in result which are already
		//present in hashset
		while (start != null) {
			Integer value = new Integer(start.data);
			if (visitedNodes.contains(value)) {
				result += start.data;
				result += "->";
			}
			start = start.next;
		}
		result += "null";
		return result;
	}

	public static Node intersectionNode(Node head1, Node head2) {

		Node list1node = null;
		Node list2node = null;

		int list1length = length(head1);
		int list2length = length(head2);

		int length_difference = 0;
		if(list1length >= list2length) {
			length_difference = list1length - list2length;
			list1node = head1;
			list2node = head2;
		} else {
			length_difference = list2length - list1length;
			list1node = head2;
			list2node = head1;
		}

		while(length_difference > 0) {
			list1node = list1node.next;
			length_difference--;
		}

		while(list1node != null) {
			if(list1node == list2node) {
				return list1node;
			}
			list1node = list1node.next;
			list2node = list2node.next;
		}
		return null;
	}

	public static Node insertion_sort(Node head) {
		Node sorted = null;
		Node curr = head;
		while (curr != null) {
			Node temp = curr.next;
			sorted = sorted_insert(sorted, curr);
			curr = temp;
		}
		return sorted;
	}

	private static Node sorted_insert(Node head, Node nodeToInsert) {
		if (nodeToInsert == null) {
			return head;
		}
		if (head == null || nodeToInsert.data <= head.data) {
			nodeToInsert.next = head;
			return nodeToInsert;
		}
		Node curr = head;
		while (curr.next != null && (curr.next.data < nodeToInsert.data)) {
			curr = curr.next;
		}
		nodeToInsert.next = curr.next;
		curr.next = nodeToInsert;
		return head;
	}

	public static Node merge_sorted(
			Node head1,
			Node head2) {

		// if both lists are empty then merged list is also empty
		// if one of the lists is empty then other is the merged list
		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}


		Node mergedHead = null;
		if (head1.data <= head2.data) {
			mergedHead = head1;
			head1 = head1.next;
		} else {
			mergedHead = head2;
			head2 = head2.next;
		}

		Node mergedTail = mergedHead;

		while (head1 != null && head2 != null) {
			Node temp = null;
			if (head1.data <= head2.data) {
				temp = head1;
				head1 = head1.next;
			} else {
				temp = head2;
				head2 = head2.next;
			}

			mergedTail.next = temp;
			mergedTail = temp;
		}

		if (head1 != null) {
			mergedTail.next = head1;
		} else if (head2 != null) {
			mergedTail.next = head2;
		}
		return mergedHead;
	}

	public static Node add_integers(Node integer1, Node integer2) {
		Node result = null;
		Node last = null;
		int carry = 0;
		while (integer1 != null || integer2 != null || carry > 0) {
			int first = (integer1 == null ? 0 : integer1.data);
			int second = (integer2 == null ? 0 : integer2.data);
			int sum = first + second + carry;

			Node pNew = new Node();
			pNew.data = sum % 10;
			carry = sum / 10;

			if (result == null) {
				result = pNew;
			} else {
				last.next = pNew;
			}
			last = pNew;

			if (integer1 != null) {
				integer1 = integer1.next;
			}
			if (integer2 != null) {
				integer2 = integer2.next;
			}
		}
		return result;
	}



	public static Node rotate_list(Node head, int n) {
		if (head == null || n == 0) {
			return head;
		}
		int len = length(head);
		// If n (number of rotations required) is bigger than length of linked list
		// or if n is negative then
		// we need to adjust total number of rotations needed
		n = adjust_rotations_needed(n, len);
		if (n == 0) {
			return head;
		}
		// Find the start of rotated list. If we have 1,2,3,4,5 where n = 2, then 4 is the start of rotated list.
		int rotations_count = len - n - 1;
		Node temp = head;
		while (rotations_count > 0) {
			temp = temp.next;
			rotations_count--;
		}
		// After the above loop temp will be pointing
		// to one node prior to rotation point
		Node new_head = temp.next;
		// Set new end of list.
		temp.next = null;
		// Iterate to the end of list and
		// link that to original head.
		temp = new_head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;
		return new_head;
	}

	private static int adjust_rotations_needed(int n, int len) {
		// If n is positive then number of rotations performed is from right side
		// and if n is negative then number of rotations performed from left side
		// Let's optimize the number of rotations.
		// Handle case if 'n' is a negative number.
		n = n % len;
		if (n < 0) {
			n = n + len;
		}
		return n;
	}


	public Node headNode;
	public static class Node {
		public int data;
		public Node next;
		public Node(){
		}
		public Node(int x){
			data = x;
		}
	}

}