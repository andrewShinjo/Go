import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Board {
    private final HashMap<Pair, Location> graph;

    public static final int COL = 19;
    public static final int ROW = 19;

    public Board() {
        graph = new HashMap<>();

        // Create graph representation of game board
        for(int x = 1; x <= ROW; x++) {
            for (int y = 1; y <= COL; y++) {
                Pair pair = new Pair (x, y);
                Location location = new Location (pair);
                graph.put (pair, location);
            }
        }

        // Connect adjacent locations on game board through adjacency list.
        for (int x = 1; x <= ROW; x++) {
            for (int y = 1; y <= COL; y++) {
                if (x + 1 <= 19)
                    graph.get(new Pair(x, y)).get_adjacency_list().add(graph.get(new Pair(x + 1, y)));
                if (x - 1 >= 1)
                    graph.get(new Pair(x, y)).get_adjacency_list().add(graph.get(new Pair(x - 1, y)));
                if (y + 1 <= 19)
                    graph.get(new Pair(x, y)).get_adjacency_list().add(graph.get(new Pair(x, y + 1)));
                if (y - 1 >= 1)
                    graph.get(new Pair(x, y)).get_adjacency_list().add(graph.get(new Pair(x, y - 1)));
            }
        }
    }

    /** Returns piece on pair location.
     *
     * @param pair = location on board
     * @return piece on pair location
     */
    public char get_piece(Pair pair) {
        return graph.get(pair).get_piece();
    }

    /** Verifies if location user wants to play stone on is empty.
     *
     * @param move = the column and row
     * @return if move is valid
     */
    public boolean is_move_legal(Pair move) {
        /** Is the location empty? If not, then illegal.
         *  Is the location suicide? If it is, then illegal.
         */
        if (is_location_empty(graph.get(move)))
            return false;
        if (is_dead(move))
            return false;

        graph.get(move).set_occupied();
        return true;
    }

    /** Sets the piece on the given location on the game board.
     *
     * @param pair = the location
     * @param piece = the piece
     */
    public void set_piece (Pair pair, char piece) {
        graph.get(pair).set_piece(piece);
    }

    /** Verifies if the given column and row position on game board is empty.
     *
     * @param location = location on game board
     * @return if position is empty
     */
    private boolean is_location_empty(Location location) {
        return location.is_occupied();
    }

    /**
     *
     * @param pair = location player wants to play
     * @return if stone in current location is dead
     */
    private boolean is_dead (Pair pair) {
        HashMap<Pair, Boolean> visited = new HashMap<> ();
        LinkedList<Pair> queue = new LinkedList<> ();

        visited.put (pair, true);
        queue.add (pair);

        while (queue.size() != 0) {
            Pair current_pair = queue.poll();
            for (Location adjacent_location : graph.get(pair).get_adjacency_list()) {
                if (! visited.containsKey(adjacent_location.get_pair())) {
                    visited.put(adjacent_location.get_pair(), true);
                    if (! adjacent_location.is_occupied())
                        return false;
                    if (graph.get(pair).get_piece() == adjacent_location.get_piece())
                        queue.add(adjacent_location.get_pair());
                }
            }
        }
        System.out.println("Stone is dead.");
        return true;
    }
}
