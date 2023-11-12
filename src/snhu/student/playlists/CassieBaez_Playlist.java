package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;
import music.artist.*;
import java.util.LinkedList;

public class CassieBaez_Playlist implements StudentPlaylist {
    
    private LinkedList<PlayableSong> playlist = new LinkedList<>();

    public CassieBaez_Playlist() {
        Adele adele = new Adele();
        playlist.addAll(adele.getAdelesSongs());
        
        ElvisPresley elvisPresley = new ElvisPresley();
        playlist.addAll(elvisPresley.getElvisPresleySongs());
        
        JessieMurph jessieMurph = new JessieMurph();
        playlist.addAll(jessieMurph.getJessieMurphSongs());
        
        JimiHendrix jimiHendrix = new JimiHendrix();
        playlist.addAll(jimiHendrix.getJimiHendrixSongs());
        
        JohnnyCash johnnyCash = new JohnnyCash();
        playlist.addAll(johnnyCash.getJohnnyCashSongs());
        
        // Add other artists and their songs similarly...
    }
    
    @Override
    public boolean hasSong(String songName) {
        return playlist.stream()
                       .anyMatch(song -> song.getTitle().equalsIgnoreCase(songName));
    }
    
    @Override
    public String getPlaylistName() {
        return "CassieBaez_Playlist";
    }

    @Override
    public LinkedList<PlayableSong> getSongs() {
        return playlist;
    }
}
