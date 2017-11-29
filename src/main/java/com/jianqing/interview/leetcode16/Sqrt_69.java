package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 11/5/17.
 * 求平方根
 *
 * 二分法
 * 牛顿迭代法 （快） Newton's Iteration
 *
 *求出根号a的近似值：首先随便猜一个近似值x，然后不断令x等于x和a/x的平均数，迭代个六七次后x的值就已经相当精确了。
 例如，我想求根号2等于多少。假如我猜测的结果为4，虽然错的离谱，但你可以看到使用牛顿迭代法后这个值很快就趋近于根号2了：
 (4 + 2/4) / 2 = 2.25
 (2.25 + 2/2.25) / 2 = 1.56944..
 (1.56944.. + 2/1.56944..) / 2 = 1.42189..
 (1.42189.. + 2/1.42189..) / 2 = 1.41423.
 */
public class Sqrt_69 {

    float accuracy = 0.0001f;

    public static void main(String[] args) {
        Sqrt_69 s = new Sqrt_69();
        float sqrtnewton = s.sqrtnewton(15);
        System.out.println(sqrtnewton);
    }
    public int sqrt(int n) {
        int x = 1;
        int y = n;
        while( x <= y) {
            int mid = x + (y -x ) /2 ;
            if(mid * mid > n) {
                y = mid -1 ;
            }
            else{
                x = mid +1;
            }
        }
        return y;
    }

    public float sqrtnewton(int n) {
        float x = (float) n /2 ;

        while(Math.abs(x*x - n) > accuracy ) {
            x = (x + n / x) / 2 ;
        }
        return x;

    }

}
