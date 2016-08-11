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
public class MaxPQHeap<Key extends Comparable<Key>>{
	
	private int size = 0;
	private Key[] keys;
	private int currentMax = 10;
	/**
	 * 创建一个有限队列
	 */
	public MaxPQHeap(){
		this.keys = (Key[]) new Comparable[this.currentMax];
	}
	
	/**
	 * 创建一个初始容量为max的优先队列
	 * @param max
	 */
	public MaxPQHeap(int max){
		this.keys = (Key[]) new Comparable[max];
		this.currentMax = max;
	}
	/**
	 * 插入一个元素
	 * @param v
	 */
	public void insert(Key v){
		this.keys[++this.size] = v;
		swim(size);
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
		Key max = this.keys[1];
		exch(1,size--);
		keys[size+1] = null;
		sink(1);
		return max;
		
	}
	
	/**
	 * 上浮堆排序
	 * @param k
	 */
	public void swim(int k){
		while(k > 1&&less(k/2,k)){
			exch(k/2,k);
			k /= 2;
		}
	}
	
	/**
	 * 下沉堆排序
	 * @param k
	 */
	public void sink(int k){
		//要有子节点才能下沉
		
		while( k*2 <= size){
			int j = 2*k;
			if(j < size&&less(j,j+1)) j++;
			if(!less(k,j)) break;
			exch(k,j);
			k = j;
		}
		 
	}
	/**
	 * 重新分配大小
	 * @param max
	 */
	public void resize(int max){
		Key[] temp = (Key[]) new Comparable[max];
		for(int i = 0; i <keys.length ;i++){
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
		return this.keys[this.size];
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
	
	/**
	 * 进行大小比较，需要对象实现Comparable接口的compareTo方法
	 * @param v 待比较对象
	 * @param w 待比较对象
	 * @return
	 */
	public boolean less(int i, int j) {
		// TODO Auto-generated method stub
		return keys[i].compareTo(keys[j]) < 0;
	}
	/**
	 * 交换对象位置
	 * @param i 待交换位置
	 * @param j 待交换位置
	 * @return
	 */
	public void exch( int i, int j) {
		Key temp = keys[i];
		keys[i] = keys[j];
		keys[j] = temp;
	}
	
}