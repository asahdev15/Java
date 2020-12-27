package datastructures.graphs;

import datastructures.graphs.node.GraphNode;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {

		ArrayList<GraphNode> nodeList = new ArrayList<>();


		//create 10 nodes: v1-v10
		for(int i=1;i<11; i++) {
			nodeList.add(new GraphNode("V"+i));
		}

		TopologicalSort graph = new TopologicalSort(nodeList);

		//add edges following graph in graph.docx
		graph.addDirectedEdge(1,3);
		graph.addDirectedEdge(2,3);
		graph.addDirectedEdge(2,4);
		graph.addDirectedEdge(3,5);
		graph.addDirectedEdge(5,6);
		graph.addDirectedEdge(5,7);
		graph.addDirectedEdge(4,7);
		graph.addDirectedEdge(7,8);
		graph.addDirectedEdge(4,9);
		graph.addDirectedEdge(2,10);


		Stack<GraphNode> stack = graph.topologicalSort();
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getName()+" ");
		}

	}



	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	
	//Constructor
	public TopologicalSort(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	// add a directed edge between two nodes
	public void addDirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i - 1);
		GraphNode second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
	} // end of method


	public Stack<GraphNode> topologicalSort() {
		Stack<GraphNode> stack = new Stack<>();
		for (GraphNode node : nodeList) { // if a node is unvisited then run topologicalSort on it
			if (!node.isVisited())
				topologicalVisit(node, stack);
		}
		return stack;
	}

	
	// Topological visit by a source node
	private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		for (GraphNode neighbor : node.getNeighbors()){	//if neighbor is not visited then recursive call to it
			if(!neighbor.isVisited()){
				topologicalVisit(neighbor, stack);
			}
		}
		node.setVisited(true);
		stack.push(node);
	} // end of method

	

}//end of class