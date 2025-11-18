import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Knob {

    // knobs
    private static ImageIcon knobDefault = new ImageIcon("Images/Knobs_default.png");
    private static ImageIcon knobRight = new ImageIcon("Images/Knobs_right.png");
    private static ImageIcon knobLeft = new ImageIcon("Images/Knobs_left.png");

    public static JLabel knobD = new JLabel(knobDefault);
    public static JLabel knobR = new JLabel(knobRight);
    public static JLabel knobL = new JLabel(knobLeft);

    public static void moveKnobLeft() {
        knobD.setVisible(false);
        knobL.setVisible(true);
        knobR.setVisible(false);
    }

    public static void moveKnobRight() {
        knobD.setVisible(false);
        knobR.setVisible(true);
        knobL.setVisible(false);
    }

    public static void moveKnobDefault() {
        knobL.setVisible(false);
        knobR.setVisible(false);
        knobD.setVisible(true);
    }
}
