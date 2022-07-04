import java.util.Arrays;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] a = {3,6,8,1,9,5,4,4};
        int[] merge = {8,4,5,7,1,3,6,2};
        int[] temp = new int[merge.length];
        int[] quick = {6,5,4,16,10,11,13,15};

//        insertionSort(a,a.length);

//        mergeSort(merge,0,merge.length-1,temp);

        quickSort(quick,0,quick.length-1);

        System.out.println(Arrays.toString(quick));
    }


    // 冒泡排序 a表示数组，n表示数组大小
    // 原地排序算法：空间复杂度为O(1) 时间复杂度，最好情况只排序一遍：O(n),最坏情况是数据刚好是倒序，需要O(n2)
    // 适合小规模数据量
    public static void bubbleSort(int[] a,int n){
        if (n <= 1)  return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n-i-1; ++j) {
                if (a[j] > a[j+1]){ // 交换
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    flag = true; // 表示有数据交换
                }
            }

            if (!flag) break; // 没有数据交换，提前退出

        }
    }



    // 插入排序，a表示数组，n表示数组大小
    // 原地排序算法：空间复杂度为O(1) 时间复杂度，最好情况只排序一遍：O(n),最坏情况是数据刚好是倒序，需要O(n2)
    // 适合小规模数据量
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }


    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void  mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr,left,mid,temp);
            //向右递归分解
            mergeSort(arr,mid +1,right,temp);

            merge(arr,left,mid,right,temp);
        }
    }

    // 合并的方法
    /**
     *
     * @param arr 排序的原始数据
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边有序序列的初始索引
     * @param temp 做中转的数组
     */
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left; // 初始化i，左边有序序列的初始索引
        int j = mid + 1 ; // 初始化j，右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        // (一)
        // 先把左右两边（有序）的数据按照规则填充到temp数组
        // 直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right){
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到temp数组
            if (arr[i] < arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else { // 反之，将右边有序序列的当前元素，拷贝到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次全部填充到temp
        while (i<=mid){ // 左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j<=right){ // 右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //(三)
        //将temp数组的额元素拷贝到arr
        //注意，并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        // 第一次合并tempLeft = 0,right = 1 // 第二次合并tempLeft = 2,right = 3 // 第一次合并tempLeft = 0,right = 3
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }


    // 快速排序
    public static void quickSort(int[] arr,int left,int right){
        int l = left; // 左下标
        int r = right; // 有下标
        // pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; // 临时变量，作为交换时使用
        //while循环的目的是让比pivot值小放到左边
        //比pivot值大放到右边
        while (l < r){
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot){
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot){
                r -= 1;
            }
            // 如果 1>=r说明pivot的左右两的值，已经按照左边全部是小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r){
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后，发现这个arr[l] == pivot值相等 r--,前移
            if(arr[l] == pivot){
                r -=1;
            }

            // 如果交换完后，发现这个arr[l] == pivot值相等 r--,前移
            if (arr[r] == pivot){
                l +=1;
            }

            // 如果 l == r,必须l++,r--,否则会出现栈溢出
            if (l == r){
                l += 1;
                r -= 1;
            }

            //向左递归
            if (left < r){
                quickSort(arr,left,r);
            }

            //向右递归
            if (right>1){
                quickSort(arr,l,right);
            }
        }
    }
}
