package snhu.jukebox.playlist;

import java.util.List;

public class PlaylistSearchResult {
    private String playlistName;
    private List<PlayableSong> playlistSongs;

    public PlaylistSearchResult(String playlistName, List<PlayableSong> playlistSongs) {
        this.playlistName = playlistName;
        this.playlistSongs = playlistSongs;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public List<PlayableSong> getPlaylistSongs() {
        return playlistSongs;
    }
}


