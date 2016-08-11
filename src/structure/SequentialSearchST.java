package structure;

public class SequentialSearchST<Key , Value> {
	
	private Node first;
	private int size = 0;
	private class Node{
		Key key;
		Value val;
		Node next;
		public Node(Key key,Value val, Node next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	public void put(Key key,Value val){
		Node x = first;
		while(x !=null){
			if(key.equals(x.key)){
				x.val = val;
				return ;
			}else{
				x = x.next;
			}
		}
		first = new Node(key,val,first);
		size++;
	}
	public Value get(Key key){
		Node x = first;
		while(x != null){
			if(key.equals(x.key)){
				return x.val;
			}else{
				x = x.next;
			}
		}
		return null;
	}
	public void delete(Key key){
		Node x = first;
		if(x == null){
			return;
		}
		if(x == key){
			first = null;
		}
		
		for(Node y = x.next;y != null; y = y.next){
			if(key.equals(y.key)){
				x.next = y.next;
				y = null;
			}else{
				x = x.next;
			}
		}
		size--;
	}
	public boolean contains(Key key){
		return this.get(key) !=null;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public int size(){
		return this.size;
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
