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
public class MaxPQ<Key extends Comparable<Key>>{
	
	private int size;
	private Key[] keys;
	private int currentMax = 10;
	/**
	 * ����һ�����޶���
	 */
	public MaxPQ(){
		this.keys = (Key[]) new Comparable[this.currentMax];
		this.size = 0;
	}
	
	/**
	 * ����һ����ʼ����Ϊmax�����ȶ���
	 * @param max
	 */
	public MaxPQ(int max){
		this.keys = (Key[]) new Comparable[max];
		this.currentMax = max;
		this.size = 0;
	}
	
	/**
	 * ��a[]�е�Ԫ�ش���һ�����ȶ���
	 * @param a
	 */
	public MaxPQ(Key []a){
		this(a.length);
		for(int i = 0; i < a.length; i++){
			this.insert(a[i]);
		}
	}
	
	/**
	 * ����һ��Ԫ��
	 * @param v
	 */
	public void insert(Key v){
	//1.����汾��ֻ��ɾ������ʱ��������ֵ��ĩλ����
	 /*	this.keys[this.size++] = v;
		if(this.size==(this.currentMax*3/4)){
			this.currentMax += this.currentMax;
			resize(this.currentMax);
		}*/
	//2.����汾���ڲ������ݵ�ʱ����бȽ�
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
	 * ɾ�����Ԫ��
	 * @return
	 */
	public Key delMax(){
		//1.����汾��ֻ��ɾ������ʱ��������ֵ��ĩλ����
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
		
		 // 2.����汾��ֱ��ɾ��ĩβԪ��
		Key key = keys[--size];
		keys[size] = null;
		return key;
	}
	
	/**
	 * ���·����С
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
	 * �������Ԫ��
	 * @return
	 */
	public Key max(){
		if(isEmpty()) throw new NoSuchElementException("PQ size is 0");
		return this.keys[this.size-1];
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
	
}