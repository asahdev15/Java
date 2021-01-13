package xdatastructures.graphs.node;

import xdatastructures.lists.LinkedList;

public class Graph
{
	public int vertices;
    public LinkedList[] array;

    public Graph(int v)
    {
        //Total number of vertex
        vertices = v;
        //definining array with size equal to the number of vertices
        array = new LinkedList[vertices];
        //Creating new List for each vertex/index of array
        for (int i = 0; i < vertices; i++)
        {
            array[i] = null;
        }
    }
    //Function to add an Edge from source to destination
    public void addEdge(int source, int destination)
    {
        //As we are implementing a directed graph so (1,0) is not equal to (0,1)
        if(array[source]==null){
            array[source]=new LinkedList();
        }
        LinkedList.insertAtHead(array[source].headNode, destination);
        //If we were to implement an undirected graph i.e (1,0) == (0,1)
        //Then we will create an edge from destination towards source as well
        //i.e array[destination].insertAtHead(source);
    }

    public void printGraph()
    {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++)
        {
            if(array[i]!=null){
                System.out.print("|" + i + "| => ");

                LinkedList.Node temp = array[i].headNode;
                while (temp != null)
                {
                    System.out.print("[" + temp.data + "] -> ");
                    temp = temp.next;
                }
                System.out.println("null");
            }
            else{

                System.out.print("|" + i + "| => "+ "null");
            }
        }
    }

    public static void main(String args[])
    {
        Graph g=new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        g.printGraph();
    }
}