package snhu.jukebox.playlist;

import java.util.ArrayList;
import snhu.student.playlists.*;

/**
 * PlaylistSearcher.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: December 10, 2023
 * Version: 2.0
 * 
 * Purpose:
 * The PlaylistSearcher class is responsible for searching within a collection of student-created 
 * playlists in the Jukebox Playlist System. It offers functionality to find playlists either by a 
 * specific song name or by the playlist name.
 * 
 * Implementation Notes:
 * - The class maintains a list of all student playlists in an ArrayList.
 * - Each student playlist is an instance of a class representing that student's curated songs.
 * - The findPlaylistBySong method searches through all playlists for a song matching the given name.
 * - The findPlaylistByName method searches for a playlist that matches the given name.
 * - Both search methods return a PlaylistSearchResult, or null if no matching playlist is found.
 * 
 * Usage:
 * This class is utilized by other components of the Jukebox Playlist System to facilitate the 
 * search for specific songs or playlists based on user queries. It acts as a central repository for 
 * managing and accessing the various student playlists.
 * 
 * Revision History:
 * - 2.0: Updated release. Updated class functionality and added a header, added further commenting for insight
 */


public class PlaylistSearcher {
    private ArrayList<StudentPlaylist> allPlaylists;

    public PlaylistSearcher() {
        allPlaylists = new ArrayList<>();
        // Add the student Playlists 
        allPlaylists.add(new MiguelBaez_Playlist());
        allPlaylists.add(new CassieBaez_Playlist());
        allPlaylists.add(new DavidPaul_Playlist());
        allPlaylists.add(new KarenSoto_Playlist());
        allPlaylists.add(new JuanGarcia_Playlist());
        allPlaylists.add(new KatieEarnst_Playlist());
        allPlaylists.add(new HaiNguyen_Playlist());
        // ... add other student playlists as necessary, might do more for data sake later on...
    }

    // Search method for finding the playlist based off the song names in each playlist
    public PlaylistSearchResult findPlaylistBySong(String songName) {
        // Normalize the song name by trimming spaces and converting to lower case.
        String normalizedSongName = songName.trim().toLowerCase();

        // Iterates over all the playlists.
        for (StudentPlaylist playlist : allPlaylists) {
            // Check if the current playlist contains the song.
            if (playlist.hasSong(normalizedSongName)) {
                //return playlist if song is found
                return new PlaylistSearchResult(playlist.getPlaylistName(), playlist.getSongs());
            }
        }
        return null; // Return null if the song is not found in any playlist
    }

    // Search method for finding the playlist by the playlist name.
    public PlaylistSearchResult findPlaylistByName(String playlistName) {
        // Iterates over all the playlist
        for (StudentPlaylist playlist : allPlaylists) {
            // Check if the playlist name matches (ignoring case differences).
            if (playlist.getPlaylistName().equalsIgnoreCase(playlistName)) {
                // return the playlist found and list the songs.
                return new PlaylistSearchResult(playlist.getPlaylistName(), playlist.getSongs());
            }
        }
        return null; // Return null if the playlist name is not found
    }
}