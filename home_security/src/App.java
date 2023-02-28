import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{

    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel camPanel;
    
    public App(){
        super("Atomic Security");
        this.setSize(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(Constants.ICON);
        this.setVisible(false);

        // Login Instance
        new Login(this);


        mainPanel = new JPanel();
        mainPanel.setBackground(Constants.GREY12);
        mainPanel.setLayout(null);

        menuPanel = new JPanel();
        menuPanel.setBackground(Constants.GREY);
        menuPanel.setBounds(0, 0 ,1300, 50);
        JLabel t1 = new JLabel("MENU PANEL");
        t1.setForeground(Constants.WHITE);
        menuPanel.add(t1);

        camPanel = new JPanel();
        camPanel.setBackground(Constants.GREY12);
        camPanel.setBounds(0, 50, 1300, 700);
        JLabel t2 = new JLabel("CAMERA PANEL");
        t2.setForeground(Constants.WHITE);
        camPanel.add(t2);
        



        mainPanel.add(menuPanel);
        mainPanel.add(camPanel);
        this.add(mainPanel);
    }
    
}
