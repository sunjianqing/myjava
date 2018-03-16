package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  Created by jianqing_sun on 3/6/18.

Example 1:
Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

Example 2:
Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)

*/
public class NestedListWeightSumII_364 {
    public static void main(String[] args) {
        NestedListWeightSumII_364 nws = new NestedListWeightSumII_364();

        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger() {

            @Override
            public boolean isInteger() {
                return true;
            }

            @Override
            public Integer getInteger() {
                return 2;
            }

            @Override
            public List<NestedInteger> getList() {
                return null;
            }
        });

        nestedList.add(new NestedInteger() {

            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                return Arrays.asList(new NestedInteger() {

                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                }, new NestedInteger() {

                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });
            }
        });

        nestedList.add(new NestedInteger() {

            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                return Arrays.asList(new NestedInteger() {

                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                }, new NestedInteger() {

                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });
            }
        });

        int res = nws.depthSumInverse(nestedList);

        System.out.println(res);
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        // find max depth
        int max = maxDepth(nestedList, 1);

        // compute sum
        int res = sum(nestedList, max);

        return res;
    }

    private int sum(List<NestedInteger> list, int curDepth) {
        int sum = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) {
                sum += n.getInteger() * curDepth;
            } else {
                sum += sum(n.getList(), curDepth - 1);
            }
        }

        return sum;
    }

    private int maxDepth(List<NestedInteger> list, int depth) {
        int max = depth;
        if (!list.isEmpty()) {
            for (NestedInteger n : list) {
                if (!n.isInteger()) {
                    max = Math.max(max, maxDepth(n.getList(), depth + 1));
                }
            }
        }

        return max;
    }


    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
