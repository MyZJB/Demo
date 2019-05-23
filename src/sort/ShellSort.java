package sort;

import java.util.Arrays;

/**
 * 希尔排序 Java  2019/03/23
 */
public class ShellSort {

    /**
     * 希尔排序
     * @param a --待排序的数组
     * @param n --数组的长度
     */
    private static void shellSort(int[] a,int n){

        //gap为步长，每次减为原来的一半
        for (int gap=n/2;gap>0;gap/=2){

            //共gap个组，对每一个组多执行直接插入排序
            for (int i=0;i<gap;i++){

                for (int j=i+gap;j<n;j+=gap){
                    //如果a[j]<a[j-gap],则寻找a[j]的位置，并将后面数据的位置多后移
                    if (a[j]<a[j-gap]){
                        int temp=a[j];
                        int k=j-gap;
                        while(k>=0&&a[k]>temp){
                            a[k+gap]=a[k];
                            k-=gap;
                        }
                        a[k+gap]=temp;
                    }
                }
            }
        }
    }

    /**
     * 对希尔排序中的单个组进行排序
     * @param a --待排序数组的长度
     * @param n --数组总的长度
     * @param i --组的起始位置
     * @param gap  --组的步长
     *
     *       组是"从i开始"，将相隔gap长度的数多取出"所组成的!
     */
    private static void groupSort(int[] a,int n,int i,int gap){
        for (int j=i+gap;j<n;j+=gap){

            //如果a[j]<a[j-gap],则寻找a[j]位置，并将后面数据的位置多后移。
            if (a[j]<a[j-gap]){
               int temp=a[j];
               int k=j-gap;
               while(k>=0&&a[k]>temp){
                   a[k+gap]=a[k];
                   k-=gap;
               }
               a[k+gap]=temp;
            }
        }
    }

    /**
     * 希尔排序
     *
     * @param a --待排序的数组
     * @param n --数组的长度
     */
    private static void shellSort2(int[] a,int n){
        //为gap为步长,每次减为原来的一半。
        for (int gap=n/2;gap>0;gap/=2){

            //共gap个组，对没一个组多执行直接插入排序
            for (int i=0;i<gap;i++){
                groupSort(a,n,i,gap);
            }

        }
    }

    public static void main(String[] args) {
        int[] arr={80,30,60,40,20,10,50,70};
        System.out.println("Before Sort:");
        System.out.println(Arrays.toString(arr));

        shellSort(arr,arr.length);
        //shellSort2(arr,arr.length);
        System.out.println("After Sort:");
        System.out.println(Arrays.toString(arr));

    }


}
