package structure;

/**
 * 线性探测表用两个平行数组keys和vals来存储符号表 
 * 元素直接存在相应Hash位置，如果该位置被占用，向后遍历。插入时遍历到第一个为NULL的地方时候插入，查询时查到NULL时候返回 NULL
 * @author Problemin
 *
 * @param <Key>
 * @param <Value>
 */
public class LinearProbingHashST<Key , Value> {
	private int N;		//元素数量
	private int M = 16; //表大小
	private Key[] keys;
	private Value[] vals;
	public LinearProbingHashST(){
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	
	public LinearProbingHashST(int max){
		keys = (Key[]) new Object[max];
		vals = (Value[]) new Object[max];
		M = max;
	}
	
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(Key key,Value val){
		if(N >= M/2) resize(2*M);//重新分配大小
		int i;
		/*
		 * i + 1 % M  如果 i + 1 小于M则返回 i + 1,这个公式用于Hash超出尾部后从头开始找
		 * 如果Keys[i]不为空，就判断是否相等，相等则覆盖，不相等则找到第一个为空的地方，并插入。
		 * 
		 */
		for(i = hash(key);keys[i] != null; i = (i + 1) % M){
			if(keys[i].equals(key)){
				vals[i] = val;
				return;
			}}
			keys[i] = key;
			vals[i] = val;
			N++;
	}
	public Value get(Key key){
		/*
		 * i + 1 % M  如果 i + 1 小于M则返回 i + 1,这个公式用于Hash超出尾部后从头开始找
		 * 如果Keys[i]不为空，就判断是否相等，相等则返回，如果最后都没找到相等的量，返回Null
		 * 
		 */
		for(int i = hash(key);keys[i] != null; i = (i + 1)%M){
			if(keys[i].equals(key)){
				return vals[i];
			}}
			return null;
	}
	/*
	 * resize操作改变了hash表的结构，所以要完全重新导入
	 * delete操作改变了删除元素后面的存储结构，所以后面的元素要重新导入，如果在末尾，会把前端的元素也重新导入，线性探测表以键簇为一个单位来操作
	 * 
	 */
	public void resize(int max){
		LinearProbingHashST<Key, Value> t = new LinearProbingHashST<Key, Value>(max);
		Key[] newKeys = (Key[]) new Object[max];
		Value[] newVals = (Value[]) new Object[max];
		for(int i = 0; i < M ;i++){
			if(keys[i] != null){
				t.put(keys[i], vals[i]);
			}
		}
		keys = newKeys;
		vals = newVals;
		M = max;
	}
}
