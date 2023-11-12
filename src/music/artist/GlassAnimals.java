package music.artist;

import java.util.ArrayList;

import snhu.jukebox.playlist.Song;

public class GlassAnimals {
	ArrayList<Song> albumTracks;
	String albumTitle;
	
	public GlassAnimals() {
	}
	
	public ArrayList<Song> getGlassAnimalsSongs() {

		albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
		Song track1 = new Song("Gooey", "Glass Animals");                      //Create a song
        Song track2 = new Song("Heat Waves", "Glass Animals");                 //Create another song
        this.albumTracks.add(track1);                                          //Add the first song to song list for Glass Animals
        this.albumTracks.add(track2);                                          //Add the second song to song list for Glass Animals
        return albumTracks;                                                    //Return the songs for  Glass Animals in the form of an ArrayList
	}

}
