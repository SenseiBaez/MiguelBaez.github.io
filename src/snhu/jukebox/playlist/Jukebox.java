package snhu.jukebox.playlist;

/**
 * Jukebox.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: December 10, 2023
 * Version: 2.0
 * 
 * Purpose:
 * The Jukebox class is designed to manage music playlists within the Jukebox Playlist System. 
 * It serves as the main interface for retrieving student-specific playlists based on their profiles. 
 * This class primarily interacts with the StudentList to access student profiles and their associated 
 * playlists.
 * 
 * Implementation Notes:
 * - The class uses a StudentList instance to manage and access student profiles.
 * - Playlists are retrieved in the form of a Queue, encapsulating the order of songs.
 * - A new LinkedList is returned when retrieving a playlist to prevent external modification of the 
 *   original playlist.
 * - If a student profile is not found, the method returns an empty queue to signify the absence of a 
 *   corresponding playlist.
 * 
 * Usage:
 * This class can be used in any system requiring management of music playlists, particularly where 
 * playlists are tied to individual user profiles, like a virtual jukebox in an educational or 
 * entertainment setting.
 * 
 * Revision History:
 * - .0: Updated release. Basic functionalities for retrieving student-specific playlists implemented, updated
 * with a header for explanation of class functionality.
 */


import java.util.LinkedList;
import java.util.Queue;

public class Jukebox {

    private StudentList studentProfile;

    public Jukebox() {
        // Initialize the StudentList instance once for all usages of this Jukebox instance
        studentProfile = new StudentList();
    }

    // This method retrieves a playlist based on the requested student name
    public Queue<PlayableSong> getPlaylist(String studentPlaylistRequested) {
        Student student = studentProfile.getStudentProfile(studentPlaylistRequested);

        if (student != null) {
            // Return a new LinkedList to ensure the original list cannot be modified outside this class
            return new LinkedList<>(student.getPlaylist());
        } else {
            // Return an empty queue if the student profile is not found
            return new LinkedList<>();
        }
    }

    // Additional methods as required...
}

