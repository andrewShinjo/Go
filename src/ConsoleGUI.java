import java.util.Scanner;

public class ConsoleGUI {

    /**
     * Prints the game board onto the console.
     *
     * @param board = 2D char array representation of game board
     */
    public void drawBoard(Board board) {
        System.out.print("   ");
        for (int i = 0; i < 19; i++) {
            char letter = (char) ('A' + i);
            System.out.print(" " + letter + " ");
        }
        System.out.println();

        for (int y = 1; y <= board.ROW; y++) {
            if (y <= 9) {
                System.out.print(" " + y + " ");
            } else {
                System.out.print(y + " ");
            }
            for (int x = 1; x <= board.COL; x++) {
                if (board.get_piece(new Pair(x, y)) == ' ') {
                    System.out.print("[ ]");
                } else if (board.get_piece(new Pair(x, y)) == 'B') {
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
    public char[] scanInput() {
        /** Scan input from user
         *  Check whether first character is alphabetical character
         *  Check whether next one or two characters are 1 through 19
         *  If last two conditions are met, then input can be returned
         *  Otherwise, input is invalid and throw an error
         */
        System.out.print("Enter next move: ");
        Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine();

        char output[] = new char[3];
        output[0] = Character.toLowerCase(move.charAt(0));

        if (! (output[0] >= 'a' && output[0] <= 's'))
            throw new IllegalArgumentException ("First character must be alphabetical character A~S or a~s.");
        if (move.length() == 2) {
            output[1] = '0';
            output[2] = move.charAt(1);
            if (output[2] >= '1' && output[2] <= '9')
                return output;
        } else if (move.length() == 3) {
            output[1] = move.charAt(1);
            output[2] = move.charAt(2);
            if (output[1] == '1' && output[2] >= '0' && output[2] <= '9')
                return output;
        }
        throw new IllegalArgumentException("Input not in the correct format. " +
                "First character must be an alphabetical character A~S or a~s. Then, an " +
                "integer in the interval [1, 19] must follow it.");
    }
}
