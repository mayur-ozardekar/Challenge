package com.study.october.week3;

/**
 * Minimum Domino Rotations For Equal Row
 *
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the ith domino, so that A[i] and B[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 *
 * If it cannot be done, return -1.
 *
 * Example 1:
 *
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 *
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 *
 * Example 2:
 *
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 *
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 *
 * Constraints:
 *
 * 2 <= A.length == B.length <= 2 * 104
 * 1 <= A[i], B[i] <= 6
 *
 */
public class Solution19 {
    public int minDominoRotations(int[] A, int[] B) {
        int[] cntA = new int[7], cntB = new int[7], cntSame = new int[7];
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int a = A[i], b = B[i];
            cntA[a] += 1;
            cntB[b] += 1;
            if (a == b) cntSame[a] += 1;
        }
        int ans = n;
        for (int v = 1; v <= 6; v++) {
            if (cntA[v] + cntB[v] - cntSame[v] == n) {
                int minSwap = Math.min(cntA[v], cntB[v]) - cntSame[v];
                ans = Math.min(ans, minSwap);
            }
        }
        return ans == n ? -1 : ans;
    }
}
