package algorithum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MutualFriendsSolution {
	
	public static void main(String[] args) {
		
		MutualFriendsSolution solution = new MutualFriendsSolution();
	
		
		String[] neighbors = {
				"1,John",
				"2,Frank",
				"3,Nolan",
				"4,Monica",
				"6,Vera"
				};
		
		String[] friendshipsInput = {
				"1,2",
				"1,3",
				"2,4"
				};
		
		solution.printOutFriendship(neighbors, friendshipsInput);
		
	}
	
	
	public void printOutFriendship(String[] neighbors, String[] friendship) {
		
		Map<Integer, String> neighborMap = new HashMap<Integer, String>();
		Map<Integer, Set<Integer>> friendsMap = new HashMap<Integer, Set<Integer>>();
		
		
		//construct neighbor map
		for (String nb : neighbors) {
			String[] nbs = nb.split("\\,");
			if(nbs.length >=1) {
				neighborMap.put(Integer.parseInt(nbs[0]), nbs[1]);
			}
		}
		
		//construct friendship map
		for (String fs : friendship) {
			
			String[] fds = fs.split("\\,");
			if(fds.length >=1) {
				Set<Integer> friendSet = friendsMap.get(Integer.parseInt(fds[0]));
				if(friendSet == null) {
					friendSet = new HashSet<Integer>();
				}
				friendSet.add(Integer.parseInt(fds[1]));
				friendsMap.put(Integer.parseInt(fds[0]), friendSet);
				
				friendSet = friendsMap.get(Integer.parseInt(fds[1]));
				if(friendSet == null) {
					friendSet = new HashSet<Integer>();
				}
				friendSet.add(Integer.parseInt(fds[0]));
				friendsMap.put(Integer.parseInt(fds[1]), friendSet);
			}
		}
	
		// traverse to formulate the friendship and neighborhood.
		for (Integer neighbor : neighborMap.keySet()) {
			System.out.print("# "+neighbor+": ");
			Set<Integer> friendSet = friendsMap.get(neighbor);
			if (friendSet == null || friendSet.isEmpty()) {
				System.out.println("NONE");
			}else {
				Integer[] fids = friendSet.toArray(new Integer[friendSet.size()]);
				int i=0;
				for(; i<fids.length-1; i++) {
					System.out.print(fids[i]+",");
				}
				System.out.println(fids[i]);
			}
		}
	}
}
