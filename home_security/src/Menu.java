import javax.swing.*;

public class Menu extends JPanel{

    public Menu(){
        this.setBackground(Constants.GREY);

        JButton b1 = new JButton("Test Button");
        this.add(b1);

        this.setVisible(true);
    }
}
