package music.artist;

import java.util.ArrayList;

import snhu.jukebox.playlist.Song;

public class KatyPerry {

	ArrayList<Song> albumTracks;
    String albumTitle;
    
    public KatyPerry() {
    }
    
    public ArrayList<Song> getKatyPerrysSongs() {
    	
    	 albumTracks = new ArrayList<Song>();                           //Instantiate the album so we can populate it below
    	 Song track1 = new Song("Wide Awake", "Katy Perry");         	//Create a song
         Song track2 = new Song("Teenage Dream", "Katy Perry");
         Song track3 = new Song("Hot n Cold", "Katy Perry");
         Song track4 = new Song("I Kissed a Girl", "Katy Perry");
    	 
         this.albumTracks.add(track1);                                  //Add the first song to song list
         this.albumTracks.add(track2);
         this.albumTracks.add(track3);
         this.albumTracks.add(track4);
         
         return albumTracks;                                            //Return the songs for Katy Perry in the form of an ArrayList
    }
}