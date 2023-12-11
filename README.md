# <pre align="center">Enhancement Two: Algorithms and Data Structures</pre>

## <pre align="center">Playlist GUI</pre>

For <code>Enhancement Two: Algorithms and Data Structures</code>, The artifact that we are looking at was originally meant to be a Jukebox player. The functionality of the program was meant to hosts playlists created by the student and when the program was run, the Command Line displayed a few options. These options were based on user input and in return, the program would return the playlist chosen by the user. This app was created during CS-310. I chose this artifact because of the opportunity that was present in the code. The playlists did not adhere to a specific algorithm and just held the raw data. This enhancement gave me the opportunity to show my ability to design and evaluate computing solutions that solve a given problem using algorithmic principles and computer science practices and standards appropriate to its solution, while managing the trade-offs involved in design choices (data structures and algorithms). I implemented a HashMap in each individual user playlist and in turn created a playlist GUI to demonstrate the functionality of the HashMap that I created.
I met course outcomes with the coding that I did for this second enhancement. I was able to show that I could employ strategies for building collaborative environments that enable diverse audiences to support organizational decision making in the field of Computer Science. I met this outcome with the user-friendly GUI that I created for playlist management which has the potential to be used in a collaborative environment. I met the outcome of designing, developing, and delivering professional-quality oral, written, and visual communications that are coherent, technically sound, and appropriately adapted to specific audiences and contexts. I demonstrated this course outcome with a well-designed GUI, which is a form of visual communication. The interface with the text fields, the different buttons, and the combo boxes, are user-friendly and is suitable for a non-technical audience and can be adapted. The course outcome to design and evaluate computing solutions that solve a given problem using algorithmic principles and computer science practices and standards appropriate to its solution, while managing the trade-offs involved in design choices (data structures and algorithms), was met with the PlaylistGUI class that I created. The data structures that I used in the class such as HashMap and LinkedList, that helped manage the playlists and songs, demonstrated my application of Computer Science practices and standards. The use of the HashMap data structure that is used in each user playlist, for example in the MiguelBaez_Playlist class, is an example of thoughtful design choice that optimizes for search efficiency. I met the course outcome to demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals (software engineering/design/database), by having my code aligned with good software engineering practices such as object-oriented design. I also met the outcome by showing good practices such as encapsulation, and the separation of concerns. Separation of concerns being that the UI logic and the playlist management are separated. My usage of Java Swing for the GUI also reflects industry-standard tools.
The process of this was in a sense a little easier for me as I got practice creating a GUI during my first enhancement so that part went smoother. There were components, such as the combo boxes, that I had to research and look up examples for as I had not used them the first time and was unfamiliar with the coding aspect for them. Another hurdle was actually implementing the HashMap and the LinkedList as I had only been exposed to these data structures during class, so these concepts required reading and research on my end to be able to implement them in my code. There was also my concern that the functionality of the Playlist GUI would interfere or break the functionality of my JukeboxPlayerGUI but with precaution and documentation that class remained intact. So, during this second enhancement I gained a deeper understanding of the HashMap and LinkedList data structures which is demonstrated by the correct functionality of my PlaylistGUI which takes the data from the specific playlists where I implement the HashMap and LinkedList data structures. Another thing that I kept in mind during this second enhancement was some of the feedback that I had received for my first enhancement. I did my best to comment everything and explain the thought process behind the code. So far, I would say that my biggest challenge has been knowledge, or lack thereof. Some of these concepts are things that I’ve never done outside of the school environment, so this is the first time really standing on my own and navigating through the holes in my own logic.



I incorporated feedback into the code, see below. My original code did not have comments or a header and that was something that I added later on as I was polishing up the code. This is the <code>PlaylistGUI.java</code> file that I am showing.

```

// public class JukeboxPlayerGUI {

    private Jukebox jukebox;
    private CommandManager cm;
    private JTextArea outputArea;
    private JTextField commandInput;

    public JukeboxPlayerGUI() {
        jukebox = new Jukebox(); // Initialize with the playlists created
        cm = new CommandManager();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        try {
            // Set a modern look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JFrame frame = new JFrame("Playlist Loader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input field for commands with tooltip
        commandInput = new JTextField();
        commandInput.setToolTipText("Type your command here and press Enter or click the execute button.");

        // Button to execute commands with an icon and tooltip
        JButton executeButton = new JButton("Execute Command");
        executeButton.setToolTipText("Click to execute the command.");
        // Helpful tip if I decide to add in an icon later on...
        // executeButton.setIcon(new ImageIcon("path/to/execute_icon.png"));

        // Text area to display results or messages with enhanced fonts and colors
        outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        outputArea.setBackground(new Color(230, 240, 250)); // A light blue background
        JScrollPane scrollPane = new JScrollPane(outputArea); // Allows for scrolling

        // Adding components to the frame
        frame.add(commandInput, BorderLayout.NORTH);
        frame.add(executeButton, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Attach action to command input for pressing Enter
        commandInput.addActionListener(e -> executeCommand(commandInput.getText()));

        // Button action to execute the command
        executeButton.addActionListener(e -> executeCommand(commandInput.getText()));

        // Start-up message with instructions
        outputArea.append("Welcome to Jukebox Player!\n");
        outputArea.append("Type 'find song [song name]' to search for a playlist by song.\n");
        outputArea.append("Type 'find playlist [playlist name]' to search for a playlist by name.\n");
        outputArea.append("Type 'quit' to exit the application.\n");

        // Set the frame size and make it visible
        frame.pack();
        frame.setVisible(true);
    }

    private void executeCommand(String command) {
        commandInput.setText(""); // Clear the input field

        if ("quit".equalsIgnoreCase(command.trim())) {
            outputArea.append("Exiting the Playlist Loader...\n");
            System.exit(0);
        } else {
            String response = cm.parseCommand(command);
            outputArea.append(response + "\n");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(JukeboxPlayerGUI::new);
    }
}

```


### <pre align="center">Original Project </pre>
The code for the first two enhancements was shared as the code used was the original jukebox player code. The original jukebox player did not have the functionality to search for a playlist nor the ability to search for a song.
This was the functionality that was added by me as well as creating the actual GUI to demonstrate the added functionality. The original student playlists did not have a HashMap implemented. Here is the code for one of the original student playlists.

```
public class MiguelBaez_Playlist {
    
	public LinkedList<PlayableSong> StudentPlaylist(){
	
	//started my playlist with Metallica	
		
	LinkedList<PlayableSong> playlist = new LinkedList<PlayableSong>();
	ArrayList<Song> metallicaTracks = new ArrayList<Song>();
    Metallica metallica = new Metallica();
	
    metallicaTracks = metallica.getMetallicaSongs();
	
	playlist.add(metallicaTracks.get(0));
	playlist.add(metallicaTracks.get(1));
	
	
	//I am going to keep imagine dragons on my playlist
	
    ImagineDragons imagineDragonsBand = new ImagineDragons();
	ArrayList<Song> imagineDragonsTracks = new ArrayList<Song>();
    imagineDragonsTracks = imagineDragonsBand.getImagineDragonsSongs();
	
	playlist.add(imagineDragonsTracks.get(0));
	playlist.add(imagineDragonsTracks.get(1));
	playlist.add(imagineDragonsTracks.get(2));
	
	//added the songs from the ThreeOHThree band file
	
	ThreeOHThree threeOHthree = new ThreeOHThree();
	ArrayList<Song> threeOHthreeTracks = new ArrayList<Song>();
	threeOHthreeTracks = threeOHthree.getThreeOHThreeSongs();
		
	playlist.add(threeOHthreeTracks.get(0));
	playlist.add(threeOHthreeTracks.get(1));
	playlist.add(threeOHthreeTracks.get(2));
	
	//added the song from the TameImpala band file
	
	TameImpala tameImpala = new TameImpala();
	ArrayList<Song> tameImpalasTracks = new ArrayList<Song>();
	tameImpalasTracks = tameImpala.getTameImpalaSongs();
	
	playlist.add(tameImpalasTracks.get(0));
	playlist.add(tameImpalasTracks.get(1));
	playlist.add(tameImpalasTracks.get(2));
	
	//added the songs from the GlassAnimals band file
	
	GlassAnimals glassAnimals = new GlassAnimals();
	ArrayList<Song> glassAnimalsTracks = new ArrayList<Song>();
	glassAnimalsTracks = glassAnimals.getGlassAnimalsSongs();
	
	playlist.add(glassAnimalsTracks.get(0));
	playlist.add(glassAnimalsTracks.get(1));
	
	
	
    return playlist;
	}
}
```

### <pre align="center">Final Design </pre>
Here is the final version of the code of one of the student playlist looks like with the implementation of the HashMap as well as what the GUI looks like.
```


public class MiguelBaez_Playlist implements StudentPlaylist {
    
    private LinkedList<PlayableSong> playlist;
    private Map<String, PlayableSong> songMap; // Hashmap for efficient song lookup

    public MiguelBaez_Playlist() {
        playlist = new LinkedList<>();
        songMap = new HashMap<>();

        // Initialize Metallica songs
        Metallica metallica = new Metallica();
        ArrayList<Song> metallicaTracks = metallica.getMetallicaSongs();
        addSongs(metallicaTracks);
        
        // Initialize Imagine Dragons songs
        ImagineDragons imagineDragonsBand = new ImagineDragons();
        ArrayList<Song> imagineDragonsTracks = imagineDragonsBand.getImagineDragonsSongs();
        addSongs(imagineDragonsTracks); // Assuming we want all their tracks
        
        // Initialize ThreeOHThree songs
        ThreeOHThree threeOHthree = new ThreeOHThree();
        ArrayList<Song> threeOHthreeTracks = threeOHthree.getThreeOHThreeSongs();
        addSongs(threeOHthreeTracks);
        
        // Initialize Tame Impala songs
        TameImpala tameImpala = new TameImpala();
        ArrayList<Song> tameImpalasTracks = tameImpala.getTameImpalaSongs();
        addSongs(tameImpalasTracks);
        
        // Initialize Glass Animals songs
        GlassAnimals glassAnimals = new GlassAnimals();
        ArrayList<Song> glassAnimalsTracks = glassAnimals.getGlassAnimalsSongs();
        addSongs(glassAnimalsTracks);
    }

    // Add a list of songs to both the playlist and the hashmap
    private void addSongs(ArrayList<Song> songs) {
        for (Song song : songs) {
            playlist.add(song);
            songMap.put(song.getTitle().toLowerCase(), song);
        }
    }
    
    @Override
    public boolean hasSong(String songName) {
        return songMap.containsKey(songName.toLowerCase());
    }
    
    @Override
    public String getPlaylistName() {
        return "MiguelBaez_Playlist";
    }

    @Override
    public LinkedList<PlayableSong> getSongs() {
        return playlist;
    }

    // Method to add a single song to both the playlist and the hashmap
    public void addSong(PlayableSong song) {
        playlist.add(song);
        songMap.put(song.getTitle().toLowerCase(), song);
    }

    // Method to remove a song from both the playlist and the hashmap  
    public boolean removeSong(String songTitle) {
        // Assuming songTitle is the key in songMap
        if (songMap.containsKey(songTitle.toLowerCase())) {
            PlayableSong song = songMap.remove(songTitle.toLowerCase());
            playlist.remove(song);
            return true; // Song was found and removed
        }
        return false; // Song was not found
    }
}

```
<img src="EnhancementTwo.png"> 
