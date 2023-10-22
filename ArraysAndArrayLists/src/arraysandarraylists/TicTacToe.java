package arraysandarraylists;

import java.util.ArrayList;

public class TicTacToe {
    private ArrayList<ArrayList<Character>> board;
    private char currentPlayer = 'X';

    public TicTacToe() {
        board = new ArrayList<>();
        // array lists start empty, you have to add the rows
        for (int row = 0; row < 3; row++) {
            board.add(new ArrayList<>());
            for (int column = 0; column < 3; column++) {
                board.get(row).add(' ');
            }
        }
    }

    public void printBoard() {
        System.out.println(board.get(0).get(0) + "|" + board.get(0).get(1) + "|" + board.get(0).get(2));
        System.out.println("-----");
        System.out.println(board.get(1).get(0) + "|" + board.get(1).get(1) + "|" + board.get(1).get(2));
        System.out.println("-----");
        System.out.println(board.get(2).get(0) + "|" + board.get(2).get(1) + "|" + board.get(2).get(2));

    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean mark(int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex > 2 || columnIndex < 0 || columnIndex > 2 ||
                board.get(rowIndex).get(columnIndex) != ' ') {
            return false;
        }
        board.get(rowIndex).set(columnIndex, currentPlayer);
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
        return true;
    }

    public boolean isTied() {
        for (ArrayList<Character> row : board) {
            if (row.contains(' ')) {
                return false;
            }
        }
        // if there is a winner, we can't be tied
        return !hasWinner();
    }

    public boolean hasWinnerByRow() {
        for (ArrayList<Character> row : board) {
            if (row.get(0) != ' ' && row.get(0) == row.get(1) && row.get(0) == row.get(2)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasWinnerByColumn() {
        for (int columnIndex = 0; columnIndex < 3; columnIndex++) {
            if (board.get(0).get(columnIndex) != ' ' &&
                    board.get(0).get(columnIndex) == board.get(1).get(columnIndex) &&
                    board.get(0).get(columnIndex) == board.get(2).get(columnIndex)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasWinnerByDiagonal() {
        return board.get(1).get(1) != ' ' && (
                (board.get(0).get(0) == board.get(1).get(1) && board.get(0).get(0) == board.get(2).get(2))
                        ||
                        (board.get(2).get(0) == board.get(1).get(1) && board.get(2).get(0) == board.get(0).get(2)));
    }

    public boolean hasWinner() {
        return hasWinnerByRow() || hasWinnerByColumn() || hasWinnerByDiagonal();
    }

    public boolean isGameOver() {
        return isTied() || hasWinner();
    }
}
