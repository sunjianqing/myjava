package com.jianqing.interview.classic;

/**
 * Created by jianqingsun on 10/28/17.
 *
 * 除了最基础的union find , 还有优化版本的， QuickUnion ， 用到了树结构， 去存储编/组 号。
 * Weighted QuickUnion 也是用树结构，但是考虑union 两树的时候， 树的大小， 尽量把小树merge 到大树里
 */
public class UnionFind {
    int count;
    int[] father;

    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) { // 初始化， 有n个联通分量
            father[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    // 查找所属联通分量
    public int find(int x) {
        return father[x];
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        for (int i = 0; i < father.length; i++) {
            if (father[i] == rootP) {
                // 遍历, 把所有id与p相同的元素都与q连接(id置为相同)
                father[i] = rootQ;
            }
        }

        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

}

class QuickUnionFind {
    int count;
    int[] id;

    int find(int i)
    {
        // 计算元素i的根节点
        // 使用深度优先巧妙的避开问题的规模,
        // 但是需要注意构造树的深度
        while (i != id[i])
        {
            i = id[i];  // 向父节点查找
        } // DFS
        return i;
    }

    public void union(int p, int q)
    {
        // Give p and q the same root.
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        id[rootP] = rootQ;  // 将一颗树(即一个组)变成另外一课树(即一个组)的子树
        count--;
    }
}