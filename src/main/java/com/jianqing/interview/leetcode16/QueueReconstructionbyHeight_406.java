package com.jianqing.interview.leetcode16;

import java.util.*;

/**
 * Created by jianqingsun on 12/14/16.
 */
public class QueueReconstructionbyHeight_406 implements Solution {

    public static void main(String[] args) {
        QueueReconstructionbyHeight_406 question = new QueueReconstructionbyHeight_406();
        question.solution();
    }

    @Override
    public void solution() {
        int[][] data = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] data1 = {{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}};

        this.reconstructQueue(data1);

    }

    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][2];
        TmpPair[] arrayList = new TmpPair[people.length];

        for ( int i = 0 ; i < people.length ; i++){
            arrayList[i] = new TmpPair(people[i][0], people[i][1]);
        }

        Arrays.sort(arrayList, new Comparator<TmpPair>() {
            @Override
            public int compare(TmpPair o1, TmpPair o2) {
                if( o1.height < o2.height){
                    return 1;
                }
                else if (o1.height > o2.height){
                    return -1;
                }

                if(o1.k > o2.k)
                    return 1;
                else if (o1.k < o2.k)
                    return -1;

                return 0;
            }
        });

        List<TmpPair> list = new ArrayList<>(arrayList.length);

        for(int i = 0; i< arrayList.length; i++){
            list.add(arrayList[i].k, arrayList[i]);
        }


        int i = 0;
        int j = 0;
        while( i < people.length){
            if(list.get(j) != null){
                res[i][0] = list.get(j).height;
                res[i][1] = list.get(j).k;
                i++;
            }
            j++;
        }

        return res;

    }


    private void swap(int[][] people,int a,int b){
        int t1=people[a][0],t2=people[a][1];
        people[a][0] = people[b][0];
        people[a][1] = people[b][1];
        people[b][0] = t1;
        people[b][1] = t2;

    }
    public int[][] reconstructQueue1(int[][] people) {
        //java 排序不方便，我这里就直接暴力排序了
        //让身高按照降序排列，高的在前面，同身高的情况下让要求前面人数人少的在前面，就可以了
        int n = people.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(people[i][0] < people[j][0])
                    swap(people,i,j);
                else if(people[i][0] == people[j][0] && people[i][1] > people[j][1])
                    swap(people,i,j);
            }
        }
        //按照顺序插入
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            la.add(people[i][1],people[i][0]);
            lb.add(people[i][1],people[i][1]);
        }
        for(int i=0;i<n;i++){
            people[i][0]=la.get(i);
            people[i][1]=lb.get(i);
        }
        return people;

    }

    class TmpPair{
        public int height;
        public int k;

        public TmpPair(int height, int k) {
            this.height = height;
            this.k = k;
        }
    }
}
