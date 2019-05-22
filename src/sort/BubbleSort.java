package sort;

/**
 * 冒泡排序: Java
 * 2019/05/21
 * 冒泡排序(Bubble Sort) 又被称为气泡排序或泡沫排序，它是一种较简单的排序算法。它会遍历若干次要排序的数列
 * 每次遍历时，它都会从前往后依次的比较两个相邻的数的大小，如果前者比后者大，则交换他们的位置
 * 这样，一次遍历之后，最大的元素就在数列的未尾，采用相同的方法再次遍历时，第二大的元素就被排列在最大元素之前，重复此操作，知道整个数列多有序为止
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param a --待排序的数组
     * @param n --数组的长度
     */
    public static void bubbleSort1(int[] a,int n){
        int i,j;
        for (i=n-1;i>0;i--){
            //将a[0....i]中最大的数据放在未尾
            for (j=0;j<i;j++){
                if (a[j]>a[j+1]){
                    //交换a[j]和a[j+1]
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序 (改进版)
     * @param a  --待排序的数组
     * @param n  --数组的长度
     */
    public static void bubbleSort2(int[] a,int n){
        int i,j;
        int flag; //标记

        for (i=n-1;i>0;i--){
            flag=0; //初始化标记为0
            //将a[0...i]中最大的数据放在未尾
            for (j=0;j<i;j++){
                if (a[j]>a[j+1]){
                    //交换a[j]和a[j+1]
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;

                    flag=1; //若发生交换，则设标记为1
                }
            }

            if (flag==0){
                break; //若没发生交换，则说明数列已有序
            }
        }
    }


    public static void bubbleSort3(int[] arr,int n){
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int i;
        int[] arr={20,30,50,40,10,60,80,70};
        System.out.println("before sort:");
        for (i=0;i< arr.length;i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n");
        bubbleSort3(arr, arr.length);
        //bubbleSort2(a, a.length);

        System.out.println("after sort:");
        for (i=0;i< arr.length;i++){
            System.out.printf("%d ", arr[i]);
        }
    }
}
