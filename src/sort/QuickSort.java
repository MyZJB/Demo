package sort;

import java.util.Arrays;

/**
 * 快速排序:java
 * 2019/05/22
 *
 * 快速排序(QuickSort) 使用分治法策略，它的基本思想是选择一个基准数，通过一趟排序将要排序的数据
 * 分割成立的两部分，其中一部分的所有数据多比另外一部分的数据要小。
 * 然后在按此方法对这两部分数据进行快速排序，整个排序过程可以递归进行，如此达到整个数据变成有序序列。
 */
public class QuickSort {

    /**
     *  快速排序
     * @param a --待排序的数组
     * @param l --数组的左边界(例如，从起始位置开始排序,则l=0)
     * @param r --数组的右边界(例如，排序截至到数组未尾，则r=a.length-1)
     */
    public static void quickSort(int[] a,int l,int r){
          if (l<r){
              int i,j,x;

              i=l;
              j=r;
              x=a[i];
              while (i<j){
                  while (i<j&&a[j]>x){  //i<j并且a的数组j下标元素大于x  j就减1
                      j--;  //从右向左找到一个小于x的数
                  }
                  if (i<j){   //如果i<j  将a[j]的值交换到a[i++]位置
                      a[i++]=a[j];
                  }
                  while (i<j&&a[i]<x){  //如果i<j并且a[i]的值小于x i就加1
                      i++; //从左向右找到一个大于x的数
                  }
                  if (i<j){  //如果i<j a[j--]=a[i]
                      a[j--]=a[i];
                  }

              }
              System.out.println(Arrays.toString(a));
              a[i]=x;
              quickSort(a,l,i-1); //递归调用
              quickSort(a,i+1,r); //递归调用

          }
    }

    public static void main(String[] args) {
        int[] arr={30,40,60,10,20,50};
        System.out.println("before sort");
        System.out.println(Arrays.toString(arr));

        quickSort(arr,0,arr.length-1);
        System.out.println("after sort");
        System.out.println(Arrays.toString(arr));
    }
}
