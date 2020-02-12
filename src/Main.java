public class Main {
    public static void main(String[] args) {
        ConsoleGUI consoleGUI = new ConsoleGUI();
        Game game = new Game();
        GameController gc = new GameController(consoleGUI, game);

        gc.updateView();
    }
}
