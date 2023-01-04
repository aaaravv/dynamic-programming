import java.util.*;

public class ClimbingStairs {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter n: ");
    int n = sc.nextInt();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);

    System.out.println(climbStairs(n));
    System.out.println(climbStairsDP(n, dp));
    System.out.println(climbStairsDPTabular(n, dp));
    System.out.println(climbStairsDPTabularWithSP(n));

    sc.close();
  }

  // recursive approach
  public static int climbStairs(int n) {
    if (n <= 1)
      return 1;

    return climbStairs(n - 1) + climbStairs(n - 2);
  }

  // memorization approach
  public static int climbStairsDP(int n, int[] dp) {
    if (n <= 1)
      return 1;

    if (dp[n] != -1)
      return dp[n];

    return dp[n] = climbStairsDP(n - 1, dp) + climbStairsDP(n - 2, dp);
  }

  // tabular approach
  public static int climbStairsDPTabular(int n, int[] dp) {
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i < dp.length; i++) {
      dp[n] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  // tabular approach with space optimization
  public static int climbStairsDPTabularWithSP(int n) {
    int prev = 1, prev2 = 1;

    for (int i = 2; i <= n; i++) {
      int curr = prev + prev2;
      prev2 = prev;
      prev = curr;
    }
    return prev;
  }
}
