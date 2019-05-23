package sort;

import java.util.Arrays;

/**
 * 选择排序 2019/05/23
 *
 * 选择排序(selection sort)是一种简单直观的排序算法。
 * 它的基本思想是:首先在未排序的数列中找到最小(or最大的元素)，然后将其存放在数列的起始位置；
 * 接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，然后放到已排序序列的未尾。
 * 以此类推，直到所有元素均排序完毕
 */
public class SelectSort {

    /**
     * 选择排序
     * @param arr  --待排序的数组
     * @param n    --待排序数组的长度
     */
    private static void selectSort(int[] arr,int n){
        int i;  //有序区未尾位置
        int j;  //无序区的起始位置
        int min;  //无序区中最小元素的位置
        for (i=0;i<n;i++){

            min=i;

            //找出"a[i+1] ... a[n]"之间的最小元素,并赋值给min
            for (j=i+1;j<n;j++){
                if (arr[j]<arr[min]){
                    min=j;
                }
            }

            //若min!=i,则交换a[i]和a[min]
            //交换之后，保证了a[0] ... a[i]之间的元素是有序的
            if (min!=i){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }

        }

    }

    public static void main(String[] args) {
        int[] arr={50,20,40,60,30,10};
        System.out.println("select sort before");
        System.out.println(Arrays.toString(arr));

        selectSort(arr,arr.length);
        System.out.println("select sort after");
        System.out.println(Arrays.toString(arr));
    }
}
