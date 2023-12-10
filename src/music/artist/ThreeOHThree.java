package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class ThreeOHThree {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public ThreeOHThree() {
    }
    
    //this is my 2nd band file for 3OH!3, again just copied the beatles format over
    //Miguel B
    
    public ArrayList<Song> getThreeOHThreeSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("DONTTRUSTME", "3OH!3");                        //Create a song
         Song track2 = new Song("STARSSTRUKK", "3OH!3");                        //Create another song
         Song track3 = new Song("We Are Youn", "3OH!3");
         this.albumTracks.add(track1);                                          //Add the first song to song list for the Beatles
         this.albumTracks.add(track2);                                          //Add the second song to song list for the Beatles 
         this.albumTracks.add(track3);                                          //Adding the third song
         return albumTracks;                                                    //Return the songs for the Beatles in the form of an ArrayList
    }
}
