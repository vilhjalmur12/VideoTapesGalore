package is.honn.ru.data;

import is.honn.ru.DTO.VideotapeDTO;
import is.honn.ru.entities.Videotape;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VideotapeRepositoryImpl implements VideotapeRepository {
    private JSONArray videotapeList;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public VideotapeRepositoryImpl() {
        videotapeList = null;
        fetchFromJSON();
    }

    public void fetchFromJSON() {
        ReaderService reader = new JsonReaderService("./src/main/resources/Videotapes.json");
        this.videotapeList = reader.getJsonArray();
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

    public List<Videotape> getAllVideoTapes() {
        return new ArrayList<Videotape>();
    }
}
