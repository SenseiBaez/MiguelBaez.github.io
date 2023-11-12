package snhu.jukebox.playlist;

public abstract class PlayableSong {
    private String title;
    private String artist;
    
    // Constructor to set title and artist
    protected PlayableSong(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
    
    // If the play method is needed for future use or other parts of the application, uncomment it.
    // abstract void play();
}
