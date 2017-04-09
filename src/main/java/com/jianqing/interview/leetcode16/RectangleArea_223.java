package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 3/13/17.
 */
public class RectangleArea_223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int overlap = overlap(A, B, C, D, E, F, G, H);

        // total is area1 + area2 - overlap
        return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
    }

    public int overlap(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length, width = 0;
        if (A > E) {
            if (A <= G) {
                if (C < G) {
                    length = C - A;
                } else {
                    length = G - A;
                }
            } else {
                return 0;
            }
        } else {
            if (C >= E) {
                if (C <= G) {
                    length = C - E;
                } else {
                    length = G - E;
                }
            } else
                return 0;
        }

        if (B > F) {
            if (B <= H) {
                if (D <= H)
                    width = D - B;
                else
                    width = H - B;
            } else
                return 0;
        } else {
            if (F <= D) {
                if (H <= D) {
                    width = H - F;
                } else {
                    width = D - F;
                }
            } else
                return 0;
        }

        return length * width;
    }

    public int solution2(int A, int B, int C, int D, int E, int F, int G, int H){
        if(C<E||G<A )
            return (G-E)*(H-F) + (C-A)*(D-B);

        if(D<F || H<B)
            return (G-E)*(H-F) + (C-A)*(D-B);

        int right = Math.min(C,G);
        int left = Math.max(A,E);
        int top = Math.min(H,D);
        int bottom = Math.max(F,B);

        return (G-E)*(H-F) + (C-A)*(D-B) - (right-left)*(top-bottom);
    }

}
