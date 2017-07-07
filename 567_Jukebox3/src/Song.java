/**
 * Created by Саша on 29.06.2017.
 */
public class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    public Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String toString() {
        return title;
    }
}
