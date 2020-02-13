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
        System.out.println(consoleGUI.scanInput());
    }

    /** Returns
     *
     * @return
     */
    public boolean is_game_over() {
        return game.is_game_over();
    }

    /** Calls the GUI to update the view of the game board's state.
     *
     */
    public void update_view() {
        consoleGUI.drawBoard(game.get_game_board());
    }
}
