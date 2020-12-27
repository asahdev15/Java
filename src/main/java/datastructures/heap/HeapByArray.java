package datastructures.heap;

public class HeapByArray {

	int[] arr;
	int sizeOfTree;

	public HeapByArray(int size) {
		// We are adding 1 here so that first cell of the array can be left blank all the time.
		// This is to eliminate problem of array starting from index 0.
		arr = new int[size+1];
		this.sizeOfTree = 0;
	}

	public int sizeOfArray() {
		return arr.length;
	}
	
	public int sizeOfTree() {
		return sizeOfTree;
	}

	public boolean isHeapEmpty() {
		return sizeOfTree <= 0;
	}

	public void deleteheap() {
		arr = null;
	}

	public Integer peek() {
		if(sizeOfTree >= 0) {
			return arr[1];
		}
		return null;
	}

	public void levelOrder() {
		for (int i = 1; i <= sizeOfTree; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void insertInHeap(int value) {
		arr[sizeOfTree+1] = value;
		sizeOfTree++;
		heapifyBottomToTop(sizeOfTree);
	}

	public void heapifyBottomToTop(int index) {
		int parent = index / 2;
		// We are at root of the tree. Hence no more Heapifying is required.
		if (index <= 1) {
			return;
		}
		// If Current value is smaller than its parent, then we need to swap
		if (arr[index] < arr[parent]) {
			int tmp = arr[index];
			arr[index] = arr[parent];
			arr[parent] = tmp;
		}
		heapifyBottomToTop(parent);
	}


	//Extract Head of Heap
	public Integer extractHeadOfHeap() {
		if(sizeOfTree == 0) {
			return null;
		}
		int extractedValue = arr[1];
		arr[1] = arr[sizeOfTree];
		sizeOfTree--;
		heapifyTopToBottom(1);
		return extractedValue;
	}
	
	public void heapifyTopToBottom(int index) {
		int left  = index*2;
		int right = (index*2)+1;
		int smallestChild = 0;
		
		if (sizeOfTree < left) { //If there is no child of this node, then nothing to do. Just return.
			return; 
		}else if (sizeOfTree == left) { //If there is only left child of this node, then do a comparison and return.
			if(arr[index] > arr[left]) {
				int tmp = arr[index];
				arr[index] = arr[left];
				arr[left] = tmp;
			}
			return;
		}else { //If both children are there
			if(arr[left] < arr[right]) { //Find out the smallest child
				smallestChild = left;
			}else {
				smallestChild = right;
			}
			if(arr[index] > arr[smallestChild]) { //If Parent is greater than smallest child, then swap
				int tmp = arr[index];
				arr[index] = arr[smallestChild];
				arr[smallestChild] = tmp;
			}
		}
		heapifyTopToBottom(smallestChild);
	}



	public static void buildMaxHeap(int[] heapArray, int heapSize)
	{
		// swap largest child to parent node
		for (int i = (heapSize) / 2; i >= 0; i--){
			maxHeapify(heapArray, i, heapSize);
		}
	}

	private static void maxHeapify(int[] heapArray, int index, int heapSize){
		int largest = index;
		while (largest < heapSize / 2){      // check parent nodes only
			int left = (2 * index);       //left child
			int right = (2 * index) + 1;      //right child

			if (left < heapSize && heapArray[left] > heapArray[index]){
				largest = left;
			}
			if (right < heapSize && heapArray[right] > heapArray[largest]){
				largest = right;
			}
			if (largest != index){ // swap parent with largest child
				int temp = heapArray[index];
				heapArray[index] = heapArray[largest];
				heapArray[largest] = temp;
				index = largest;
			}
			else
				break; // if heap property is satisfied
		} //end of while
	}





	public static void buildMinHeap(int[] heapArray, int heapSize) {

		// swap smallest child to parent node
		for (int i = (heapSize) / 2; i >= 0; i--) {
			minHeapify(heapArray, i, heapSize);
		}
	}


	private static void minHeapify(int[] heapArray, int index, int heapSize) {
		int smallest = index;

		while (smallest < heapSize / 2) { // check parent nodes only
			int left = (2 * index); //left child
			int right = (2 * index) + 1; //right child

			if (left < heapSize && heapArray[left] < heapArray[index]) {
				smallest = left;
			}
			if (right < heapSize && heapArray[right] < heapArray[smallest]) {
				smallest = right;
			}

			if (smallest != index) { // swap parent with smallest child
				int temp = heapArray[index];
				heapArray[index] = heapArray[smallest];
				heapArray[smallest] = temp;
				index = smallest;
			} else {
				break; // if heap property is satisfied
			}

		} //end of while
	}

	public static int[] findKSmallest(int[] arr, int k)
	{
		int arraySize = arr.length;
		if(k <= arraySize)
		{
			int[] result = new int[k];
			for (int i = 0; i < k; i++)
			{
				buildMinHeap(arr, arraySize);
				result[i] = arr[1];
				arr[1] =  arr[--arraySize];
			}
			return result;
		}
		System.out.println("Value of k = " + k+ "out of bounds!");
		return arr;
	}

	public static int[] findKLargest(int[] arr, int k) {
		int arraySize = arr.length;
		if ( k <= arraySize) {
			int[] result = new int[k];	// build the result array of size = k
			for (int i = 0; i < k; i++) {
				buildMaxHeap(arr, arraySize);
				result[i] = arr[1];
				arr[1] = arr[--arraySize];
			}
			return result;
		}
		System.out.println("Value of k = " + k + "Out of Bounds");
		return arr;
	}




}