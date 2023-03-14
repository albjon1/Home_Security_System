import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{

    private JPanel mainPanel;
    private Menu menu;
    private JPanel camPanel;
    
    public App(){
        super("Atomic Security");
        this.setSize(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setIconImage(Constants.ICON);
        // Ensures frame is centred regardless of monitor size
        this.setLocationRelativeTo(null);
        this.setVisible(false);

        // Login Instance
        new Login(this);


        mainPanel = new JPanel();
        mainPanel.setBackground(Constants.GREY12);
        mainPanel.setLayout(null);

        // Menu
        menu = new Menu();
        menu.setBounds(0, 0 , 1300, 75);
        this.add(menu);

        camPanel = new JPanel();
        camPanel.setBackground(Constants.GREY12);
        camPanel.setBounds(0, 50, 1300, 700);
        JLabel t2 = new JLabel("CAMERA PANEL");
        t2.setForeground(Constants.WHITE);
        camPanel.add(t2);

        mainPanel.add(camPanel);
        this.add(mainPanel);
    }
    
}
