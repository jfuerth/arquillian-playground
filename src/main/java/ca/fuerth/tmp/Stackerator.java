package ca.fuerth.tmp;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 * Simple utility that dumps all input to System.out. If you run it from within
 * Eclipse, you can paste stack traces into it and hyperlinked stack traces
 * appear in the Eclipse Console view.
 * <p>
 * It turns out this little hack isn't even necessary: if you look on the
 * Eclipse Console View's toolbar, you'll find an "Open Console" icon. Click it,
 * and choose the first item, "Java Stack Trace Console." Just paste stack
 * traces in that console for the same benefit.
 *
 * @author Jonathan Fuerth <jfuerth@redhat.com>
 *
 */
public class Stackerator {

  public static void main(String[] args) {
    JFrame f = new JFrame("Paste here");
    JTextArea ta = new JTextArea();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(ta);
    f.pack();
    f.setVisible(true);

    ta.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void removeUpdate(DocumentEvent e) {
        // don't care
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
        changedUpdate(e);
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        try {
          System.out.println(e.getDocument().getText(e.getOffset(), e.getLength()));
        } catch (BadLocationException e1) {
          e1.printStackTrace();
        }
      }
    });

  }
}
