package snhu.jukebox.playlist;

/**
 * CommandManager.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: December 10, 2023
 * Version: 2.0
 * 
 * Purpose:
 * The CommandManager class is responsible for parsing and executing commands related to searching
 * for songs and playlists within the Jukebox Playlist System. It acts as a controller that interprets
 * user input and delegates search tasks to the PlaylistSearcher.
 * 
 * Implementation Notes:
 * - The class utilizes the PlaylistSearcher for executing the actual search operations.
 * - Commands are parsed based on predefined string patterns to identify the type of search
 *   requested by the user.
 * - Each search type (song or playlist) has a dedicated private method for handling the specific 
 *   search logic.
 * - The formatSearchResult method centralizes the formatting of the search output, enhancing 
 *   maintainability and consistency across different search types.
 * 
 * Usage:
 * This class is intended to be used as part of the Jukebox Playlist System where users can input
 * commands to find specific songs or playlists. It simplifies the interface between the user's input
 * and the system's searching mechanisms.
 * 
 * Revision History:
 * - 2.0: Updated release. Core functionalities for parsing commands and searching for songs and 
 *        playlists are implemented. Added commenting for further insight into functionality of class
 */


// The CommandManager class manages the parsing and execution of commands related to searching playlists.
public class CommandManager {
    // playlistSearcher is an instance of PlaylistSearcher used to perform search operations.
    private PlaylistSearcher playlistSearcher = new PlaylistSearcher();

    // Constructor for CommandManager. It can be expanded to initialize any required state.
    public CommandManager() {
    }

    // parseCommand takes a String command and processes it to give an appropriate response.
    public String parseCommand(String command) {
        String response;

        // Check if the command starts with "find song " and process the command accordingly.
        if (command.startsWith("find song ")) {
            // Extract the song query from the command.
            String query = command.substring(10).trim();
            // Find a playlist by the song name.
            response = findPlaylistBySong(query);
        } 
        // Check if the command starts with "find playlist " and process the command accordingly.
        else if (command.startsWith("find playlist ")) {
            // Extract the playlist query from the command.
            String query = command.substring(14).trim();
            // Find a playlist by its name.
            response = findPlaylistByName(query);
        } 
        // Check if the command is not empty and not recognized.
        else if (!command.trim().isEmpty()) {
            response = "Invalid command.";
        } 
        // If the command is empty, prompt the user to enter a valid command.
        else {
            response = "Please enter a valid command.";
        }

        return response;
    }

    // findPlaylistBySong searches for a playlist containing the specified song.
    private String findPlaylistBySong(String songName) {
        // Use playlistSearcher to find a playlist by song name.
        PlaylistSearchResult result = playlistSearcher.findPlaylistBySong(songName);
        // Format the search result for display.
        return formatSearchResult(result);
    }

    // findPlaylistByName searches for a playlist by its name.
    private String findPlaylistByName(String playlistName) {
        // Use playlistSearcher to find a playlist by its name.
        PlaylistSearchResult result = playlistSearcher.findPlaylistByName(playlistName);
        // Format the search result for display.
        return formatSearchResult(result);
    }

    // formatSearchResult formats the search results for display to the user.
    private String formatSearchResult(PlaylistSearchResult result) {
        // Check if the search result is not null (meaning a playlist was found).
        if (result != null) {
            // Construct the response with the playlist name.
            String response = "Playlist found: " + result.getPlaylistName() + "\n";
            response += "Song is in '" + result.getPlaylistName() + "':\n";
            // Add each song in the playlist to the response.
            for (PlayableSong song : result.getPlaylistSongs()) {
                response += song.getTitle() + " by " + song.getArtist() + "\n";
            }
            return response;
        } else {
            // Return this message if no playlist was found.
            return "Playlist not found.";
        }
    }
}

