
public class Solution {

  public int numRookCaptures(char[][] board) {
    if (board.length < 2 || board[0].length < 2)
      return 0;
    int count = 0, x = -1, y = -1;
    for (int i = 0; i < board.length && x == -1; i++)
      for (int j = 0; j < board[0].length && x == -1; j++) {
        if (board[i][j] == 'R') {
          x = i;
          y = j;
        }
      }
    
    if (x == -1)
      return 0;
    int i, j;
    for (i = x - 1; i >= 0 && board[i][y] == '.'; i--);
    if (i >= 0 && board[i][y] == 'p')
      count++;
    for (i = x + 1; i < board.length && board[i][y] == '.'; i++);
    if (i < board.length && board[i][y] == 'p')
      count++;
    for (j = y - 1; j >= 0 && board[x][j] == '.'; j--);
    if (j >= 0 && board[x][j] == 'p')
      count++;
    for (j = y + 1; j < board[0].length && board[x][j] == '.'; j++);
    if (j < board[0].length && board[x][j] == 'p')
      count++;
    return count;
  }

  public static void main(String[] args) {
    char[][] chessboard1 =
        {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'},
            {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}},
        chessboard2 =
            {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'}, {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
                {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'}, {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}},
        chessboard3 =
            {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}};

    Solution s = new Solution();

    System.out.println("Checking case1: " + (s.numRookCaptures(chessboard1) == 3));
    System.out.println("Checking case2: " + (s.numRookCaptures(chessboard2) == 0));
    System.out.println("Checking case3: " + (s.numRookCaptures(chessboard3) == 3));
  }
}
