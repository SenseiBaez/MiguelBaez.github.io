package music.artist;

import java.util.ArrayList;

import snhu.jukebox.playlist.Song;

public class TravisScott {

	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public TravisScott() {
    }
    
    public ArrayList<Song> getTravisScottsSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                           //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Butterfly Effect", "Travis Scott");    //Create a song
    	 Song track2 = new Song("MELTDOWN", "Travis Scott");
    	 Song track3 = new Song("SAY MY GRACE", "Travis Scott");
    	 Song track4 = new Song("HYAENA", "Travis Scott");
         
         this.albumTracks.add(track1);                                  //Add the first song to song list
         this.albumTracks.add(track2);
         this.albumTracks.add(track3);
         this.albumTracks.add(track4);
         
         return albumTracks;                                            //Return the songs for Travis Scott in the form of an ArrayList
    }
}