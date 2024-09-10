// LONGEST COMMON SUBSEQUENCE
//Memoization methon =  top-down approach
//Tabulation method = bottom - up approach

public class LCS {
    static int recursiveLongestCommonSubsequence(String x, String y, int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return 1 + recursiveLongestCommonSubsequence(x, y, m - 1, n - 1);
        } else {
            return Math.max(recursiveLongestCommonSubsequence(x, y, m, n - 1), recursiveLongestCommonSubsequence(x, y, m - 1, n));
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
    static int tabulationLCS(String x, String y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j]= Math.max(t[i][j - 1], t[i - 1][j]);

                }
            }
        }
        return t[m][n];
    }
    static int longestCommonSubstring(String x, String y){
//        Longest common substring from x, y
        int m = x.length();
        int n = y.length();
        int[][] t = new int[m + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = 0;
                }
// to note the max value till now .
                max = Math.max(max, t[i][j]);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(recursiveLongestCommonSubsequence("abcde", "acfge", 5, 5));
        System.out.println(tabulationLCS("abcde", "abcge", 5, 5));
        System.out.println(longestCommonSubstring("adbcde", "acbcge"));
    }
}
