import java.util.*;

public class Solution {
  // fastest
  public List<String> fizzBuzz(int n) {
    List<String> list = new ArrayList<String>();
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 != 0) {
        list.add("Fizz");
      } else if (i % 3 != 0 && i % 5 == 0) {
        list.add("Buzz");
      } else if (i % 3 == 0 && i % 5 == 0) {
        list.add("FizzBuzz");
      } else {
        list.add(String.valueOf(i));
      }
    }
    return list;
  }

  // more neat
  public List<String> fizzBuzz3(int n) {
    List<String> res = new LinkedList<String>();
    for (; n > 0; n--) {
      String str = "";
      if (n % 3 == 0)
        str += "Fizz";
      if (n % 5 == 0)
        str += "Buzz";
      if (str.equals(""))
        str = String.valueOf(n);
      res.add(0, str);
    }
    return res;
  }

  public List<String> fizzBuzz2(int n) {
    List<String> res = new LinkedList<String>();
    for (; n > 0; n--) {
      boolean multipleOf3 = n % 3 == 0;
      boolean multipleOf5 = n % 5 == 0;
      if (multipleOf3 && multipleOf5)
        res.add(0, "FizzBuzz");
      else if (multipleOf3)
        res.add(0, "Fizz");
      else if (multipleOf5)
        res.add(0, "Buzz");
      else
        res.add(0, String.valueOf(n));
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.fizzBuzz(15));
  }

}
