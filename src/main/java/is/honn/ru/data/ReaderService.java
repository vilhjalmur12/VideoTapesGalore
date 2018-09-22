package is.honn.ru.data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface ReaderService {
    JSONArray getJsonArray();
    void readFromFile(String filepath);
    void writeToFile();

    @Override
    String toString();
}
