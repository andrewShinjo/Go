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
        insert_move(consoleGUI.scanInput());
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
        consoleGUI.drawBoard(game.get_game_board());
    }

    /** Inserts stone onto board location corresponding to the input.
     *
     * @param input = location on board to insert move
     */
    private void insert_move(char[] input) {
        assert input.length == 3 : "Input assumed to be two or three characters long.";
        int row = convert_alpha(input[0]) - 1;
        int col = Character.getNumericValue(input[1]) * 10 + Character.getNumericValue(input[2]) - 1;
        game.insertPiece(col, row);
    }

    private int convert_alpha(char c) {
        assert (c >= 'a' && c <= 's') : "input should be letter from a to s.";
        return (c - 96);
    }
}
