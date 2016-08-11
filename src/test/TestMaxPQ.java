package test;

import edu.princeton.cs.algs4.Stopwatch;
import structure.MaxPQ;
import structure.MaxPQHeap;
import structure.StackArray;

public class TestMaxPQ {
		
	public static void main(String []args){
		Integer a[] = {5,234,16,228,131,524,21122,312312,1231,1233,4112323,6,7121233,8,2,1234,1236,7};
		/*
		MaxPQ mp = new MaxPQ(a);
		for(int i = 0; i < a.length; i++){
			System.out.println(mp.delMax());
		}*/
		MaxPQHeap<Integer> mp = new MaxPQHeap<Integer>(10);
		for(int i = 0; i < a.length; i++){
			mp.insert(a[i]);
		}
		
	 
		for(int i = 1; i < mp.size(); i++){
			System.out.println(mp.delMax());
		}
		
	}
}