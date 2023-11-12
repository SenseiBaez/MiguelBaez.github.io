package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class JimiHendrix {
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public JimiHendrix() {
    }
    
    public ArrayList<Song> getJimiHendrixSongs() {
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Purple Haze", "Jimi Hendrix");             	//Create a song
         Song track2 = new Song("Fire", "Jimi Hendrix");         				//Create another song
         this.albumTracks.add(track1);                                          //Add the first song to song list for Jimi Hendrix
         this.albumTracks.add(track2);                                          //Add the second song to song list for Jimi Hendrix 
         return albumTracks;                                                    //Return the songs for Jimi Hendrix in the form of an ArrayList
    }
}
