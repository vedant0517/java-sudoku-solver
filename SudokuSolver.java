public class SudokuSolver {

    // Solves the Sudoku puzzle using backtracking
    public static boolean solveSudoku(int[][] board, int row, int col) {
        // Base case: If we've reached past the last row, puzzle is solved
        if (row == 9) {
            return true;
        }

        // Move to the next cell
        int nextRow = row;
        int nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // Skip filled cells
        if (board[row][col] != 0) {
            return solveSudoku(board, nextRow, nextCol);
        }

        // Try placing digits 1–9
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit; // Place digit
                // Recursively try to solve further
                if (solveSudoku(board, nextRow, nextCol)) {
                    return true;
                }

                // Backtrack if it doesn't lead to a solution
                board[row][col] = 0;
            }
        }
        return false; // No valid digit found
    }

    // Checks if placing a digit is allowed in the current cell
    public static boolean isSafe(int[][] board, int row, int col, int digit) {
        // Row check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) return false;
        }

        // Column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) return false;
        }
        // 3x3 box check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) return false;
            }
        }
        return true;
    }

    // Prints the Sudoku board with formatting
    public static void printBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("----------+-----------+-----------");
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + board[row][col] + " ");
            }
            System.out.println();
        }
    }
    // Main method
    public static void main(String[] args) {
        int[][] board = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };

        if (solveSudoku(board, 0, 0)) {
            System.out.println("✅ Solution exists:");
            printBoard(board);
        } else {
            System.out.println("❌ No solution exists for the given puzzle.");
        }
    }
}