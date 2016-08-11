package sort;


/**
 *希尔排序：即在将插入排序进行改进，对相隔隔gap个位置的元素组成的子序列进行排序，h不断递减到1，在最后变为1的时候进行的操作和插入排序一样，但由于有序部分比较多，所以移动较少
 *关于h的选择.由于h要不断从大变小，gap最初可以很大，Algorithm 4 中给出的初始值为 N/3,而且每次排序后缩小为原来的1/3，直到gap=1
 *注意:希尔排序的遍历顺序跟插入排序一样从左到右。区别是，插入排序从1开始，希尔排序从gap开始，每次往后每次取一个与其前面的子序列比较
 *   ！！！每一次只对某一序列待排部分拿出一个值，放到改序列的已排序部分进行
 *   为什么直接gap/2可以，而gap/3不行..
 *   因为当最后gap =2 或者gap =3时 ，除以 2 就是可以得到gap = 1;因为任何大于1的整除二分之后总可以得到1（自动取整）.
 *   但是如果除以3，假如长度是18，开始gap =6>=1进入循环gap/3=2 >=1，进入循环gap/3=0推出循环;所以在gap=2的时候排序就结束了。因此不能直接除
 * @author Problemin
 *
 */
public class Shell extends SortBase {

	@Override
	public void sort(Comparable[] a) {
		int len = a.length;
		int gap = 1;
		while(gap < len/3) gap = 3*gap + 1;
		while(gap >= 1){
		for(int i = gap; i< a.length; i++){
			for(int j = i; j >= gap && less(a[j],a[j-gap]); j -= gap ){
				exch(a,j,j-gap);
			}
		}
		gap /=2;
		}
	}
}
