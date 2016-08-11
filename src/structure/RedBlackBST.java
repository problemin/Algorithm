package structure;

/**
 * 红色节点指的是有红色链接指向的节点
 * 
 * @author Problemin
 *
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBST<Key extends Comparable<Key> , Value> {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		private Node left,right;
		private int N;//该节点下有多少子节点
		private boolean color;
		public Node(Key key, Value val, int N){
			this.key = key;
			this.val = val;
			this.color = RED;
			this.N = N;
		}
	} 
	/**
	 * 检查某节点x是否是红节点
	 * @param x
	 * @return
	 */
	private boolean isRed(Node x){
		if(x == null) return false;
		return x.color == RED;
	}
	/**
	 * 
	 * @param h
	 * @return
	 */
	private Node rotateLeft(Node h){
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) +1;
		return x;
		
	}
	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) +1;
		return x;
	}
	
	private void flipColors(Node h){
		h.left.color = BLACK;
		h.right.color = BLACK;
		h.color = RED;
	}
	public void put(Key key, Value val){
		root = put(root, key, val);
	}
	/**
	 * 将Key和Value插入以x为根节点的子树中
	 * @param x 子树根节点
	 * @param key 插入的键
	 * @param val 插入的值
	 */
	public Node put(Node x,Key key, Value val){
		if(x == null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		if(cmp > 0) x.right = put(x.right,key,val);
		else if(cmp < 0) x.left = put(x.left,key,val);
		else x.val = val;
		/*
		 * 如果x的右节点是红色节点，左节点是黑色节点，x左转
		 * 如果x的左节点时红色节点，且左节点的左节点是红色节点，x右转
		 * 如果x的左右节点都是红色，变黑，父节点变红
		 * 
		 */
		if(isRed(x.right)&&!isRed(x.left)) x = rotateLeft(x);
		if(isRed(x.left)&&isRed(x.left.left)) x = rotateRight(x);
		if(isRed(x.left)&&isRed(x.right)) flipColors(x);
		
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public Value get(Key key){
		return null;
	}
	private Value get(Node x, Key key){
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
	public int size(Node x){
		if(x == null) return 0;
		return x.N;
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
