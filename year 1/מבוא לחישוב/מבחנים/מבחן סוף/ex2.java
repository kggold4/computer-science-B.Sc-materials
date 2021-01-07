/**
 * 
 * final test b
 * @author kfir goldfarb, id: 208980359
 * 
 */

import java.util.Arrays;

public class ex2 {
		
	//question 1:	
	public static int Binary2Dec(String  S) {

		//if the string is empty
		if(S.equals("")) {
			System.out.println("invalid input");
			return -1;
		}

		//if the string is invalid input
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) != '0' && S.charAt(i) != '1') {
				System.out.println("invalid input");
				return -1;
			}
		}

		//if the string is valid
		//calculate binary string to decimal
		double n = 0;
		for(int i = 0;i < S.length(); i++) {
			if(S.charAt(i) == '1') {
				n = n + Math.pow(2, S.length() - 1 - i);
			}
		}

		//return desimal
		return (int)n;
	}

	//question 2:
	public static int[][] rgb2gray(int[][][] imRGB){
			
			//create matrix of the grey image
			int[][] greyImage = new int[imRGB[0].length][imRGB[0][0].length];
			
			//calculate colors to gray
			for (int j = 0; j < imRGB[0][0].length; j++) {
				for (int i = 0; i < imRGB[0].length; i++) {
					greyImage[i][j] = (int)(((0.3 * imRGB[0][i][j]) + (0.59 * imRGB[1][i][j]) + (0.11 * imRGB[2][i][j])) * 255);
				}
			}
			
			//return the gray colors in matrix
			return greyImage;
		
	}

	//question 3:
	public static int[] interlace(int[]a, int b[]) {
		
		//the new array
		int[] c = new int[a.length + b.length];

		//on boolean is for navigate from i in a and i in b
		boolean on = true;

		//indexs of a and b arrays
		int indexA = 0, indexB = 0;

		//in case and |a| > |b|
		if(a.length > b.length) {
			for(int i = 0; i < c.length; i++) {

				//taking a numbers
				if(on) {
					c[i] = a[indexA];
					indexA++;
					if(indexB != b.length) on = false;

				//taking b numbers
				} else {
					if(indexB == b.length) break;
					c[i] = b[indexB];
					indexB++;
					on = true;
				}
			}
		
		//in case and |b| > |a|
		} else if(b.length > a.length) {
			for(int i = 0; i < c.length; i++) {

				//taking a numbers
				if(on) {
					if(indexA == a.length) break;
					c[i] = a[indexA];
					indexA++;
					on = false;

				//taking b numbers
				} else {
					if(indexA != a.length) on = true;;
					c[i] = b[indexB];
					indexB++;
				}
			}

		//in case and |a| = |b|
		} else {
			for(int i = 0; i < c.length; i++) {

				//taking a numbers
				if(on) {
					c[i] = a[indexA];
					indexA++;
					on = false;

				//taking b numbers
				} else {
					c[i] = b[indexB];
					indexB++;
					on = true;
				}
			}
		}

		//return the new array
		return c;

	}

	//question 4:
	public static void Psort(Point[] p) {

		//create middle point for calculate distance with other points
		Point m = new Point();
		
		//using bubble sort
		for(int i = 0; i < p.length; i++) {
			for(int j = 0; j < p.length - 1; j++) {
				if(p[j].distance(m) > p[j + 1].distance(m)) {

					//swap
					Point temp = p[j];
					p[j] = p[j + 1];
					p[j + 1] = temp;
				}
			}
		}
	}
		
	//main function
	public static void main(String[] args) {

		// question 1:
		String S = "001100";
		int sum = Binary2Dec(S);
		System.out.println("sum = " + sum);//output 12
	
		//question 2:
		int [][][] im=MyImageIO.readImageFromFile("cat.jpeg");
		int[][] gray= rgb2gray(im);
		MyImageIO.writeImageToFile("catGray.jpg",gray);
		
		//question 3
		int[] a1 = {1,-8,5};
		int[] b1 = {2,6,4};
		System.out.println(Arrays.toString(interlace(a1,b1)));

		int[] a2 = {1,3,5,7,8,9};
		int[] b2 = {2,4,6};
		System.out.println(Arrays.toString(interlace(a2,b2)));

		int[] a3 = {2,4,6};
		int[] b3 = {1,3,5,7,8,9};
		System.out.println(Arrays.toString(interlace(a3,b3)));
		
		//question 4
		Point p1 = new Point();
		Point p2 = new Point(1,2);
		Point p3 = new Point(1,54);
		Point p4 = new Point(7.5,8);
		Point[] p = {p4,p3,p2,p1};
		System.out.println(Arrays.toString(p)); //before sorting
		Psort(p);
		System.out.println(Arrays.toString(p)); //after sorting
		
	}
}