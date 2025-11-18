import javax.swing.JLabel;

public class CapselKnode {
    public JLabel label;
    public CapselKnode next;
    public boolean isCaught;

    public CapselKnode(JLabel label) {
        this.label = label;
        isCaught = false;
    }

}
