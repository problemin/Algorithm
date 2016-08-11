package sort;


/**
 *归并排序:采用分治思想，将一个数组的排序转化为若干小数组的排序，然后将结果归并起来
 *采用分治思想算法复杂度始终是nlogn
 * @author Problemin
 *
 */
public class Merge extends SortBase {

	private static Comparable[] aux;
	
	@Override
	public void sort(Comparable[] a) {
		aux = new Comparable[a.length]; //一次性给辅助数组分配空间
		sort(a,0,a.length-1);
	}
	
	/**
	 * 将数组a进行自顶向下归并排序 <br>
	 * 此方法是归并排序的主方法，将在此处进行分治
	 * @param a
	 */
	public void sort (Comparable[] a,int lo,int hi) {
		if(hi <= lo) return;           //已经不可以再分
		int mid = lo + (hi - lo)/2;
		sort(a,lo,mid);                //对左侧进行归并排序
		sort(a,mid+1,hi);              //对右侧进行递归排序
		merge(a,lo,mid,hi);            //左右两侧进行归并
	}
	
	/**
	 * 将数组a进行自底向上归并排序<br>
	 * 此方法是归并排序的主方法，
	 * @param a
	 */
	public void sortBu(Comparable[] a){
		int len = a.length;
		aux = new Comparable[len]; //一次性给辅助数组分配空间
		// lo..size-1..mid..size..hi
		//mid = lo + size -1
		//hi = lo + size +size -1
		//每次规模倍增
		for(int size = 1; size < len; size += size){
			for(int lo = 0; lo < len ; lo += size+size){
				merge(a,lo,lo+size-1,Math.min(lo+size+size-1, len-1));
			}
		}
	}
	/**
	 * 将a[lo,mid]与a[mid,hi]进行归并<br>
	 * 此方法是归并排序的基础方法，此处做的是一次归并
	 * @param a
	 * @param lo
	 * @param hi
	 */
	public void merge(Comparable[] a,int lo,int mid,int hi) {
		int i = lo;			//左侧标记
		int j = mid + 1;	//右侧标记
		
		for(int k = lo;k <= hi; k++){ //将a[lo,hi]复制到aux[lo..hi]中
			aux[k] = a[k];
		}
		
		for(int k = lo; k <= hi; k++){
			//开始从aux中取元素往a中放，每次从两边取出首个进行比较然后将小的存到a中，并把标记后移	
			//如果有一边先用完了，由于剩余的部分是有序的，可以直接复制过去
			if     (i > mid)  			 a[k] = aux[j++];         //左边用尽，取右边元素
			else if(j > hi ) 		     a[k] = aux[i++];         //右边用尽，取左边元素
			else if(less(aux[i],aux[j])) a[k] = aux[i++];         //两边都没用尽，则各取首位进行比较，如果aux[i]比aux[j]小，则存aux[i]，然后i++
			else                         a[k] = aux[j++];         //如果aux[j]比aux[i]小，则存aux[j],然后j++
		}
	}
}
