package utils;

/**
 * java排序算法
 *
 * @author liaohong
 * @since 2019/7/22 9:54
 */
public class SortMethords {

    /**
     * 交换值
     *
     * @param a
     * @param b
     */
    void swap(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    void print(int arr[]) {
        if (arr == null || arr.length == 0) {
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "--");
            }
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(N2) 　　稳定性：稳定
     *
     * @param arr
     * @return
     */
    public int[] bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * 首先初始化最小元素索引值为首元素，依次遍历待排序数列，
     * 若遇到小于该最小索引位置处的元素则刷新最小索引为该较小元素的位置，直至遇到尾元素，结束一次遍历，
     * 并将最小索引处元素与首元素交换；然后，初始化最小索引值为第二个待排序数列元素位置，
     * 同样的操作，可得到数列第二个元素即为次小元素；以此类推。
     * 时间复杂度：O(N2) 　　稳定性：不稳定
     *
     * @param arr
     * @return
     */
    public int[] selectSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (arr[i] > arr[minIndex]) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    /**
     * 快速排序
     * 类似于选择排序的定位思想）选一基准元素，依次将剩余元素中小于该基准元素的值放置其左侧，
     * 大于等于该基准元素的值放置其右侧；然后，取基准元素的前半部分和后半部分分别进行同样的处理；
     * 以此类推，直至各子序列剩余一个元素时，即排序完成（类比二叉树的思想，from up to down）
     * 时间复杂度：O(NlogN) 　　稳定性：不稳定
     *
     * @param arr
     * @return
     */
    public void quickSort(int arr[], int left, int right) {
        if (left < right) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, left, right);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, 0, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    private int getIndex(int[] arr, int left, int right) {
        // 基准数据
        int tmp = arr[left];
        while (left < right) {
            // 当队尾的元素大于等于基准数据时,向前挪动right指针
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给left
            arr[left] = arr[right];
            // 当队首元素小于等于tmp时,向前挪动left指针
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            // 当队首元素大于tmp时,需要将其赋值给right
            arr[right] = arr[left];

        }
        // 跳出循环时left和right相等,此时的left或right就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道left位置的值并不是tmp,所以需要将tmp赋值给arr[left]
        arr[left] = tmp;
        return left; // 返回tmp的正确位置
    }

    /**
     * 插入排序
     * 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * 时间复杂度：O(N2) 　　稳定性：稳定
     *
     * @param arr
     * @return
     */
    public int[] insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 && arr[j] < arr[j - 1]; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        SortMethords sortMethords = new SortMethords();
//        int[] ints = sortMethords.bubbleSort(arr);
//        int[] ints1 = sortMethords.selectSort(arr);
        int[] ints = sortMethords.insertSort(arr);
        sortMethords.print(ints);
    }

}
