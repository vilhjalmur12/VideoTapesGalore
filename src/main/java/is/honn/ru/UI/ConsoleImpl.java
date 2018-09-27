package is.honn.ru.UI;

import is.honn.ru.DTO.UserDTO;
import is.honn.ru.DTO.UserVideoRelationDTO;
import is.honn.ru.DTO.VideotapeDTO;
import is.honn.ru.entities.User;
import is.honn.ru.entities.Videotape;

import java.text.ParseException;
import java.util.*;

public class ConsoleImpl implements Console {

    public void run() {
        String argument = "";

        welcomeScreen();


        while(true) {

            argument = getArgument();
            validateArgument(argument);
        }
    }

    private void welcomeScreen() {
        outl("--- Welcome to videogalore ---");
        helpScreen();
    }

    private void helpScreen() {
        outl("-------   To use the software use the following commands  -------");
        outl("| reg-user - registers user to the software                     |");
        outl("| reg-tape - registers tape to the software                     |");
        outl("| loan - loans out a videotape to a user                        |");
        outl("| all-tapes - shows all tapes in the database                   |");
        outl("| all-users - shows all users in the database                   |");
        outl("| tapes-by-user - shows all tapes rented by user                |");
        outl("| help - shows this help screen                                 |");
        outl("| users-renting - list of users renting a tape                  |");
        outl("-----------------------------------------------------------------");
    }

    private void outl(String text) {
        System.out.println(text);
    }

    private void out(String text) {
        System.out.print(text);
    }

    private String getArgument() {
        out("> ");
        return scanner.nextLine();
    }

    private void validateArgument(String argument) {
        if(argument.equalsIgnoreCase("exit")) {
            System.exit(0);
        } else if (argument.equalsIgnoreCase("reg-user")) {
            registerUser();
        } else if (argument.equalsIgnoreCase("reg-tape")) {
            registerVideotape();
        } else if (argument.equalsIgnoreCase("help")) {
            helpScreen();
        } else if (argument.equalsIgnoreCase("loan")) {
            loanTape();
        } else if (argument.equalsIgnoreCase("all-tapes")) {
            printAllTapes();
        } else if (argument.equalsIgnoreCase("all-users")) {
            printAllUsers();
        } else if (argument.equalsIgnoreCase("tape-by-user")) {
            printTapesByUser();
        } else if (argument.equalsIgnoreCase("users-renting")) {
            printUsersRenting();
        } else if (argument.equalsIgnoreCase("monthly-overdue")) {
            monthlyOverdue();
        }
    }

    private void registerUser() {
        UserDTO newUser = new UserDTO();

        out("First Name ");
        newUser.setFirstName(getArgument());
        outl("");

        out("Last Name ");
        newUser.setLastName(getArgument());
        outl("");

        out("Address ");
        newUser.setAddress(getArgument());
        outl("");

        out("Email ");
        newUser.setEmail(getArgument());
        outl("");

        out("Phone");
        newUser.setEmail(getArgument());
        outl("");

        userService.registerUser(newUser);

    }

    private void registerVideotape() {
        VideotapeDTO newTape = new VideotapeDTO();

        out("Title ");
        newTape.setTitle(getArgument());
        outl("");

        out("Director First Name ");
        newTape.setDirectorFirstName(getArgument());
        outl("");

        out("Director Last Name ");
        newTape.setDirectorLastName(getArgument());
        outl("");

        out("Type ");
        newTape.setType(getArgument());
        outl("");


        Date relDate = new Date();
        try {
            out("Release Date (yyyy-MM-dd) ");
            relDate = dateFormat.parse(getArgument());
        } catch (ParseException pex) {
            outl("Incorrect date format, setting the release date to today.");
        }

        newTape.setReleaseDate(relDate);
        outl("");

        out("EIDR Number ");
        newTape.setEIDR(getArgument());
        outl("");

        videoService.registerVideotape(newTape);
    }

    private void printAllTapes() {
        outl("-- Videotapes ---");
        outl("Title\tDirector\tType\tRelease Date\tEIDR");

        for (Videotape tape : videoService.getAllTapes()) {
            outl(tape.toString());
        }
    }

    private void printAllUsers() {
        outl("-- Users ---");
        outl("Name\tAddress\tEmail\tPhone");

        for (User user : userService.getAllUsers()) {
            outl(user.toString());
        }
    }

    private void printTapesByUser() {
        out("User ID ");
        List<UserVideoRelationDTO> relList =
                relationService.getAllRelationsByUserId(Integer.parseInt(getArgument()));

        List<Videotape> tapeList = new ArrayList<Videotape>();

        outl("-- Videotapes ---");
        outl("Title\tDirector\tType\tRelease Date\tEIDR");

        for (UserVideoRelationDTO relTmp : relList) {
            outl(videoService.getVideotapeById(relTmp.getTapeId()).toString());
            outl("Borrowing Date\tReturn Date");
            out(dateFormat.format(relTmp.getBorrowDate()) + "\t");
            if (relTmp.getReturnDate() == null) {
                outl("");
            } else {
                outl(dateFormat.format(relTmp.getReturnDate()));
            }
        }

    }

    private void loanTape() {
        boolean notList = true;
        String argument = "";
        int tapeId = 0;
        int userId = 0;


        while (notList) {
            outl("Enter videotape ID or list all videotapes (all-tapes)");
            argument = getArgument();

            try {
                tapeId = Integer.parseInt(argument);
                notList = false;
            } catch (Exception ex) {
                if (argument.equalsIgnoreCase("all-tapes")) {
                    printAllTapes();
                } else {
                    outl("Invalid request, try again.");
                }
            }
        }
        notList = true;

        while(notList) {
            outl("Enter username ID or list all users (all-users)");
            argument = getArgument();

            try {
                userId = Integer.parseInt(argument);
                notList = false;
            } catch (Exception ex) {
                if(argument.equalsIgnoreCase("all-users")) {
                    printAllUsers();
                } else {
                    outl("Invalid request, try again");
                }
            }
        }

        UserVideoRelationDTO rel = new UserVideoRelationDTO(userId, tapeId, new Date(), null);

        if (relationService.loanTape(rel)) {
            outl("Successful register!");
        } else {
            outl("Unsuccessful register, cannot be loaned");
        }
    }

    public void printUsersRenting() {

        for(Integer userId : relationService.getUsersRenting()) {
            outl(userService.getUserById(userId).toString());
            for (UserVideoRelationDTO relByUser : relationService.getAllRelationsByUserId(userId)) {
                if (relByUser.getReturnDate() == null) {
                    outl(videoService.getVideotapeById(relByUser.getTapeId()).toString());
                }
            }
            outl("");
        }
    }

    public void monthlyOverdue() {

        try {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, -1);
            Date date = cal.getTime();
            String dateString = dateFormat.format(date);
            Date formattedDate = dateFormat.parse(dateString);


            for (UserVideoRelationDTO relation :
                    relationService.listDateOverdueRenting(dateFormat.parse(dateString)))
            {
                outl(userService.getUserById(relation.getUserId()).toString());
                outl(videoService.getVideotapeById(relation.getTapeId()).toString());
                outl("Rented Date: " + dateFormat.format(relation.getBorrowDate()));
                outl("");
            }
        } catch (ParseException ex) {
            outl("Illegal use of date in time");
        }
    }


}
