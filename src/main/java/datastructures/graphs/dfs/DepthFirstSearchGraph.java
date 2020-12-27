package datastructures.graphs.dfs;

import java.util.Stack;

public class DepthFirstSearchGraph {

    public static void main(String[] args) {
        DepthFirstSearchGraph g= new DepthFirstSearchGraph(6);
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
        g.dfsExplore(0);
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

    public DepthFirstSearchGraph(int size) {
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

    public void dfsExplore(int startVertex) {
        Boolean[] visited = new Boolean[size];
        for (int i = 0; i < size; i++) {
            visited[i] = false;
        }
        Stack<Integer> st = new Stack<Integer>();
        st.push(startVertex);
        while (!st.isEmpty()) {
            int n = st.pop();
            st.push(n);
            visited[n] = true;
            Node head = array[n].head;
            Boolean isDone = true;
            while (head != null) {
                if (visited[head.value] == false) {
                    st.push(head.value);
                    visited[head.value] = true;
                    isDone = false;
                    break;
                } else {
                    head = head.next;
                }
            }
            if (isDone == true) {
                int out = st.pop();
                System.out.println("Visited node: " + out);
            }
        }
    }
}
