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

        // create image of board in window
        ImageIcon board_icon = new ImageIcon("baduk board.png");
        Image board_image = board_icon.getImage();
        Image rescaled_board_image = board_image.getScaledInstance(570, 570, java.awt.Image.SCALE_SMOOTH);
        board_icon = new ImageIcon(rescaled_board_image);

        JLabel board_label = new JLabel(board_icon);
        board_label.setLayout(new GridLayout(BOARD_COL, BOARD_ROW));

        for (int i = 1; i <= BOARD_COL; i++) {
            for (int j = 1; j <= BOARD_ROW; j++) {
                JButton button = new JButton();
                button.setMinimumSize(new Dimension(30, 30));
                button.setMaximumSize((new Dimension(30, 30)));
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
                board_label.add(button);
            }
        }

        GridBagConstraints c1 = new GridBagConstraints();
        c1.anchor = GridBagConstraints.CENTER;
        window.add(board_label, c1);
    }
}
