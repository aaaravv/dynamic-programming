import java.util.*;

public class FrogJumpWithKDist {
  public static void main(String[] args) {
    System.out.println(frogJump(9, new int[] { 40, 10, 20, 70, 80, 10, 20, 70, 80, 60 }, 4));

    int[] dp = new int[9 + 1];
    Arrays.fill(dp, -1);
    System.out.println(frogJumpDP(9, new int[] { 40, 10, 20, 70, 80, 10, 20, 70, 80, 60 }, 4, dp));
    System.out.println(frogJumpDPTabular(9, new int[] { 40, 10, 20, 70, 80, 10, 20, 70, 80, 60 }, 4, dp));
  }

  // recursive approach
  public static int frogJump(int n, int[] a, int k) {
    if (n == 0)
      return 0;

    int minSteps = Integer.MAX_VALUE;

    for (int j = 1; j <= k; j++) {
      if (n - j < 0)
        break;

      else if (n - j >= 0) {
        int currStep = frogJump(n - j, a, k) + Math.abs(a[n] - a[n - j]);
        minSteps = Math.min(minSteps, currStep);
      }
    }

    return minSteps;
  }

  // memorized recursive approach
  public static int frogJumpDP(int n, int[] a, int k, int[] dp) {
    if (n == 0)
      return 0;

    if (dp[n] != -1)
      return dp[n];

    int minSteps = Integer.MAX_VALUE;

    for (int j = 1; j <= k; j++) {
      if (n - j < 0)
        break;

      else if (n - j >= 0) {
        int currStep = frogJump(n - j, a, k) + Math.abs(a[n] - a[n - j]);
        minSteps = Math.min(minSteps, currStep);
      }
    }
    return dp[n] = minSteps;
  }

  // tabular approach
  public static int frogJumpDPTabular(int n, int[] a, int k, int[] dp) {
    dp[0] = 0;

    if (n == 0)
      return dp[0];

    for (int i = 1; i < dp.length; i++) {
      int minSteps = Integer.MAX_VALUE;

      for (int j = 0; j <= k; j++) {
        if (i - j < 0)
          break;

        else if (i - j >= 0) {
          int currStep = dp[i - j] + Math.abs(a[n] - a[n - j]);
          minSteps = Math.min(currStep, minSteps);
        }
      }
    }
    return dp[n];
  }

  // tabular approach with space optimization -> no need as creating and
  // maintaining a list of size k will be of no use as if in worst case n == k it
  // will be same as taking an entire dp array of size n like tabulation
}
