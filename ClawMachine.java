import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ClawMachine extends JFrame {

    // frame stats
    public static final int width = 1200;
    public static final int height = 800;

    public static final int clawWidth = 240;
    public static final int clawHeight = 400;

    private static ImageIcon background = new ImageIcon("Images/Background_1200_800.png");
    private static ImageIcon front = new ImageIcon("Images/Front_1200_800.png");

    public static JLabel backLabel = new JLabel(background);
    public static JLabel frontLabel = new JLabel(front);

    public static JLayeredPane layers;

    public static GameListener listener = new GameListener();

    public ClawMachine() {

        GameApplication.frame.setTitle("Claw Machine");
        GameApplication.frame.setSize(new Dimension(width, height));
        GameApplication.frame.setLocationRelativeTo(null);
        GameApplication.frame.setResizable(false);
        GameApplication.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameApplication.frame.setLayout(null);

        ImageIcon icon = new ImageIcon("Images/Icon_120_120.png", "Claw Icon");
        GameApplication.frame.setIconImage(icon.getImage());

        layers = new JLayeredPane();
        layers.setBounds(0, 0, width, height);

        backLabel.setBounds(0, 0, width, height);
        frontLabel.setBounds(0, 0, width, height);

        // claws label
        Claw.clawOp.setBounds(Claw.clawMax, 0, clawWidth, clawHeight);
        Claw.clawOp.setVisible(true);

        Claw.clawClo.setBounds(Claw.clawMax, 0, clawWidth, clawHeight);
        Claw.clawClo.setVisible(false);

        // button label
        Button.buttonCl.setBounds(0, 0, width, height);
        Button.buttonCl.setVisible(true);

        Button.buttonDef.setBounds(0, 0, width, height);
        Button.buttonDef.setVisible(false);

        // knobs label
        Knob.knobL.setBounds(0, 0, width, height);
        Knob.knobL.setVisible(false);

        Knob.knobR.setBounds(0, 0, width, height);
        Knob.knobR.setVisible(false);

        Knob.knobD.setBounds(0, 0, width, height);
        Knob.knobD.setVisible(true);

        // capsel positions
        Capsel.setCapselPosition();

        // add labels to layeredPane
        layers.add(backLabel, Integer.valueOf(0));

        layers.add(Claw.clawOp, Integer.valueOf(50));
        layers.add(Claw.clawClo, Integer.valueOf(52));

        layers.add(frontLabel, Integer.valueOf(70));

        layers.add(Knob.knobR, Integer.valueOf(100));
        layers.add(Knob.knobL, Integer.valueOf(101));
        layers.add(Knob.knobD, Integer.valueOf(102));

        layers.add(Button.buttonDef, Integer.valueOf(103));
        layers.add(Button.buttonCl, Integer.valueOf(104));

        GameApplication.frame.setFocusable(true);

        GameApplication.frame.add(layers);

        // add keyListener
        GameApplication.frame.addKeyListener(new GameListener());

        GameApplication.frame.setVisible(true);

    }

    public static void removeLabels(JLabel... labels) {
        for (int i = 0; i < labels.length; i++) {
            labels[i].setVisible(false);
            ClawMachine.layers.remove(labels[i]);
        }
    }

    public static void removeListener() {
        GameApplication.frame.removeKeyListener(GameApplication.frame.getKeyListeners()[0]);
    }

    public static void addListener() {
        KeyListener[] list = GameApplication.frame.getKeyListeners();
        if (list.length == 0) {
            GameApplication.frame.addKeyListener(new GameListener());
        }
    }

    public static void addMouseListener(JLabel label, MouseListener listener) {
        if (label.getMouseListeners().length == 0) {
            label.addMouseListener(listener);
        }
    }

    public static void removeMouseListener(JLabel label, MouseListener listener) {
        label.removeMouseListener(listener);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
