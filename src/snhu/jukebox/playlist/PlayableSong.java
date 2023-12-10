package snhu.jukebox.playlist;

/**
 * PlayableSong.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: November 15, 2023
 * Version: 2.0
 * 
 * Purpose:
 * This class is for creating playable song objects within the jukebox 
 * playlist system. It encapsulates the common attributes of a song - its title and artist. This class 
 * provides a base structure for specific types of songs that can be extended with additional
 * functionalities as required.
 * 
 * Implementation Notes:
 * - The class is designed to be abstract to allow for various types of playable songs with different
 *   characteristics.
 * - The title and artist properties are set through a protected constructor, making them immutable 
 *   after initialization.
 * - Getter methods are provided for accessing the title and artist of a song.
 * 
 * Usage:
 * This class should be extended by other classes that represent specific types of songs in a music 
 * management system.
 * 
 * 
 * Revision History:
 * - 2.0: Updated release. Basic structure for playable songs with title and artist attributes.
 */


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
}

