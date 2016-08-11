package sort;
public abstract class SortBase{
	/**
	 * 进行排序
	 * @param a 待排数组
	 */
	public abstract void sort(Comparable[] a);
	/**
	 * 进行大小比较，需要对象实现Comparable接口的compareTo方法
	 * @param v 待比较对象
	 * @param w 待比较对象
	 * @return
	 */
	public boolean less(Comparable v, Comparable w) {
		// TODO Auto-generated method stub
		return v.compareTo(w) < 0;
	}
	/**
	 * 交换对象位置
	 * @param a 待排数组
	 * @param i 待交换位置
	 * @param j 待交换位置
	 * @return
	 */
	public void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	/**
	 * 判断是否排序
	 * @param a 待排数组
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
	 * 输出所有元素，需要对象重写toString()方法
	 * @param a 待排数组
	 * @return
	 */
	public void showAll(Comparable[] a) {
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
}
