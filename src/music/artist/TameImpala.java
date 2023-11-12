package music.artist;

import java.util.ArrayList;

import snhu.jukebox.playlist.Song;

public class TameImpala {
	ArrayList<Song> albumTracks;
	String albumTitle;
	
	public TameImpala() {
	}
	
	public ArrayList<Song> getTameImpalaSongs() {
		
		albumTracks = new ArrayList<Song>();                                                      //Instantiate the album so we can populate it below
		Song track1 = new Song("Elephant", "Tame Impala");                                        //Create a song
        Song track2 = new Song("Feels Like We Only Go Backwards", "Tame Impala");                 //Create another song
        Song track3 = new Song("The Less I Know The Better", "Tame Impala");                      //Create another song
        this.albumTracks.add(track1);                                                             //Add the first song to song list for Tame Impala
        this.albumTracks.add(track2);                                                             //Add the second song to song list for Tame Impala
        this.albumTracks.add(track3);                                                             //Add the third song to song list for Tame Impala
        return albumTracks;                                                                       //Return the songs for Tame Impala in the form of an ArrayList	 
	}
	
	
}


