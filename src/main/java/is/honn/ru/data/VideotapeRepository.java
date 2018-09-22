package is.honn.ru.data;

import is.honn.ru.DTO.VideotapeDTO;
import is.honn.ru.entities.Videotape;

import java.util.List;

public interface VideotapeRepository {
    void fetchFromJSON();
    Videotape getVideoTapeById(int id);
    List<Videotape> getAllVideoTapes();
    void registerVideotape(VideotapeDTO tape);
}
