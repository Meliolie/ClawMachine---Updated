import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case 37: // <-
                if (Claw.clawOp.getX() >= Claw.clawMin) {
                    Knob.moveKnobLeft();
                    Claw.moveClaw(-10);
                    update(1);
                }
                break;
            case 39: // ->
                if (Claw.clawOp.getX() <= Claw.clawMax) {
                    Knob.moveKnobRight();
                    Claw.moveClaw(10);
                    update(1);
                }
                break;
            case 65: // a
                if (Claw.clawOp.getX() >= Claw.clawMin) {
                    Knob.moveKnobLeft();
                    Claw.moveClaw(-10);
                    update(1);
                }
                break;
            case 68: // d
                if (Claw.clawOp.getX() <= Claw.clawMax) {
                    Knob.moveKnobRight();
                    Claw.moveClaw(10);
                    update(1);
                }
                break;
            case 10: // enter
                if (Claw.clawOp.getX() <= Capsel.maxX - 75) {
                    Button.clickButton();
                    Knob.moveKnobDefault();
                    Claw.lowerClaw();
                    Capsel.catchCapsel();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void checkGameState() {
        update(10);
        if (Capsel.capsels.head == null) {
            End.resetGame();
        }
    }

    public static void update() {
        update(100);
    }

    public static void update(int num) {
        ClawMachine.backLabel.paintImmediately(ClawMachine.backLabel.getVisibleRect());
        waiting(num);
    }

    public static void waiting(long num) {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static double random() {
        return Math.random();
    }

}
