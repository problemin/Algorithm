package structure;

/**
 * ��ɫ�ڵ�ָ�����к�ɫ����ָ��Ľڵ�
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
		private int N;//�ýڵ����ж����ӽڵ�
		private boolean color;
		public Node(Key key, Value val, int N){
			this.key = key;
			this.val = val;
			this.color = RED;
			this.N = N;
		}
	} 
	/**
	 * ���ĳ�ڵ�x�Ƿ��Ǻ�ڵ�
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
	 * ��Key��Value������xΪ���ڵ��������
	 * @param x �������ڵ�
	 * @param key ����ļ�
	 * @param val �����ֵ
	 */
	public Node put(Node x,Key key, Value val){
		if(x == null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		if(cmp > 0) x.right = put(x.right,key,val);
		else if(cmp < 0) x.left = put(x.left,key,val);
		else x.val = val;
		/*
		 * ���x���ҽڵ��Ǻ�ɫ�ڵ㣬��ڵ��Ǻ�ɫ�ڵ㣬x��ת
		 * ���x����ڵ�ʱ��ɫ�ڵ㣬����ڵ����ڵ��Ǻ�ɫ�ڵ㣬x��ת
		 * ���x�����ҽڵ㶼�Ǻ�ɫ����ڣ����ڵ���
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
