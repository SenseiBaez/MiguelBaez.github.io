package music.artist;

import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class TheDeadPoetSociety {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public TheDeadPoetSociety() {
    }

    //Added artist Dead Poet Society and 2 songs.
    
    public ArrayList<Song> getDeadPoetSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song(".CoDA.", "The Dead Poet Society");             //Create a song
         Song track2 = new Song(".intoodeep.", "The Dead Poet Society");         //Create another song
         Song track3 = new Song("Sound and Silence", "The Dead Poet Society");
         Song track4 = new Song("Lo Air", "The Dead Poet Society");
         
         this.albumTracks.add(track1);                                          //Add the first song to song list for the Beatles
         this.albumTracks.add(track2);                                          //Add the second song to song list for the Beatles 
         this.albumTracks.add(track3);
         this.albumTracks.add(track4);
         
         return albumTracks;                                                    //Return the songs for the Beatles in the form of an ArrayList
    }
}
