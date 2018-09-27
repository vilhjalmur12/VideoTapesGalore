package is.honn.ru.Service;

import is.honn.ru.DTO.UserDTO;
import is.honn.ru.data.UserRepository;
import is.honn.ru.data.UserRepositoryImpl;
import is.honn.ru.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserRepository _userRepo;

    public UserService() {
        _userRepo = new UserRepositoryImpl();
    }

    public User getUserById(int id) {
        return _userRepo.getUserById(id);
    }

    public void registerUser(UserDTO user) {
        _userRepo.registerUser(user);
    }

    public List<User> getAllUsers() {
        return _userRepo.getAllUsers();
    };
}
