package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;
import music.artist.*;
import java.util.LinkedList;

public class JuanGarcia_Playlist implements StudentPlaylist {
    
    private LinkedList<PlayableSong> playlist;

    public JuanGarcia_Playlist() {
        playlist = new LinkedList<>();

        // Initialize Papa Roach songs
        PapaRoach papaRoach = new PapaRoach();
        playlist.addAll(papaRoach.getPapaRoachSongs());
        
        // Initialize Rosenfeld songs
        Rosenfeld rosenfeld = new Rosenfeld();
        playlist.addAll(rosenfeld.getRosenfeldSongs());
        
        // Initialize Slushii songs
        Slushii slushii = new Slushii();
        playlist.addAll(slushii.getSlushiiSongs());
        
        // Initialize The Beatles songs
        TheBeatles theBeatles = new TheBeatles();
        playlist.addAll(theBeatles.getBeatlesSongs());

        // ... Add any additional artists and their songs here
    }
    
    @Override
    public boolean hasSong(String songName) {
        return playlist.stream()
                       .anyMatch(song -> song.getTitle().equalsIgnoreCase(songName));
    }
    
    @Override
    public String getPlaylistName() {
        return "JuanGarcia_Playlist";
    }

    @Override
    public LinkedList<PlayableSong> getSongs() {
        return playlist;
    }
}
