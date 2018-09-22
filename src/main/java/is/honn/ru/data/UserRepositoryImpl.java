package is.honn.ru.data;

import is.honn.ru.entities.User;
import is.honn.ru.DTO.UserDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private JSONArray friendList;

    private JSONArray userVideotapeRelation;


    public UserRepositoryImpl() {
        friendList = null;
        fetchFromJSON();
    }


    public void fetchFromJSON() {
        ReaderService reader = new JsonReaderService("./src/main/resources/Friends.json");
        this.friendList = reader.getJsonArray();
    }


    public User getUserById(int id) {
        User user = null;
        Iterator<JSONObject> iter = this.friendList.iterator();
        while (iter.hasNext()) {
            JSONObject tmp = iter.next();
            if (Integer.parseInt(tmp.get("id").toString()) == id) {
                user = new User(
                        tmp.get("first_name").toString() + " " + tmp.get("last_name"),
                        tmp.get("address").toString(),
                        tmp.get("email").toString(),
                        tmp.get("phone").toString());
                break;
            }
        }

        return user;
    }


    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<User>();

        Iterator<JSONObject> iter = this.friendList.iterator();
        while(iter.hasNext()) {

        }

        return new ArrayList<User>();
    }


    public void registerUser(UserDTO user) {
        JSONObject tmpObj = (JSONObject) friendList.get(friendList.size() - 1);
        int id = Integer.parseInt(tmpObj.get("id").toString()) + 1;

        JSONObject newUser = new JSONObject();
        newUser.put("id", id);
        newUser.put("first_name", user.getFirstName());
        newUser.put("last_name", user.getLastName());
        newUser.put("email", user.getEmail());
        newUser.put("phone", user.getPhone());
        newUser.put("address", user.getAddress());

        this.friendList.add(newUser);
    }
}
