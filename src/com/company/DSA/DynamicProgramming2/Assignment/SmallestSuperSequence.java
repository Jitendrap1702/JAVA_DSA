/*
Given two strings S and T with lengths M and N.
Find and return the length of their shortest 'Super Sequence'.
The shortest 'Super Sequence' of two strings is defined as the smallest string possible that
will have both the given strings as its subsequences.
Note :
If the two strings do not have any common characters,
then return the sum of the lengths of the two strings.
Input Format:
The first only line of input contains a string, that denotes the value of string S.
The following line contains a string, that denotes the value of string T.
Output Format:
Length of the smallest super-sequence of given two strings.
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
ab
ac
Sample Output 1 :
3
Explanation of Sample Output 1 :
Their smallest super sequence can be "abc" which has length = 3.
Sample Input 2 :
pqqrpt
qerepct
Sample Output 2 :
9
 */
package com.company.DSA.DynamicProgramming2.Assignment;

public class SmallestSuperSequence {

    // Iterative memoization : Top Down Approach
    public static int smallestSuperSequence(String str1, String str2) {

        int m = str1.length(), n = str2.length();
        int[][] storage = new int[m+1][n+1];
        for (int i = 0; i <= m; i++){ // first column
            storage[i][0] = i;
        }

        for (int i = 0; i <= n; i++){ // first row
            storage[0][i] = i;
        }

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    storage[i][j] = 1 + storage[i-1][j-1];
                }else {
                    storage[i][j] = 1 + Math.min(storage[i-1][j], storage[i][j-1]);
                }
            }
        }
        return storage[m][n];
    }

    public static void main(String[] args) {

//        String str1 = "ab", str2 = "ac";
        String str1 = "pqqrpt", str2 = "qerepct";
        int ans = smallestSuperSequence(str1, str2);
        System.out.println(ans);
    }
}
