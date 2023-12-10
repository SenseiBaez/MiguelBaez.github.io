package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class Nelly {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public Nelly() {
    }
    
    public ArrayList<Song> getNellySongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Hot in Here", "Nelly");                        //Create a song
         Song track2 = new Song("Grillz", "Nelly");                             //Create another song
         Song track3 = new Song ("Ride Wit Me","Nelly");                        //Create another song
         Song track4 = new Song("E.I","Nelly");                                 //Create another song
         Song track5 = new Song("All A Dream","Nelly");                         //Create another song
         
         this.albumTracks.add(track1);                                          //Add the first song to song list for  Nelly
         this.albumTracks.add(track2);                                          //Add the second song to song list for  Nelly
         this.albumTracks.add(track3);                                          //Add the third song to song list for Nelly
         this.albumTracks.add(track4);                                          //Add the fourth song to song list for Nelly
         this.albumTracks.add(track5);                                          //Add the fifth song to song list for Nelly
         return albumTracks;                                                    //Return the songs for Nelly in the form of an ArrayList
    }
}
