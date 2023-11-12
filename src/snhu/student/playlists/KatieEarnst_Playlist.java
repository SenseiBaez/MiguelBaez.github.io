package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;
import music.artist.*;
import java.util.LinkedList;

public class KatieEarnst_Playlist implements StudentPlaylist {
    
    private LinkedList<PlayableSong> playlist;

    public KatieEarnst_Playlist() {
        playlist = new LinkedList<>();

        // Initialize The Dead Poet Society songs
        TheDeadPoetSociety deadPoet = new TheDeadPoetSociety();
        playlist.addAll(deadPoet.getDeadPoetSongs());

        // Initialize The Story So Far songs
        TheStorySoFar theStorySoFar = new TheStorySoFar();
        playlist.addAll(theStorySoFar.getTheStorySoFarSongs());

        // Initialize The Wallflowers songs
        TheWallflowers theWallflowers = new TheWallflowers();
        playlist.addAll(theWallflowers.getTheWallflowersSongs());

        // Initialize The Weeknd songs
        TheWeeknd theWeeknd = new TheWeeknd();
        playlist.addAll(theWeeknd.getTheWeekndSongs());

        // ... Add any additional artists and their songs here
    }
    
    @Override
    public boolean hasSong(String songName) {
        return playlist.stream()
                       .anyMatch(song -> song.getTitle().equalsIgnoreCase(songName));
    }
    
    @Override
    public String getPlaylistName() {
        return "KatieEarnst_Playlist";
    }

    @Override
    public LinkedList<PlayableSong> getSongs() {
        return playlist;
    }
}
