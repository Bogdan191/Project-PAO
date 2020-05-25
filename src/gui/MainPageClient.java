package gui;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPageClient extends JFrame {
    private JPanel panel;
    private JButton biletCalatorButton;
    private JButton biletColetButton;
    private JButton sediiButton;
    private JButton contactButton;
    private JButton istoricComenziButton;
    private JButton anulareBiletButton;
    private JButton soferiButton;
    private JButton ruteButton;
    private JLabel despreNoiLabel;

    public MainPageClient() {

        this.add(this.panel);
        this.setSize(500, 600);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo((Component)null);
    }
}
