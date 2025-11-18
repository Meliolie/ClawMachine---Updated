import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Button {

    // button
    private static ImageIcon buttonClicked = new ImageIcon("Images/Button_clicked.png");
    private static ImageIcon buttonDefault = new ImageIcon("Images/Button_default.png");

    public static JLabel buttonCl = new JLabel(buttonClicked);
    public static JLabel buttonDef = new JLabel(buttonDefault);

    public static void clickButton() {
        buttonDef.setVisible(false);
        buttonCl.setVisible(true);

        GameListener.update();

        buttonCl.setVisible(false);
        buttonDef.setVisible(true);

    }
}
