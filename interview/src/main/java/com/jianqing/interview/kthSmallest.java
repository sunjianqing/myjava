package com.jianqing.interview;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/19/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class KthSmallest {

    public int[] a = new int[]{2, 4, 5, 7, 9};
    public int[] b = new int[]{1, 3, 5, 6, 12, 13};

    public Integer solution(int[] a , int[] b , int k){

        int i = 0 , j = 0;
        while(i < a.length && j< b.length){
            if(a[i] < b[j]){
                if(i+j+1 == k)
                    return a[i];
                else
                    i++;
            }
            else if(a[i] > b[j]){
                if(i+j+1 == k){
                    return b[j];
                }
                else
                    j++;
            }
            else {
                //a[i] = b[j]
                if(i+j+1 == k){
                    return a[i]; // or b[j]
                }

                if(i+j+1+1 == k){
                    // because i and j will be increased , the sum of i and j will be increased 2, we may miss the k
                    return a[i]; // or b[j]
                }

                i++;
                j++;
            }

        }
        return null;
    }

    public static void main(String[] args){
        KthSmallest ks = new KthSmallest();
        int solution =  ks.solution(ks.a,ks.b,7);
        System.out.println(solution);

    }

}
