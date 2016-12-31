

public class BSTree<Key extends Comparable<Key>,Value> {
	private Node root;
	class Node{
		private Key key;
		private Value value;
		private Node left,right;
		
		public Node(Key key,Value value){
			this.key = key;
			this.value = value;
		}
	}
		public void add(Key key,Value value){
			root = add(root,key,value);
		}
		
		private Node add(Node currentRoot,Key key,Value value){
			if(currentRoot==null) return new Node(key,value);//递归基
			int cmp=key.compareTo(currentRoot.key);
			if(cmp<0){
				currentRoot.left = add(currentRoot.left,key,value);
			}else if(cmp>0){
				currentRoot.right = add(currentRoot.right,key,value);
			}else{
				//相等,进行覆盖操作
				currentRoot.value = value;
			}
			return currentRoot;
		}
		
		public Value get(Key key){
			return get(root,key);
		}
		
		private Value get(Node currentRoot,Key key){
			if(currentRoot == null) return null;
			
			int cmp=key.compareTo(currentRoot.key);
			if(cmp<0){
				return get(currentRoot.left,key);
			}else if(cmp>0){
				return get(currentRoot.right,key);
			}else{
				//相等,返回
				return currentRoot.value;
			}
		}
		
		public void delete(Key key){
			root = delete(root,key);
		}
		
		private Node delete(Node currentRoot,Key key){
			if(currentRoot == null) return null;
			int cmp=key.compareTo(currentRoot.key);
			if(cmp<0){
				currentRoot.left = delete(currentRoot.left,key);
			}else if(cmp>0){
				currentRoot.right = delete(currentRoot.right,key);
			}else{
				//相等,删除
				if(currentRoot.left == null){
					return currentRoot.right;
				}if(currentRoot.right == null){
					return currentRoot.left ;
				}else{
					Node x = currentRoot;
					currentRoot = min(currentRoot.right);
					currentRoot.right = deleteMin(x.right);
					currentRoot.left = x.left;
				}
			}
			return currentRoot;
		}
		
		public Node min(Node currentRoot){
			if(currentRoot.left !=null){
				return min(currentRoot.left);
			}else{
				return currentRoot;
			}
		}
		
		public Node deleteMin(Node currentRoot){
			if(currentRoot.left != null){
				currentRoot.left = deleteMin(currentRoot.left);
			}else{
				return currentRoot.right;
			}
			return currentRoot;
		}
		public void print(){
			 print(root);
		}
		
		private void print(Node x){
			 if(x==null) return;
			 print(x.left);
			 System.out.println(x.key+"--"+x.value);
			 print(x.right);
		}
	
	public static void main(String[] args) {
		BSTree<Integer,String> bst = new BSTree<Integer,String>();
		bst.add(11301083, "张中华");
		bst.add(11301081, "张敏");
		bst.add(15126231, "张敏");
		bst.add(11301079, "曾颂");
		bst.add(15126131, "田旭耕");
		bst.add(11301078, "杨恺");
		bst.add(15126192, "傅韧峤");
		
		bst.print();
		System.out.println("--------------");
		bst.delete(11301083);
		bst.print();
	}
}
