package test;

import structure.IndexMaxPQ;

public class TestIndexMaxPQ {
		
	public static void main(String []args){
		Integer a[] = {2,7,4,6,5,9,4,51,48,62,98,75,65,21};
		 
		IndexMaxPQ<Integer> mp = new IndexMaxPQ<Integer>(10);
		for(int i = 0; i < a.length; i++){
			mp.insert(i+1,a[i]);
		}
		for(int i = 0; i < a.length; i++){
		System.out.print(mp.delMax()+"--");
	}
		System.out.println("");
		for(int i = 0; i < a.length; i++){
			mp.insert(i+1,a[i]);
		}
		mp.change(1, 78);
		for(int i = 0; i < a.length; i++){
			System.out.print(mp.delMax()+"--");
		}
	 
	}
}