package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;
import music.artist.*;
import java.util.LinkedList;

public class DavidPaul_Playlist implements StudentPlaylist {
    
    private LinkedList<PlayableSong> playlist;

    public DavidPaul_Playlist() {
        playlist = new LinkedList<>();

        // Initialize Katy Perry songs
        KatyPerry katyPerry = new KatyPerry();
        playlist.addAll(katyPerry.getKatyPerrysSongs());
        
        // Initialize Linkin Park songs
        LinkinPark linkinPark = new LinkinPark();
        playlist.addAll(linkinPark.getLinkinParkSongs());
        
        // Initialize Michael Jackson songs
        MichaelJackson michaelJackson = new MichaelJackson();
        playlist.addAll(michaelJackson.getMichaelJacksonSongs());
        
        // Initialize Modest Mouse songs
        ModestMouse modestMouse = new ModestMouse();
        playlist.addAll(modestMouse.getModestMouseSongs());
        
        // Initialize Travis Scott songs
        TravisScott travisScott = new TravisScott();
        playlist.addAll(travisScott.getTravisScottsSongs());
        
        // ... Add any additional artists and their songs
    }
    
    @Override
    public boolean hasSong(String songName) {
        return playlist.stream().anyMatch(song -> song.getTitle().equalsIgnoreCase(songName));
    }
    
    @Override
    public String getPlaylistName() {
        return "DavidPaul_Playlist";
    }

    @Override
    public LinkedList<PlayableSong> getSongs() {
        return playlist;
    }
}
