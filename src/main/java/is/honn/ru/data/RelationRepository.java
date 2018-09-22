package is.honn.ru.data;

import is.honn.ru.DTO.UserVideoRelationDTO;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;

public interface RelationRepository {
    HashSet<UserVideoRelationDTO> _relations = new HashSet<UserVideoRelationDTO>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    void fetchFromJSON();
    HashSet<UserVideoRelationDTO> getAllRelations();
    UserVideoRelationDTO getRelationByTapeId(int id);
    void setRelation(UserVideoRelationDTO relation);
    List<UserVideoRelationDTO> getAllRelationsByUserId(int id);
}
