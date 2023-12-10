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
    	 Song track1 = new Song("With Oden On Our Side", "Amon Amarth");        //Add new song
         Song track2 = new Song("Crack the Sky", "Amon Amarth");                //Add new song 
    	 Song track3 = new Song("Twilight Of The Thunder God", "Amon Amarth");  //Add new song 
         Song track4 = new Song("Raise Your Horns", "Amon Amarth");             //Add new song 
    	 Song track5 = new Song("Ravens Flight", "Amon Amarth");                //Add new song 
         Song track6 = new Song("Shield Wall", "Amon Amarth");                  //Add new song
         this.albumTracks.add(track1);                                          //Adding song to artist album
         this.albumTracks.add(track2);                                          //Adding song to artist album 
         this.albumTracks.add(track3);                                          //Adding song to artist album 
         this.albumTracks.add(track4);                                          //Adding song to artist album
         this.albumTracks.add(track5);                                          //Adding song to artist album
         this.albumTracks.add(track6);                                          //Adding song to artist album
         return albumTracks;                                                    //Return the songs for the Beatles in the form of an ArrayList
    }
}
