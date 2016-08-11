package test;

import structure.Queue;

public class TestQueue {
		
	public static void main(String []args){
		Queue<String> queue = new Queue<String>();
		queue.enqueue("11301081");
		queue.enqueue("11301078");
		queue.enqueue("11301069");
		
		for(String x :queue){
			System.out.println(x);
		}
		
		queue.dequeue();
		for(String x :queue){
			System.out.println(x);
		}
	}
}