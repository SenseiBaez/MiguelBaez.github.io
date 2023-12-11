package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;

/**
 * StudentPlaylist.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: November 15, 2023
 * Version: 2.0
 * 
 * Purpose:
 * This interface defines the structure and required functionalities for student playlist 
 * classes in the music management application. It provides methods to check for a song's 
 * presence, add and remove songs, retrieve the playlist name, and get all songs in the playlist.
 * 
 * Implementation Notes:
 * - Classes implementing this interface should maintain a list of PlayableSong objects.
 * - The implementation should ensure unique song entries in the playlist.
 * 
 * Usage:
 * This interface is intended to be implemented by specific playlist classes representing 
 * individual student playlists. Implementations should handle the logic for managing 
 * songs in the playlist.
 * 
 * 
 * Revision History:
 * - 2.0: Updated class with the basic structure and methods for playlist management.
 */


import java.util.List;

/**
 * StudentPlaylist.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: November 15, 2023
 * Version: 2.0
 * 
 * Purpose:
 * This interface defines the essential functionalities required for student playlist classes 
 * in a music management application. It outlines methods to check for a song's presence, add 
 * and remove songs, retrieve the playlist's name, and get a list of all songs in the playlist.
 * 
 * Implementation Notes:
 * - Implementing classes should manage a collection of PlayableSong objects.
 * - Unique song entries in the playlist should be ensured by the implementation.
 * - This interface does not enforce any specific data structure for storing songs, allowing 
 *   flexibility in implementation.
 * 
 * Usage:
 * This interface is designed to be implemented by classes representing individual student 
 * playlists. Each implementation should handle song management and playlist functionalities 
 * specific to the student's preferences and requirements.
 * 
 * Revision History:
 * - 2.0: Refinement of method definitions and documentation. Enhanced flexibility for implementation.
 * - 1.0: Initial creation with basic structure and method definitions for playlist management.
 */


public interface StudentPlaylist {
    // Check if a song is in the playlist
    boolean hasSong(String songName);
    
    // Get the name of the playlist
    String getPlaylistName();
    
    // Get the songs in the playlist
    List<PlayableSong> getSongs();
    
    // Add a song to the playlist
    void addSong(PlayableSong song);

    // Remove a song from the playlist
    boolean removeSong(String songTitle);
}
