import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> al = new ArrayList();
    al.add(new ArrayList());
    for (int num : nums) {
      List<List<Integer>> tempList = new ArrayList();
      for (List<Integer> list : al) {
        tempList.add(new ArrayList(list) {
          {
            add(num);
          }
        });
      }
      for (List<Integer> list : tempList)
        al.add(list);
    }
    return al;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    
    int[] nums = {1,2,3};
    System.out.println("Chekcing: "+(s.subsets(nums)));
  }

}
