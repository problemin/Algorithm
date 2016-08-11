package structure;

public class BST<Key extends Comparable<Key> , Value> {
	
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		private Node left,right;
		private int N; //以该节点为根的子树中节点总数
		
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
	 * 从某个节点x向其子节点插入，如果大于x,向x的右节点插入；如果小于x，向x的左节点插入，如果等于x，则覆盖val
	 * 如果向子节点插入，子节点不存在，则new Node(key,val) 返回到上一层，并把x的子节点设置为新节点
	 * @param x
	 * @param key
	 * @param val
	 * @return
	 */
	public Node put(Node x,Key key, Value val){
		if(x == null) return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		//放到右侧
		if(cmp > 0) x.right = put(x.right,key,val);
		//放到左侧
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
	 * 从某个节点x向其子节点插入，如果大于x,向x的右节点查询；如果小于x，向x的左节点查询，如果等于x，返回val
	 * 如果x为空 返回null
	 * @param x
	 * @param key
	 * @return
	 */
	private Value get(Node x, Key key){
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp > 0)  return get(x.right,key);
		//放到左侧
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
