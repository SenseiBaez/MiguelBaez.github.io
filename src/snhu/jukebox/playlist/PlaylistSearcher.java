// PlaylistSearcher.java
package snhu.jukebox.playlist;

import java.util.ArrayList;
import snhu.student.playlists.StudentPlaylist;
import snhu.student.playlists.*;

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
        // ... add other student playlists as necessary
    }

    public PlaylistSearchResult findPlaylistBySong(String songName) {
        String normalizedSongName = songName.trim().toLowerCase();

        for (StudentPlaylist playlist : allPlaylists) {
            if (playlist.hasSong(normalizedSongName)) {
                return new PlaylistSearchResult(playlist.getPlaylistName(), playlist.getSongs());
            }
        }
        return null; // Return null if the song is not found in any playlist
    }
}
