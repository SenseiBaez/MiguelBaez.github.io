package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class Slushii {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public Slushii() {
    }
    
    public ArrayList<Song> getSlushiiSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("All I Need", "Slushii");                       //Create a song
         Song track2 = new Song("LUV U NEED U", "Slushii");                     //Create another song
    	 Song track3 = new Song("Far Away", "Slushii");                         //Create a song
         Song track4 = new Song("So Long", "Slushii");                          //Create another song         
         Song track5 = new Song("Twinbow", "Slushii");                          //Create another song    
         
         this.albumTracks.add(track1);                                          //Add the first song to song list for the Beatles
         this.albumTracks.add(track2);                                          //Add the second song to song list for the Beatles 
         this.albumTracks.add(track3);                                          //Add the third song to song list for the Beatles 
         this.albumTracks.add(track4);                                          //Add the fourth song to song list for the Beatles 
         this.albumTracks.add(track5);                                          //Add the fifth song to song list for the Beatles 
         
         return albumTracks;                                                    //Return the songs for the Beatles in the form of an ArrayList
    }
}
