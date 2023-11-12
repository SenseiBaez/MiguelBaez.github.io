package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class PapaRoach {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public PapaRoach() {
    }
    
    public ArrayList<Song> getPapaRoachSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Forever", "Papa Roach");             			//Create a song
         Song track2 = new Song("Getting Away With Murder", "Papa Roach");      //Create another song
         Song track3 = new Song("Last Resort", "Papa Roach");
         Song track4 = new Song("Help", "Papa Roach");
         
         this.albumTracks.add(track1);                                          //Add the first song to song list for the Papa Roach
         this.albumTracks.add(track2);                                          //Add the second song to song list for the Papa Roach
         this.albumTracks.add(track3);
         this.albumTracks.add(track4);
         
         return albumTracks;                                                    //Return the songs for Papa Roach in the form of an ArrayList
    }
}
