import javax.swing.*;
import java.awt.*;

public class GUI {
    // private member variables
    private final JFrame window = new JFrame();
    private final JPanel board = new JPanel();

    private final Intersection[][] intersections;

    private static final int BOARD_COL = 19;
    private static final int BOARD_ROW = 19;

    /**
     *
     */
    public GUI() {
        window.setMinimumSize(new Dimension(1000, 1000));
        window.setLayout(new GridBagLayout());

        // Set up components to create board
        board.setLayout(new GridLayout(19, 19));

        // create image of board in window
        ImageIcon board_icon = new ImageIcon("baduk board.png");
        Image board_image = board_icon.getImage();
        Image rescaled_board_image = board_image.getScaledInstance(570, 570, java.awt.Image.SCALE_SMOOTH);
        board_icon = new ImageIcon(rescaled_board_image);

        JLabel board_label = new JLabel(board_icon);
        board_label.setLayout(new GridLayout(BOARD_COL, BOARD_ROW));

        intersections = new Intersection[BOARD_COL][BOARD_ROW];

        // Initialize JButtons on every intersection on the board.
        for (int y = 0; y < BOARD_COL; y++) {
            for (int x = 0; x < BOARD_ROW; x++) {
                Intersection intersection = new Intersection(y, x);

                intersections[y][x] = intersection;
                intersections[y][x].setMinimumSize(new Dimension(30, 30));
                intersections[y][x].setMaximumSize((new Dimension(30, 30)));
                intersections[y][x].setOpaque(false);
                intersections[y][x].setContentAreaFilled(false);
                intersections[y][x].setBorderPainted(false);
                board_label.add(intersections[y][x]);
            }
        }

        GridBagConstraints c1 = new GridBagConstraints();
        c1.anchor = GridBagConstraints.CENTER;
        window.add(board_label, c1);

        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
