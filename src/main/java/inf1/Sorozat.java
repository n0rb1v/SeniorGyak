package inf1;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sorozat {
    private String date;
    private String name;
    private int season;
    private int episode;
    private int minutes;
    private int ready;

    public Sorozat(String date, String name, String s_e, int minutes, int ready) {
        this.date = date;
        this.name = name;
        String[] tmp = s_e.split("x");
        this.season = Integer.parseInt(tmp[0]);
        this.episode = Integer.parseInt(tmp[1]);
        this.minutes = minutes;
        this.ready = ready;
    }

    public LocalDate getDate() {
        if (date.equals("NI")) {
            return null;
        } else {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            return LocalDate.parse(date, dateTimeFormatter);
        }
    }

    public String getName() {
        return name;
    }

    public int getSeason() {
        return season;
    }

    public int getEpisode() {
        return episode;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getReady() {
        return ready;
    }
}
