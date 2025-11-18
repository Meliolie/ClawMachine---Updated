import javax.swing.JLabel;

public class CapselList {

    public CapselKnode head;

    public CapselList() {
        head = null;
    }

    /**
     * appends JLabels to the CapselList.
     * 
     * @param labels JLabels you want to append.
     */
    public void append(JLabel... labels) {
        for (int i = 0; i < labels.length; i++) {
            CapselKnode cap = new CapselKnode(labels[i]);
            cap.next = head;
            head = cap;
        }
    }

    /**
     * searches through a CapselList to find a Capsel which lies within the Claw
     * coordinates.
     * 
     * @return returns Capsel which coordinates lie within the Claw coordinates.
     *         Returns null when no such Capsel exists.
     */
    public CapselKnode search(CapselList list) {
        CapselKnode cap = list.head;
        while (cap != null && !isWithinCoord(cap)) {
            cap = cap.next;
        }
        return cap;
    }

    private boolean isWithinCoord(CapselKnode cap) {
        if (Claw.clawClo.getX() + 60 <= cap.label.getX() && cap.label.getX()
                + Capsel.CAPSIZE <= Claw.clawClo.getX() + ClawMachine.clawWidth - 60) {
            return true;
        }
        return false;
    }

    public void removeCap(CapselKnode cap) {
        CapselList list = Capsel.capsels;

        CapselKnode prev = null;
        CapselKnode p = head;

        while (p != null && p != cap) {
            prev = p;
            p = p.next;
        } // p == null || p == cap
        if (p != null) {
            if (p == head) {
                head = p.next;
            } else {
                prev.next = p.next;
            }
            p.label.setVisible(false);
        }
    }

    /**
     * sets CapselList to null. Deletes all entries in the List.
     */
    public static void deleteList() {
        Capsel.capsels.head = null;
    }

}
