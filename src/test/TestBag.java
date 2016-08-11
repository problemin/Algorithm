package test;

import structure.Bag;

public class TestBag {
		
	public static void main(String []args){
		Bag<Double> numbers = new Bag<Double>();
		while(numbers.size()<2){
			numbers.add(10.0);
		}
		int size = numbers.size();
		
		double sum = 0.0;
		for(double x : numbers){
			sum += x;
		}
		double mean = sum/size;

		sum = 0.0;
		for(double x : numbers){
			sum += (x - mean)*(x - mean);
		}
		double std = Math.sqrt(sum/(size-1));
		
		System.out.println("Mean:"+mean);
		System.out.println("Std:"+std);
		
		for(double x :numbers){
			System.out.println(x);
		}
		System.out.println(numbers.size());
	}
}