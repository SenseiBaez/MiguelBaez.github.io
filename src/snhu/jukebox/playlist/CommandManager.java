package snhu.jukebox.playlist;

public class CommandManager {

    private PlaylistSearcher playlistSearcher = new PlaylistSearcher();

    public CommandManager() {
        // Constructor can be used to initialize any state as required
    }

    // This method handles the parsing of commands entered in the GUI
    public String parseCommand(String command) {
        String response;

        if (command.startsWith("find ")) {
            String query = command.substring(5).trim();
            PlaylistSearchResult result = playlistSearcher.findPlaylistBySong(query);

            if (result != null) {
                response = "Playlist found: " + result.getPlaylistName() + "\n";
                response += "Songs in '" + result.getPlaylistName() + "':\n";
                for (PlayableSong song : result.getPlaylistSongs()) {
                    response += song.getTitle() + " by " + song.getArtist() + "\n";
                }
            } else {
                response = "Playlist not found.";
            }
        } else if (!command.trim().isEmpty()) {
            response = "Playlist command received: " + command;
        } else {
            response = "Please enter a valid command.";
        }

        return response;
    }
}
