package sort;


/**
 * ѡ������ÿ����δ���򲿷�ѡ��һ����С�ķŵ�ǰ�棬������Сֵ�ı������ƶ�һλ
 * �ص㣺1.����ʱ��������޹أ����ǲ�û���ã���Ϊ��ʹ����ʱ������ģ���Ȼ����б�����Ƚϣ����ӶȲ��䣩
 * 	   2.�����ƶ��������ٵģ���Ϊÿ��ֻ�ƶ�һ��Ԫ�أ��ƶ�N��
 * ʱ�临�Ӷȣ��n^2,����n^2ƽ��n^2
 * ȱ�㣺δ���򲿷��������ԻᾡϤ����
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
					min = j; //����δ���򲿷��ҵ���СԪ��
				}
			}
			exch(a,min,i); //��δ���򲿷ֵ���СԪ�طŵ�ǰ��
		}
	}
}
