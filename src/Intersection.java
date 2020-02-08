import javax.swing.*;

public class Intersection extends JButton {
    // private member variables
    private final int y;
    private final int x;
    private boolean isOccupied;

    /**
     * Instantiates an intersection, a location player can place a stone on the board.
     *
     * @param x = x position on game board
     * @param y = y position on game board
     */
    public Intersection(int y, int x) {
        this.y = y;
        this.x = x;
        isOccupied = false;
    }

    /**
     * Prints the position of the intersection in the format (y, x).
     */
    public void printPosition() {
        System.out.println("My position is (" + y + ", " + x + ").");
    }
}
