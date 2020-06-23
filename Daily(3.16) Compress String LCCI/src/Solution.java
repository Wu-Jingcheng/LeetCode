
public class Solution {
  public String compressString(String S) {
    int len = S.length();
    StringBuffer sb = new StringBuffer();
    int count = 0, index = 0;
    for (int i = 0; i < len; i++) {
      if (index >= len - 1)
        return S;
      if (i > 0 && S.charAt(i) != S.charAt(i - 1)) {
        sb.append(S.charAt(i - 1));
        index++;
        if (index == len - 1)
          return S;
        String temp = String.valueOf(count);
        sb.append(temp);
        index+=temp.length();
        count = 1;
      } else
        count++;
    }
    if (index >= len - 1)
      return S;
    sb.append(S.charAt(len - 1));
    index++;
    if (index >= len - 1)
      return S;
    String temp = String.valueOf(count);
    sb.append(temp);
    return sb.toString();
  }

  public static void main(String[] args) {
    String input1 = "aabcccccaaa", output1 = "a2b1c5a3";
    String input2 = "abbccd", output2 = "abbccd";
    String input3 = "abcccc", output3 = "abcccc";
    String input4 = "abccc", output4 = "abccc";

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.compressString(input1).equals(output1)));
    System.out.println("Checking case2: " + (s.compressString(input2).equals(output2)));
    System.out.println("Checking case3: " + (s.compressString(input3).equals(output3)));
    System.out.println("Checking case4: " + (s.compressString(input4).equals(output4)));

  }

}
