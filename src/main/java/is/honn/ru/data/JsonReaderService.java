package is.honn.ru.data;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReaderService implements ReaderService {
    private JSONParser parser;
    private JSONArray list;

    public JsonReaderService(String filepath) {
        parser = new JSONParser();
        readFromFile(filepath);
    }

    public JSONArray getJsonArray() {
        return list;
    }
    public void readFromFile(String filepath) {
        JSONArray jsonArray = null;

        try {
            //
            Object obj = parser.parse(new FileReader(filepath));
            jsonArray = (JSONArray) obj;

        } catch (ParseException pex) {
            System.out.println("Parsing file error");
        } catch (IOException ioex) {
            System.out.println("IO Exception");
        }

        this.list = jsonArray;
    }

    public void writeToFile() {

    }

    @Override
    public String toString() {
        return "";
    }
}
