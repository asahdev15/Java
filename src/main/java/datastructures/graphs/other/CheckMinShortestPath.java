package datastructures.graphs.other;

import datastructures.graphs.node.Graph;
import datastructures.lists.LinkedList;
import datastructures.queues.MyQueue;

class CheckMinShortestPath {

	public static int findMin(Graph g, int source, int destination) {

		int result = 0;
		int num_of_vertices = g.vertices;

		//Boolean Array to hold the history of visited nodes (by default-false)
		//Make a node visited whenever you enqueue it into queue
		boolean[] visited = new boolean[num_of_vertices];

		//For keeping track of distance of current_node from source
		int[] distance = new int[num_of_vertices];

		//Create Queue for Breadth First Traversal and enqueue source in it
		MyQueue queue = new MyQueue(num_of_vertices);

		queue.enqueue(source);
		visited[source] = true;

		//Traverse while queue is not empty
		while (!queue.isEmpty()) {
			//Dequeue a vertex/node from queue and add it to result
			int current_node = queue.dequeue();
			//Get adjacent vertices to the current_node from the array,
			//and if they are not already visited then enqueue them in the Queue
			//and also update their distance from source by adding 1 in current_nodes's distance
			LinkedList.Node temp = null;
			if (g.array[current_node] != null)
					temp = g.array[current_node].headNode;
			while (temp != null) {
				if (!visited[temp.data]) {
					queue.enqueue(temp.data);
					visited[temp.data] = true;
					distance[temp.data] = distance[current_node] + 1;
				}
				if (temp.data == destination){
				  return distance[destination];
				}
				temp = temp.next;
			}
		}//end of while
		return -1;
	}
  
  public static void main(String args[]) {
    
     Graph g=new Graph(6);
      g.addEdge(0,1);
	  g.addEdge(0,3);
      g.addEdge(0,2);
      g.addEdge(3,5);
      g.addEdge(5,4);
	  g.addEdge(2,4);
    System.out.println(findMin(g, 0, 4));
  }
}