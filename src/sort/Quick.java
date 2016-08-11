package sort;

import edu.princeton.cs.algs4.StdRandom;


/**-
 *�������򣺿�������Ҳ�ǲ��÷���˼������򣬿��������˼·��ѡȡһ�����Ԫ��һ����a[lo]�����Ų�����λ����
 *Ȼ���ڷֱ��lo->hi,hi->lo����ɨ�裬�����Ԫ���ҵ�һ����a[lo]��ģ����Ҳ��ҵ�һ����a[lo]С�ģ�����λ�ý�����ֱ������ɨ��ı������
 *���i>=j ��˵�� i ���Ԫ��һ����a[lo]С�ˣ�����j�Ҳ�Ԫ��һ����a[lo]���˴�ʱ��a[lo]�ŵ�a[i]��a[j]֮�伴��
 *˳��������������п��ŵ�����ʮ��֮�ͣ������ڽ��в���֮ǰҪ�ȶ������һ�����Ҳ���
 *���÷���˼���㷨���Ӷ�ʼ����nlogn
 * @author Problemin
 *
 */
public class Quick extends SortBase {

	private static Comparable[] aux;
	
	@Override
	public void sort(Comparable[] a) {
		StdRandom.shuffle(a); //�������� 
		 sort(a,0,a.length-1);
	}
	
	/**
	 * ������a�����Զ����¹鲢���� <br>
	 * �˷����ǹ鲢����������������ڴ˴����з���
	 * @param a
	 */
	public void sort (Comparable[] a,int lo,int hi) {
		if(hi <= lo) return;           //�Ѿ��������ٷ�
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);                //�������й鲢����
		sort(a,j+1,hi);              //���Ҳ���еݹ�����
	}
	
	public void sort3way(Comparable[] a) {
		StdRandom.shuffle(a); //�������� 
		sort3way(a,0,a.length-1);
	}
	
	/**
	 * ������a�����Զ����¹鲢���� <br>
	 * �˷����ǹ鲢����������������ڴ˴����з���
	 * @param a
	 */
	public void sort3way (Comparable[] a,int lo,int hi) {
		if(hi <= lo) return;           //�Ѿ��������ٷ�
		//Ҫʹ��a[lo..lt-1]��Ԫ��С��v,a[lt...i]��Ԫ�ص���v,a[i...gt]��Ԫ�ش���v
		Comparable v = a[lo];
		int lt = lo;
		int gt = hi;
		int i =lo + 1;
		while(i <= gt){
			int cmp = a[i].compareTo(v);
			if(cmp < 0 ) exch(a, lt++, i++);
			else if(cmp > 0) exch(a, i, gt--);
			else i++;
		}
		sort3way(a,lo,lt-1);
		sort3way(a,gt+1,hi);
	}
	
	/**
	 * ��a[lo]�����з�,������a[lo]����λ��
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int partition(Comparable []a,int lo,int hi){
		Comparable part = a[lo];//����һ���з�ֵ
		int i = lo ,j = hi+1;	//����ָ��
		while(true){
			while(less(a[++i],part)) if(i == hi) break;  //��������ɨ�裬���ҵ���part���Ԫ��ʱ����������ɨ�赽hi����
			while(less(part,a[--j])) if(j == lo) break;  //��������ɨ�裬���ҵ���partС��Ԫ��ʱ����������ɨ�赽lo����
			if(i >= j)  break;                           //˵������һ��λ��jʹ����������
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
}
