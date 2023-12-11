package snhu.jukebox.playlist;

import java.util.List;

/**
 * PlaylistSearchResult.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: December 10, 2023
 * Version: 2.0
 * 
 * Purpose:
 * The PlaylistSearchResult class is designed to encapsulate the results of a playlist search within 
 * the Jukebox Playlist System. It serves as a data container for holding both the name of a playlist 
 * and the list of songs it contains.
 * 
 * Implementation Notes:
 * - The class stores the name of the playlist and a list of PlayableSong objects.
 * - It provides a constructor for initializing the playlist name and songs list.
 * - Getter methods are provided to retrieve the playlist name and the list of songs.
 * 
 * Usage:
 * This class is primarily used by the PlaylistSearcher to return search results. It can be utilized 
 * anywhere within the system where a representation of a playlist and its contents is required, 
 * particularly in search operations.
 * 
 * Revision History:
 * - 2.0: Updated release. Added further commenting and a header for class explanation.
 */


public class PlaylistSearchResult {
    // Private field to store the playlist name
    private String playlistName;
    // Private field to store the list of playable songs in the playlist
    private List<PlayableSong> playlistSongs;

    public PlaylistSearchResult(String playlistName, List<PlayableSong> playlistSongs) {
        // The name of the playlist
        this.playlistName = playlistName;
        // The list of the songs in the playlist
        this.playlistSongs = playlistSongs;
    }

    public String getPlaylistName() {
        // Getter method returning the name of the playlist
        return playlistName;
    }

    public List<PlayableSong> getPlaylistSongs() {
        // Getter method returning the list of playable songs
        return playlistSongs;
    }
}


