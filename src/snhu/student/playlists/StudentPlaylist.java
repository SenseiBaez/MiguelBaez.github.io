package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;

import java.util.List;

public interface StudentPlaylist {
    // Check if a song is in the playlist
    boolean hasSong(String songName);
    
    // Get the name of the playlist
    String getPlaylistName();
    
    // Get the songs in the playlist
    List<PlayableSong> getSongs();
}
