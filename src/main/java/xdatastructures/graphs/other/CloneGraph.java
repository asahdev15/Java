package xdatastructures.graphs.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        Node newNode = new Node(node.val);

        visited.put(newNode.val, newNode);

        for(Node n : node.neighbors){
            Node child = (visited.containsKey(n.val))? visited.get(n.val) : cloneGraph(n);
            newNode.neighbors.add(child);
        }

        return newNode;

    }
}

class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

}