package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class VirtualRiot {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public VirtualRiot() {
    }
    
    public ArrayList<Song> getVirtualRiotSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Everyday", "Virtual Riot");                    //Create a song
         Song track2 = new Song("Nasty", "Virtual Riot");                       //Create another song
         Song track3 = new Song("Energy Drinks", "Virtual Riot");               //Create another song
         Song track4 = new Song("We're Not Alone", "Virtual Riot");             //Create another song
         Song track5 = new Song("This Could Be Us", "Virtual Riot");            //Create another song
         
         this.albumTracks.add(track1);                                          //Add the first song to song list for the Beatles
         this.albumTracks.add(track2);                                          //Add the second song to song list for the Beatles 
         this.albumTracks.add(track3);                                          //Add the third song to song list for the Beatles 
         this.albumTracks.add(track4);                                          //Add the fourth song to song list for the Beatles 
         this.albumTracks.add(track5);                                          //Add the fifth song to song list for the Beatles 
         
         return albumTracks;                                                    //Return the songs for the Beatles in the form of an ArrayList
    }
}
