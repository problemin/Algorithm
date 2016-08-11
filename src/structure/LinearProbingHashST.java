package structure;

/**
 * ����̽���������ƽ������keys��vals���洢���ű� 
 * Ԫ��ֱ�Ӵ�����ӦHashλ�ã������λ�ñ�ռ�ã�������������ʱ��������һ��ΪNULL�ĵط�ʱ����룬��ѯʱ�鵽NULLʱ�򷵻� NULL
 * @author Problemin
 *
 * @param <Key>
 * @param <Value>
 */
public class LinearProbingHashST<Key , Value> {
	private int N;		//Ԫ������
	private int M = 16; //���С
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
		if(N >= M/2) resize(2*M);//���·����С
		int i;
		/*
		 * i + 1 % M  ��� i + 1 С��M�򷵻� i + 1,�����ʽ����Hash����β�����ͷ��ʼ��
		 * ���Keys[i]��Ϊ�գ����ж��Ƿ���ȣ�����򸲸ǣ���������ҵ���һ��Ϊ�յĵط��������롣
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
		 * i + 1 % M  ��� i + 1 С��M�򷵻� i + 1,�����ʽ����Hash����β�����ͷ��ʼ��
		 * ���Keys[i]��Ϊ�գ����ж��Ƿ���ȣ�����򷵻أ�������û�ҵ���ȵ���������Null
		 * 
		 */
		for(int i = hash(key);keys[i] != null; i = (i + 1)%M){
			if(keys[i].equals(key)){
				return vals[i];
			}}
			return null;
	}
	/*
	 * resize�����ı���hash��Ľṹ������Ҫ��ȫ���µ���
	 * delete�����ı���ɾ��Ԫ�غ���Ĵ洢�ṹ�����Ժ����Ԫ��Ҫ���µ��룬�����ĩβ�����ǰ�˵�Ԫ��Ҳ���µ��룬����̽����Լ���Ϊһ����λ������
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
