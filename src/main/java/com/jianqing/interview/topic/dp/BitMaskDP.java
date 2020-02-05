package com.jianqing.interview.topic.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * https://www.geeksforgeeks.org/bitmasking-and-dynamic-programming-set-1-count-ways-to-assign-unique-cap-to-every-person/
 *
 *
 * There are 100 different types of caps each having a unique id from 1 to 100. Also, there are ‘n’ persons each having a collection of a variable number of caps. One day all of these persons decide to go in a party wearing a cap but to look unique they decided that none of them will wear the same type of cap. So, count the total number of arrangements or ways such that none of them is wearing the same type of cap.
 *
 * Constraints: 1 <= n <= 10 Example:
 *
 * The first line contains the value of n, next n lines contain collections
 * of all the n persons.
 * Input:
 * 3
 * 5 100 1     // Collection of the first person.
 * 2           // Collection of the second person.
 * 5 100       // Collection of the third person.
 *
 * Output:
 * 4
 * Explanation: All valid possible ways are (5, 2, 100),  (100, 2, 5),
 *             (1, 2, 5) and  (1, 2, 100)
 * Since, number of ways could be large, so output modulo 1000000007
 */
public class BitMaskDP {
    static final int MOD = 1000000007;

    // for input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // capList[i]'th vector contains the list of persons having a cap with id i
    // id is between 1 to 100 so we declared an array of 101 vectors as indexing
    // starts from 0.
    static Vector<Integer> capList[] = new Vector[101];


    // dp[2^10][101] .. in dp[i][j], i denotes the mask i.e., it tells that
    // how many and which persons are wearing cap. j denotes the first j caps
    // used. So, dp[i][j] tells the number ways we assign j caps to mask i
    // such that none of them wears the same cap
	/*
			10 个人 ， mask ， 就用 2^10
		dp 是 多少人 （mask 里的1 的个数）， 已经带上帽子， 那些帽子号 是小于 j的

		dp[1101000000][3]
		dp[1001010000][3]

		dp[0000000000][1] = dp[0000000000][2]
								+ sum(dp[1000000000][1] + dp[0001000000][1]) // 比如person 7 跟10 可以带帽子1

		dp[1010010000][20]

		dp[0000000000][2] 子问题 可能会产生dp[1000000000][3] ， 这个又是
		dp[1000000000][1] 需要的 （这就节省了重复计算时间）


		dp[1001000000][49]
			dp[1001000000][50]
				dp[1001000000][51]
					dp[1001000000][52]
						...

				caplist[50] 不为空，[2,3]
				dp[1001000100][51]
				dp[1001000010][51]
			caplist[49] ...

	*/
    static int dp[][] = new int[1025][101];

    // This is used for base case, it has all the N bits set
    // so, it tells whether all N persons are wearing a cap.
    static int allmask;

    // Mask is the set of persons, i is cap-id (OR the
    // number of caps processed starting from first cap).
    static long countWaysUtil(int mask, int i)
    {
        // If all persons are wearing a cap so we
        // are done and this is one way so return 1
        if (mask == allmask) return 1;

        // If not everyone is wearing a cap and also there are no more
        // caps left to process, so there is no way, thus return 0;
        if (i > 100) return 0;

        // If we already have solved this subproblem, return the answer.
        if (dp[mask][i] != -1) return dp[mask][i];

        // Ways, when we don't include this cap in our arrangement
        // or solution set.
        long ways = countWaysUtil(mask, i+1);

        // size is the total number of persons having cap with id i.
        // 有多少个人 可能会带 帽子 i
		/*
		 比如 person 1 : 2, 50, 88
		 	  person 2 : 1, 50, 66
		 	 capList[50] 就有 1,2 (person 号， 是按顺序的)
			*/
        int size = capList[i].size();

        // So, assign one by one ith cap to all the possible persons
        // and recur for remaining caps.
        for (int j = 0; j < size; j++)
        {
            // if person capList[i][j] is already wearing a cap so continue as
            // we cannot assign him this cap
            if ((mask & (1 << capList[i].get(j))) != 0) continue;

                // Else assign him this cap and recur for remaining caps with
                // new updated mask vector
            else ways += countWaysUtil(mask | (1 << capList[i].get(j)), i+1);
            ways %= MOD;
        }

        // Save the result and return it.
        return dp[mask][i] = (int) ways;
    }

    // Reads n lines from standard input for current test case
    static void countWays(int n) throws Exception
    {
        //----------- READ INPUT --------------------------
        String str;
        String split[];
        int x;

        for (int i=0; i<n; i++)
        {
            str = br.readLine();
            split = str.split(" ");

            // while there are words in the split[]
            for (int j = 0; j < split.length; j++) {
                // add the ith person in the list of cap if with id x
                x = Integer.parseInt(split[j]);
                capList[x].add(i);
            }

        }
        //----------------------------------------------------

        // All mask is used to check of all persons
        // are included or not, set all n bits as 1
        allmask = (1 << n) - 1;

        // Initialize all entries in dp as -1
        for (int[] is : dp) {
            for (int i = 0; i < is.length; i++) {
                is[i] = -1;
            }
        }

        // Call recursive function count ways
        System.out.println(countWaysUtil(0, 1));
    }

    // Driver method
    public static void main(String args[]) throws Exception
    {
        int n; // number of persons in every test case

        // initializing vector array
        for (int i = 0; i < capList.length; i++)
            capList[i] = new Vector<>();


        n = Integer.parseInt(br.readLine());
        countWays(n);
    }
}