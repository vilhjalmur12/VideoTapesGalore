package is.honn.ru.data;

import is.honn.ru.entities.User;
import is.honn.ru.entities.Videotape;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {

    public void fetchFromJSON() {
        
    }

    public User getUserById(int id) {
        return new User();
    }

    public List<User> getAllUsers() {
        return new ArrayList<User>();
    }

    public Videotape getVideoTapeById() {
        return new Videotape();
    }
    public List<Videotape> getAllVideoTapes() {
        return new ArrayList<Videotape>();
    }
    public void registerUser(User user) {

    }
    public void registerVideotape(Videotape tape) {

    }
}
