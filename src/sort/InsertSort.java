package sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * 2019/05/22
 *
 * 直接插入排序(Straight Insertion Sort)的基本思想是：
 *    把n个待排序的元素看成为一个有序表和一个无序表。
 *   开始时有序表中只包含1个元素，无序表中包含n-1个元素，排序过程中每次从元素表中取出每一个元素，将它插入到有序表中的适当的位置
 *   使之成为新的有序表，重复n-1次可完成排序过程
 */
public class InsertSort {

    /**
     * 直接插入排序
     * @param a --待排序的数组
     * @param n --数组的长度
     */
    private static void insert_sort(int[] a,int n){
        int i,j,k;
        for (i=1;i<n;i++){

            //为a[i]在前面a[0....i-1]有序区间找一个合适的位置
            for (j=i-1;j>=0;j--){
                if (a[j]<a[i]){
                    break;
                }
            }
            //如找到了一个合适的位置
            if (j!=i-1){
                //将比a[i]大的数据向后偏移
                int temp=a[i];
                for (k=i-1;k>j;k--) {
                    a[k + 1] = a[k];
                }
                    //将a[i]放到正确的位置上
                    a[k+1]=temp;

            }
        }
    }



    public static void main(String[] args) {
        int[] arr={20,40,30,10,60,50};
        System.out.println("Insert sort before");
        System.out.println(Arrays.toString(arr));

        insert_sort(arr,arr.length);

        System.out.println("Insert sort after");
        System.out.println(Arrays.toString(arr));
    }
}
