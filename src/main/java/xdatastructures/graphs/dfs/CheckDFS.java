package xdatastructures.graphs.dfs;

import xdatastructures.graphs.node.Graph;
import xdatastructures.lists.LinkedList;
import xdatastructures.stacks.MyStack;

//Create Stack => myStack stack = new myStack(5) ; where 5 is size of stack
//Functions of Stack => stack.push(int),stack.pop(),top(),isEmpty() 
//class Graph => {int vertices, linkedList[] array}
//class linkedList => {Node headNode}
//class Node => {int data, Node nextElement}
class CheckDFS {

  //Depth First Traversal of Graph g from source vertex  
  public static String dfsTraversal(Graph g, int source) {

    String result = "";
    int num_of_vertices = g.vertices;

    //Boolean Array to hold the history of visited nodes (by default-false)
    //Make a node visited whenever you push it into stack
    boolean[] visited = new boolean[num_of_vertices];

    //Create Stack(Implemented in previous lesson) for Depth First Traversal and Push source in it
    MyStack stack = new MyStack(num_of_vertices);

    stack.push(source);
    visited[source] = true;

    //Traverse while stack is not empty
    while (!stack.isEmpty()) {

      //Pop a vertex/node from stack and add it to the result
      int current_node = stack.pop();
      result += String.valueOf(current_node);

      //Get adjacent vertices to the current_node from the array,
      //and if they are not already visited then push them in the stack
      LinkedList.Node temp = null;
      if(g.array[current_node] !=null)
          temp = g.array[current_node].headNode;

      while (temp != null) {

        if (!visited[temp.data]) {
          stack.push(temp.data);
          //Visit the node
          visited[current_node] = true;

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

    System.out.println(dfsTraversal(g, 0));
  }
}