package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class TheWeeknd {
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public TheWeeknd() {
    }
    
    public ArrayList<Song> getTheWeekndSongs() {
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Starboy", "The Weeknd");             			//Create a song
         Song track2 = new Song("Blinding Lights", "The Weeknd");				//Create another song
         Song track3 = new Song("Die For You", "The Weeknd");
         
         this.albumTracks.add(track1);                                          //Add the first song to song list for the Weeknd
         this.albumTracks.add(track2);                                          //Add the second song to song list for the Weeknd 
         this.albumTracks.add(track3);
         
         return albumTracks;                                                    //Return the songs for the Weeknd in the form of an ArrayList
    }
}
