public class Main {
    public static void main(String[] args) {
        ConsoleGUI console_gui = new ConsoleGUI();
        Game game = new Game();
        GameController game_controller = new GameController(console_gui, game);

        while (! game_controller.is_game_over()) {  // while game is not over,
            game_controller.update_view();          // update the view
            game_controller.play_move();            // play a move
            game_controller.switch_player();        // changes to next player's turn
        }
    }
}
