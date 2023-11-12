package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class TheStorySoFar {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public TheStorySoFar() {
    }
    
    public ArrayList<Song> getTheStorySoFarSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                               //Instantiate the album so we can populate it below
    	 Song track1 = new Song("States and Minds", "The Story So Far");    //Create a song
         Song track2 = new Song("Roam", "The Story So Far");                //Create a second song
         Song track3 = new Song("Mt. Diablo", "The Story So Far");          //Create a third song
         
         this.albumTracks.add(track1);                                      //Add the first song to song list for The Story So Far
         this.albumTracks.add(track2);                                      //Add the second song to song list for The Story So Far
         this.albumTracks.add(track3);                                      //Add the third song to song list for The Story So Far
         
         return albumTracks;                                                //Return the songs for The Story So Far in the form of an ArrayList
    }

}
