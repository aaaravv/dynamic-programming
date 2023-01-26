import java.util.Arrays;

public class FrogJump {
  /**
   * Greedy Approach doesn't work here as ->
   * 
   * suppose for eg > [30, 10, 60, 10, 60, 50]
   * output for greedy approach will be a total of:
   * 1. 30 -> 10 (20)
   * 2. 10 -> 10 (0)
   * 3. 10 -> 50 (40)
   * Total energy: 20 + 0 + 40 = 60
   * 
   * Actual output:
   * 1. 30 -> 60 (30)
   * 2. 60 -> 60 (0)
   * 3. 60 -> 50 (10)
   * Total energy: 30 + 0 + 10 = 40
   */

  public static void main(String[] args) {
    System.out.println(frogJump(5, new int[] { 30, 10, 60, 10, 60, 50 }, 0, 0));

    int[] dp = new int[5 + 1];
    Arrays.fill(dp, -1);
    System.out.println(frogJumpDP(5, new int[] { 30, 10, 60, 10, 60, 50 }, 0, Integer.MAX_VALUE, dp));
    System.out.println(frogJumpDPTabular(5, new int[] { 30, 10, 60, 10, 60, 50 }, dp));
    System.out.println(frogJumpDPTabularWithSP(5, new int[] { 30, 10, 60, 10, 60, 50 }));
  }

  // recursive approach
  public static int frogJump(int n, int[] a, int left, int right) {
    if (n == 0)
      return 0;

    left = frogJump(n - 1, a, left, right) + Math.abs(a[n] - a[n - 1]);

    if (n > 1)
      right = frogJump(n - 2, a, left, right) + Math.abs(a[n] - a[n - 2]);

    return Math.min(left, right);

  }

  // memorized recursive approach
  public static int frogJumpDP(int n, int[] a, int left, int right, int[] dp) {
    if (n == 0)
      return 0;

    if (dp[n] != -1)
      return dp[n];
    left = frogJumpDP(n - 1, a, left, right, dp) + Math.abs(a[n] - a[n - 1]);

    if (n > 1)
      right = frogJumpDP(n - 2, a, left, right, dp) + Math.abs(a[n] - a[n - 2]);

    return dp[n] = Math.min(left, right);
  }

  // tabular approach
  public static int frogJumpDPTabular(int n, int[] a, int[] dp) {
    dp[0] = 0;

    if (n == 0)
      return dp[0];

    int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

    for (int i = 1; i < dp.length; i++) {
      left = dp[i - 1] + Math.abs(a[n] - a[n - 1]);
      if (i > 1)
        right = dp[i - 2] + Math.abs(a[n] - a[n - 2]);

      dp[n] = Math.min(left, right);
    }

    return dp[n];
  }

  // tabular approach with space optimization
  public static int frogJumpDPTabularWithSP(int n, int[] a) {
    int prev = 0, prev2 = 0;

    if (n == 0)
      return prev;

    int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

    for (int i = 1; i < n; i++) {
      left = prev + Math.abs(a[n] - a[n - 1]);

      if (i > 1)
        right = prev2 + Math.abs(a[n] - a[n - 2]);

      int res = Math.min(left, right);
      prev2 = prev;
      prev = res;
    }

    return prev;
  }
}
