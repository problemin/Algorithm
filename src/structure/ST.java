package structure;

public class ST<Key extends Comparable<Key>, Value > {
	
	private int size = 0;;
	private Key[] keys;
	private Value[] vals;
	private int currentMax = 10;
	public ST(){
		this.keys =  (Key[]) new Comparable[currentMax];
		this.vals = (Value[]) new Object[currentMax];
	}
	public void put(Key key,Value val){
		this.keys[size++] = key;
		this.vals[size] = val;
		
	}
	public Value get(Key key){
		return null;
	}
	public void delete(Key key){
		
	}
	public boolean contains(Key key){
		return false;
	}
	public boolean isEmpty(){
		return false;
	}
	public int size(){
		return 0;
	}
	public Key min(){
		return null;
	}
	public Key max(){
		return null;
	}
	public Key floor(Key key){
		return key;
	}
	public Key ceiling(Key key){
		return key;
	}
	public int rank(Key key){
		return 0;
	}
	public Key select(int k){
		return null;
	}
	public void deleteMin(){
	}
	public void deleteMax(){
	}
	public int size(Key lo,Key hi){
		return 0;
	}
	public Iterable<Key> keys(Key lo,Key hi){
		return null;
	}
	public Iterable<Key> keys(){
		return null;
	}
}
