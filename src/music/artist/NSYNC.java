package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class NSYNC {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public NSYNC() {
    }
    
    public ArrayList<Song> getNSYNCSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Bye Bye", "NSYNC");                            //Create a song
         Song track2 = new Song("Gone", "NSYNC");                               //Create another song
         Song track3 = new Song("Girlfriend", "NSYNC");                         //Create another song
         Song track4 = new Song("I want you back", "NSYNC");                    //Create another song
         
         this.albumTracks.add(track1);                                          //Add the first song to song list for  NSYNC
         this.albumTracks.add(track2);                                          //Add the second song to song list for NSYNC
         this.albumTracks.add(track3);											//Add the third song to song list for  NSYNC
         this.albumTracks.add(track4);                                          //Add the fourth song to song list for NSYNC
         
         return albumTracks;                                                    //Return the songs for NSYNC in the form of an ArrayList
    }
}
