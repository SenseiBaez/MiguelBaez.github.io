package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class Metallica {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public Metallica() {
    }
    
    //copied the TheBeatles class and repurposed it for Metallica, because why not
    
    public ArrayList<Song> getMetallicaSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Master of Puppets", "Metallica");              //Create a song
         Song track2 = new Song("For Whom the Bell Tolls", "Metallica");        //Create another song
         this.albumTracks.add(track1);                                          //Add the first song to song list for the Beatles
         this.albumTracks.add(track2);                                          //Add the second song to song list for the Beatles 
         return albumTracks;                                                    //Return the songs for the Beatles in the form of an ArrayList
    }
}
