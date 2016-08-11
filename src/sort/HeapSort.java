package sort;


/**
 *堆排序：运用优先队列的特点进行排序
 * @author Problemin
 *
 */
public class HeapSort extends SortBase {

	@Override
	public void sort(Comparable[] a) {
		construct(a);
		int N = a.length-1;
		while(N > 1){
			exch(a,1,N);
			sink(a,1,--N);
		}
		 
	}
	
	
	/**
	 * 构造堆
	 * @param a
	 */
	public void construct(Comparable[] a){
		int N = a.length-1;
/*		for(int i = 1; i < N; i++){
			swim(a,i);
		}*/
		for(int i = N/2; i >= 1; i--)
			sink(a,i,N);
	}
	
	/**
	 * 上浮
	 * @param a
	 * @param k
	 */
	public void swim(Comparable[] a,int k){
		if(k <= 1) return;
		int j = k/2; //j是父节点
		if(less(a[j],a[k])) exch(a,j,k);
		else return;
		swim(a,j);
	}
	
	/**
	 * 下沉
	 * @param a
	 * @param k
	 */
	public void sink(Comparable[] a,int k,int n){
/*		此方法有问题
 * if(2*k > n) return;
		int j = 2*k;
		if(k <n&&less(a[j],a[j+1])) ++j;
		if(less(a[k],a[j])) exch(a,k,j);
		else return;
		sink(a,j,n);*/
		   while (2*k <= n) {
	            int j = 2*k;
	            if (j < n && less(a[j],a[j+1])) j++;
	            if (!less(a[k],a[j])) break;
	            exch(a, k, j);
	            k = j;
	        }
	}
	
	public void showAll(Comparable[] a) {
		for(int i = 1; i < a.length; i++)
			System.out.println(a[i]);
	}
	
}
