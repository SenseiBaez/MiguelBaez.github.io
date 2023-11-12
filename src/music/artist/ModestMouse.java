package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class ModestMouse {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public ModestMouse() {
    }
       

	public ArrayList<Song> getModestMouseSongs() {
		albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
   	 	Song track1 = new Song("Float On", "Modest Mouse");                    //Create a song
        Song track2 = new Song("Dashboard", "Modest Mouse");                   //Create another song
        Song track3 = new Song("Lampshades On Fire", "Modest Mouse");
        Song track4 = new Song("We Are Between", "Modest Mouse");
        
        
        this.albumTracks.add(track1);                                          //Add the first song to song list for Modest Mouse
        this.albumTracks.add(track2);                                          //Add the second song to song list for Modest Mouse 
        this.albumTracks.add(track3);
        this.albumTracks.add(track4);
        
        return albumTracks;
	}
}