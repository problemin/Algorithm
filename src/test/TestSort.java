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
 * ѡ�����������
 * @author Problemin
 *
 */
public class TestSort {
	public static void main(String []args){

		int Max =10;
		Stopwatch time;
		Random rand = new Random();
		SortBase sort ;
		//���ڱȽϴ�С��Ҫʵ��Comparable����Ҫʹ��Integer����
		/*Integer [] a =new Integer[Max];
		System.out.println("��ʼ�����ݣ�"+Max+"����ֵ��"+Max+"���ڵ��������......");
		for(int i = 0; i < Max; i++){
			a[i] = rand.nextInt(Max);
		}   */
		System.out.println("��ʼ���������......"); 
		/*
 		System.out.println("ѡ������(����)��ʼ......");
		sort = new Selection();
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("ѡ������(����)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("������:"+sort.isSorted(a));
		System.out.println("ѡ������(˳��)��ʼ......");
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("ѡ������(˳��)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("������:"+sort.isSorted(a));
		
		StdRandom.shuffle(a); //�������� 
	
		System.out.println("��������(����)��ʼ......");
		sort = new Insertion();
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("��������(����)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("������:"+sort.isSorted(a));
		System.out.println("��������(˳��)��ʼ......");
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("��������(˳��)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("������:"+sort.isSorted(a));
		
		StdRandom.shuffle(a); //�������� 
		 
		System.out.println("ϣ������(����)��ʼ......");
		sort = new Shell();
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("ϣ������(����)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("������:"+sort.isSorted(a));
		System.out.println("ϣ������(˳��)��ʼ......");
		time = new Stopwatch();
		sort.sort(a);
		System.out.print("ϣ������(˳��)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("������:"+sort.isSorted(a));
		
		StdRandom.shuffle(a); //�������� 
		
		System.out.println("�Զ����¹鲢����(����)��ʼ......");
		Merge msort = new Merge();
		time = new Stopwatch();
		msort.sort(a);
		System.out.print("�Զ����¹鲢����(����)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("������:"+msort.isSorted(a));
		System.out.println("�Զ����¹鲢����(˳��)��ʼ......");
		time = new Stopwatch();
		msort.sort(a);
		System.out.print("�Զ����¹鲢����(˳��)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("������:"+msort.isSorted(a));
		
		StdRandom.shuffle(a); //�������� 
		 
		System.out.println("�Ե����Ϲ鲢����(����)��ʼ......");
		time = new Stopwatch();
		msort.sortBu(a);;
		System.out.print("�Ե����Ϲ鲢����(����)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("������:"+msort.isSorted(a));
		System.out.println("�Ե����Ϲ鲢����(˳��)��ʼ......");
		time = new Stopwatch();
		msort.sortBu(a);
		System.out.print("�Ե����Ϲ鲢����(˳��)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("���򲢽��:"+msort.isSorted(a));
		 */
		/*StdRandom.shuffle(a); //�������� 
	
		System.out.println("��������(���)��ʼ......");
		Quick qsort = new Quick();
		time = new Stopwatch();
		qsort.sort(a);
		System.out.print("��������(���)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("������:"+qsort.isSorted(a));
		System.out.println("�����зֿ�������(���)��ʼ......");
		time = new Stopwatch();
		qsort.sort3way(a);
		System.out.print("�����зֿ�������(���)��������ʱ��"+time.elapsedTime()+"s ");
		System.out.println("������:"+qsort.isSorted(a));
		*/
		String [] a = {"-","S","O","R","T","E","X","A","M","P","L","E"};
		HeapSort hp = new HeapSort();
		//Heap.sort(a);
		hp.sort(a);
		//hp.construct(a);
		hp.showAll(a);
		
	}
}
