package structure;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * ���ȶ���
 * @author Problemin
 *
 * @param <Item>
 */
public class MaxPQHeap<Key extends Comparable<Key>>{
	
	private int size = 0;
	private Key[] keys;
	private int currentMax = 10;
	/**
	 * ����һ�����޶���
	 */
	public MaxPQHeap(){
		this.keys = (Key[]) new Comparable[this.currentMax];
	}
	
	/**
	 * ����һ����ʼ����Ϊmax�����ȶ���
	 * @param max
	 */
	public MaxPQHeap(int max){
		this.keys = (Key[]) new Comparable[max];
		this.currentMax = max;
	}
	/**
	 * ����һ��Ԫ��
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
	 * ɾ�����Ԫ��
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
	 * �ϸ�������
	 * @param k
	 */
	public void swim(int k){
		while(k > 1&&less(k/2,k)){
			exch(k/2,k);
			k /= 2;
		}
	}
	
	/**
	 * �³�������
	 * @param k
	 */
	public void sink(int k){
		//Ҫ���ӽڵ�����³�
		
		while( k*2 <= size){
			int j = 2*k;
			if(j < size&&less(j,j+1)) j++;
			if(!less(k,j)) break;
			exch(k,j);
			k = j;
		}
		 
	}
	/**
	 * ���·����С
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
	 * �������Ԫ��
	 * @return
	 */
	public Key max(){
		if(isEmpty()) throw new NoSuchElementException("PQ size is 0");
		return this.keys[this.size];
	}
	
	/**
	 * �ж����ȶ����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	/**
	 * ���ض���Ԫ�ظ���
	 * @return
	 */
	public int size(){
		return this.size;
	}
	
	/**
	 * ���д�С�Ƚϣ���Ҫ����ʵ��Comparable�ӿڵ�compareTo����
	 * @param v ���Ƚ϶���
	 * @param w ���Ƚ϶���
	 * @return
	 */
	public boolean less(int i, int j) {
		// TODO Auto-generated method stub
		return keys[i].compareTo(keys[j]) < 0;
	}
	/**
	 * ��������λ��
	 * @param i ������λ��
	 * @param j ������λ��
	 * @return
	 */
	public void exch( int i, int j) {
		Key temp = keys[i];
		keys[i] = keys[j];
		keys[j] = temp;
	}
	
}