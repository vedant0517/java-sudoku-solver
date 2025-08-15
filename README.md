# Sudoku Solver (Java)

This is a Java-based Sudoku solver using the *backtracking algorithm*.  
It can solve any valid Sudoku puzzle by filling empty cells with the correct digits.

---

## 📜 Features
- Solves 9x9 Sudoku puzzles
- Uses *recursion* and *backtracking*
- Well-formatted Sudoku board printing
- Easy to modify for different Sudoku inputs

---

## 🚀 How It Works
1. The algorithm scans each empty cell.
2. Tries digits 1–9 in order.
3. Uses isSafe() to check if the digit is valid in:
   - The current row
   - The current column
   - The current 3x3 sub-grid
4. If a digit is valid, places it and moves to the next cell.
5. If no digit works, *backtracks* and tries the next possibility.
