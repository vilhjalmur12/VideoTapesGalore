package is.honn.ru.Service;

import is.honn.ru.DTO.VideotapeDTO;
import is.honn.ru.data.VideotapeRepository;
import is.honn.ru.data.VideotapeRepositoryImpl;
import is.honn.ru.entities.Videotape;

import java.util.List;

public class VideotapeService {
    private VideotapeRepository _tapeRepo;

    public VideotapeService() {
        _tapeRepo = new VideotapeRepositoryImpl();
    }

    public Videotape getVideotapeById(int id) {
        return _tapeRepo.getVideoTapeById(id);
    }

    public void registerVideotape(VideotapeDTO tape) {
        _tapeRepo.registerVideotape(tape);
    }

    public List<Videotape> getAllTapes() { return _tapeRepo.getAllVideoTapes(); }
}
