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

    public void updateView() {
        consoleGUI.drawBoard(game.get_game_board());
    }
}
