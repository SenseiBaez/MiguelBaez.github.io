package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class TheEagles {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public TheEagles() {
    }
    
    public ArrayList<Song> getEaglesSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Hotel California", "The Eagles");              //Create a song
         Song track2 = new Song("Take It Easy", "The Eagles");   		        //Create another song
         this.albumTracks.add(track1);                                          //Add the first song to song list for the Eagles
         this.albumTracks.add(track2);                                          //Add the second song to song list for the Eagles 
         return albumTracks;                                                    //Return the songs for the Eagles in the form of an ArrayList
    }
}
