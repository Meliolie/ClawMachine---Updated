import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Claw {

    public static int clawDownCord = 160;

    // claw stats
    public static int clawMin = 430;
    public static int clawMax = 895;

    // claws
    private static ImageIcon clawOpen = new ImageIcon("Images/Claw_open.png");
    private static ImageIcon clawClosed = new ImageIcon("Images/Claw_closed.png");

    public static JLabel clawOp = new JLabel(clawOpen);
    public static JLabel clawClo = new JLabel(clawClosed);

    /**
     * moves the claw.
     * 
     * @param num Positiv when claw moves to the right. Negativ when claw moves to
     *            the left.
     */
    public static void moveClaw(int num) {
        clawOp.setLocation(clawOp.getX() + num, clawOp.getY());
        moveClawCloToOp();
    }

    /**
     * moves the claw up and when there is a capsel within the coordinates also
     * moves up the capsel.
     * 
     * @param num
     * @param cap Capsel you want to move up with the claw.
     */
    public static void moveClawUp(int num, CapselKnode cap) {

        while (clawClo.getY() > clawDownCord - num) {
            clawClo.setLocation(clawClo.getX(), clawClo.getY() - 10);
            moveClawOpToClo();
            if (cap != null) {
                cap.label.setLocation(cap.label.getX(), cap.label.getY() - 10);
            }

            GameListener.update(100);
        }
    }

    /**
     * Lowers the claw and changes the image to the closed claw.
     */
    public static void lowerClaw() {
        while (clawOp.getY() < clawDownCord) {
            clawOp.setLocation(clawOp.getX(), clawOp.getY() + 10);
            moveClawCloToOp();
            GameListener.update();
        }
        closeClaw();
    }

    /**
     * sets the location of the claw to the beginning.
     */
    public static void resetClaw(CapselKnode cap) {
        while (clawClo.getY() > 0) {
            clawClo.setLocation(clawClo.getX(), clawClo.getY() - 10);
            moveClawOpToClo();
            if (cap != null && cap.isCaught) {
                cap.label.setLocation(cap.label.getX(), cap.label.getY() - 10);
            }
            GameListener.update();
        }
        while (clawClo.getX() < clawMax) {
            clawClo.setLocation(clawClo.getX() + 10, clawClo.getY());
            moveClawOpToClo();
            if (cap != null && cap.isCaught) {
                cap.label.setLocation(cap.label.getX() + 10, cap.label.getY());
            }
            GameListener.update();
        }
        Claw.openClaw();
    }

    public static void openClaw() {
        clawClo.setVisible(false);
        clawOp.setVisible(true);
        GameListener.update(10);
    }

    public static void closeClaw() {
        clawClo.setVisible(true);
        clawOp.setVisible(false);
        GameListener.update(10);
    }

    public static void moveClawCloToOp() {
        clawClo.setLocation(clawOp.getX(), clawOp.getY());
    }

    public static void moveClawOpToClo() {
        clawOp.setLocation(clawClo.getX(), clawClo.getY());
    }

    public static void removeClaw() {
        ClawMachine.removeLabels(clawOp, clawClo);
    }
}
