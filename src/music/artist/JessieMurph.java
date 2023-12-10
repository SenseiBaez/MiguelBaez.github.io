package music.artist;

import java.util.ArrayList;

import snhu.jukebox.playlist.Song;

public class JessieMurph {

	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public JessieMurph() {
    }
    
    //Added artist Jessie Murph and 3 songs.
    
    public ArrayList<Song> getJessieMurphSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                               //Instantiate the album so we can populate it below
    	 Song track1 = new Song("I Would've", "Jessie Murph");              //Create a song
         Song track2 = new Song("Look Who's Cryin' Now", "Jessie Murph");   //Create another song
         Song track3 = new Song("Sobriety", "Jessie Murph");                //Create a third song
         this.albumTracks.add(track1);                                      //Add the first song to song list for Imagine Dragons
         this.albumTracks.add(track2);                                      //Add the second song to song list for Imagine Dragons 
         this.albumTracks.add(track3);                                      //Add the third song to song list for Imagine Dragons 
         return albumTracks;                                                //Return the songs for Imagine Dragons in the form of an ArrayList
    }
}