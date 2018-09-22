package is.honn.ru.data;

import com.sun.org.apache.xerces.internal.dom.PSVIDOMImplementationImpl;
import is.honn.ru.DTO.VideotapeDTO;
import is.honn.ru.entities.User;
import is.honn.ru.DTO.UserDTO;
import is.honn.ru.entities.Videotape;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RepositoryImpl implements Repository {
    private JSONArray friendList;
    private JSONArray videotapeList;
    private JSONArray userVideotapeRelation;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public RepositoryImpl() {
        friendList = null;
        videotapeList = null;
        fetchFromJSON();
    }


    public void fetchFromJSON() {
        ReaderService reader = new JsonReaderService("./src/main/resources/Friends.json");
        this.friendList = reader.getJsonArray();
        reader = new JsonReaderService("./src/main/resources/Videotapes.json");
        this.videotapeList = reader.getJsonArray();
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


    public Videotape getVideoTapeById(int id) {
        Videotape tape = null;
        Iterator<JSONObject> iter = this.videotapeList.iterator();

        while (iter.hasNext()) {
            JSONObject tmp = iter.next();
            if (Integer.parseInt(tmp.get("id").toString()) == id) {
                try {
                    Date date = dateFormat.parse(tmp.get("release_date").toString());
                    tape = new Videotape(
                            tmp.get("title").toString(),
                            tmp.get("director_first_name").toString() + " " +
                                    tmp.get("director_last_name").toString(),
                            tmp.get("type").toString(),
                            date,
                            tmp.get("eidr").toString()
                    );
                } catch (ParseException pex) {
                    System.out.println("Illegal date parse in: " + this.getClass().toString());
                }

            }
        }


        return new Videotape();
    }


    public List<Videotape> getAllVideoTapes() {
        return new ArrayList<Videotape>();
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


    public void registerVideotape(VideotapeDTO tape) {
        JSONObject tmpObj = (JSONObject) videotapeList.get(videotapeList.size() - 1);
        int id = Integer.parseInt(tmpObj.get("id").toString() + 1);

        try {
            Date date = dateFormat.parse(tape.getReleaseDate().toString());
            JSONObject newTape = new JSONObject();
            newTape.put("id", id);
            newTape.put("title", tape.getTitle());
            newTape.put("director_first_name", tape.getDirectorFirstName());
            newTape.put("director_last_name", tape.getDirectorLastName());
            newTape.put("type", tape.getType());
            newTape.put("release_date", tape.getReleaseDate().toString());
            newTape.put("eidr", tape.getEIDR());

            this.videotapeList.add(newTape);
        } catch (ParseException pex) {
            System.out.println("Illegal date parse in: " + this.getClass().toString());
        }
    }


}
