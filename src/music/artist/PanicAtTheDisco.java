package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class PanicAtTheDisco {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public PanicAtTheDisco() {
    }
    
    public ArrayList<Song> getPanicAtTheDiscoSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                          //Instantiate the album so we can populate it below
    	 Song track1 = new Song("I Write Sins Not Tragedies", "Panic! At the Disco");  //Create a song
         Song track2 = new Song("But It's Better If You Do", "Panic! At the Disco");   //Create another song
         Song track3 = new Song("High Hopes", "Panic! At the Disco");
         
         this.albumTracks.add(track1);                                                 //Add the first song to song list for Panic! At The Disco
         this.albumTracks.add(track2);                                                 //Add the second song to song list for Panic! At The Disco
         this.albumTracks.add(track3);
         
         return albumTracks;                                                           //Return the songs for Panic! At The Disco in the form of an ArrayList
    }

}
