
public class Solution {
  // 100%, dfs
  public void solve(char[][] board) {
    if (board.length < 3 || board[0].length < 3)
      return;
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      dfs(board, i, 0);
      dfs(board, i, n - 1);
    }
    for (int j = 0; j < n; j++) {
      dfs(board, 0, j);
      dfs(board, m - 1, j);
    }

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        if (board[i][j] == '#')
          board[i][j] = 'O';
        else
          board[i][j] = 'X';
  }

  private void dfs(char[][] board, int i, int j) {
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
      return;
    board[i][j] = '#';
    dfs(board, i - 1, j);
    dfs(board, i + 1, j);
    dfs(board, i, j - 1);
    dfs(board, i, j + 1);
  }

  public static void print(char[][] board) {
    for (char[] row : board) {
      for (char c : row)
        System.out.print(c + "!");
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    char[][] board1 =
        {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'X', 'O'}};
    s.solve(board1);
    print(board1);
    char[][] board2 = {{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'},
        {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}};
    print(board2);
    s.solve(board2);
    print(board2);
  }
}


