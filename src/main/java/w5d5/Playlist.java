package w5d5;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songs;

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        List<Song> result = new ArrayList<>();
        for (Song item: songs) {
            if (item.getLenghtInSeconds() > mins*60) {
                result.add(item);
            }
        }
        return result;
    }
}
