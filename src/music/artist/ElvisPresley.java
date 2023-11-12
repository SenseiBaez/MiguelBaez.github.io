package music.artist;


import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

public class ElvisPresley {
	
	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public ElvisPresley() {
    }
    
    public ArrayList<Song> getElvisPresleySongs() {
    	
    	 albumTracks = new ArrayList<Song>();                                   //Instantiate the album so we can populate it below
    	 Song track1 = new Song("That’s All Right", "Elvis Presley");             //Create a song
         Song track2 = new Song("Hound Dog", "Elvis Presley");                  //Create another song
         Song track3 = new Song("Are You Lonesome Tonight?", "Elvis Presley");
         Song track4 = new Song("Suspicious Minds", "Elvis Presley");
         this.albumTracks.add(track1);                                          //Add the first song to song list for Elvis
         this.albumTracks.add(track2);
         this.albumTracks.add(track3);                                          //Add the third song to song list for Elvis 
         this.albumTracks.add(track4);
         return albumTracks;                                                    //Return the songs for Elvis in the form of an ArrayList
    }
}