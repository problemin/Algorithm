package structure;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 优先队列
 * @author Problemin
 *
 * @param <Item>
 */
public class MaxPQ<Key extends Comparable<Key>>{
	
	private int size;
	private Key[] keys;
	private int currentMax = 10;
	/**
	 * 创建一个有限队列
	 */
	public MaxPQ(){
		this.keys = (Key[]) new Comparable[this.currentMax];
		this.size = 0;
	}
	
	/**
	 * 创建一个初始容量为max的优先队列
	 * @param max
	 */
	public MaxPQ(int max){
		this.keys = (Key[]) new Comparable[max];
		this.currentMax = max;
		this.size = 0;
	}
	
	/**
	 * 用a[]中的元素创建一个优先队列
	 * @param a
	 */
	public MaxPQ(Key []a){
		this(a.length);
		for(int i = 0; i < a.length; i++){
			this.insert(a[i]);
		}
	}
	
	/**
	 * 插入一个元素
	 * @param v
	 */
	public void insert(Key v){
	//1.无序版本，只在删除数据时候查找最大值与末位交换
	 /*	this.keys[this.size++] = v;
		if(this.size==(this.currentMax*3/4)){
			this.currentMax += this.currentMax;
			resize(this.currentMax);
		}*/
	//2.有序版本，在插入数据的时候进行比较
		this.keys[this.size++] = v;
		if(this.size >= 2){
			for(int i = size-1; i > 0; i--){
				if(keys[i].compareTo(keys[i-1]) < 0){
					Key temp = keys[i];
					keys[i] = keys[i-1];
					keys[i-1] = temp;
				}
			}
		}
		
		if(this.size == (this.currentMax*3/4)){
			this.currentMax += this.currentMax;
			resize(this.currentMax);
		}

	}
	
	/**
	 * 删除最大元素
	 * @return
	 */
	public Key delMax(){
		//1.无序版本，只在删除数据时候查找最大值与末位交换
		/*
		if(isEmpty()) throw new NoSuchElementException("PQ size is 0");
		int max = 0;
		for(int i = 1; i < this.size; i++){
			if(keys[i].compareTo(keys[max]) > 0) max = i;
		}
		Key temp = keys[size-1];
		keys[size - 1] = keys[max];
		keys[max] = temp;
		Key key = this.keys[--this.size];
		this.keys[this.size] = null;
		if(this.size<(this.currentMax/4)){
			resize(this.currentMax/2);
		}
		return key;
		*/
		
		 // 2.有序版本，直接删除末尾元素
		Key key = keys[--size];
		keys[size] = null;
		return key;
	}
	
	/**
	 * 重新分配大小
	 * @param max
	 */
	public void resize(int max){
		Key[] temp = (Key[]) new Comparable[max];
		for(int i = 0; i < this.size ;i++){
			temp[i] = this.keys[i];
		}
		this.keys = temp;
	}
	/**
	 * 返回最大元素
	 * @return
	 */
	public Key max(){
		if(isEmpty()) throw new NoSuchElementException("PQ size is 0");
		return this.keys[this.size-1];
	}
	
	/**
	 * 判断优先队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	/**
	 * 返回队列元素个数
	 * @return
	 */
	public int size(){
		return this.size;
	}
	
}