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
public class IndexMaxPQ<Key extends Comparable<Key>>{
	
	private int size = 0;
	private Key[] keys;
	private int currentMax = 10;
	private int[] pq;
	private int[] qp;
	/**
	 * ����һ�����޶���
	 */
	public IndexMaxPQ(){
		this.keys = (Key[]) new Comparable[this.currentMax];
		this.pq = new int[this.currentMax];
		this.qp = new int[this.currentMax];
	}
	
	/**
	 * ����һ����ʼ����Ϊmax�����ȶ���
	 * @param max
	 */
	public IndexMaxPQ(int max){
		this.keys = (Key[]) new Comparable[max];
		this.currentMax = max;
		this.pq = new int[max];
		this.qp = new int[max];
	}
	/**
	 * ��kλ�ô�����һ��Ԫ��v
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
	 * ��kλ�õ�Ԫ���޸�Ϊv
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
	 * �Ƿ��������Ϊk��Ԫ��
	 * @param k
	 * @return
	 */
	public boolean contains(int k){
		return pq[k]!=0;
	}
	/**
	 * ɾ������Ϊk��Ԫ��
	 * @param k
	 * @return
	 */
	public void delete(int k){
		
	}
	/**
	 * ɾ�����Ԫ��
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
	 * �������Ԫ��
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
		return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
	}
	/**
	 * ��������λ��
	 * @param i ������λ��
	 * @param j ������λ��
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