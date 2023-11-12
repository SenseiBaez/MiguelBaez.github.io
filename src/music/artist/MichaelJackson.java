package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class MichaelJackson {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public MichaelJackson() {
    }
    
    public ArrayList<Song> getMichaelJacksonSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Billie Jean", "Michael Jackson");              //Create a song
         Song track2 = new Song("The Way You Make Me Feel", "Michael Jackson");
         Song track3 = new Song("Beat It", "Michael Jackson");
         Song track4 = new Song("Smooth Criminal", "Michael Jackson");
         
         this.albumTracks.add(track1);                                          //Add the first song to song list for Michael Jackson
         this.albumTracks.add(track2);
         this.albumTracks.add(track3);
         this.albumTracks.add(track4);
         
         return albumTracks;                                                    //Return the songs for Michael Jackson in the form of an ArrayList
    }
}