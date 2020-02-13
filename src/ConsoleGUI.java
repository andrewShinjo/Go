import java.util.Scanner;

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

    /** Scans String input that corresponds to where user wants to play.
     *
     * @return
     */
    public String scanInput() {
        /** Scan input from user
         *  Check whether first character is alphabetical character
         *  Check whether next one or two characters are 1 through 19
         *  If last two conditions are met, then input can be returned
         *  Otherwise, input is invalid and throw an error
         */
        System.out.print("Enter next move: ");
        Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine();

        char alpha = Character.toLowerCase(move.charAt(0));
        if (! (alpha >= 'a' && alpha <= 's'))
            throw new IllegalArgumentException ("First character must be alphabetical character A~S or a~s.");

        if (move.length() == 2 && move.charAt(1) >= '1' && move.charAt(1) <= '9'
         || move.length() == 3 && move.charAt(1) == '1' && move.charAt(2) >= '0'
         && move.charAt(2) <= '9') {
            return move;
        }
        throw new IllegalArgumentException("Input not in the correct format. " +
                "First character must be an alphabetical character A~S or a~s. Then, an " +
                "integer in the interval [1, 19] must follow it.");
    }
}
