package lecture18;

public class ExampleHash {
	int x, y;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExampleHash other = (ExampleHash) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ExampleHash [x=" + x + ", y=" + y + "]";
	}
	public ExampleHash(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public static void main(String[] args) {
		String s = "a";
		int code = s.hashCode();
		System.out.println("code = "+code);
		Integer x = 1290;
		code  = x.hashCode();
		System.out.println("code = "+code);
		Double y = 1290.345;
		code  = y.hashCode();
		System.out.println("code = "+code);
		////////////
		ExampleHash obj = new ExampleHash(59, 85);
		code = obj.hashCode();
		System.out.println("code = "+code);
		
	}

}
