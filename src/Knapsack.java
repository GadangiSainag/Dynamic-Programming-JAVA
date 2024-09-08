public class Knapsack {
    static int recursiveKnapsack(int[] wt, int[] val, int w, int n) {
//        0-1 Knapsack (any element is taken only once)
        if (n == 0 || w == 0) {
            return 0;
        }
        if (wt[n - 1] <= w) {
            return Math.max(val[n - 1] + recursiveKnapsack(wt, val, w - wt[n - 1], n - 1), recursiveKnapsack(wt, val, w, n - 1));
        } else if (wt[n - 1] > w) {
            return recursiveKnapsack(wt, val, w, n - 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(recursiveKnapsack(new int[]{1,2,3,7}, new int[]{5,5,5,7}, 10, 4));
    }
}
