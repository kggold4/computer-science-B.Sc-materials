package divideChocolate;

public class DivideChocolate {
	
	public static int divideChocolate(int n){
		if (n==2) return 1;			
		if (n==1) return 0;	
		
		int k = (int)(Math.random()*(n-1)) + 1;
		//System.out.println("k = " + k);
		int a = divideChocolate(k);
		int b = divideChocolate(n-k);
		
		return k*(n-k)+a+b;
	}

	public static void main(String[] args) {
		for (int i=2; i<=20; i++){
			System.out.println("p("+i+") = "+ divideChocolate(i));
		}
	}

}
