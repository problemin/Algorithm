package sort;


/**
 * 选择排序：每次在未排序部分选择一个最小的放到前面，并把最小值的标记向后移动一位
 * 特点：1.运行时间和输入无关（但是并没有用，因为即使输入时是有序的，仍然会进行遍历与比较，复杂度不变）
 * 	   2.数据移动量是最少的，因为每次只移动一个元素，移动N次
 * 时间复杂度：最坏n^2,最优n^2平均n^2
 * 缺点：未排序部分若有序，仍会尽悉遍历
 * @author Problemin
 *
 */
public class Selection extends SortBase {

	@Override
	public void sort(Comparable[] a) {
		int len = a.length;
		for(int i = 0 ; i < len ; i++){
			int min = i;
			for(int j = min; j < len; j++){
				if(!less(a[min],a[j])){
					min = j; //遍历未排序部分找到最小元素
				}
			}
			exch(a,min,i); //把未排序部分的最小元素放到前面
		}
	}
}
