
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 0)
            return "";
        StringBuffer[] overall = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++)
            overall[i] = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        boolean going_down = false;
        int index = 0;
        for (char c : s.toCharArray()) {
            overall[index].append(c);
            if (index == 0 || index == numRows - 1)
                going_down = !going_down;
            if (numRows > 1) {
                if (going_down)
                    index++;
                else
                    index--;
            }
        }
        for (int i = 0; i < numRows; i++)
            sb.append(overall[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "PAYPALISHIRING";
        int numRows1 = 3, numRows2 = 4;
        System.out.println(s.convert(str, numRows1));
        System.out.println(s.convert(str, numRows2));
    }
}