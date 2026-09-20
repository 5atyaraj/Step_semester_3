import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int songCount;

    // Constructor
    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    // Add a song
    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full.");
        }
    }

    // Return a copy of songs
    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    // Read-only song count
    public int getSongCount() {
        return songCount;
    }
}

public class P2_ThePlaylist {
    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        System.out.println("Song Count: " + p.getSongCount());

        String[] copy = p.getSongs();

        System.out.println("Songs before modifying copy:");
        for (String song : copy) {
            System.out.println(song);
        }

        // Modify the returned array
        copy[0] = "Hacked";

        System.out.println("\nModified copy:");
        for (String song : copy) {
            System.out.println(song);
        }

        System.out.println("\nActual playlist:");
        String[] actualSongs = p.getSongs();

        for (String song : actualSongs) {
            System.out.println(song);
        }
    }
}