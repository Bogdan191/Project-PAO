package gui;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.*;

import model.User;
import service.LoginService;

public class LoginFrame extends JFrame {
    private JButton buttonLogin;
    private JButton registerButton;
    private JTextField textFieldUser;
    private JPasswordField passwordField;
    private JLabel passwordText;
    private JLabel usernameText;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;

    public LoginFrame() { // crearea layout-ului
        buttonLogin = new JButton("Log in");
        registerButton = new JButton("Register");
        textFieldUser = new JTextField(20);
        passwordField = new JPasswordField(20);
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
        buttonLogin.addActionListener((ev) -> { //buton pentru login
           logIn();
        });

        registerButton.addActionListener((ev) ->{ //buton pentru inregistrarea unui nou cont

            registerPage();

        });
        setDefaultCloseOperation(3);
        setLocationRelativeTo((Component)null);
        setVisible(true);
    }

    private void registerPage(){ // se deschide o noua fereastra 'AddClient' care se ocupa cu inregistrarea unui user
        this.dispose();
        AddClient n = new AddClient();
        n.setVisible(true);
    }


    private void logIn() {
        String username = textFieldUser.getText();
        String password = this.passwordField.getText();
        User user = new User(username, password);
        LoginService service = LoginService.getInstance(); //serviciu folosit pentru login
        if (service.login(user)) { ///daca logarea s-a efectuat cu succes, se deschide fereastra principala
            //JOptionPane.showMessageDialog((Component)null, "Log in reusit!");
            this.dispose();
            MainPageClient m = new MainPageClient();
            m.setVisible(true);
            m.setUsername(username);
        } else { ///altfel, se afiseaza un mesaj corespunzator
            JOptionPane.showMessageDialog((Component)null, "User-ul si/sau parola incorecte. \n Log in nereusit!");
        }

    }
}