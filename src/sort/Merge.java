package sort;


/**
 *�鲢����:���÷���˼�룬��һ�����������ת��Ϊ����С���������Ȼ�󽫽���鲢����
 *���÷���˼���㷨���Ӷ�ʼ����nlogn
 * @author Problemin
 *
 */
public class Merge extends SortBase {

	private static Comparable[] aux;
	
	@Override
	public void sort(Comparable[] a) {
		aux = new Comparable[a.length]; //һ���Ը������������ռ�
		sort(a,0,a.length-1);
	}
	
	/**
	 * ������a�����Զ����¹鲢���� <br>
	 * �˷����ǹ鲢����������������ڴ˴����з���
	 * @param a
	 */
	public void sort (Comparable[] a,int lo,int hi) {
		if(hi <= lo) return;           //�Ѿ��������ٷ�
		int mid = lo + (hi - lo)/2;
		sort(a,lo,mid);                //�������й鲢����
		sort(a,mid+1,hi);              //���Ҳ���еݹ�����
		merge(a,lo,mid,hi);            //����������й鲢
	}
	
	/**
	 * ������a�����Ե����Ϲ鲢����<br>
	 * �˷����ǹ鲢�������������
	 * @param a
	 */
	public void sortBu(Comparable[] a){
		int len = a.length;
		aux = new Comparable[len]; //һ���Ը������������ռ�
		// lo..size-1..mid..size..hi
		//mid = lo + size -1
		//hi = lo + size +size -1
		//ÿ�ι�ģ����
		for(int size = 1; size < len; size += size){
			for(int lo = 0; lo < len ; lo += size+size){
				merge(a,lo,lo+size-1,Math.min(lo+size+size-1, len-1));
			}
		}
	}
	/**
	 * ��a[lo,mid]��a[mid,hi]���й鲢<br>
	 * �˷����ǹ鲢����Ļ����������˴�������һ�ι鲢
	 * @param a
	 * @param lo
	 * @param hi
	 */
	public void merge(Comparable[] a,int lo,int mid,int hi) {
		int i = lo;			//�����
		int j = mid + 1;	//�Ҳ���
		
		for(int k = lo;k <= hi; k++){ //��a[lo,hi]���Ƶ�aux[lo..hi]��
			aux[k] = a[k];
		}
		
		for(int k = lo; k <= hi; k++){
			//��ʼ��aux��ȡԪ����a�зţ�ÿ�δ�����ȡ���׸����бȽ�Ȼ��С�Ĵ浽a�У����ѱ�Ǻ���	
			//�����һ���������ˣ�����ʣ��Ĳ���������ģ�����ֱ�Ӹ��ƹ�ȥ
			if     (i > mid)  			 a[k] = aux[j++];         //����þ���ȡ�ұ�Ԫ��
			else if(j > hi ) 		     a[k] = aux[i++];         //�ұ��þ���ȡ���Ԫ��
			else if(less(aux[i],aux[j])) a[k] = aux[i++];         //���߶�û�þ������ȡ��λ���бȽϣ����aux[i]��aux[j]С�����aux[i]��Ȼ��i++
			else                         a[k] = aux[j++];         //���aux[j]��aux[i]С�����aux[j],Ȼ��j++
		}
	}
}
