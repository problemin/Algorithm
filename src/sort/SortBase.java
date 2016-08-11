package sort;
public abstract class SortBase{
	/**
	 * ��������
	 * @param a ��������
	 */
	public abstract void sort(Comparable[] a);
	/**
	 * ���д�С�Ƚϣ���Ҫ����ʵ��Comparable�ӿڵ�compareTo����
	 * @param v ���Ƚ϶���
	 * @param w ���Ƚ϶���
	 * @return
	 */
	public boolean less(Comparable v, Comparable w) {
		// TODO Auto-generated method stub
		return v.compareTo(w) < 0;
	}
	/**
	 * ��������λ��
	 * @param a ��������
	 * @param i ������λ��
	 * @param j ������λ��
	 * @return
	 */
	public void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	/**
	 * �ж��Ƿ�����
	 * @param a ��������
	 * @return
	 */
	public boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++ ){
			if(less(a[i],a[i-1])){
				return false;
			}
		}
		return true;
	}
	/**
	 * �������Ԫ�أ���Ҫ������дtoString()����
	 * @param a ��������
	 * @return
	 */
	public void showAll(Comparable[] a) {
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
}
