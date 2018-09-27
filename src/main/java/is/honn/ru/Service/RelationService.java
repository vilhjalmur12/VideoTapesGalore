package is.honn.ru.Service;

import is.honn.ru.DTO.UserDTO;
import is.honn.ru.DTO.UserVideoRelationDTO;
import is.honn.ru.data.RelationRepository;
import is.honn.ru.data.RelationRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class RelationService {
    private RelationRepository _relationRepo;

    public RelationService() {
        _relationRepo = new RelationRepositoryImpl();
    }

    public List<UserVideoRelationDTO> getAllRelationsByUserId(int id) {
        return _relationRepo.getAllRelationsByUserId(id);
    }

    public boolean loanTape(UserVideoRelationDTO rel) {
        if (_relationRepo.getAllRelations().contains(rel)) {
            return false;
        } else {
            _relationRepo.setRelation(rel);
        }
        return true;
    }

    public HashSet<Integer> getUsersRenting() {
        HashSet<Integer> userIds = new HashSet<Integer>();

        for (UserVideoRelationDTO relation : _relationRepo.getAllRelations()) {
            if (relation.getReturnDate() == null) {
                userIds.add(relation.getUserId());
            }
        }
        return userIds;
    }

    public List<UserVideoRelationDTO> listDateOverdueRenting (Date date) {
        List<UserVideoRelationDTO> retVal = new ArrayList<UserVideoRelationDTO>();

        for (UserVideoRelationDTO relation : _relationRepo.getAllRelations()) {
            if (relation.getReturnDate() == null && date.compareTo(relation.getBorrowDate()) > 0) {
                retVal.add(relation);
            }
        }

        return retVal;
    }
}
