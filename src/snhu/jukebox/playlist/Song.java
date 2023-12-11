package snhu.jukebox.playlist;

/**
 * Song.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: December 10, 2023
 * Version: 2.0
 * 
 * Purpose:
 * The Song class is a concrete implementation of the PlayableSong abstract class in the Jukebox 
 * Playlist System. It represents a musical song with basic attributes such as title and artist. This 
 * class is designed to be a simple representation of a song without additional complexities.
 * 
 * Implementation Notes:
 * - Inherits from the PlayableSong abstract class.
 * - The constructor takes a song title and artist name and passes them to the superclass constructor.
 * - As a basic implementation, this class does not add any additional functionality beyond what is 
 *   provided by PlayableSong.
 * 
 * Usage:
 * This class should be used whenever a simple representation of a song is needed within the Jukebox 
 * Playlist System. It is suitable for scenarios where only basic song information (title and artist) 
 * is required.
 * 
 * Revision History:
 * - 2.0: Updated release. Added header for class explanation.
 */


public class Song extends PlayableSong {

    public Song(String title, String artist) {
        super(title, artist); // Call to the superclass (PlayableSong) constructor
    }
}
