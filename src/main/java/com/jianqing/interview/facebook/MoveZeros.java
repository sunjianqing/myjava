package com.jianqing.interview.facebook;

/**
 * Created by jianqing_sun on 5/8/17.
 * 把所有不是0的数字移动到最左边
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
