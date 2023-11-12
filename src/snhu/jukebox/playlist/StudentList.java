package snhu.jukebox.playlist;

import snhu.student.playlists.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

