package is.honn.ru.DTO;

import java.util.Date;

public class VideotapeDTO {
    private int id;
    private String title;
    private String directorFirstName;
    private String directorLastName;
    private String type;
    private Date releaseDate;
    private String EIDR;

    public VideotapeDTO() {}

    public VideotapeDTO(String title, String directorFirstName, String directorLastName,
                     String type, Date releaseDate, String EIDR) {
        this.title = title;
        this.directorFirstName = directorFirstName;
        this.directorLastName = directorLastName;
        this.type = type;
        this.releaseDate = releaseDate;
        this.EIDR = EIDR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectorFirstName() {
        return directorFirstName;
    }

    public void setDirectorFirstName(String director) {
        this.directorFirstName = director;
    }

    public String getDirectorLastName() {
        return directorLastName;
    }

    public void setDirectorLastName(String directorLastName) {
        this.directorLastName = directorLastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEIDR() {
        return EIDR;
    }

    public void setEIDR(String EIDR) {
        this.EIDR = EIDR;
    }

    // TODO: finna leið fyrir date í string format
    @Override
    public String toString() {
        return String.format("%s \t%s \t %s\t %s\t %s", this.title, this.directorFirstName,
                this.directorLastName, this.type, this.EIDR);
    }
}
