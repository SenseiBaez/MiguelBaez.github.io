package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class TheWallflowers {
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public TheWallflowers() {
    }
    
    public ArrayList<Song> getTheWallflowersSongs() {
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("One Headlight", "The Wallflowers");            //Create a song
    	 Song track2 = new Song("6th Avenue Heartache", "The Wallflowers");
    	 Song track3 = new Song("CLoser to You", "The Wallflowers");
   													
         this.albumTracks.add(track1);                                          //Add the first song to song list for the Wallflowers
         this.albumTracks.add(track2);
         this.albumTracks.add(track3);
                                               
         return albumTracks;                                                    //Return the songs for the Wallflowers in the form of an ArrayList
    }
}
