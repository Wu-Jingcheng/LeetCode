
public class Solution {

  public boolean exist(char[][] board, String word) {
    if (board.length == 0 || board[0].length == 0)
      return word.equals("");
    boolean result = false;
    for (int i = 0; i < board.length && !result; i++)
      for (int j = 0; j < board[0].length && !result; j++) {
        result = existCore(board, i, j, word, 0);
      }
    return result;
  }

  private boolean existCore(char[][] board, int i, int j, String word, int index) {
    if (index == word.length())
      return true;
    else if (i < board.length && i >= 0 && j < board[0].length && j >= 0
        && board[i][j] == word.charAt(index)) {
      char temp = board[i][j];
      board[i][j] = ' ';
      boolean result = false;
      for (int x = -1; x <= 1 && !result; x++)
        for (int y = -1; y <= 1 && !result; y++) {
          if (x == 0 && y == 0 || x * y != 0)
            continue;
          result = existCore(board, i + x, j + y, word, index + 1);
        }
      board[i][j] = temp;
      return result;
    } else
      return false;
  }

  public static void main(String[] args) {
    char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    String word1 = "ABCCED", word2 = "SEE", word3 = "ABCB";
    boolean result1 = true, result2 = true, result3 = false;

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.exist(board1, word1) == result1));
    System.out.println("Checking case2: " + (s.exist(board1, word2) == result2));
    System.out.println("Checking case3: " + (s.exist(board1, word3) == result3));
  }

}
