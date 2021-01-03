
public class FirstBoolean {

	public static void main(String[] args) {
		int x = 3, y = 4;
		boolean b = x<=y;
		System.out.println("b = "+b);
		b = x>y;
		System.out.println("b = "+b);
		int a = 3, d = 4, c = 5;
		b = (a+d>c)&&(a+c>d)&&(d+c>a);
		System.out.println("b = "+b);
		c = 1;
		b = (a+d>c) && (a+c>d) && (d+c>a);
		System.out.println("b = "+b);
		b = true;
		boolean u = !b;
		System.out.println("b = "+b+", u = "+u);
		b = !b;
		System.out.println("b = "+b);
	}

}
