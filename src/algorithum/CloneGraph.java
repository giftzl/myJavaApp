package algorithum;

import java.util.HashMap;

import util.UndirectedGraphNode;

public class CloneGraph {
	
	public static void main(String[] args) {
		
	}
	
	

	private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		return clone(node);
		
	}

	private UndirectedGraphNode clone(UndirectedGraphNode node) {
		//TODO: clone graph algorithm!!!
		if (node == null)
			return null;

		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(clone.label, clone);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			clone.neighbors.add(clone(neighbor));
		}
		return clone;
	}
}
