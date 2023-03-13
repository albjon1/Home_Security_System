import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Register extends JFrame{

    // GLOBAL VARIABLES
    private final JPanel mainPanel;
    private final JTextField emailField;
    private final JPasswordField passwordField;
    private final JButton registerButton;
    private final JButton quitButton;
    private final JRadioButton showPassButton;
    private final JButton backButton;

    // GLOBAL VARIABLE OF LOGIN
    private final Login login;

    public Register(Login login){
        super("Atomic Security [REGISTER]");
        this.login = login;
        this.setSize(Constants.REGISTER_WIDTH, Constants.REGISTER_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(Constants.ICON);

        // MAIN PANEL INIT / ADDING COMPONENTS
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Constants.GREY12);

        JLabel titleIcon = new JLabel(new ImageIcon("images/title_icon.png"));
        titleIcon.setBounds(373, 15, 65, 65);
        mainPanel.add(titleIcon);

        JLabel title = new JLabel("Register");
        title.setForeground(Constants.GREY);
        title.setFont(new Font("consolas", Font.BOLD, 40));
        title.setBounds(317, 95, 350, 50);

        JLabel uTitle = new JLabel("Email");
        uTitle.setForeground(Constants.GREY);
        uTitle.setFont(new Font("consolas", Font.BOLD, 20));
        uTitle.setBounds(375, 160, 100, 30);
        mainPanel.add(uTitle);


        emailField = new JTextField();
        emailField.setBounds(304, 190, 200, 25);
        emailField.setFont(new Font("arial", Font.BOLD, 18));
        emailField.setSelectionColor(Constants.WHITE);
        emailField.setBorder(null);
        emailField.setCaretColor(Constants.GREY12);
        emailField.setBackground(Constants.GREY);
        emailField.putClientProperty("caretWidth", 2);
        emailField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                uTitle.setForeground(Constants.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                uTitle.setForeground(Constants.GREY);
            }
        });
        mainPanel.add(emailField);

        JLabel pTitle = new JLabel("Password");
        pTitle.setForeground(Constants.GREY);
        pTitle.setFont(new Font("consolas", Font.BOLD, 20));
        pTitle.setBounds(360, 230, 100, 30);
        mainPanel.add(pTitle);

        passwordField = new JPasswordField();
        passwordField.setBounds(304, 260, 200, 25);
        passwordField.setFont(new Font("arial", Font.BOLD, 18));
        passwordField.setSelectionColor(Constants.WHITE);
        passwordField.setBorder(null);
        passwordField.setCaretColor(Constants.GREY12);
        passwordField.setBackground(Constants.GREY);
        passwordField.putClientProperty("caretWidth", 2);
        passwordField.setEchoChar('\u25CF');
        passwordField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                pTitle.setForeground(Constants.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                pTitle.setForeground(Constants.GREY);
            }
        });
        mainPanel.add(passwordField);

        registerButton = new JButton("Register");
        registerButton.setBounds(354, 330, 100, 35);
        registerButton.setBackground(Constants.GREY);
        registerButton.setFont(new Font("arial", Font.BOLD, 15));
        registerButton.setFocusable(false);
        registerButton.setRolloverEnabled(false);
        registerButton.setBorder(null);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        mainPanel.add(registerButton);

        quitButton = new JButton(new ImageIcon("images/quit_icon.png"));
        quitButton.setBounds(715, 440, 65, 65);
        quitButton.setBackground(Constants.GREY12);
        quitButton.setFocusable(false);
        quitButton.setRolloverEnabled(false);
        quitButton.setBorder(null);
        quitButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });

        backButton = new JButton(new ImageIcon("images/back_button_icon.png"));
        backButton.setBounds(15, 7, 48, 48);
        backButton.setBackground(Constants.GREY12);
        backButton.setFocusable(false);
        backButton.setRolloverEnabled(false);
        backButton.setBorder(null);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Instance of login passed
                login.setVisible(true);
            }
        });
        mainPanel.add(backButton);

        showPassButton = new JRadioButton("Show");
        showPassButton.setBackground(Constants.GREY12);
        showPassButton.setForeground(Constants.GREY);
        showPassButton.setFocusable(false);
        showPassButton.setBounds(370, 290, 60, 25);
        showPassButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showPass();
            }

        });
        mainPanel.add(showPassButton);

        mainPanel.add(title);
        this.add(mainPanel);
        this.add(mainPanel);

        this.setVisible(true);
    }

    private void register(){
        String emailAddress = emailField.getText();
        this.emailField.setText("");
        this.passwordField.setText("");
        JOptionPane.showMessageDialog(this, "Successfully registered [ " + emailAddress + "]", "Registration Successful", JOptionPane.PLAIN_MESSAGE);
        this.dispose();
        login.setVisible(true);
    }


    private void showPass() {
        if (showPassButton.isSelected()) {
            passwordField.setEchoChar((char) 0);
        }

        if(!showPassButton.isSelected()){
            passwordField.setEchoChar('\u25CF');
        }
    }
}
