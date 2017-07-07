import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by Smile on 06.07.2017.
 */
public class Jukebox6 {
    ArrayList<Song> songList = new ArrayList<>();

    public static void main(String[] args) {
        new Jukebox6().go();
    }

    class ArtistComporator implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());

        }
    }

    void go() {
        getSongs();
        System.out.println("\nДо сортировки\n" + songList);
        Collections.sort(songList);
        System.out.println("\nПосле сортировки\n" + songList);

//        //Comparator
//        ArtistComporator artistComporator = new ArtistComporator();
//        Collections.sort(songList, artistComporator);
//        System.out.println(songList);

        HashSet<Song> songSet = new HashSet<>();
        songSet.addAll(songList);
        System.out.println("\nПосле HashSet\n" + songSet);
    }

    void getSongs() {
        try {
            File file = new File("songlist4.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch(Exception ex) {ex.printStackTrace();}
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
        System.out.println(nextSong.getArtist());
    }
}
