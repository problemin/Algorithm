package structure;

public class BinarySearchST<Key extends Comparable<Key> , Value> {
	
	private Key[] keys;
	private Value[] vals;
	private int N;
	public BinarySearchST(int capacity){
		this.keys = (Key[]) new Comparable[capacity];
		this.vals = (Value[]) new Object[capacity];
		this.N = 0;
	}
	public void put(Key key,Value val){
		int i = rank(key);
		//存在则覆盖
		if(i < N && keys[i].compareTo(key) == 0){
			vals[i] = val;
			return;
		}
		//不存在则插入，插入前先将插入位置后的元素后移
		for( int j = N;j > i; j--){
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		//后移结束，插入元素
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	public Value get(Key key){
		if(isEmpty()) return null;
		int i = rank(key);
		if(i < N&&keys[i].compareTo(key) == 0) return vals[i];
		else return null;
	}
	public void delete(Key key){
		
	}
	public boolean contains(Key key){
		return this.get(key) != null;
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public int size(){
		return N;
	}
	public Key min(){
		return keys[0];
	}
	public Key max(){
		return keys[N-1];
	}
	public Key floor(Key key){
		int i = rank(key);
		if(i <= N){
			if(key.compareTo(keys[i]) < 0) return keys[i -1];
			else return keys[i];
		}else{
			return keys[N];
		}
	}
	public Key ceiling(Key key){
		return keys[rank(key)];
	}
	public int rank(Key key){
		int lo = 0,hi = N -1;
		while(hi >= lo){
			int mid = lo + (hi - lo)/2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0) hi = mid - 1;
			else if(cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	public int rank(Key key,int lo,int hi){
		if(hi < lo) return lo;
		int mid = lo + (hi - lo)/2;
		int cmp = key.compareTo(keys[mid]);
		if(cmp > 0) return rank(key,mid+1,hi);
		else if(cmp < 0) return rank(key,lo,mid-1);
		else return mid;
	}
	public Key select(int k){
		return keys[k];
	}
	public void deleteMin(){
	}
	public void deleteMax(){
	}
	public int size(Key lo,Key hi){
		return 0;
	}
	public Iterable<Key> keys(Key lo,Key hi){
		Queue<Key> q = new Queue<Key>();
		for( int i = rank(lo); i < rank(hi); i++)
			q.enqueue(keys[i]);
		if(contains(hi))
			q.enqueue(keys[rank(hi)]);
		return q;
	}
	public Iterable<Key> keys(){
		Queue<Key> q = new Queue<Key>();
		for(int i = 0;i < N; i++){
			q.enqueue(keys[i]);
		}
		return q;
	}
}
