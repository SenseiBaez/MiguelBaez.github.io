package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class TwoFeet {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public TwoFeet() {
    }
    
    public ArrayList<Song> getTwoFeetSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("I Feel Like I'm Drowning", "Two Feet");        //Create a song
         Song track2 = new Song("I Want It", "Two Feet");                       //Create another song
         Song track3 = new Song("Nightmares", "Two Feet");                      //Create another song
         Song track4 = new Song("Back Of My Mind", "Two Feet");                 //Create another song
         Song track5 = new Song("Lies", "Two Feet");                            //Create another song
         Song track6 = new Song("Devil", "Two Feet");                           //Create another song
         
         this.albumTracks.add(track1);                                          //Add the first song to song list for Two Feet
         this.albumTracks.add(track2);                                          //Add the next song to song list for Two Feet
         this.albumTracks.add(track3);                                          //Add the next song to song list for Two Feet
         this.albumTracks.add(track4);                                          //Add the next song to song list for Two Feet
         this.albumTracks.add(track5);                                          //Add the next song to song list for Two Feet
         this.albumTracks.add(track6);                                          //Add the next song to song list for Two Feet
         
         return albumTracks;                                                    //Return the songs for Two Feet in the form of an ArrayList
    }
}
