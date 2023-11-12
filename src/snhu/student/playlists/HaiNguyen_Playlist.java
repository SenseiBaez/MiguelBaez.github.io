package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;
import music.artist.*;
import java.util.LinkedList;

public class HaiNguyen_Playlist implements StudentPlaylist {
    
    private LinkedList<PlayableSong> playlist;

    public HaiNguyen_Playlist() {
        playlist = new LinkedList<>();

        // Initialize The Eagles songs
        TheEagles theEaglesBand = new TheEagles();
        playlist.addAll(theEaglesBand.getEaglesSongs());

        // Initialize Taylor Swift songs
        TaylorSwift taylorSwift = new TaylorSwift();
        playlist.addAll(taylorSwift.getTaylorSwiftSongs());

        // Initialize Amon Amarth songs
        AmonAmarth amonAmarthBand = new AmonAmarth();
        playlist.addAll(amonAmarthBand.getAmonAmarthSongs());

        // Add other artists and songs if necessary
    }
    
    @Override
    public boolean hasSong(String songName) {
        return playlist.stream()
                       .anyMatch(song -> song.getTitle().equalsIgnoreCase(songName));
    }
    
    @Override
    public String getPlaylistName() {
        return "HaiNguyen_Playlist";
    }

    @Override
    public LinkedList<PlayableSong> getSongs() {
        return playlist;
    }
}

