package sort;

import edu.princeton.cs.algs4.StdRandom;


/**-
 *快速排序：快速排序也是采用分治思想的排序，快速排序的思路是选取一个随机元素一般是a[lo]（待排部分首位），
 *然后在分别从lo->hi,hi->lo进行扫描，从左边元素找到一个比a[lo]大的，在右侧找到一个比a[lo]小的，进行位置交换，直到左右扫描的标记相遇
 *如果i>=j ，说明 i 左侧元素一定比a[lo]小了，并且j右侧元素一定比a[lo]大了此时把a[lo]放到a[i]与a[j]之间即可
 *顺序或逆序的数组进行快排的性能十分之低，所以在进行操作之前要先对其进行一个打乱操作
 *采用分治思想算法复杂度始终是nlogn
 * @author Problemin
 *
 */
public class Quick extends SortBase {

	private static Comparable[] aux;
	
	@Override
	public void sort(Comparable[] a) {
		StdRandom.shuffle(a); //打乱数组 
		 sort(a,0,a.length-1);
	}
	
	/**
	 * 将数组a进行自顶向下归并排序 <br>
	 * 此方法是归并排序的主方法，将在此处进行分治
	 * @param a
	 */
	public void sort (Comparable[] a,int lo,int hi) {
		if(hi <= lo) return;           //已经不可以再分
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);                //对左侧进行归并排序
		sort(a,j+1,hi);              //对右侧进行递归排序
	}
	
	public void sort3way(Comparable[] a) {
		StdRandom.shuffle(a); //打乱数组 
		sort3way(a,0,a.length-1);
	}
	
	/**
	 * 将数组a进行自顶向下归并排序 <br>
	 * 此方法是归并排序的主方法，将在此处进行分治
	 * @param a
	 */
	public void sort3way (Comparable[] a,int lo,int hi) {
		if(hi <= lo) return;           //已经不可以再分
		//要使地a[lo..lt-1]的元素小于v,a[lt...i]的元素等于v,a[i...gt]的元素大于v
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
	 * 按a[lo]进行切分,并返回a[lo]的新位置
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int partition(Comparable []a,int lo,int hi){
		Comparable part = a[lo];//设置一个切分值
		int i = lo ,j = hi+1;	//设置指针
		while(true){
			while(less(a[++i],part)) if(i == hi) break;  //从左往右扫描，当找到比part大的元素时结束，或者扫描到hi结束
			while(less(part,a[--j])) if(j == lo) break;  //从右往左扫描，当找到比part小的元素时结束，或者扫描到lo结束
			if(i >= j)  break;                           //说明存在一个位置j使得左右有序
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
}
