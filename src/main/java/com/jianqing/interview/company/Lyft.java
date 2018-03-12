package com.jianqing.interview.company;

/**
 * Created by jianqing_sun on 3/8/18.
 */
public class Lyft {

    /*
        abc + 2 -> cde

        aBC + 2 -> cDE

        xyz + 2 --> zab
     */

    public static void main(String[] args) {
        Lyft lyft = new Lyft();

        String abc = lyft.CeasarCipher("zBC", 2);
        System.out.println(abc);

    }
    public String CeasarCipher(String s, int n){
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            if(Character.isLowerCase(c)){
                if(c + 2 > 'z' ){
                    sb.append((char)(c-'y'+'a'));
                }
                else{
                    sb.append((char)(c + 2));
                }
            }
            else{
                if(c + 2 > 'Z' ){
                    sb.append((char)(c-'Y'+'A'));
                }
                else{
                    sb.append((char)(c + 2));
                }
            }
        }

        return sb.toString();
    }

    /*
        俩稀疏向量相加
        要么build 俩map， 在相应的的key （其实是那个维度上相加）
        要么就是build 一个map， 去另一个vector 里， 做binary search 每一个map的key， 再相加
     */
    public void  AddTwoSparseVector(int[] n1, int[] n2){
        return;
    }
}
