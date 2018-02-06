package com.jianqing.interview.company;

/**
 * Created by jianqing_sun on 1/23/18.
 */
public class GS {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1,1, 3,4);
        System.out.println(rectangle);

        RPoint l2 = new RPoint(3,10);
        RPoint r2 = new RPoint(5,8);

        RPoint l1 = new RPoint(0,2);

        RPoint r1 = new RPoint(10,0);

        GS gs = new GS();
        boolean b = gs.doOverlap(l1, r1, l2, r2);
        System.out.println(b);

    }

    boolean doOverlap(RPoint l1, RPoint r1, RPoint l2, RPoint r2)
    {
        // 四个有一个为true 了， 就说明没重合， 因为重合的情况下，
        // If one rectangle is on left side of other
        if (l1.x > r2.x || l2.x > r1.x)
            return false;

        // If one rectangle is above other
        if (l1.y < r2.y || l2.y < r1.y)
            return false;

        return true;
    }
}

class Rectangle{
    int row;
    int col;
    int width;
    int height;

    public Rectangle(int row, int col, int width, int height) {
        this.row = row;
        this.col = col;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "row=" + row +
                ", col=" + col +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}

class RPoint{
    int x;
    int y;

    public RPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
