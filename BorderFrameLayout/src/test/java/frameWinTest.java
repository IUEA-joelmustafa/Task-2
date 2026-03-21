import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import java.awt.Component;

class frameWinTest {

    @Test
    void createButtonsReturnExpectedLabels() throws Exception {
        final frameWin[] holder = new frameWin[1];
        SwingUtilities.invokeAndWait(() -> holder[0] = new frameWin(false));
        frameWin fw = holder[0];

        JButton b1 = fw.createButtonOne();
        assertEquals("Option 1", b1.getText());

        JButton b2 = fw.createButtonTwo();
        assertEquals("Option 2", b2.getText());

        JButton b3 = fw.createButtonThree();
        assertEquals("Option 3", b3.getText());

        JButton submit = fw.createButtonSubmit();
        assertEquals("Submit", submit.getText());
    }

    @Test
    void frameIsConstructedWithTitleAndCenterScroll() throws Exception {
        final frameWin[] holder = new frameWin[1];
        SwingUtilities.invokeAndWait(() -> holder[0] = new frameWin(false));
        frameWin fw = holder[0];

        // frame should be created
        assertNotNull(fw.frame);
        assertEquals("Border Layout", fw.frame.getTitle());

        // center should contain a JScrollPane
        boolean foundScroll = false;
        for (Component c : fw.frame.getContentPane().getComponents()) {
            if (c instanceof JScrollPane) {
                foundScroll = true;
                break;
            }
        }
        assertTrue(foundScroll, "Expected a JScrollPane in the frame content pane");
    }
}
