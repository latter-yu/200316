import java.util.Arrays;

public class T200316 {
    public static void main(String[] args) {
        //二维数组
        int[][] arr = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} };
        for (int row = 0; row < arr.length; row++) {//打印行
            for (int col = 0; col < arr[row].length; col++) {//打印列
                System.out.printf("%d\t", arr[row][col]);
            }
            System.out.println("");
            //1	 2	3	4
            //5  6	7	8
            //9  10	11	12
        }
    }

    public static void main5(String[] args) {
        //数组的逆置
        //设定两个下标, 分别指向第一个元素和最后一个元素. 交换两个位置的元素.
        //然后让前一个下标自增, 后一个下标自减, 循环继续即可.
        int[] arr = {1, 2, 3, 4};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
        //Arrays.toString(int[] a): 返回指定数组的内容的字符串表示形式。
        //System.out.println(arr);  输出的是数组首字母的地址
    }
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main4(String[] args) {
        //冒泡排序法
        //每次尝试找到当前待排序区间中最小(或最大)的元素, 放到数组最前面(或最后面).
        int[] arr = {1, 4, 8, 6, 3, 5, 2, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr) {
        // [0, bound) 构成了一个前闭后开区间, 表示已排序区间
        // [bound, length) 构成了一个前闭后开区间, 表示待排序区间
        //排序次数为arr.length-1
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = arr.length - 1 ; cur > bound; cur--) {
                if (arr[cur - 1] > arr[cur]) {
                    int tmp = arr[cur - 1];
                    arr[cur - 1] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }
    }

    public static void main3(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(arr1 == arr2);//false
        //arr1 == arr2 比较数组地址是否相同
        System.out.println(Arrays.equals(arr1, arr2));//true
        //arr.equals() 比较数组内容的大小
    }

    public static void main2(String[] args) {
        //查找指定数字(输出下标)
        int[] arr = {1, 4, 8, 6, 3, 5, 2};
        System.out.println(find(arr, 6));//3
    }
    public static int find(int[] arr, int n) {
        //for(int x : arr) 不可用，x为下标对应数字
        //输出：6
        for(int i = 0; i < arr.length; i++) {
            //i为下标
            if(arr[i] == n) {
                return i;
                //输出：3
            }
        }
        return -1;
    }

    public static void main1(String[] args) {
        //二分查找法（有序数组中）
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr, 3));//2
        //数组是引用，传递的是地址，无需定义新变量输出
    }
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (right+left)/2;
            if(arr[mid] < key) {
                //中间数小，去右侧区间找
                left = mid + 1;
            }else if(arr[mid] > key) {
                //中间数大，去左侧区间找
                right = mid -1;
            }else {
                //找到了
                return mid;
            }
        }
        //退出循环，没找到
        return -1;
    }
}
