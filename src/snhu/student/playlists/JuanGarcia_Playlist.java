package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;
import music.artist.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import snhu.jukebox.playlist.Song;
import java.util.ArrayList;

/**
 * JuanGarcia_Playlist.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: November 15, 2023
 * Version: 2.0
 * 
 * Purpose:
 * This class implements the StudentPlaylist interface and represents a specific playlist 
 * curated by Juan Garcia. It includes functionalities to add and remove songs, check for 
 * their presence, and retrieve the playlist's songs. The class also provides a mechanism 
 * for initializing the playlist with predefined sets of songs from various artists.
 * 
 * Implementation Notes:
 * - The playlist is maintained as a LinkedList, allowing efficient insertion and deletion.
 * - A HashMap is used for quick song lookup by title.
 * - Song addition and removal are reflected in both the LinkedList and HashMap for consistency.
 * 
 * Usage:
 * This class is intended to be used in a music management system where individual student 
 * playlists are managed. It demonstrates the implementation of the StudentPlaylist interface 
 * with specific artist selections.
 * 
 * 
 * Revision History:
 * - 2.0: Updated release. Playlist now uses HashMap for quick lookup, and LinkedList to increase
 * efficiency of insertion and deletion.
 */

public class JuanGarcia_Playlist implements StudentPlaylist {
    
	private LinkedList<PlayableSong> playlist;
    private Map<String, PlayableSong> songMap; // Hashmap for efficient song lookup

    public JuanGarcia_Playlist() {
    	playlist = new LinkedList<>();
        songMap = new HashMap<>();
        
        // Initialize Papa Roach songs
        PapaRoach papaRoach = new PapaRoach();
        ArrayList<Song> papaRoachTracks = papaRoach.getPapaRoachSongs();
        addSongs(papaRoachTracks);
        
        // Initialize Rosenfeld songs
        Rosenfeld rosenfeld = new Rosenfeld();
        ArrayList<Song> rosenfeldTracks = rosenfeld.getRosenfeldSongs();
        addSongs(rosenfeldTracks);
        
        // Initialize Slushii songs
        Slushii slushii = new Slushii();
        ArrayList<Song> slushiiTracks = slushii.getSlushiiSongs();
        addSongs(slushiiTracks);
        
        // Initialize The Beatles songs
        TheBeatles theBeatles = new TheBeatles();
        ArrayList<Song> theBeatlesTracks = theBeatles.getBeatlesSongs();
        addSongs(theBeatlesTracks);

        // ... Add any additional artists and their songs here
    }
    
    private void addSongs(ArrayList<Song> songs) {
        for (Song song : songs) {
            playlist.add(song);
            songMap.put(song.getTitle().toLowerCase(), song);
        }
    }
    
    @Override
    public boolean hasSong(String songName) {
        return songMap.containsKey(songName.toLowerCase());
    }
    
    @Override
    public String getPlaylistName() {
        return "JuanGarcia_Playlist";
    }

    @Override
    public LinkedList<PlayableSong> getSongs() {
        return playlist;
    }

    // Method to add a single song to both the playlist and the hashmap
    public void addSong(PlayableSong song) {
        playlist.add(song);
        songMap.put(song.getTitle().toLowerCase(), song);
    }

    // Method to remove a song from both the playlist and the hashmap
    public boolean removeSong(String songTitle) {
        // Assuming songTitle is the key in songMap
        if (songMap.containsKey(songTitle.toLowerCase())) {
            PlayableSong song = songMap.remove(songTitle.toLowerCase());
            playlist.remove(song);
            return true; // Song was found and removed
        }
        return false; // Song was not found
    }
}

