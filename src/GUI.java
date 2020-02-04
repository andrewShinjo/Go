import javax.swing.*;
import java.awt.*;

public class GUI {
    // private member variables
    private final JFrame window = new JFrame ();
    private final JPanel board = new JPanel ();

    /**
     *
     */
    public GUI () {
        initializeGUI ();
        window.setVisible (true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private final void initializeGUI () {
        window.setLayout (new BorderLayout());
        window.add(board, BorderLayout.CENTER);

        // Set up components to create board
        GridLayout boardLayout = new GridLayout (19, 19);
        board.setLayout (boardLayout);

        for (int i = 1; i <= 19; i++) {
            for (int j = 1; j <= 19; j++) {
                board.add(new JButton("( " + j + ", " + i + ")"));
            }
        }
    }
}
