package test;

import edu.princeton.cs.algs4.Stopwatch;
import structure.StackArray;

public class TestStack {
		
	public static void main(String []args){
		StackArray<String> stack = new StackArray<String>();
		Stopwatch timer = new Stopwatch();
		stack.push("11301081");
		stack.push("11301082");
		stack.push("11301083");
		stack.push("11301084");
		stack.pop();
		for(String x:stack){
			System.out.println(x+" "+timer.elapsedTime());
			
		}
		
	}
}