package xdatastructures.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchGraph {

    public static void main(String[] args) {
        BreadthFirstSearchGraph g= new BreadthFirstSearchGraph(6);
        g.add(0, 2);
        g.add(0, 1);
        g.add(1, 4);
        g.add(1, 3);
        g.add(1, 0);
        g.add(3, 1);
        g.add(4, 1);
        g.add(2, 5);
        g.add(2, 0);
        g.add(5, 2);
        g.BFSExplore(0);
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private class AdjList {
        Node head;
    }


    int size;
    AdjList[] array;

    public BreadthFirstSearchGraph(int size) {
        this.size = size;
        array = new AdjList[this.size];
        for (int i = 0; i < size; i++) {
            array[i] = new AdjList();
        }
    }

    public void add(int src, int dest) {
        Node n = new Node(dest);
        n.next = array[src].head;
        array[src].head = n;
    }

    public void BFSExplore(int StartVertex) {
        Boolean[] visited = new Boolean[size];
        for (int i = 0; i < size; i++)
            visited[i] = false;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(StartVertex);
        while (!q.isEmpty()) {
            int n = q.poll();
            System.out.println("Visted node: " + n);
            visited[n] = true;
            Node head = array[n].head;
            while (head != null) {
                if (visited[head.value] == false) {
                    q.add(head.value);
                    visited[head.value] = true;
                } else {
                    head = head.next;
                }
            }

        }
    }
}
