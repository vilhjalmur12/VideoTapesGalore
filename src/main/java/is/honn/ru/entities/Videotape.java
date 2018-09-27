package is.honn.ru.entities;

import java.util.Date;

public class Videotape {
    private int id;
    private String title;
    private String director;
    private String type;
    private Date releaseDate;
    private String EIDR;

    public Videotape() {}

    public Videotape(String title, String director,
                     String type, Date releaseDate, String EIDR) {
        this.title = title;
        this.director = director;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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
        return String.format("%s\t\t%s\t\t%s\t\t%s", this.title, this.director,
                this.type, this.EIDR);
    }
}
