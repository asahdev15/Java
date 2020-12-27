package datastructures.graphs.other;

import datastructures.graphs.node.Graph;
import datastructures.lists.LinkedList;

import java.util.Arrays;

class CheckMotherVertex {

  public static int findMotherVertex(Graph g) {
    // visited[] is used for DFS. Initially all are 
    // initialized as not visited
    boolean[] visited = new boolean[g.vertices];
    Arrays.fill(visited, false);

    // To store last finished vertex (or mother vertex)
    int lastV = 0;

    // Do a DFS traversal and find the last finished vertex
    for (int i = 0; i < g.vertices; i++) {
      if (visited[i] == false) {
        visited = DFS(g, i, visited);
        lastV = i;
      }
    }

    // If there exist mother vertex (or vetices) in given 
    // graph, then lastV must be one (or one of them) 

    // Now check if lastV is actually a mother vertex (or graph 
    // has a mother vertex). We basically check if every vertex 
    // is reachable from lastV or not. 

    // Reset all values in visited[] as false and do 
    // DFS beginning from lastV to check if all vertices are 
    // reachable from it or not. 
    Arrays.fill(visited, false);
    boolean[] visitedNew = DFS(g, lastV, visited);

    for (int i = 0; i < visitedNew.length; i++){
      if(visitedNew[i] == false){
        return -1;
      }
    }

    return lastV;
  }

  // A recursive function to print DFS starting from v
  public static boolean[] DFS(Graph g, int node, boolean[] visited) {

    visited[node] = true;
    LinkedList.Node temp = null;
    if (g.array[node] !=null)
        temp = g.array[node].headNode;

    while(temp != null){
      if(visited[temp.data]){
        temp = temp.next;
      }
      else{
        visited[temp.data] = true;
        visited = DFS(g, temp.data, visited);
        temp = temp.next;
      }
    }
    return visited;
  }
  
  public static void main(String args[]) {
    Graph g = new Graph(4);
    g.addEdge(0,1);
    g.addEdge(1,2);
    g.addEdge(3,0);
    g.addEdge(3,1);
    g.printGraph();
    System.out.println("Mother Vertex is: " + findMotherVertex(g));
    
  }
  
}