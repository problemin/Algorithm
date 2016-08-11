package test;

import java.util.Random;

import sort.HeapSort;
import sort.Insertion;
import sort.Merge;
import sort.Quick;
import sort.Selection;
import sort.Shell;
import sort.SortBase;
import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 选择排序测试类
 * @author Problemin
 *
 */
public class TestSort {
	public static void main(String []args){

		int Max =10;
		Stopwatch time;
		Random rand = new Random();
		SortBase sort ;
		//由于比较大小需要实现Comparable所以要使用Integer对象
		/*Integer [] a =new Integer[Max];
		System.out.println("初始化数据："+Max+"个数值在"+Max+"以内的随机整数......");
		for(int i = 0; i < Max; i++){
			a[i] = rand.nextInt(Max);
		}   */
		System.out.println("初始化数据完成......"); 
		/*
 		System.out.println("选择排序(乱序)开始......");
		sort = new Selection();
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("选择排序(乱序)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序结果:"+sort.isSorted(a));
		System.out.println("选择排序(顺序)开始......");
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("选择排序(顺序)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序结果:"+sort.isSorted(a));
		
		StdRandom.shuffle(a); //打乱数组 
	
		System.out.println("插入排序(乱序)开始......");
		sort = new Insertion();
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("插入排序(乱序)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序结果:"+sort.isSorted(a));
		System.out.println("插入排序(顺序)开始......");
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("插入排序(顺序)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序结果:"+sort.isSorted(a));
		
		StdRandom.shuffle(a); //打乱数组 
		 
		System.out.println("希尔排序(乱序)开始......");
		sort = new Shell();
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("希尔排序(乱序)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序结果:"+sort.isSorted(a));
		System.out.println("希尔排序(顺序)开始......");
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("希尔排序(顺序)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序结果:"+sort.isSorted(a));
		
		StdRandom.shuffle(a); //打乱数组 
		
		System.out.println("自顶向下归并排序(乱序)开始......");
		Merge msort = new Merge();
		time = new Stopwatch();
		msort.sort(a);
		System.out.print("自顶向下归并排序(乱序)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序结果:"+msort.isSorted(a));
		System.out.println("自顶向下归并排序(顺序)开始......");
		time = new Stopwatch();
		msort.sort(a);
		System.out.print("自顶向下归并排序(顺序)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序结果:"+msort.isSorted(a));
		
		StdRandom.shuffle(a); //打乱数组 
		 
		System.out.println("自底向上归并排序(乱序)开始......");
		time = new Stopwatch();
		msort.sortBu(a);;
		System.out.print("自底向上归并排序(乱序)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序结果:"+msort.isSorted(a));
		System.out.println("自底向上归并排序(顺序)开始......");
		time = new Stopwatch();
		msort.sortBu(a);
		System.out.print("自底向上归并排序(顺序)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序并结果:"+msort.isSorted(a));
		 */
		/*StdRandom.shuffle(a); //打乱数组 
	
		System.out.println("快速排序(随机)开始......");
		Quick qsort = new Quick();
		time = new Stopwatch();
		qsort.sort(a);
		System.out.print("快速排序(随机)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序结果:"+qsort.isSorted(a));
		System.out.println("三向切分快速排序(随机)开始......");
		time = new Stopwatch();
		qsort.sort3way(a);
		System.out.print("三向切分快速排序(随机)结束，用时："+time.elapsedTime()+"s ");
		System.out.println("排序结果:"+qsort.isSorted(a));
		*/
		String [] a = {"-","S","O","R","T","E","X","A","M","P","L","E"};
		HeapSort hp = new HeapSort();
		//Heap.sort(a);
		hp.sort(a);
		//hp.construct(a);
		hp.showAll(a);
		
	}
}
