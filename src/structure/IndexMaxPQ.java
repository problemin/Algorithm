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
public class IndexMaxPQ<Key extends Comparable<Key>>{
	
	private int size = 0;
	private Key[] keys;
	private int currentMax = 10;
	private int[] pq;
	private int[] qp;
	/**
	 * 创建一个有限队列
	 */
	public IndexMaxPQ(){
		this.keys = (Key[]) new Comparable[this.currentMax];
		this.pq = new int[this.currentMax];
		this.qp = new int[this.currentMax];
	}
	
	/**
	 * 创建一个初始容量为max的优先队列
	 * @param max
	 */
	public IndexMaxPQ(int max){
		this.keys = (Key[]) new Comparable[max];
		this.currentMax = max;
		this.pq = new int[max];
		this.qp = new int[max];
	}
	/**
	 * 在k位置处插入一个元素v
	 * @param k
	 * @param v
	 */
	public void insert(int k,Key v){
		this.keys[++this.size] = v;
		pq[k] = size;
		swim(size);
		if(this.size == (this.currentMax*3/4)){
			this.currentMax += this.currentMax;
			resize(this.currentMax);
		}
	}
	
	public void printAll(){
		for(int i =0;i< size;i++){
			System.out.print(keys[pq[i+1]]+"--");
		}
		System.out.print("\n");
	}
	/**
	 * 将k位置的元素修改为v
	 * @param k
	 * @param v
	 */
	public void change(int k,Key v){
		if (!contains(k)) throw new NoSuchElementException("index is not in the priority queue");
        keys[k] = v;
        swim(qp[k]);
        sink(qp[k]);
	}
	/**
	 * 是否存在索引为k的元素
	 * @param k
	 * @return
	 */
	public boolean contains(int k){
		return pq[k]!=0;
	}
	/**
	 * 删除索引为k的元素
	 * @param k
	 * @return
	 */
	public void delete(int k){
		
	}
	/**
	 * 删除最大元素
	 * @return
	 */
	public Key delMax(){
		Key max = this.keys[pq[1]];
		exch(1,size--);
		keys[pq[size+1]] = null;
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
		int[] newPq = new int[max];
		int[] newQp = new int[max];
		for(int i = 0; i <keys.length ;i++){
			temp[i] = this.keys[i];
			newPq[i] = this.pq[i];
			newQp[i] = this.qp[i];
		}
		this.keys = temp;
		this.pq = newPq;
		this.qp = newQp;
	}
	/**
	 * 返回最大元素
	 * @return
	 */
	public Key max(){
		if(isEmpty()) throw new NoSuchElementException("PQ size is 0");
		return this.keys[pq[1]];
	}
	/**
     * Returns an index associated with a maximum key.
     *
     * @return an index associated with a maximum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    public int maxIndex() {
        if (size == 0) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
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
		return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
	}
	/**
	 * 交换对象位置
	 * @param i 待交换位置
	 * @param j 待交换位置
	 * @return
	 */
	public void exch( int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}
	
}