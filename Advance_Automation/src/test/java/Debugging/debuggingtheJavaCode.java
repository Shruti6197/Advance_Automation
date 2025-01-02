package Debugging;

public class debuggingtheJavaCode {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println("Before Swapping the values");
		System.out.println("A:"+a);
		System.out.println("B:"+b);
		
		int temp;
		temp = a;
		a = b;
		b = temp;
		
		System.out.println("After Swapping the values");
		System.out.println("A:"+a);
		System.out.println("B:"+b);

	}

}
