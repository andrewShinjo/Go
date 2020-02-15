import java.util.ArrayList;

public class Location {

    private final Pair pair;
    private final ArrayList<Location> adjacency_list;

    private boolean occupied;
    private char piece;

    /** Creates a location on the game board.
     *
     * @param pair = coordinate location on game board
     */
    public Location(Pair pair) {
        this.pair = pair;
        adjacency_list = new ArrayList<Location>();

        occupied = false;
        piece = ' ';
    }

    /** Return's the location's adjacency list.
     *
     * @return adjacency_list = the adjacency list
     */
    public ArrayList<Location> get_adjacency_list() {
        return adjacency_list;
    }

    /** Returns location's coordinate pair.
     *
     * @return pair = x, y coordinates
     */
    public Pair get_pair() {
        return pair;
    }

    /** Returns the piece occupying the location.
     *
     * @return piece = the piece
     */
    public char get_piece() {
        return piece;
    }

    /** Return if location is occupied.
     *
     * @return occupied = if occupied
     */
    public boolean is_occupied() {
        return occupied;
    }

    /** If occupied is true, sets occupied to false.
     * If occupied is false, set occupied to true.
     *
     */
    public void set_occupied() {
        if(occupied == true) {
            occupied = false;
        } else {
            occupied = true;
        }
    }

    /** Sets the location's piece.
     *
     * @param piece = the piece
     */
    public void set_piece(char piece) {
        this.piece = piece;
    }
}
