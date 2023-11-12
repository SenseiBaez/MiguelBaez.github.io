package snhu.jukebox.playlist;

public class Song extends PlayableSong {

    public Song(String title, String artist) {
        super(title, artist); // Call to the superclass (PlayableSong) constructor
    }
    
   
    @Override
    void play() {
        // Simulation or logging of playing the song can be done here, if functionality is wanted in the future.
        System.out.println("Now playing " + getTitle() + " by " + getArtist() + ".");
    }
    */
}
