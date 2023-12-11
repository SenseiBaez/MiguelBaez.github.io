package snhu.jukebox.playlist;

import snhu.student.playlists.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * StudentList.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: November 15, 2023
 * Version: 2.0
 * 
 * Purpose:
 * This class manages a collection of student profiles within the jukebox playlist system.
 * It maintains a mapping of playlist names to student profiles, each profile consisting of a 
 * student's name and their associated playlist. The class provides functionalities to retrieve
 * a list of student names and to get specific student profiles based on playlist names.
 * 
 * Implementation Notes:
 * - The class uses a HashMap to store student profiles, ensuring efficient retrieval.
 * - The student profile initialization is hardcoded with specific playlist names and students.
 * 
 * Usage:
 * This class can be utilized in a larger music management system where information about
 * students and their respective playlists needs to be accessed or displayed.
 * 
 * 
 * Revision History:
 * - 2.0: Updated class with HashMap to store student profiles
 */


public class StudentList {

    private Map<String, Student> studentProfiles;

    public StudentList() {
        studentProfiles = new HashMap<>();
        
        // Initialize each student's playlist and add to the map
       
        studentProfiles.put("MiguelBaez_Playlist", new Student("Miguel Baez", new MiguelBaez_Playlist().getSongs()));
        studentProfiles.put("CassieBaez_Playlist", new Student("Cassie Baez", new CassieBaez_Playlist().getSongs()));
        studentProfiles.put("DavidPaul_Playlist", new Student("David Paul", new DavidPaul_Playlist().getSongs()));
        studentProfiles.put("KarenSoto_Playlist", new Student("Karen Soto", new KarenSoto_Playlist().getSongs()));
        studentProfiles.put("JuanGarcia_Playlist", new Student("Juan Garcia", new JuanGarcia_Playlist().getSongs()));
        studentProfiles.put("KatieEarnst_Playlist", new Student("Katie Earnst", new KatieEarnst_Playlist().getSongs()));
        studentProfiles.put("HaiNguyen_Playlist", new Student("Hai Nguyen", new HaiNguyen_Playlist().getSongs()));
    }

    public List<String> getStudentsNames() {
        return studentProfiles.keySet().stream().collect(Collectors.toList());
    }

    public Student getStudentProfile(String playlistName) {
        return studentProfiles.get(playlistName);
    }
}
