package sort;


/**
 *插入排序：即把位排序部分的第一个元素拿出来，插入到已排序的部分。将插入位置后面的元素后移。类似于从左往右整理扑克牌
 *特点：1.与选择排序一样，左侧总是有序的，不同点是选择排序是绝对有序（元素已归位）。选择排序是相对有序，但是还可能会有元素差入进来.
 *	  2.数组已经相对有序时，时间会减少很多（整理扑克牌时如果接近有序，也不用花太多时间）
 *    3.由于插入排序插入时会影响到后续元素的位置，因此用数组来实现会有大量的时间用于元素位置移动。(可以尝试用链表改进)
 *    最坏：n^2 最优 n 平均n^2
 * @author Problemin
 *
 */
public class Insertion extends SortBase {

	@Override
	public void sort(Comparable[] a) {
		for(int i = 1;i < a.length;i++){
			for(int j = i; j > 0 && less(a[j],a[j-1]); j-- ){
				exch(a,j-1,j);
			}
		}
	}
}
