package xdatastructures.graphs.other;

import xdatastructures.graphs.node.Graph;
import xdatastructures.lists.LinkedList;

//Create Stack => myStack stack = new myStack(5) ; where 5 is size of stack
//Functions of Stack => stack.push(int),stack.pop(),top(),isEmpty() 
//class graph => {int vertices, linkedList[] array}
//class linkedList => {Node headNode}
//class Node => {int data, Node nextElement}
class CheckCycle {
  public static boolean detectCycle(Graph g){
    int num_of_vertices = g.vertices;

    //Boolean Array to hold the history of visited nodes (by default-false)
    boolean[] visited = new boolean [num_of_vertices];
    //Holds a flag if the node is currently in Stack or not (by default- false)
    boolean[] stackFlag = new boolean[num_of_vertices];
  
    for (int i = 0; i < num_of_vertices; i++){
      //Check cyclic on each node 
      if (cyclic(g, i, visited, stackFlag)){
        return true;
      }
    }
    return false;
  }
  public static boolean cyclic(Graph g, int v, boolean[] visited, boolean[] stackFlag){
    //if node is currently in stack that means we have found a cycle
    if (stackFlag[v])
      return true;

    //if it is already visited (and not in Stack) then there is no cycle
    if (visited[v])
      return false;

    visited[v] = true;
    stackFlag[v] = true;

    // check adjacency list of the node
    LinkedList.Node temp = null;
    if (g.array[v] != null)
          temp = g.array[v].headNode;

    while (temp != null) {
      //run cyclic function recursively on each outgowing path
      if(cyclic(g, temp.data, visited, stackFlag)){
        return true;
      }
      temp = temp.next;
    }
    stackFlag[v] = false;
    
    return false;    
  }
  
  public static void main(String args[]) {
   
    Graph g1 = new Graph(4);
    g1.addEdge(0,1);
    g1.addEdge(1,2);
    g1.addEdge(1,3);
    g1.addEdge(3,0);
    g1.printGraph();
    System.out.println(detectCycle(g1));

    System.out.println();
    Graph g2 = new Graph(3);
    g2.addEdge(0,1);
    g2.addEdge(1,2);
    g2.printGraph();
    System.out.println(detectCycle(g2));
  }
}