import java.util.Objects;

public class Pair {
    public final int row;
    public final int col;

    /** Creates coordinate position for location object.
     *
     * @param row = the row
     * @param col = the column
     */
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return row == pair.row && col == pair.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
