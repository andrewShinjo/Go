public class Main {
    public static void main(String[] args) {
        GUI g = new GUI();
        Game game = new Game ();
        GameController gc = new GameController(g, game);
    }
}
