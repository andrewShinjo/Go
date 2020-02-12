public class ConsoleGUI {

    /**
     * Prints the game board onto the console.
     *
     * @param board = 2D char array representation of game board
     */
    public void drawBoard(char[][] board) {
        System.out.print("   ");
        for (int i = 0; i < 19; i++) {
            char letter = (char) ('A' + i);
            System.out.print(" " + letter + " ");
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            if (i < 9) {
                System.out.print(" " + (i + 1) + " ");
            } else {
                System.out.print((i + 1) + " ");
            }
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    System.out.print("[ ]");
                } else if (board[i][j] == 'B') {
                    System.out.print("[B]");
                } else {
                    System.out.print("[W]");
                }
            }
            System.out.println();
        }
    }
}
