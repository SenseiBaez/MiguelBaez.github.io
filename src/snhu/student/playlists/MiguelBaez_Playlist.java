package snhu.student.playlists;

import snhu.jukebox.playlist.PlayableSong;
import snhu.jukebox.playlist.Song;
import music.artist.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class MiguelBaez_Playlist implements StudentPlaylist {
    
    private LinkedList<PlayableSong> playlist;

    public MiguelBaez_Playlist() {
        playlist = new LinkedList<>();
        
        // Initialize Metallica songs
        Metallica metallica = new Metallica();
        ArrayList<Song> metallicaTracks = metallica.getMetallicaSongs();
        playlist.add(metallicaTracks.get(0));
        playlist.add(metallicaTracks.get(1));
        
        // Initialize Imagine Dragons songs
        ImagineDragons imagineDragonsBand = new ImagineDragons();
        ArrayList<Song> imagineDragonsTracks = imagineDragonsBand.getImagineDragonsSongs();
        playlist.addAll(imagineDragonsTracks); // Assuming we want all their tracks
        
        // Initialize ThreeOHThree songs
        ThreeOHThree threeOHthree = new ThreeOHThree();
        ArrayList<Song> threeOHthreeTracks = threeOHthree.getThreeOHThreeSongs();
        playlist.addAll(threeOHthreeTracks);
        
        // Initialize Tame Impala songs
        TameImpala tameImpala = new TameImpala();
        ArrayList<Song> tameImpalasTracks = tameImpala.getTameImpalaSongs();
        playlist.addAll(tameImpalasTracks);
        
        // Initialize Glass Animals songs
        GlassAnimals glassAnimals = new GlassAnimals();
        ArrayList<Song> glassAnimalsTracks = glassAnimals.getGlassAnimalsSongs();
        playlist.addAll(glassAnimalsTracks);
    }
    
    @Override
    public boolean hasSong(String songName) {
        return playlist.stream()
                       .anyMatch(song -> song.getTitle().equalsIgnoreCase(songName));
    }
    
    @Override
    public String getPlaylistName() {
        return "MiguelBaez_Playlist";
    }

    @Override
    public LinkedList<PlayableSong> getSongs() {
        return playlist;
    }
}
