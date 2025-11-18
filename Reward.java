import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Reward {

    public static MouseListener rewardListener;

    public static final int ANIMALSIZE = 240;
    public static final int ANIMALX = 480;
    public static final int ANIMALY = 270;

    private static ImageIcon animalPopUp = new ImageIcon("Animals/Animal_popup.png");

    private static ImageIcon orangeCat = new ImageIcon("Animals/Orange_cat.png");
    private static ImageIcon siameseCat = new ImageIcon("Animals/Siamese_cat.png");
    private static ImageIcon blackCat = new ImageIcon("Animals/Black_cat.png");
    private static ImageIcon capybara = new ImageIcon("Animals/Capybara.png");
    private static ImageIcon chick = new ImageIcon("Animals/Chicken.png");
    private static ImageIcon birb = new ImageIcon("Animals/Bird.png");
    private static ImageIcon parr = new ImageIcon("Animals/Parrot.png");
    private static ImageIcon shar = new ImageIcon("Animals/Shark.png");
    private static ImageIcon orc = new ImageIcon("Animals/Orca.png");

    public static JLabel popUp = new JLabel(animalPopUp);

    public static JLabel orange = new JLabel(orangeCat);
    public static JLabel siamese = new JLabel(siameseCat);
    public static JLabel black = new JLabel(blackCat);
    public static JLabel capy = new JLabel(capybara);
    public static JLabel chicken = new JLabel(chick);
    public static JLabel bird = new JLabel(birb);
    public static JLabel parrot = new JLabel(parr);
    public static JLabel shark = new JLabel(shar);
    public static JLabel orca = new JLabel(orc);

    JLabel text = new JLabel();

    public static void setReward() {

        ClawMachine.removeListener();

        popUp.setBounds(200, 70, 800, 600);
        popUp.setVisible(true);

        ClawMachine.layers.add(popUp, JLayeredPane.POPUP_LAYER);

        int random = ClawMachine.getRandomNumber(1, 10);

        switch (random) {
            case 1:
                addLayer(orange);
                break;
            case 2:
                addLayer(siamese);
                break;
            case 3:
                addLayer(black);
                break;
            case 4:
                addLayer(capy);
                break;
            case 5:
                addLayer(chicken);
                break;
            case 6:
                addLayer(bird);
                break;
            case 7:
                addLayer(parrot);
                break;
            case 8:
                addLayer(shark);
                break;
            case 9:
                addLayer(orca);
                break;
        }

        rewardListener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ClawMachine.removeLabels(popUp, orange, siamese, black, capy, chicken, bird, parrot, shark, orca);
                GameListener.update(10);
                ClawMachine.removeMouseListener(popUp, rewardListener);
                ClawMachine.addListener();
                GameListener.checkGameState();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        };

        ClawMachine.addMouseListener(popUp, rewardListener);

    }

    public static void addLayer(JLabel label) {
        label.setBounds(ANIMALX, ANIMALY, ANIMALSIZE, ANIMALSIZE);
        label.setVisible(true);
        GameListener.update();
        ClawMachine.layers.add(label, JLayeredPane.DRAG_LAYER);

    }
}
