/**
 * TicTacToe
 */
public class TicTacToe {

  static Character checkRows(String[] rows) {
    for (int i = 0; i < rows.length; i++) {
      String row = rows[i];

      if (row.equals("XXX")) {
        return 'X';
      }
      if (row.equals("OOO")) {
        return 'O';
      }
    }
    return null;
  }

  static Character checkCols(String[] rows) {
    String[] cols = { "", "", "" };

    for (int rowNum = 0; rowNum < 3; rowNum++) {
      char[] rowArr = rows[rowNum].toCharArray();

      for (int colNum = 0; colNum < 3; colNum++) {
        cols[colNum] = cols[colNum] + rowArr[colNum];
      }
    }

    for (int i = 0; i < cols.length; i++) {
      String col = cols[i];

      if (col.equals("XXX")) {
        return 'X';
      }
      if (col.equals("OOO")) {
        return 'O';
      }
    }
    return null;
  }

  static String[] generateRows(String board) {
    String[] rows = { "", "", "" };
    char[] boardChars = board.toCharArray();

    for (int i = 0; i < boardChars.length; i++) {
      if (i >= 0 && i < 3) {
        rows[0] = rows[0] + boardChars[i];
      }
      if (i >= 3 && i < 6) {
        rows[1] = rows[1] + boardChars[i];
      }
      if (i >= 6 && i < 9) {
        rows[2] = rows[2] + boardChars[i];
      }
    }

    return rows;
  }

  static void print(String[] rows) {
    for (int i = 0; i < rows.length; i++) {
      System.out.println(rows[i]);
    }
  }

  // static boolean checkWinner(String[] rows) {
  // // check the rows
  // Character winner = null;
  // winner = checkRows(rows);
  // System.out.println(winner);
  // // check the columns
  // // check the diagonals
  // // if any of them have 3 pieces from the same player, that player won

  // return true;
  // }

  static boolean checkWin(String[] rows) {
    boolean diagLTRHasWinner = true;
    boolean diagRTLHasWinner = true;
    Character winner = null;
    winner = checkRows(rows);
    System.out.println(winner);
    for (int j = 1; j < rows.size; j++) {
      boolean columHasWinner = true;
      boolean rowHasWinner = true;
      for (int i = 0; i < rows.size; i++) {
        columHasWinner = columHasWinner && (board[i][j] == board[i][j - 1]);
        rowHasWinner = rowHasWinner && (board[j][i] == board[j - 1][i]);
      }
      if ((rowHasWinner && board[j][0] != -1) || (columHasWinner && board[0][j] != -1)) {
        return true;
      }
      diagLTRHasWinner = diagLTRHasWinner && (board[j][j] == board[j - 1][j - 1]);
      diagRTLHasWinner = diagLTRHasWinner && (board[rows.size - j][j] == board[rows.size - j + 1][j - 1]);
    }
    return (diagRTLHasWinner && board[0][0] != -1) || (diagLTRHasWinner && board[rows.size - 1][0] != -1);
  }

  public static void main(String[] args) {
    String board = "XXX--O--X";
    String[] rows = generateRows(board);
    // print(rows);
    checkWinner(rows);
  }
}
