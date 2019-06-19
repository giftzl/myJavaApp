package algorithum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphLoopSolution {
	
	private List<GraphNode> nodes = null;
	

	/**
	 * BFSearch
	 * @param node 
	 * 			entry node
	 * 			
	 */
	public List<GraphNode> searchTraversing(GraphNode node) {
		List<GraphNode> visited = new ArrayList<GraphNode>(); 
		Queue<GraphNode> q = new LinkedList<GraphNode>(); 
		Set<Integer> loopSet = new HashSet<>();
		q.offer(node);
		
		while (!q.isEmpty()) {
			GraphNode currNode = q.poll();
			if (!visited.contains(currNode)) {
				visited.add(currNode);
				loopSet.add(currNode.getLabel());
				System.out.println("Node:" + currNode.getLabel());
				for (int i = 0; i < currNode.edgeList.size(); i++) {
					q.offer(currNode.edgeList.get(i).getNodeRight());
				}
			}
		}
		return visited;
	}
	
	public void initGraph(int n) {
		if (nodes == null) {
			nodes = new ArrayList<GraphNode>();
		}
		
		GraphNode node = null;
		for (int i = 0; i < n; i++) {
			node = new GraphNode(i);
			nodes.add(node);
		}
	}
	
	public GraphNode genGraph(int n) {
		initGraph(n);
		GraphEdge edge01 = new GraphEdge(nodes.get(0), nodes.get(1));
		GraphEdge edge02 = new GraphEdge(nodes.get(0), nodes.get(2));
		GraphEdge edge13 = new GraphEdge(nodes.get(1), nodes.get(3));
		GraphEdge edge14 = new GraphEdge(nodes.get(1), nodes.get(4));
		GraphEdge edge25 = new GraphEdge(nodes.get(2), nodes.get(5));
		GraphEdge edge26 = new GraphEdge(nodes.get(2), nodes.get(6));
		GraphEdge edge37 = new GraphEdge(nodes.get(3), nodes.get(7));
		GraphEdge edge47 = new GraphEdge(nodes.get(4), nodes.get(7));
		GraphEdge edge56 = new GraphEdge(nodes.get(5), nodes.get(6));
		
		
		nodes.get(0).addEdgeList(edge01);
		nodes.get(0).addEdgeList(edge02);
		nodes.get(1).addEdgeList(edge13);
		nodes.get(1).addEdgeList(edge14);
		nodes.get(2).addEdgeList(edge25);
		nodes.get(2).addEdgeList(edge26);
		nodes.get(3).addEdgeList(edge37);
		nodes.get(4).addEdgeList(edge47);
		nodes.get(5).addEdgeList(edge56);
		
		return nodes.get(0);
	}
	
	public List<GraphNode> getGraphNodes() {
		return nodes;
	}
	
	public static void main(String[] args) {
		GraphLoopSolution solution = new GraphLoopSolution();
		GraphNode node = solution.genGraph(8);
		solution.searchTraversing(node);
	}
}

class GraphNode {
	public List<GraphEdge> edgeList = null;
	private int label ;

	public GraphNode(int label) {
		this.label = label;
		if (edgeList == null) {
			edgeList = new ArrayList<GraphEdge>();
		}
	}

	public void addEdgeList(GraphEdge edge) {
		edgeList.add(edge);
	}

	public int getLabel() {
		return label;
	}
}

class GraphEdge {
	
	private GraphNode nodeLeft;
	private GraphNode nodeRight;

	/** 
	 * @param nodeLeft  left point of the edge
	 * @param nodeRight right point of the edge
	 *  
	 */
	public GraphEdge(GraphNode nodeLeft, GraphNode nodeRight) {
		this.nodeLeft = nodeLeft;
		this.nodeRight = nodeRight;
	}

	public GraphNode getNodeLeft() {
		return nodeLeft;
	}

	public GraphNode getNodeRight() {
		return nodeRight;
	}

}


