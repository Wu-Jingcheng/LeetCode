
public class Solution {
  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    return !(rec1[2] <= rec2[0] || rec1[0] >= rec2[2] || rec1[3] <= rec2[1] || rec1[1] >= rec2[3]);
  }

  public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
    return (rec1[2] < rec2[2] ? rec1[2] : rec2[2]) - (rec1[0] > rec2[0] ? rec1[0] : rec2[0]) > 0
        && (rec1[3] < rec2[3] ? rec1[3] : rec2[3]) - (rec1[1] > rec2[1] ? rec1[1] : rec2[1]) > 0;
  }

  public static void main(String[] args) {
    Solution s = new Solution();

    int[] rec11 = {0, 0, 2, 2}, rec12 = {1, 1, 3, 3};
    System.out.println("Checking case1: " + s.isRectangleOverlap(rec11, rec12));

    int[] rec21 = {0, 0, 1, 1}, rec22 = {1, 0, 2, 2};
    System.out.println("Checking case2: " + !s.isRectangleOverlap(rec21, rec22));
  }

}
