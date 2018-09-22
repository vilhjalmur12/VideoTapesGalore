package is.honn.ru.data;

import is.honn.ru.DTO.UserVideoRelationDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.util.*;

public class RelationRepositoryImpl implements RelationRepository {

    public RelationRepositoryImpl() {
        fetchFromJSON();
    }

    public void fetchFromJSON() {
        ReaderService reader = new JsonReaderService("./src/main/resources/Friends.json");

        Iterator<JSONObject> iter = reader.getJsonArray().iterator();

        while (iter.hasNext()) {
            JSONObject tmp = iter.next();

            if(tmp.containsKey("tapes")) {
                JSONArray tapeArr = (JSONArray) tmp.get("tapes");
                Iterator<JSONObject> tapeIter = tapeArr.iterator();

                while (tapeIter.hasNext()) {

                    try {
                        JSONObject tapeObject = tapeIter.next();
                        Date borrowDate = null;
                        Date returnDate = null;
                        try {
                            borrowDate = dateFormat.parse(tapeObject.get("borrow_date").toString());
                            returnDate = dateFormat.parse(tapeObject.get("return_date").toString());
                        } catch (NullPointerException nex) {

                        }

                        _relations.add(new UserVideoRelationDTO(
                                Integer.parseInt(tmp.get("id").toString()),
                                Integer.parseInt(tapeObject.get("id").toString()),
                                borrowDate,
                                returnDate
                        ));
                    } catch (ParseException pex) {
                        System.out.println("Illegal date parsing in: " + this.getClass().toString());
                    }
                }
            }
        }
    }

    public HashSet<UserVideoRelationDTO> getAllRelations() {
        return this._relations;
    }

    public UserVideoRelationDTO getRelationByTapeId(int id) {
        UserVideoRelationDTO retValue = null;

        for(UserVideoRelationDTO tmp : _relations) {
            if(tmp.getTapeId() == id) {
                retValue = tmp;
            }
        }

        return retValue;
    }

    public List<UserVideoRelationDTO> getAllRelationsByUserId(int id) {
        List<UserVideoRelationDTO> retValue = new ArrayList<UserVideoRelationDTO>();

        for(UserVideoRelationDTO iter : _relations) {
            if(iter.getUserId() == id) {
                retValue.add(iter);
            }
        }

        return retValue;
    }

    public void setRelation(UserVideoRelationDTO relation) {
        _relations.add(relation);
    }
}
