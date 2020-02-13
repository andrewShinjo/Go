public class Game {
    private final char[][] game_board;
    public static final int COL = 19;
    public static final int ROW = 19;

    private boolean black_turn;
    private boolean game_over;


    /**
     * Creates a 2D char array representation of game board where each index is assigned the value 0.
     * In this program, a value of 0 in the 2D array denotes an unoccupied position on the game board.
     */
    public Game() {
        game_board = new char[19][19];
        black_turn = true;
        game_over = false;

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

    /** Returns whether the game is over.
     *
     * @return is_game_over = is the game over?
     */
    public boolean is_game_over() { return game_over; }
}
