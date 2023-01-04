import java.util.*;

public class MaximumSumNonAdjacent {

  public static void main(String[] args) {
    ArrayList<Integer> lst = new ArrayList<>();
    lst.add(2);
    lst.add(1);
    lst.add(4);
    lst.add(9);

    int[] dp = new int[lst.size() + 1]; // dp array
    Arrays.fill(dp, -1);
    System.out.println(findMaximumNonAdjacentSum(lst, lst.size() - 1));
    System.out.println(findMaximumNonAdjacentSumDP(lst, lst.size() - 1, dp));
    System.out.println(findMaximumNonAdjacentSumTabular(lst, lst.size() - 1, dp));
    System.out.println(findMaximumNonAdjacentSumTabularWithSP(lst, lst.size() - 1));
  }

  // recursive approach
  public static int findMaximumNonAdjacentSum(ArrayList<Integer> nums, int idx) {
    if (idx == 0)
      return nums.get(idx);
    if (idx < 0)
      return 0;

    int pick = nums.get(idx) + findMaximumNonAdjacentSum(nums, idx - 2);
    int nonPick = 0 + findMaximumNonAdjacentSum(nums, idx - 1);

    return Math.max(pick, nonPick);
  }

  // memorization approach
  public static int findMaximumNonAdjacentSumDP(ArrayList<Integer> nums, int idx, int[] dp) {
    if (idx == 0)
      return nums.get(idx);
    if (idx < 0)
      return 0;
    if (dp[idx] != -1)
      return dp[idx];

    int pick = nums.get(idx) + findMaximumNonAdjacentSumDP(nums, idx - 2, dp);
    int nonPick = 0 + findMaximumNonAdjacentSumDP(nums, idx - 1, dp);

    return dp[idx] = Math.max(pick, nonPick);
  }

  // tabular approach
  public static int findMaximumNonAdjacentSumTabular(ArrayList<Integer> nums, int idx, int[] dp) {
    dp[0] = nums.get(0);

    if (idx == 0)
      return dp[0];

    for (int i = 1; i <= idx; i++) {
      int pick = nums.get(i);
      if (i > 1)
        pick += dp[i - 2];

      int notPick = dp[i - 1];
      dp[i] = Math.max(pick, notPick);
    }

    return dp[idx];
  }

  // tabulation with space optimization
  public static int findMaximumNonAdjacentSumTabularWithSP(ArrayList<Integer> nums, int idx) {
    int prev = nums.get(0);

    if (idx == 0)
      return prev;

    int prev2 = 0;

    for (int i = 1; i <= idx; i++) {
      int pick = nums.get(i);
      if (i > 1)
        pick += prev2;

      int notPick = prev;
      int currPick = Math.max(pick, notPick);
      prev2 = prev;
      prev = currPick;
    }

    return prev;
  }
}