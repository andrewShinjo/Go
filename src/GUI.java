import javax.swing.*;
import java.awt.*;

public class GUI {
    // private member variables
    private final JFrame window = new JFrame();
    private final JPanel board = new JPanel();

    private final JPanel menu = new JPanel();

    private static final int BOARD_COL = 19;
    private static final int BOARD_ROW = 19;

    /**
     *
     */
    public GUI() {
        initializeGUI();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private final void initializeGUI () {
        window.setLayout(new GridBagLayout());

        // Set up components to create board
        board.setLayout(new GridLayout(19, 19));

        // create all the JButtons
        for (int i = 1; i <= BOARD_COL; i++) {
            for (int j = 1; j <= BOARD_ROW; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(30, 30));
                board.add(button);
            }
        }

        JLabel image = new JLabel();
        ImageIcon img = new ImageIcon("baduk board.png");
        image.setIcon(img);

        // Testing JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.add(board, 2);
        layeredPane.add(image, 1);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.anchor = GridBagConstraints.CENTER;
        window.add(layeredPane, c1);
    }
}
