public class GameController {
    private final GUI gui;
    private final Game game;

    /** Initalizes GameController which acts as the middleman
     * between the graphics and the game.
     *
     * @param gui = class with everything related to graphics
     * @param game = class with everything related to the game
     */
    public GameController (GUI gui, Game game) {
        this.gui = gui;
        this.game = game;
    }

}
