import is.honn.ru.DTO.UserVideoRelationDTO;
import is.honn.ru.UI.Console;
import is.honn.ru.UI.ConsoleImpl;
import is.honn.ru.data.RelationRepository;
import is.honn.ru.data.RelationRepositoryImpl;
import is.honn.ru.data.UserRepository;
import is.honn.ru.data.UserRepositoryImpl;

import java.util.HashSet;
import java.util.List;

public class main {
    public static void main(String[] args) {

        Console console = new ConsoleImpl();

        console.run();
    }
}
