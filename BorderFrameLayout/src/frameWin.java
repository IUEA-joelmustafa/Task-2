import javax.swing.*;
import java.awt.*;

public class frameWin {
    JFrame frame;

    public frameWin(){
        createFrame();
    }

    void createFrame() {
        //  frame creation
        frame = new JFrame("Border Layout");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //  North Lable

        JLabel titleLable = new JLabel("Application Title Demo",JLabel.CENTER);
        frame.add(titleLable,BorderLayout.NORTH);

        //   south button

        frame.add(createButtonSubmit(), BorderLayout.SOUTH);

        //  west panels and buttons

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(3,1));

        westPanel.add(createButtonOne(), BorderLayout.WEST);
        westPanel.add(createButtonTwo(), BorderLayout.WEST);
        westPanel.add(createButtonThree(), BorderLayout.WEST);
        frame.add(westPanel, BorderLayout.WEST);

        //  center textarea

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane,BorderLayout.CENTER);

        frame.setVisible(true);

    }

    //   buttons

    JButton createButtonOne(){
        JButton buttonOne = new JButton("Option 1");
        return buttonOne;
    }
    JButton createButtonTwo(){
        JButton buttonTwo = new JButton("Option 2");
        return buttonTwo;
    }
    JButton createButtonThree(){
        JButton buttonThree = new JButton("Option 3");
        return buttonThree;
    }
    JButton createButtonSubmit(){
        JButton submit = new JButton("Submit");
        return submit;
    }
}
