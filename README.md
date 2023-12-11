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
This was the functionality that was added by me as well as creating the actual GUI to demonstrate the added functionality. The original student playlists did not have a HashMap implemented. Here is the code for the original project.

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
Here is the final version of the code with the implementation of the HashMap as well as what the GUI looks like.
```

// Class declaration for the PlaylistGUI
public class PlaylistGUI {

	// Declaration of GUI components
    private JFrame frame; // Main window
    private JTextField songTitleField, artistField; // Text fields for input
    private JTextArea resultArea; // Text area for showing results
    private JComboBox<String> playlistSelector, searchTypeSelector, songActionSelector, searchActionSelector; // combo boxes for different selections
    private Map<String, StudentPlaylist> playlists; // Map to hold the playlists
    private JButton performSongActionButton, performSearchActionButton; // Buttons for actions
    private String lastFoundPlaylistName; // To store the name of the last found playlist

    public PlaylistGUI() {
        playlists = new HashMap<>(); // Initializing the playlists map
        
        // Adding the user playlists
        playlists.put("MiguelBaez_Playlist", new MiguelBaez_Playlist());
        playlists.put("CassieBaez_Playlist", new CassieBaez_Playlist());
        playlists.put("DavidPaul_Playlist", new DavidPaul_Playlist());
        playlists.put("HaiNguyen_Playlist", new HaiNguyen_Playlist());
        playlists.put("JuanGarcia_Playlist", new JuanGarcia_Playlist());
        playlists.put("KarenSoto_Playlist", new KarenSoto_Playlist());
        playlists.put("KatieEarnst_Playlist", new KatieEarnst_Playlist());
        // Add other playlists as needed

        initializeUI(); // Initializes the User Interface
    }

    // Method to initialize the user interface
    private void initializeUI() {
        frame = new JFrame("Playlist Manager"); // Creates the main window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        frame.setLayout(new BorderLayout()); // Sets the layout manager
        
        // Initialize the text fields and combo boxes
        songTitleField = new JTextField(20); // Field for user entry
        playlistSelector = new JComboBox<>(playlists.keySet().toArray(new String[0])); // Selector for the playlists
        searchTypeSelector = new JComboBox<>(new String[]{"By Title", "By Artist"}); // Selector for the search type
        songActionSelector = new JComboBox<>(new String[]{"Add Song", "Remove Song"}); // Selector for song action
        searchActionSelector = new JComboBox<>(new String[]{"Search Song", "Search by Artist"}); // Selector for search action
        
        // Initialize buttons for performing selected actions
        performSongActionButton = new JButton("Perform Action"); // Button for performing song actions
        performSearchActionButton = new JButton("Search"); // Button for performing search actions
        JButton displayButton = new JButton("Display Playlist"); // Button for displaying playlists that are selected or found

        resultArea = new JTextArea(10, 40); // Text area for displaying the results from selections and inputs
        resultArea.setEditable(false); // Making the result area non-editable

        // Setting action listeners for buttons
        performSongActionButton.addActionListener(e -> performSongAction());
        performSearchActionButton.addActionListener(e -> performSearchAction());
        displayButton.addActionListener(e -> displayPlaylist());

        // Creating the panel and the needed components for the panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(playlistSelector);
        topPanel.add(searchTypeSelector);
        topPanel.add(songTitleField);
        topPanel.add(songActionSelector);
        topPanel.add(performSongActionButton);
        topPanel.add(searchActionSelector);
        topPanel.add(performSearchActionButton);
        topPanel.add(displayButton);

        // Creating a scroll pane for the top and side panels as necessary
        JScrollPane topPanelScrollPane = new JScrollPane(topPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Adding components to the frame 
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        frame.add(topPanelScrollPane, BorderLayout.SOUTH);

        // Finalizing the frame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    // Method to perform song actions based on user selections
    private void performSongAction() {
    	String selectedAction = (String) songActionSelector.getSelectedItem();
        if ("Add Song".equals(selectedAction)) {
            addSong();
        } else if ("Remove Song".equals(selectedAction)) {
            removeSong();
        }
    }

    // Method to perform search action based on user input and user selection
    private void performSearchAction() {
        String searchText = songTitleField.getText().trim();
        String selectedAction = (String) searchActionSelector.getSelectedItem();

        if (searchText.isEmpty()) {
            resultArea.append("Please enter a search query.\n");
            return;
        }

        if ("Search Song".equals(selectedAction)) {
            searchSong(searchText);
        } else if ("Search by Artist".equals(selectedAction)) {
            searchByArtist(searchText);
        }
    }

    // Method to add songs to the playlists
    private void addSong() {
        String title = songTitleField.getText().trim();
        if (title.isEmpty()) {
            resultArea.append("Please enter a song title to add.\n");
            return;
        }

        String selectedPlaylistName = (String) playlistSelector.getSelectedItem();
        StudentPlaylist currentPlaylist = playlists.get(selectedPlaylistName);
        PlayableSong song = new Song(title, "Unknown Artist"); // Assuming artist name is not known
        currentPlaylist.addSong(song);
        resultArea.append("Added song '" + title + "' to " + selectedPlaylistName + ".\n");
    }

    // Method to search the playlists based off song title
    private void searchSong(String searchText) {
        boolean found = false;
        for (Map.Entry<String, StudentPlaylist> entry : playlists.entrySet()) {
            StudentPlaylist playlist = entry.getValue();
            for (PlayableSong song : playlist.getSongs()) {
                if (song.getTitle().equalsIgnoreCase(searchText)) {
                    resultArea.append("Found '" + song.getTitle() + "' by " + song.getArtist() + " in " + entry.getKey() + "\n");
                    lastFoundPlaylistName = entry.getKey(); // Store the playlist name where the song was found
                    found = true;
                    break; // Break if song is found
                }
            }
            if (found) break; // Break the outer loop if song is found
        }

        if (!found) {
            resultArea.append("No matches found for '" + searchText + "'.\n");
        }
    }

    // Method to search for a playlist based off the music artist
    private void searchByArtist(String searchText) {
        boolean found = false;
        for (Map.Entry<String, StudentPlaylist> entry : playlists.entrySet()) {
            StudentPlaylist playlist = entry.getValue();
            for (PlayableSong song : playlist.getSongs()) {
                if (song.getArtist().equalsIgnoreCase(searchText)) {
                    resultArea.append("Found '" + song.getTitle() + "' by " + searchText + " in " + entry.getKey() + "\n");
                    lastFoundPlaylistName = entry.getKey(); // Store the playlist name where the artist's song was found
                    found = true;
                }
            }
        }

        if (!found) {
            resultArea.append("No songs by '" + searchText + "' found in any playlist.\n");
        }
    }

    
    // Method to remove song from playlist selected
    private void removeSong() {
        String title = songTitleField.getText().trim();
        if (title.isEmpty()) {
            resultArea.append("Please enter a song title to remove.\n");
            return;
        }

        String selectedPlaylistName = (String) playlistSelector.getSelectedItem();
        StudentPlaylist currentPlaylist = playlists.get(selectedPlaylistName);
        if (currentPlaylist != null && currentPlaylist.removeSong(title)) {
            resultArea.append("Removed song '" + title + "' from " + selectedPlaylistName + ".\n");
        } else {
            resultArea.append("Song '" + title + "' not found in " + selectedPlaylistName + ".\n");
        }
    }

    // Method to display playlists
    private void displayPlaylist() {
        if (lastFoundPlaylistName != null) {
            displaySpecificPlaylist(lastFoundPlaylistName);
            lastFoundPlaylistName = null; // Reset after displaying
        } else {
            String selectedPlaylistName = (String) playlistSelector.getSelectedItem();
            displaySpecificPlaylist(selectedPlaylistName);
        }
    }

    // Method to display a specific playlist when selected
    private void displaySpecificPlaylist(String playlistName) {
        StudentPlaylist playlist = playlists.get(playlistName);
        if (playlist == null) {
            resultArea.append("No playlist selected or available.\n");
            return;
        }

        resultArea.append("Playlist (" + playlist.getPlaylistName() + "):\n");
        for (PlayableSong song : playlist.getSongs()) {
            resultArea.append(song.getTitle() + " by " + song.getArtist() + "\n");
        }
    }
    
    // Main method, the entry point of the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlaylistGUI::new); // Ensures that the GUI is created in the Event Dispatch Thread
    }
}
```
<img src="EnhancementOne.png"> 
