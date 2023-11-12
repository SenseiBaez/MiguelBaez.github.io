package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;
import music.artist.*;
import java.util.LinkedList;

public class KarenSoto_Playlist implements StudentPlaylist {
    
    private LinkedList<PlayableSong> playlist;

    public KarenSoto_Playlist() {
        playlist = new LinkedList<>();

        // Initialize Nelly songs
        Nelly nelly = new Nelly();
        playlist.addAll(nelly.getNellySongs());

        // Initialize NSYNC songs
        NSYNC nSYNC = new NSYNC();
        playlist.addAll(nSYNC.getNSYNCSongs());

        // Initialize Two Feet songs
        TwoFeet twoFeet = new TwoFeet();
        playlist.addAll(twoFeet.getTwoFeetSongs());

        // Initialize Panic! At The Disco songs
        PanicAtTheDisco panicAtTheDisco = new PanicAtTheDisco();
        playlist.addAll(panicAtTheDisco.getPanicAtTheDiscoSongs());

        // Initialize Virtual Riot songs
        VirtualRiot virtualRiot = new VirtualRiot();
        playlist.addAll(virtualRiot.getVirtualRiotSongs());

        // ... Add any additional artists and their songs here
    }
    
    @Override
    public boolean hasSong(String songName) {
        return playlist.stream()
                       .anyMatch(song -> song.getTitle().equalsIgnoreCase(songName));
    }
    
    @Override
    public String getPlaylistName() {
        return "KarenSoto_Playlist";
    }

    @Override
    public LinkedList<PlayableSong> getSongs() {
        return playlist;
    }
}
