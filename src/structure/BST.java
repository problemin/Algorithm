package structure;

public class BST<Key extends Comparable<Key> , Value> {
	
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		private Node left,right;
		private int N; //�Ըýڵ�Ϊ���������нڵ�����
		
		public Node(Key key, Value val, int N){
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	public void put(Key key, Value val){
		root = put(root,key,val);
	}
	
	/**
	 * ��ĳ���ڵ�x�����ӽڵ���룬�������x,��x���ҽڵ���룻���С��x����x����ڵ���룬�������x���򸲸�val
	 * ������ӽڵ���룬�ӽڵ㲻���ڣ���new Node(key,val) ���ص���һ�㣬����x���ӽڵ�����Ϊ�½ڵ�
	 * @param x
	 * @param key
	 * @param val
	 * @return
	 */
	public Node put(Node x,Key key, Value val){
		if(x == null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		//�ŵ��Ҳ�
		if(cmp > 0) x.right = put(x.right,key,val);
		//�ŵ����
		else if(cmp < 0) x.left = put(x.left,key,val);
		//x.key = key
		else x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
		
	}
	public Value get(Key key){
		return get(root,key);
	}
	
	/**
	 * ��ĳ���ڵ�x�����ӽڵ���룬�������x,��x���ҽڵ��ѯ�����С��x����x����ڵ��ѯ���������x������val
	 * ���xΪ�� ����null
	 * @param x
	 * @param key
	 * @return
	 */
	private Value get(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp > 0)  return get(x.right,key);
		//�ŵ����
		else if(cmp < 0)  return get(x.left,key);
		else return x.val;
	}
	public void delete(Key key){
		 
	}
	public boolean contains(Key key){
		return get(key) == null;
	}
	public boolean isEmpty(){
		return root == null;
	}
	public int size(){
		return size(root);
	}
	public int size(Node x){
		if(x == null) return 0;
		return x.N;
	}
}
