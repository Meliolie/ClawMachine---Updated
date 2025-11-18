import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class End {

    public static MouseListener endListener;

    // pop up
    private static ImageIcon popUp = new ImageIcon("Images/PopUp.png");

    public static JLabel pop = new JLabel(popUp);

    public static void resetGame() {

        ClawMachine.removeListener();

        // pop up at end of game
        pop.setBounds(0, 0, ClawMachine.width, ClawMachine.height);
        pop.setVisible(true);

        ClawMachine.layers.add(pop, JLayeredPane.POPUP_LAYER);

        endListener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ClawMachine.removeLabels(pop);
                ClawMachine.removeMouseListener(pop, endListener);
                Capsel.setCapselPosition();
                GameListener.update(10);
                ClawMachine.addListener();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        };

        ClawMachine.addMouseListener(pop, endListener);

    }
}
