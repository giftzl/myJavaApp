package algorithum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DsfCycleSolution {


	private static int MAX_NODE_COUNT = 4;

	private static List<String> nodes = new ArrayList<String>();

	private static int[][] adjacencyMatrix = new int[MAX_NODE_COUNT][MAX_NODE_COUNT];


	private static int addNode(String nodeName) {
		if (!nodes.contains(nodeName)) {
			if (nodes.size() >= MAX_NODE_COUNT) {
				System.out.println("nodes exceed length limit:" + nodeName);
				return -1;
			}
			nodes.add(nodeName);
			return nodes.size() - 1;
		}
		return nodes.indexOf(nodeName);
	}


	public static void addLine(String startNode, String endNode) {
		int startIndex = addNode(startNode);
		int endIndex = addNode(endNode);
		if (startIndex >= 0 && endIndex >= 0) {
			adjacencyMatrix[startIndex][endIndex] = 1;
		}
	}

	public static List<String> find() {
	
		List<Integer> trace = new ArrayList<Integer>();
	
		List<String> rs = new ArrayList<>();
		
		if (adjacencyMatrix.length > 0) {
			findCycle(0, trace, rs);
		}
		if (rs.size() == 0) {
			rs.add("no cycle!");
		}
		return rs;
	}


	private static void findCycle(int v, List<Integer> trace, List<String> rs) {
		int j;
	
		if ((j = trace.indexOf(v)) != -1) {
			StringBuffer sb = new StringBuffer();
			String startNode = nodes.get(trace.get(j));
			while (j < trace.size()) {
				sb.append(nodes.get(trace.get(j)) + "-");
				j++;
			}
			rs.add("cycle:" + sb.toString() + startNode);
			return;
		}
		trace.add(v);
		for (int i = 0; i < nodes.size(); i++) {
			if (adjacencyMatrix[v][i] == 1) {
				findCycle(i, trace, rs);
			}
		}
		trace.remove(trace.size() - 1);
	}

	
	public static void main(String[] args) {
		DsfCycleSolution.addLine("A", "B");
		DsfCycleSolution.addLine("A", "C");
		DsfCycleSolution.addLine("B", "D");
		DsfCycleSolution.addLine("D", "A");
		
		for(int i= 0; i< adjacencyMatrix.length; i++) {
			System.out.println(Arrays.toString(adjacencyMatrix[i]));
		}
		
		List<String> reslut = DsfCycleSolution.find();
		for (String string : reslut) {
			System.out.println(string);
		}
	}
}
