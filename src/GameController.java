public class GameController {
    private final ConsoleGUI consoleGUI;
    private final Game game;

    /**
     * Initalizes GameController which acts as the middleman
     * between the graphics and the game.
     *
     * @param consoleGUI = class with everything related to drawing game on console
     * @param game       = class with everything related to the game
     */
    public GameController(ConsoleGUI consoleGUI, Game game) {
        this.consoleGUI = consoleGUI;
        this.game = game;
    }

    /** Scans a string input from user to get location of next move.
     * If either input doesn't correspond to location on game board
     * or move is illegal, ask for input again. If a move is
     * successfully played, switch player's turn.
     */
    public void play_move() {
        /** Scan input from user
         * Convert input to (column, row) format
         * Check if the given col, row is legal to play on
         */
       char[] input = consoleGUI.scanInput();
       Pair move = convert_move(input);
       if(game.get_board().is_move_legal(move)) {
           System.out.println("Move is legal");
           insert_move(move);
           switch_player();
       }
    }

    /** Returns whether game is over or not.
     *
     * @return if game is over
     */
    public boolean is_game_over() {
        return game.is_game_over();
    }

    /** Calls game to switch the color of the next stone to be played.
     *
     */
    public void switch_player() {
        game.switch_stone();
    }

    /** Calls the GUI to update the view of the game board's state.
     *
     */
    public void update_view() {
        consoleGUI.drawBoard(game.get_board());
    }

    /** Inserts stone onto board location corresponding to the input.
     *
     * @param pair = location on board to insert move
     */
    private void insert_move(Pair pair) {
        game.insertPiece(pair);
    }

    /** Converts letter in user's move input onto the corresponding integer
     * on the board's coordinate.
     *
     * @param c = letter in user's input
     * @return number corresponding to letter's location on game board
     */
    private int convert_alpha(char c) {
        assert (c >= 'a' && c <= 's') : "input should be letter from a to s.";
        return (c - 96);
    }

    /** Converts move from char array format to two integers.
     *
     * @param c = move in char array format
     * @return output = move represented by two integers
     */
    private Pair convert_move(char[] c) {
        assert c.length == 3 : "Input assumed to be two or three characters long.";
        int row = convert_alpha(c[0]);
        int col = Character.getNumericValue(c[1]) * 10 + Character.getNumericValue(c[2]);

        return new Pair (row, col);
    }
}
