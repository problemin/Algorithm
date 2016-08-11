package test;

import java.util.Scanner;

public class TestScanner {
	public static void main(String []args){
		Scanner s = new Scanner(System.in);
		 System.out.println("ÇëÊäÈë×Ö·û´®£º"); 
		 String str = s.nextLine(); 
		 if(hasJoker(str)){
			 System.out.println("ERROR");
			 System.exit(-1);
		 }
		 
		 
	}
	
	public static boolean hasJoker(String str){
			return str.contains("joker")||str.contains("JOKER");
	}
	
	public static int[] transfer(String str){
		int [] v = new int[4];
		String [] arr = str.split(" ");
		for(int i = 0 ; i < 4; i++){
			switch(arr[i]){
			case "J": arr[i] = "11";
			case "Q": arr[i] = "12";
			case "K": arr[i] = "13";
			case "A": arr[i] = "1";
			}
			v[i] = Integer.parseInt(arr[i]);
		}
		return v;
	}
	public static String caculate(int[] v){
		
		
		return null;
	}
}
