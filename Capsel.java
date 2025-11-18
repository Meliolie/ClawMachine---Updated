import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Capsel {
    private static int capselX = 68;
    private static int capselY = 300;

    private static int pickUpCapsel = 100;

    public static CapselList capsels = new CapselList();

    // capsel stats
    public static final int CAPSIZE = 80;
    public static int minY = 450;
    public static int maxY = 480;
    public static int minX = 500;
    public static int maxX = 865;

    // capsel mint
    private static ImageIcon capselMint1 = new ImageIcon("Images/Capsel_mint1.png");
    private static ImageIcon capselMint2 = new ImageIcon("Images/Capsel_mint2.png");
    private static ImageIcon capselMint3 = new ImageIcon("Images/Capsel_mint3.png");
    private static ImageIcon capselMint4 = new ImageIcon("Images/Capsel_mint4.png");
    private static ImageIcon capselMint5 = new ImageIcon("Images/Capsel_mint5.png");
    private static ImageIcon capselMint6 = new ImageIcon("Images/Capsel_mint6.png");

    // capsel pink
    private static ImageIcon capselPink1 = new ImageIcon("Images/Capsel_pink1.png");
    private static ImageIcon capselPink2 = new ImageIcon("Images/Capsel_pink2.png");
    private static ImageIcon capselPink3 = new ImageIcon("Images/Capsel_pink3.png");
    private static ImageIcon capselPink4 = new ImageIcon("Images/Capsel_pink4.png");
    private static ImageIcon capselPink5 = new ImageIcon("Images/Capsel_pink5.png");
    private static ImageIcon capselPink6 = new ImageIcon("Images/Capsel_pink6.png");

    public static JLabel capselM1 = new JLabel(capselMint1);
    public static JLabel capselM2 = new JLabel(capselMint2);
    public static JLabel capselM3 = new JLabel(capselMint3);
    public static JLabel capselM4 = new JLabel(capselMint4);
    public static JLabel capselM5 = new JLabel(capselMint5);
    public static JLabel capselM6 = new JLabel(capselMint6);

    public static JLabel capselP1 = new JLabel(capselPink1);
    public static JLabel capselP2 = new JLabel(capselPink2);
    public static JLabel capselP3 = new JLabel(capselPink3);
    public static JLabel capselP4 = new JLabel(capselPink4);
    public static JLabel capselP5 = new JLabel(capselPink5);
    public static JLabel capselP6 = new JLabel(capselPink6);

    /**
     * searches for a capsel within the claw coordinates. If such a capsel exists,
     * 0.75 chance to catch it. 0.25 chance the claw opens and ball falls down.
     * resets the claw to original position.
     */
    public static void catchCapsel() {

        double randomNum = GameListener.random();
        CapselList list = capsels;
        CapselKnode cap = list.search(list);
        if (cap == null) {
            Claw.resetClaw(cap);
            return;
        }
        int capOriginY = cap.label.getY();
        pickUpCapsel(cap);
        Claw.moveClawUp(pickUpCapsel, cap);
        if (randomNum >= 0.25) {
            cap.isCaught = true;
            Claw.resetClaw(cap);
            fallDownCapsel(cap);
            GameListener.update(10);
            Reward.setReward();
        } else {
            Claw.openClaw();
            while (cap.label.getY() < capOriginY) {
                cap.label.setLocation(cap.label.getX(), cap.label.getY() + 10);
                GameListener.update();
            }
            Claw.resetClaw(cap);
        }
    }

    /**
     * moves capsel down, if capsel got caught. Removes Capsel from CapselList and
     * sets visibility on false.
     * 
     * @param cap Capsel you caught.
     */
    public static void fallDownCapsel(CapselKnode cap) {
        if (cap.isCaught) {
            while (cap.label.getY() < 690) {
                cap.label.setLocation(cap.label.getX(), cap.label.getY() + 20);
                GameListener.update(70);
            }
            capsels.removeCap(cap);
        }
    }

    /**
     * moves the capsel alongside the claw.
     * 
     * @param cap capsel you caught.
     */
    public static void pickUpCapsel(CapselKnode cap) {
        cap.label.setLocation(Claw.clawClo.getX() + capselX, Claw.clawClo.getY() + capselY);
        GameListener.update();
    }

    /**
     * 6 different capsel combinations. Picks one random. Adds the capsel to the
     * capsellist and jlayeredpane and sets visibility true.
     */
    public static void setCapselPosition() {

        CapselList.deleteList();

        removeLayer(capselM1, capselM2, capselM3, capselM4, capselM5, capselM6);
        removeLayer(capselP1, capselP2, capselP3, capselP4, capselP5, capselP6);

        // different capsel positions
        int random = ClawMachine.getRandomNumber(1, 7);
        switch (random) {
            case 1:
                capselM1.setBounds(500, 480, CAPSIZE, CAPSIZE);
                capselM3.setBounds(800, 476, CAPSIZE, CAPSIZE);
                capselM5.setBounds(750, 450, CAPSIZE, CAPSIZE);
                capselP2.setBounds(580, 475, CAPSIZE, CAPSIZE);
                capselP4.setBounds(680, 473, CAPSIZE, CAPSIZE);
                capselP6.setBounds(620, 455, CAPSIZE, CAPSIZE);

                addCapsel(capselM1, capselM3, capselM5, capselP2, capselP4, capselP6);

                capsels.append(capselM1, capselM3, capselM5, capselP2, capselP4, capselP6);
                break;
            case 2:
                capselM2.setBounds(510, 480, CAPSIZE, CAPSIZE);
                capselM3.setBounds(765, 476, CAPSIZE, CAPSIZE);
                capselM6.setBounds(820, 450, CAPSIZE, CAPSIZE);
                capselP1.setBounds(565, 475, CAPSIZE, CAPSIZE);
                capselP3.setBounds(700, 473, CAPSIZE, CAPSIZE);
                capselP5.setBounds(620, 455, CAPSIZE, CAPSIZE);

                addCapsel(capselM2, capselM3, capselM6, capselP1, capselP3, capselP5);

                capsels.append(capselM2, capselM3, capselM6, capselP1, capselP3, capselP5);
                break;
            case 3:
                capselM1.setBounds(520, 480, CAPSIZE, CAPSIZE);
                capselM5.setBounds(745, 476, CAPSIZE, CAPSIZE);
                capselM6.setBounds(810, 450, CAPSIZE, CAPSIZE);
                capselP1.setBounds(615, 475, CAPSIZE, CAPSIZE);
                capselP2.setBounds(590, 470, CAPSIZE, CAPSIZE);
                capselP3.setBounds(700, 473, CAPSIZE, CAPSIZE);
                capselP5.setBounds(660, 455, CAPSIZE, CAPSIZE);

                addCapsel(capselM1, capselM5, capselM6, capselP1, capselP2, capselP3, capselP5);

                capsels.append(capselM1, capselM5, capselM6, capselP1, capselP2, capselP3, capselP5);
                break;
            case 4:
                capselP4.setBounds(520, 480, CAPSIZE, CAPSIZE);
                capselP1.setBounds(715, 476, CAPSIZE, CAPSIZE);
                capselM6.setBounds(560, 450, CAPSIZE, CAPSIZE);
                capselM2.setBounds(760, 475, CAPSIZE, CAPSIZE);
                capselP3.setBounds(850, 473, CAPSIZE, CAPSIZE);
                capselM4.setBounds(615, 455, CAPSIZE, CAPSIZE);

                addCapsel(capselP4, capselP1, capselM6, capselM2, capselP3, capselM4);

                capsels.append(capselP4, capselP1, capselM6, capselM2, capselP3, capselM4);
                break;
            case 5:
                capselM4.setBounds(810, 480, CAPSIZE, CAPSIZE);
                capselP3.setBounds(715, 476, CAPSIZE, CAPSIZE);
                capselP6.setBounds(560, 450, CAPSIZE, CAPSIZE);
                capselM5.setBounds(760, 475, CAPSIZE, CAPSIZE);
                capselP1.setBounds(510, 473, CAPSIZE, CAPSIZE);
                capselM2.setBounds(615, 455, CAPSIZE, CAPSIZE);

                addCapsel(capselM4, capselP3, capselM6, capselM5, capselP1, capselM2);

                capsels.append(capselM4, capselP3, capselM6, capselM5, capselP1, capselM2);
                break;
            case 6:
                capselM6.setBounds(510, 480, CAPSIZE, CAPSIZE);
                capselP5.setBounds(750, 476, CAPSIZE, CAPSIZE);
                capselP1.setBounds(580, 450, CAPSIZE, CAPSIZE);
                capselM3.setBounds(842, 475, CAPSIZE, CAPSIZE);
                capselP2.setBounds(702, 473, CAPSIZE, CAPSIZE);
                capselM1.setBounds(655, 455, CAPSIZE, CAPSIZE);

                addCapsel(capselM6, capselP5, capselP1, capselM3, capselP2, capselM1);

                capsels.append(capselM6, capselP5, capselP1, capselM3, capselP2, capselM1);
                break;
            case 7:
                capselM6.setBounds(800, 480, CAPSIZE, CAPSIZE);
                addCapsel(capselM6);

                capsels.append(capselM6);
                break;
            case 8:
                capselM3.setBounds(842, 475, CAPSIZE, CAPSIZE);
                capselP2.setBounds(702, 473, CAPSIZE, CAPSIZE);

                addCapsel(capselM3, capselP2);
                capsels.append(capselM3, capselP2);
                break;
        }
    }

    public static void addCapsel(JLabel... labels) {
        int val = 20;
        for (int i = 0; i < labels.length; i++) {
            labels[i].setVisible(true);
            ClawMachine.layers.add(labels[i], Integer.valueOf(val));
            val--;
        }
    }

    public static void removeLayer(JLabel... labels) {
        for (int i = 0; i < labels.length; i++) {
            ClawMachine.layers.remove(labels[i]);
        }
    }

}
