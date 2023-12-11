package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;
import snhu.jukebox.playlist.Song;
import music.artist.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * KatieEarnst_Playlist.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: November 15, 2023
 * Version: 2.0
 * 
 * Purpose:
 * This class implements the StudentPlaylist interface and represents a specific playlist 
 * curated by Katie Earnst. It includes functionalities to add and remove songs, check for 
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

public class KatieEarnst_Playlist implements StudentPlaylist {
    
	private LinkedList<PlayableSong> playlist;
    private Map<String, PlayableSong> songMap; // Hashmap for efficient song lookup

    public KatieEarnst_Playlist() {
    	playlist = new LinkedList<>();
        songMap = new HashMap<>();
        
        // Initialize The Dead Poet Society songs
        TheDeadPoetSociety deadPoet = new TheDeadPoetSociety();
        ArrayList<Song> deadPoetTracks = deadPoet.getDeadPoetSongs();
        addSongs(deadPoetTracks);

        // Initialize The Story So Far songs
        TheStorySoFar theStorySoFar = new TheStorySoFar();
        ArrayList<Song> theStorySoFarTracks = theStorySoFar.getTheStorySoFarSongs();
        addSongs(theStorySoFarTracks);

        // Initialize The Wallflowers songs
        TheWallflowers theWallflowers = new TheWallflowers();
        ArrayList<Song> theWallflowersTracks = theWallflowers.getTheWallflowersSongs();
        addSongs(theWallflowersTracks);

        // Initialize The Weeknd songs
        TheWeeknd theWeeknd = new TheWeeknd();
        ArrayList<Song> theWeekndTracks = theWeeknd.getTheWeekndSongs();
        addSongs(theWeekndTracks);

        // ... Add any additional artists and their songs here
    }
    
 // Add a list of songs to both the playlist and the hashmap
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
        return "KatieEarnst_Playlist";
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
