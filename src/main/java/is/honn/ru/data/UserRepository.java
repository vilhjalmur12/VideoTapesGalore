package is.honn.ru.data;

import is.honn.ru.DTO.UserDTO;
import is.honn.ru.DTO.VideotapeDTO;
import is.honn.ru.entities.User;
import is.honn.ru.entities.Videotape;

import java.util.HashSet;
import java.util.List;

public interface UserRepository {
    //HashSet<User> _userDB = new HashSet<User>();
    //HashSet<Videotape> _videotapeDB = new HashSet<Videotape>();

    void fetchFromJSON();
    User getUserById(int id);
    List<User> getAllUsers();
    void registerUser(UserDTO user);
}
