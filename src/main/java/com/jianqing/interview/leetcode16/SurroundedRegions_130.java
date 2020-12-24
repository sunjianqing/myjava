package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/21/18.
 * <p>
 * 两种解法，
 * <p>
 * Method 1 (DFS)： 把四个边上的所有O换成1， 并且跟这些1相连的也都换成1
 * 然后board 里所有的O 就都是要找的element了， 把它们都换成X，然后把1 都换回来
 * <p>
 * Method 2： Union Find 如果O在四边上， 把它归到一个组， 其余的O跟它的邻居归到一起， 最后再扫一遍， 如果O不在四边的那个组， 就设为X
 */
public class SurroundedRegions_130 {

    public void method2(char[][] board) {
        if(board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;

        UF uf = new UF(m * n + 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if( board[i][j] == 'O' && (i == 0 || i == m - 1|| j == 0 || j == n - 1)){
                    uf.union(i*n + j, m*n); // if a 'O' node is on the boundry, connect it to the dummy node （用最后一个点, m*n index 那个点作为 dummy node ）
                }
                else if(board[i][j] == 'O'){
                    if(board[i-1][j] == 'O'){
                        uf.union(i*n + j, (i-1)*n + j);
                    }

                    if(board[i+1][j] == 'O'){
                        uf.union(i*n + j, (i+1)*n + j);
                    }

                    if(board[i][j-1] == 'O'){
                        uf.union(i*n + j, i*n + j -1 );
                    }

                    if(board[i][j+1] == 'O'){
                        uf.union(i*n + j, i*n + j + 1 );
                    }
                }
            }
        }

        // 最后扫一遍 跟 dummy node 比
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 'O'){
                    if(!uf.connected(i*n + j, m*n)){ // 是 0 ， 并且不跟dummy node （用最后一个点, m*n index 那个点作为 dummy node ） 连着， 就设成X
                        board[i][j] = 'X';
                    }
                }
            }
        }

    }

}

class UF {
    int[] parents;

    UF(int n) {
        parents = new int[n + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    int find(int p) {
        while (p != parents[p]) {
            parents[p] = parents[parents[p]]; // 路径压缩
            p = parents[p];
        }
        return p;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    void union(int p, int q) {
        int proot = find(p); // proot 就是一路按照parent index找的， 直到某个点的parent 是它本身
        int qroot = find(q);

        if (proot != qroot) {
            parents[proot] = qroot;
        }
    }
}
