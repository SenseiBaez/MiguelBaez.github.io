package snhu.jukebox.playlist;

import java.util.LinkedList;

/**
 * Student.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: December 10, 2023
 * Version: 2.0
 * 
 * Purpose:
 * The Student class represents an individual student in the Jukebox Playlist System. Each student is 
 * characterized by a unique name and possesses a personal playlist of songs. This class encapsulates 
 * the student's personal information and their musical preferences as a playlist.
 * 
 * Implementation Notes:
 * - The name of the student is stored as a String.
 * - The student's playlist is managed as a LinkedList of PlayableSong objects, allowing for efficient 
 *   list operations.
 * - Provides getter and setter methods for both the student's name and their playlist, ensuring data 
 *   encapsulation and the ability to update the student's details.
 * 
 * Usage:
 * This class is used within the Jukebox Playlist System to represent students and their respective 
 * playlists. It can be utilized in functionalities like playlist creation, modification, and retrieval 
 * based on student profiles.
 * 
 * Revision History:
 * - 2.0: Updated release. Added comments for further explanation as well as a header
 */


// This represents a student in the Playlist system
public class Student {

    // Name of the student
    private String name;
    // The student playlist containing the playable songs
    private LinkedList<PlayableSong> playlist;

    public Student(String name, LinkedList<PlayableSong> playlist) {
        this.name = name;
        this.playlist = playlist;
    }

    // A string for the student's name
    public String getName() {
        return name;
    }

    // Sets or updates the student's name
    public void setName(String name) {
        this.name = name;
    }

    // Retrieves the student's playlist
    public LinkedList<PlayableSong> getPlaylist() {
        return playlist;
    }

    // Sets or updates the student's playlist
    public void setPlaylist(LinkedList<PlayableSong> playlist) {
        this.playlist = playlist;
    }
}

