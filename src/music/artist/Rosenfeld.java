package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class Rosenfeld {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public Rosenfeld() {
    }
    
    public ArrayList<Song> getRosenfeldSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Do It For Me", "Rosenfeld");                   //Create a song
         Song track2 = new Song("Gimme Love", "Rosenfeld");                     //Create another song
         Song track3 = new Song("I Want To", "Rosenfeld");                      //Create another song
         
         this.albumTracks.add(track1);                                          //Add the first song to song list for Rosenfeld
         this.albumTracks.add(track2);                                          //Add the next song to song list for Rosenfeld
         this.albumTracks.add(track3);                                          //Add the next song to song list for Rosenfeld
         
         return albumTracks;                                                    //Return the songs for Rosenfeld in the form of an ArrayList
    }
}
