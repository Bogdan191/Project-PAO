package gui;

import model.Client;

import javax.swing.*;

public class AddClient extends JFrame{
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JTextField nameText;
    private JTextField phoneNumberText;
    private JLabel usernameLabel;
    private JButton registerButton;
    private JPanel mainPanel;
    private JButton backToLoginButton;

    public AddClient(){

        add(mainPanel);

        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        backToLoginButton.addActionListener((ev) -> { /// buton care duce inapoi la pagina de login
            backToLogin();
        });

        registerButton.addActionListener((ev) -> { /// buton care inregistreaza noul cont de user
            addClient();
        });



    }

    private void backToLogin(){ /// functia asociata butonului 'backToLoginButton'
        this.dispose();
        LoginFrame newFrame = new LoginFrame();
        newFrame.setVisible(true);
    }

    private void addClient() { ///functia asociata butonului 'registerButton'

        String username = usernameText.getText();
        String password = passwordText.getText();
        String name = nameText.getText();
        String phoneNumber = phoneNumberText.getText();

        service.AddClient serviceAdd = new service.AddClient(); /// serviciu care adauga in baza de date noul cont de user

        boolean corect = false;
        while(!corect){ /// cat timp input-ul de date este incorect, reincearca
            if(username.equals("")) {
                JOptionPane.showMessageDialog(null, "Te rog completeaza campul 'username'");
                break;
            }
            if(password.equals("")) {
                JOptionPane.showMessageDialog(null, "Te rog completeaza campul 'Parola'");
                break;
            }
            if(password.length() < 5){
                JOptionPane.showMessageDialog(null, "Parola trebuie sa aiba mai mult de 5 caractere!");
                break;
            }
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Te rog completeaza campul 'Nume prenume'");
                break;
            }
            if(phoneNumber.equals("")){
                JOptionPane.showMessageDialog(null, "Te rog completeaza campul 'Numar de telefon'");
                break;

            }
            if(phoneNumber.length() < 10) {
                JOptionPane.showMessageDialog(null, "Numarul de telefon nu are un format corect");
                break;
            }
            if(serviceAdd.existingUsername(username)){
                JOptionPane.showMessageDialog(null, "Username existent. Alege altul");
                break;
            }
            else if(username != null && password != null && name != null && phoneNumber != null){
                corect = true;
            }
        }

        if(corect){ //se adauga in baza de date si se revine la pagina de login
            serviceAdd.addClient(new Client(username, password, name, phoneNumber, 0));
            this.dispose();
            LoginFrame newFrame = new LoginFrame();
            newFrame.setVisible(true);
        }



    }



}

