import javax.swing.*;
import java.awt.*;
 
public class FrameWin {
 
    private JFrame frame;
 
    public FrameWin() {
        this(true);
    }
 
    public FrameWin(boolean show) {
        createFrame();
        if (frame != null) frame.setVisible(show);
    }
 
    private void createFrame() {
        // Frame creation
        frame = new JFrame("Border Layout");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
 
        // North label
        JLabel titleLabel = new JLabel("Application Title Demo", JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);
 
        // South button
        frame.add(createButtonSubmit(), BorderLayout.SOUTH);
 
        // West panel with buttons (GridLayout — no constraint needed)
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(3, 1));
        westPanel.add(createButtonOne());
        westPanel.add(createButtonTwo());
        westPanel.add(createButtonThree());
        frame.add(westPanel, BorderLayout.WEST);
 
        // Center text area with scroll support
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);
    }
 
    private JButton createButtonOne() {
        JButton buttonOne = new JButton("Option 1");
        buttonOne.addActionListener(e -> System.out.println("Option 1 clicked"));
        return buttonOne;
    }
 
    private JButton createButtonTwo() {
        JButton buttonTwo = new JButton("Option 2");
        buttonTwo.addActionListener(e -> System.out.println("Option 2 clicked"));
        return buttonTwo;
    }
 
    private JButton createButtonThree() {
        JButton buttonThree = new JButton("Option 3");
        buttonThree.addActionListener(e -> System.out.println("Option 3 clicked"));
        return buttonThree;
    }
 
    private JButton createButtonSubmit() {
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> System.out.println("Submit clicked"));
        return submit;
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(FrameWin::new);
    }
}
}
