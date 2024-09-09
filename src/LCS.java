// LONGEST COMMON SUBSEQUENCE
//Memoization methon =  top-down approach
//Tabulation method = bottom - up approach

import java.util.Arrays;

public class LCS {
    static int recursiveLongestCommonSubsequence(String x, String y, int m, int n){
        if(n==0 || m==0){
            return 0;
        }
        if(x.charAt(m-1) == y.charAt(n-1)){
            return 1 + recursiveLongestCommonSubsequence(x, y, m-1, n-1);
        }else{
            return Math.max( recursiveLongestCommonSubsequence(x,y,m,n-1),recursiveLongestCommonSubsequence(x,y,m-1,n));
        }
    }
/*
    static int recursiveMemoizationLCS(String x, String y, int m, int n){
//        ----------------------Setting up the Matrix-------------------
        final int MAX_CONSTRAIN = 1000;
        int[][] t = new int[MAX_CONSTRAIN+1][MAX_CONSTRAIN+1];
        for (int i = 0; i <=MAX_CONSTRAIN+1; i++) {
            Arrays.fill(t[i], -1);
        }
//        Base condition
        if (n==0 || m==0){
            return 0;
        }
//        Check if value already calculated
        if(t[m][n] !=-1){
            return t[m][n];
        }

        if(x.charAt(m-1) == y.charAt(n-1)){
            return t[m][n] = 1 + recursiveMemoizationLCS(x, y ,m-1, n-1);
        }else{
            return t[m][n] = Math.max( recursiveMemoizationLCS(x,y,m,n-1),recursiveMemoizationLCS(x,y,m-1,n));
        }

    }
*/
    public static void main(String[] args) {
        System.out.println(recursiveLongestCommonSubsequence("abcde", "acfge", 5,5));


    }
}
