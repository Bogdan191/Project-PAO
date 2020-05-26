package gui;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.User;
import service.LoginService;

public class LoginFrame extends JFrame {
    private JButton buttonLogin;
    private JButton registerButton;
    private JTextField textFieldUser;
    private JTextField passwordField;
    private JLabel passwordText;
    private JLabel usernameText;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;

    public LoginFrame() {
        buttonLogin = new JButton("Log in");
        registerButton = new JButton("Register");
        textFieldUser = new JTextField(20);
        passwordField = new JTextField(20);
        passwordText = new JLabel("Password:");
        usernameText = new JLabel("Username:");

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        setLayout(new GridLayout(3, 1));
        setSize(500, 500);
        add(p1);
        add(p2);
        add(p3);
        p1.add(usernameText);
        p1.add(textFieldUser);
        p2.add(passwordText);
        p2.add(passwordField);
        p3.add(buttonLogin);
        p3.add(registerButton);
        buttonLogin.addActionListener((ev) -> {
           logIn();
        });

        registerButton.addActionListener((ev) ->{

            registerPage();

        });
        setDefaultCloseOperation(3);
        setLocationRelativeTo((Component)null);
        setVisible(true);
    }

    private void registerPage(){
        this.dispose();
        AddClient n = new AddClient();
        n.setVisible(true);
    }

    private void logIn() {
        String username = this.textFieldUser.getText();
        String password = this.passwordField.getText();
        User user = new User(username, password);
        LoginService service = LoginService.getInstance();
        if (service.login(user)) {
            JOptionPane.showMessageDialog((Component)null, "Log in reusit!");
            this.dispose();
            MainPageClient m = new MainPageClient();
            m.setVisible(true);
        } else {
            JOptionPane.showMessageDialog((Component)null, "Log in nereusit");
        }

    }
}