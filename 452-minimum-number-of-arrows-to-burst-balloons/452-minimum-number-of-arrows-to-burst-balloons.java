class Solution {
    public int findMinArrowShots(int[][] points) {
    if (points == null || points.length == 0)
      return 0;

    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
    int arrows = 1, target = points[0][1];

    for (int i = 1; i < points.length; i++)
      if (target < points[i][0]) {
        target = points[i][1];
        arrows += 1;
      }

    return arrows;
  }
}