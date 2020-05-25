package service;

import model.User;
import repositories.UserRepository;

public class LoginService {
    UserRepository userRepository;
    public LoginService() {
        userRepository = new UserRepository();
    }

    public boolean login(User client) {

        User client1 = userRepository.findClientByUsername(client.getUsername());

        return client1 != null && client.getPassword().equals(client1.getPassword());
    }

    public final static LoginService getInstance(){
        return SingleTonHolder.INSTANCE;
    }

    private final static class SingleTonHolder {
        private final  static LoginService INSTANCE = new LoginService();
    }
}
