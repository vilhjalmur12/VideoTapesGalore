import is.honn.ru.DTO.UserDTO;
import is.honn.ru.data.JsonReaderService;
import is.honn.ru.data.ReaderService;
import is.honn.ru.data.Repository;
import is.honn.ru.data.RepositoryImpl;
import is.honn.ru.entities.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

public class main {
    public static void main(String[] args) {

        Repository repo = new RepositoryImpl();
        repo.fetchFromJSON();



    }
}
