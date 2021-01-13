package xdatastructures.graphs.other;

import xdatastructures.graphs.node.Graph;
import xdatastructures.lists.LinkedList;

class CheckNumEdges {

  public static int numEdges(Graph g) {

    // For undirected graph, just sum up the size of 
    // all the adjacency lists for each vertex and then divide it by 2.
    // It will give us total number of edges in the graph.
    int sum = 0;

    for (int i = 0; i < g.vertices; i++) {

      LinkedList.Node temp = null;
      if (g.array[i] != null)
          temp = g.array[i].headNode;

      while (temp != null) {
        sum++;
        temp = temp.next;
      }
    }
    return sum/2;
  }

  public static void main(String args[]) {

    Graph g = new Graph(9);
    g.addEdge(0,2);
    g.addEdge(0,5);
    g.addEdge(2,3);
    g.addEdge(2,4);
    g.addEdge(5,3);
    g.addEdge(5,6);
    g.addEdge(3,6);
    g.addEdge(6,7);
    g.addEdge(6,8);
    g.addEdge(6,4);
    g.addEdge(7,8);
    
    // making an undirected graph
    g.addEdge(2,0);
    g.addEdge(5,0);
    g.addEdge(3,2); 
    g.addEdge(4,2); 
    g.addEdge(3,5); 
    g.addEdge(6,5); 
    g.addEdge(6,3);
    g.addEdge(7,6); 
    g.addEdge(8,6); 
    g.addEdge(4,6); 
    g.addEdge(8,7); 
    g.printGraph();
    System.out.println("Number of edges: " + numEdges(g));
    System.out.println();

    Graph g2 = new Graph(7);
    g2.addEdge(1,2);
    g2.addEdge(1,3);
    g2.addEdge(3,4);
    g2.addEdge(3,5);
    g2.addEdge(2,5);
    g2.addEdge(2,4);
    g2.addEdge(4,6);
    g2.addEdge(4,5);
    g2.addEdge(6,5);
    
    // making an undirected graph
    g2.addEdge(2,1);
    g2.addEdge(3,1);
    g2.addEdge(4,3);
    g2.addEdge(5,3);
    g2.addEdge(5,2);
    g2.addEdge(4,2);
    g2.addEdge(6,4);
    g2.addEdge(5,4);
    g2.addEdge(5,6);

    g2.printGraph();
    System.out.println("Number of edges: " + numEdges(g2));
  }
}