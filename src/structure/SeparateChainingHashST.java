package structure;

/**
 * 拉链法实现散列表
 * 数组下标是散列值，数组元素为一条链表，链表元素是散列值为相同下标的元素
 * @author Problemin
 *
 */
public class SeparateChainingHashST<Key,Value> {
	private int N;//键值对总数
	private int M;//散列表的大小
	private SequentialSearchST<Key,Value>[] st;
	
	public SeparateChainingHashST(){
	}
	
	public SeparateChainingHashST(int M){
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i = 0; i < M; i++){
			st[i] = new SequentialSearchST();
		}
	}
	
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff)% M;
	}
	
	public Value get(Key key){
		return (Value) st[hash(key)].get(key);
	}
	
	public void put(Key key,Value val){
		st[hash(key)].put(key, val);
	}
}
