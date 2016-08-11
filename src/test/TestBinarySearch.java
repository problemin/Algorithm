package test;

import java.util.Iterator;
import java.util.Random;

import structure.BinarySearchST;
import structure.Queue;

public class TestBinarySearch {
		
	public static void main(String []args){
		BinarySearchST bst = new BinarySearchST<Integer, String>(60);
		Random rd = new Random();
		for(int i = 0; i < 50; i++){
			int key = rd.nextInt(70);
			String val = "val"+i;
			bst.put(key, val);
		}
		
		Queue<Integer> q = (Queue<Integer>) bst.keys();
		Iterator it =q.iterator();
		while(it.hasNext()){
			System.out.println("key:"+it.next()+" value:"+bst.get((Integer) it.next()));
		}
	}
}