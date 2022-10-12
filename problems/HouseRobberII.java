import java.util.*;

public class HouseRobberII {
  public static void main(String[] args) {
    ArrayList<Integer> temp1 = new ArrayList<>();
    ArrayList<Integer> temp2 = new ArrayList<>();
    int[] arr = { 2, 7, 9, 3, 1 };
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      if (i != 0)
        temp1.add(arr[i]);
      if (i != n - 1)
        temp2.add(arr[i]);
    }

    System.out.println(Math.max(houseRobberIITabularWithSP(temp2), houseRobberIITabularWithSP(temp1)));

  }

  // tabulation with space optimization
  public static long houseRobberIITabularWithSP(ArrayList<Integer> valueInHouse) {
    int n = valueInHouse.size();
    long prev = valueInHouse.get(0);

    if (n == 0)
      return prev;

    long prev2 = 0;

    for (int i = 1; i < n; i++) {
      long pick = valueInHouse.get(i);
      if (i > 1)
        pick += prev2;

      long notPick = prev;
      long currPick = Math.max(pick, notPick);
      prev2 = prev;
      prev = currPick;
    }
    return prev;
  }
}
