import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Game {
    private final char[][] game_board;
    public static final int COL = 19;
    public static final int ROW = 19;

    private boolean black_turn;
    private boolean game_over;

    private char current_stone;
    private char other_stone;

    private final Board board;


    /**
     * Creates a 2D char array representation of game board where each index is assigned the value 0.
     * In this program, a value of 0 in the 2D array denotes an unoccupied position on the game board.
     */
    public Game() {
        board = new Board();
        game_board = new char[19][19];
        black_turn = true;
        game_over = false;

        current_stone = 'B';
        other_stone = 'W';

        // Create 2D char array representation of game board
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                game_board[i][j] = 0;
            }
        }

    }

    /** Returns graph representation of game board.
     *
     * @return board = graph representation of game board
     */
    public Board get_board() {
        return board;
    }



    /** Returns whether it is black's turn or not.
     *
     * @return black_turn = is it black's turn?
     */
    public boolean get_turn() { return black_turn; }

    /** Inserts the current player's piece onto the board.
     *
     * @param pair = location on board
     */
    public void insertPiece(Pair pair) {
        board.set_piece(pair, current_stone);
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

}

