package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class AmonAmarth {
	
    ArrayList<Song> albumTracks;
    String albumTitle;
    
    public AmonAmarth() {
    }
    
    public ArrayList<Song> getAmonAmarthSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("With Oden On Our Side", "Amon Amarth");             //Create a song
         Song track2 = new Song("Crack the Sky", "Amon Amarth");         //Create another song
    	 Song track3 = new Song("Twilight Of The Thunder God", "Amon Amarth");             //Create a song
         Song track4 = new Song("Raise Your Horns", "Amon Amarth");         //Create another song
    	 Song track5 = new Song("Ravens Flight", "Amon Amarth");             //Create a song
         Song track6 = new Song("Shield Wall", "Amon Amarth");         //Create another song
         this.albumTracks.add(track1);                                          //Add the first song to song list for the Beatles
         this.albumTracks.add(track2);                                          //Add the second song to song list for the Beatles 
         this.albumTracks.add(track3);                                          //Add the second song to song list for the Beatles 
         this.albumTracks.add(track4);                                          //Add the second song to song list for the Beatles 
         this.albumTracks.add(track5);                                          //Add the second song to song list for the Beatles 
         this.albumTracks.add(track6);                                          //Add the second song to song list for the Beatles 
         return albumTracks;                                                    //Return the songs for the Beatles in the form of an ArrayList
    }
}
