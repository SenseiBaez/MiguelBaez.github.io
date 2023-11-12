package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class JohnnyCash {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public JohnnyCash() {
    }
    

	public ArrayList<Song> getJohnnyCashSongs() {
		
		albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
   	 	Song track1 = new Song("Hurt", "Johnny Cash");                         //Create a song
        Song track2 = new Song("Folsom Prison Blues", "Johnny Cash");          //Create another song
        Song track3 = new Song("Boy Named Sue", "Johnny Cash");                //Create another song
        this.albumTracks.add(track1);                                          //Add the first song to song list for Johnny Cash
        this.albumTracks.add(track2);                                          //Add the second song to song list for Johnny Cash
        this.albumTracks.add(track3);                                          //Add the third song to song list for Johnny Cash
        return albumTracks;
	}
}