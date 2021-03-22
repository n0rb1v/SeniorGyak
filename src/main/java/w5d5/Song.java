package w5d5;

public class Song {
    private String name;
    private long lenghtInSeconds;
    private String artist;

    public Song(String name, long lenghtInSeconds, String artist) {
        if (name.isBlank()||artist.isBlank()) {
            throw new IllegalArgumentException("argument error");
        }
        if (lenghtInSeconds < 1) {
            throw new IllegalArgumentException("argument error");
        }
        this.name = name;
        this.lenghtInSeconds = lenghtInSeconds;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", lenghtInSeconds=" + lenghtInSeconds +
                ", artist='" + artist + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public long getLenghtInSeconds() {
        return lenghtInSeconds;
    }

    public String getArtist() {
        return artist;
    }
}
