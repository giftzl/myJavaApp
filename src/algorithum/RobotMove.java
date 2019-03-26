package algorithum;

public class RobotMove {

	public static void main(String[] args) {
		
		String moves = "UDLRRR";
		
		boolean isCircle= judgeCircle(moves);
		
		System.out.println("Robot moves '"+ moves + (isCircle? "' in ":"' not in ")+"Circle");
	
	}
	
	public static boolean judgeCircle(String moves) {
		int v = 0;
		int h = 0;
		boolean isCircle=false;
		
		for(char c : moves.toCharArray()) {
			
			switch (c) {
			case 'U':
				v++;
				break;
			case 'D':
				v--;
				break;
			case 'L':
				h--;
				break;
			case 'R':
				h++;
				break;
			default:
				break;
			}
		}
		if(v==0 && h==0)
			isCircle = true; 
		
		return isCircle;
		
	}
	
}
