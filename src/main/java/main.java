import is.honn.ru.DTO.UserVideoRelationDTO;
import is.honn.ru.data.RelationRepository;
import is.honn.ru.data.RelationRepositoryImpl;
import is.honn.ru.data.UserRepository;
import is.honn.ru.data.UserRepositoryImpl;

import java.util.HashSet;
import java.util.List;

public class main {
    public static void main(String[] args) {

        RelationRepository relRepo = new RelationRepositoryImpl();

        List<UserVideoRelationDTO> userRel = relRepo.getAllRelationsByUserId(2);

        for (UserVideoRelationDTO iter : userRel) {
            System.out.println(iter);
        }
    }
}
