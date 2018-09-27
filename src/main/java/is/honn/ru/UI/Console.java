package is.honn.ru.UI;

import is.honn.ru.Service.RelationService;
import is.honn.ru.Service.UserService;
import is.honn.ru.Service.VideotapeService;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public interface Console {
    UserService userService = new UserService();
    VideotapeService videoService = new VideotapeService();
    RelationService relationService = new RelationService();
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    void run();
}
