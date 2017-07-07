import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Smile on 06.07.2017.
 */
public class Jukebox8 {
    ArrayList<Song> songList = new ArrayList<>();

    public static void main(String[] args) {
        new Jukebox8().go();
    }

    class TitleComporator implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getTitle().compareTo(two.getTitle());

        }
    }

    void go() {
        getSongs();
        System.out.println("\nДо сортировки\n" + songList);
        Collections.sort(songList);
        System.out.println("\nПосле сортировки\n" + songList);

//        //Comparator
        TitleComporator titleComporator = new TitleComporator();
//        Collections.sort(songList, artistComporator);
//        System.out.println(songList);

        TreeSet<Song> songSet = new TreeSet<>();
        songSet.addAll(songList);
        System.out.println("\nПосле TreeSet\n" + songSet);
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
