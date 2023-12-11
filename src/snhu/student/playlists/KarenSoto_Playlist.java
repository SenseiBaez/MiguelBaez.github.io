package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;
import snhu.jukebox.playlist.Song;
import music.artist.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * KarenSoto_Playlist.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: November 15, 2023
 * Version: 2.0
 * 
 * Purpose:
 * This class implements the StudentPlaylist interface and represents a specific playlist 
 * curated by Karen Soto. It includes functionalities to add and remove songs, check for 
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

public class KarenSoto_Playlist implements StudentPlaylist {
    
	private LinkedList<PlayableSong> playlist;
    private Map<String, PlayableSong> songMap; // Hashmap for efficient song lookup

    public KarenSoto_Playlist() {
    	playlist = new LinkedList<>();
        songMap = new HashMap<>();
        
        // Initialize Nelly songs
        Nelly nelly = new Nelly();
        ArrayList<Song> nellyTracks = nelly.getNellySongs();
        addSongs(nellyTracks);

        // Initialize NSYNC songs
        NSYNC nSYNC = new NSYNC();
        ArrayList<Song> nSYNCTracks = nSYNC.getNSYNCSongs();
        addSongs(nSYNCTracks);

        // Initialize Two Feet songs
        TwoFeet twoFeet = new TwoFeet();
        ArrayList<Song> twoFeetTracks = twoFeet.getTwoFeetSongs();
        addSongs(twoFeetTracks);

        // Initialize Panic! At The Disco songs
        PanicAtTheDisco panicAtTheDisco = new PanicAtTheDisco();
        ArrayList<Song> panicAtTheDiscoTracks = panicAtTheDisco.getPanicAtTheDiscoSongs();
        addSongs(panicAtTheDiscoTracks);

        // Initialize Virtual Riot songs
        VirtualRiot virtualRiot = new VirtualRiot();
        ArrayList<Song> virtualRiotTracks = virtualRiot.getVirtualRiotSongs();
        addSongs(virtualRiotTracks);

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
        return "KarenSoto_Playlist";
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
