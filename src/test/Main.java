package test;
import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner cin = new Scanner(System.in);
		int n = Integer.parseInt(cin.nextLine());
			if(n >= 3){
				//int result = 1 + n*(n-1)/2 + n*(n-1)*(n-2)*(n-3)/24 - n;
				int result = (int) (Math.pow(2, n-1) - n);
				System.out.println(result);
			}else{
				System.out.println(0);
			}
	}
}
