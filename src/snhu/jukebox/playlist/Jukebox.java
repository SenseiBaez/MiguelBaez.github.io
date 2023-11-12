package snhu.jukebox.playlist;

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

