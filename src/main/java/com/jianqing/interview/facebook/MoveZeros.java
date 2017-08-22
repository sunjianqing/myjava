package com.jianqing.interview.facebook;

/**
 * Created by jianqing_sun on 5/8/17.
 * 把所有不是0的数字移动到最左边
 *
 *
 * https://gist.github.com/gcrfelix/76e265bdc5407fad7d2d
 * 一个数组中将所有的非零元素移动到数组最前面，返回零的个数，
 比如[1,0,3,0,4,5,0,1] => [1,3,4,5,1, X,X,X] 顺序不要紧，移动之后数组后面几个元素可以是任意值
 要求移动次数最少

 解法：
 两种情况，

 第一种，如果数组中大部分是0的情况，使用remove dups的解法，这样移动次数最少
 public int moveZeros(int[] nums) {
 if(nums == null || nums.length == 0) {
 return;
 }
 int index = 0;
 for(int i=0; i<nums.length; i++) {
 if(nums[i] != 0) {
 nums[index++] = nums[i];
 }
 }
 return nums.length - index;
 }

 第二种情况，如果数组中大部分是非0的情况，以上方法会让大部分数字重新赋值，所以移动次数多
 这时候我们可以采用类似sort colors的做法，使用two pointers使移动次数最少
 但是这种方法会打乱原数组的relative order
 public class MoveZeroBack {
 public static void moveZeroBack(int[] nums) {
 if (nums == null || nums.length == 0) {
 return;
 }
 int start = 0;
 int end = nums.length - 1;
 while (start <= end) {
 if (nums[end] == 0) {
 end--;
 continue;
 }
 if (nums[start] != 0) {
 start++;
 continue;
 }

 //minimize write operations
 nums[start] = nums[end];
 end --;
 //swap(nums, start, end);
 }
 }

 private static void swap(int[] nums, int i, int j) {
 int tmp = nums[i];
 nums[i] = nums[j];
 nums[j] = tmp;
 }

 private static void printArray(int[] nums) {
 for (int i = 0; i < nums.length; i++) {
 System.out.print(nums[i] + " ");
 }
 System.out.println();
 }
 }

 */
public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
//        mz.solution(new int[]{0,3,1,3,0,0});
        int[] arr = new int[]{0,3,1,3,0,0};
        mz.solution(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print( arr[i] + " ");
        }
    }

    public void moveZeroes(int[] nums) {
        int zeroIndex = 0, i = 0;

        // 将非0数字都尽可能向前排,但是没交换
        for (; i< nums.length ; i ++){
            if (nums[i] != 0 ){
                nums[zeroIndex] = nums[i];
                zeroIndex ++;
            }
        }

        // 将剩余的都置0
        for(;zeroIndex<nums.length; zeroIndex++){
            nums[zeroIndex] = 0;
        }
    }


    public void solution(int[] array) {
        int p1 = 0, p2 = 0;
        while (p2 < array.length) {
            if (array[p2] == 0)
                break;
            p2++;
        }

        if (p2 == array.length)
            return;

        p1 = p2;
        while (p1 < array.length) {
            if (array[p1] == 0) {
                p1++;
            } else {
                int tmp = array[p1];
                array[p1] = array[p2];
                array[p2] = tmp;
                p1++;
                p2++;
            }
        }
    }
}
