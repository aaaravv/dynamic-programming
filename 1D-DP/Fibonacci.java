import java.util.*;

public class Fibonacci {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter n: ");
    int n = sc.nextInt();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);

    System.out.println(fibbonacci(n));
    System.out.println(fibbonacciDP(n, dp));
    System.out.println(fibbonacciDPTabular(n, dp));
    System.out.println(fibbonacciDPTabularWithSP(n));

    sc.close();
  }

  // recursive approach
  public static int fibbonacci(int n) {
    if (n <= 1)
      return n;

    return fibbonacci(n - 1) + fibbonacci(n - 2);
  }

  // memorization approach
  public static int fibbonacciDP(int n, int[] dp) {
    if (n <= 1)
      return n;

    if (dp[n] != -1)
      return dp[n];

    return dp[n] = fibbonacciDP(n - 1, dp) + fibbonacciDP(n - 2, dp);
  }

  // tabular approach
  public static int fibbonacciDPTabular(int n, int[] dp) {
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i < dp.length; i++) {
      dp[n] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  // tabular approach with space optimization
  public static int fibbonacciDPTabularWithSP(int n) {
    int prev = 1, prev2 = 0;

    if (n == 0)
      return prev2;

    if (n == 1)
      return prev;

    for (int i = 2; i <= n; i++) {
      int curr = prev + prev2;
      prev2 = prev;
      prev = curr;
    }
    return prev;
  }
}
