public class Game {
    private final char[][] game_board;
    public static final int COL = 19;
    public static final int ROW = 19;

    private boolean black_turn;
    private boolean game_over;

    private char current_stone;
    private char other_stone;


    /**
     * Creates a 2D char array representation of game board where each index is assigned the value 0.
     * In this program, a value of 0 in the 2D array denotes an unoccupied position on the game board.
     */
    public Game() {
        game_board = new char[19][19];
        black_turn = true;
        game_over = false;

        current_stone = 'B';
        other_stone = 'W';

        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                game_board[i][j] = 0;
            }
        }
    }

    /**
     * Returns the 2D char array representation of the game board.
     *
     * @return game_board = 2D char array representation of game board
     */
    public char[][] get_game_board() {
        return game_board;
    }

    /** Returns whether it is black's turn or not.
     *
     * @return black_turn = is it black's turn?
     */
    public boolean get_turn() { return black_turn; }

    public void insertPiece(int[] move) {
        game_board[move[0]][move[1]] = current_stone;
    }

    /** Returns whether the game is over.
     *
     * @return is_game_over = is the game over?
     */
    public boolean is_game_over() { return game_over; }

    /** Switches the stone color from black to white and vice-versa.
     *
     */
    public void switch_stone() {
        if(current_stone == 'B') {
            current_stone = 'W';
            other_stone = 'B';
        }
         else {
             current_stone = 'B';
             other_stone = 'W';
        }
    }

    /** Verifies if location user wants to play stone on is empty.
     *
     * @param col = the column
     * @param row = the row
     * @return if move is valid
     */
    public boolean verify_move(int[] move) {
        /** Is the location empty? If not, then illegal.
         *  Is the location suicide? If it is, then illegal.
         */
        if (! is_location_empty(move)) {
            return false;
        }
        return true;
    }

    /** Verifies if the given column and row position on game board is empty.
     *
     * @param col = column on the game board
     * @param row = row on the game board
     * @return if position is empty
     */
    private boolean is_location_empty(int[] move) {
        if (game_board[move[0]][move[1]] != ' ')
            return false;
        return true;
    }

    private boolean is_suicide(int[] move) {
        int[] up = {move[0] - 1, move[1]};
        int[] down = {move[0] + 1, move[1]};
        int[] left = {move[0], move[1] - 1};
        int[] right = {move[0], move[1] + 1};

        return true;
    }
}

