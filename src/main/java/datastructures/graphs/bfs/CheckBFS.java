package datastructures.graphs.bfs;

import datastructures.graphs.node.Graph;
import datastructures.lists.LinkedList;
import datastructures.queues.MyQueue;

//Create Queue => myQueue queue = new myQueue(5) ; where 5 is size of queue
//Functions of Queue => queue.enqueue(int) , queue.dequeue(), size(), peek() , isEmpty()
//class Graph => {int vertices, linkedList[] array}
//class linkedList => {Node headNode}
//class Node => {int data, Node nextElement}
class CheckBFS {

  //Breadth First Traversal of Graph g from source vertex
  public static String bfsTraversal(Graph g, int source) {

    String result = "";
    int num_of_vertices = g.vertices;

    //Boolean Array to hold the history of visited nodes (by default-false)
    //Make a node visited whenever you enqueue it into queue
    boolean[] visited = new boolean[num_of_vertices];

    //Create Queue(Implemented in previous lesson) for Breadth First Traversal and enqueue source in it
    MyQueue queue = new MyQueue(num_of_vertices);

    queue.enqueue(source);
    visited[source] = true;

    //Traverse while queue is not empty
    while (!queue.isEmpty()) {

      //Dequeue a vertex/node from queue and add it to result
      int current_node = queue.dequeue();

      result += String.valueOf(current_node);

      //Get adjacent vertices to the current_node from the array,
      //and if they are not already visited then enqueue them in the Queue
      LinkedList.Node temp = null;
      if(g.array[current_node] != null)
        temp = g.array[current_node].headNode;

      while (temp != null) {

        if (!visited[temp.data]) {
          queue.enqueue(temp.data);
          visited[temp.data] = true; //Visit the current Node
        }
        temp = temp.next;
      }
    }//end of while
    return result;
  }

  public static void main(String args[]) {
    Graph g = new Graph(5);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,3);
    g.addEdge(1,4);


    System.out.println(bfsTraversal(g, 0));
  }
}