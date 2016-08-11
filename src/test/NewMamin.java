package test;
import java.util.ArrayList;
import java.util.Scanner;
public class NewMamin {
	public static void main(String []args){
		Scanner cin = new Scanner(System.in);
		String []str = cin.nextLine().split(" "); 
		int [] books = new int [Integer.parseInt(str[0])];
		for(int i = 0; i < books.length ; i ++){
			books[i] = Integer.parseInt(str[i+1]);
		}
		System.out.println(getMin(books));
	}

	public static int getMin(int []arr) {  
		ArrayList<Integer> list = new ArrayList<Integer>();  
	     for (int num : arr) {
	    	 list.add(num);  
	     }
	     int res = 0;  
	     while (list.size() > 1) {  
	         int pos = -1;  
	         int mn = Integer.MAX_VALUE;  
	         for (int i = 0; i < list.size(); ++i) {  
	             int tmp = list.get(i) + list.get((i + 1) % list.size());  
	             if (tmp < mn) {  
	                 mn = tmp;  
	                 pos = i;  
	             }  
	         }  
	         int tmp = list.get(pos) + list.get((pos + 1) % list.size());  
	         res += tmp;  
	         if (pos == list.size() - 1) {
	        	 //如果pos在末尾，则删除第一个和最后一个
	             list.remove(pos);  
	             list.remove(0);  
	             list.add(tmp);  
	         }  
	         else {  
	        	 //如果在中间，则删除两次Pos，因为每次删除都会有元素补位
	             list.remove(pos);  
	             list.remove(pos);  
	             list.add(pos, tmp);  
	         }  
	     }  
	     return res;  
    }
}
   /* 
     	public static int getSum(int[] arr,int i, int j) {  
	        int res = 0;  
	        for (int k = i; k % arr.length != j; ++k) {  
	            res += arr[k % arr.length];  
	        }  
	        return res + arr[j];  
	    }
     public static int getMin(int []arr) {  
        int len = arr.length;  
        int[][] dp = new int[len][len];       
        for (int i = 0; i < len; ++i) {
        		dp[i][i] = 0;
        }  
        int res = Integer.MAX_VALUE;  
        for (int l = 2; l <= len; ++l) {  
            for (int i = 0; i < len; ++i) {  
                int r = (i + l - 1) % len;  
                dp[i][r] = Integer.MAX_VALUE;  
                for (int k = i; k % len != r; ++k) {                      
                    dp[i][r] = Math.min(dp[i][r], dp[i][k % len] + dp[(k + 1) % len][r] + getSum(arr,i, r));  
                }  
                if (l == len) {
                	res = Math.min(res, dp[i][(i - 1 + len) % len]);  
                }
            }             
        }  
        return res;  
    }  */
