
public class FirstExchange {

	public static void main(String[] args) {
		int x = 3, y = 4;
		//swap x<->
		System.out.println("before x = "+x+", y = "+y);
		int t = x;
		x = y;
		y = t;
		System.out.println("after x = "+x+", y = "+y);
	}

}
