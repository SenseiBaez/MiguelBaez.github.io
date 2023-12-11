# <pre align="center">Enhancement One: Software Design and Engineering</pre>

## <pre align="center">Jukebox Player GUI</pre>

For <code>Enhancement One: Software Design/Engineering</code>, The first artifact chosen was based on a Jukebox player project that took place in CS-310. It involved adding oneself to directory of the Jukebox and then making a playlist of your favorite songs. You could then see a person’s playlist by searching up their playlist name. I chose this artifact because its functionality was basic, and I thought it was a prime candidate to showcase my skills with software design/engineering. I improved the artifact by adding the fuller functionality to search by the song name as well as improved on the current logic to search by playlist name. I also created a GUI for the jukebox player, which was renamed to playlist loader, to be able to visually see what you are searching for and the results. 
My work on this enhancement demonstrated my ability to design, develop, and deliver professional-quality oral, written, and visual communications that are coherent, technically sound, and appropriately adapted to specific audiences and contexts. This was shown by the modular design of my code. The code is broken into distinct methods, where each method is going to handle different aspects of the GUI which demonstrates modular design principles. 
The enhancements I made to the user interface, adding the nimbus modern look and feel, and the tooltips to help the user align with the best practices in GUI design. This shows my understanding involved in the trade-offs in design choices like functionality and user experience. I demonstrated my usage of well-founded and innovative technique in computing practices with the modern java features in my code. The use of lambda expressions for event listeners showcases the application of efficient programming techniques. My error handling where I implement try-catching for setting the look and feel shows my initiative to include error handling. Having user experience be the focus for the enhancement such as keyboard shortcuts is a key aspect of innovative software solutions. This is shown by having ‘enter’ to execute commands, and tooltips for guiding users on what their inputs should be.
I demonstrated professional-quality communications and my ability to adapt to specific audiences and contexts with my code clarity and documentation. My code is written clearly, is understandable for others, is commented to explain what is going on at each step and demonstrates my ability to communicate technical implementations effectively. Having a user-friendly interface with tooltips and the visual feedback that I included represents an effective form of visual communication.
The process to make these changes to the functionality did not come without its challenges. Prior to this I had only experienced Java Swing once, and in my current job, I don’t code a lot in Java, so I was definitely out of practice. I have also never built a GUI so that was a learning process that involved taking a couple days of reading documentation and looking up examples so that I could create the GUI for my playlist loader.

I incorporated feedback into the code, see below. My original code did not have comments or a header and that was something that I added later on as I was polishing up the code. This is the <code>JukeboxPlayerGUI.java</code> file that I am showing.

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
The code for the first two enhancements was shared as the code used was the original Jukebox player code. The original jukebox player did not have the functionality to search for a playlist nor the ability to search for a song.
This was the functionality that was added by me as well as creating the actual GUI to demonstrate the added functionality. The original project's Jukebox player class did not have the functionality to search by song only a basic capability to search the playlist.
Here is the original code that controlled the commands that was tied to the Jukebox Player.
```
public class CommandManager {
	
	public CommandManager(){
	}
	
	// Method to print the main menu
	void printMainMenu(){
		System.out.println("\n\nWelcome to SNHU Jukebox Playlist Music!");
		System.out.println("Enter Student Playlist Name (Example: TestStudent1_Playlist): ");
		System.out.println("Quit: quit");
		System.out.print("Enter a Command : ");
	}
	
	String getCommand(){
		String command="";
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			command = br.readLine();
		}
		catch(Exception e){
			System.out.println("Something went wrong with the system input!   Please try again.");
		}
		return command;
	}
	
	String parseCommand(String command){
		String studentPlaylistRequested ="";
		if(command!=null && command.length()>0){
			studentPlaylistRequested = command;
		}
		else{
			System.out.println("Please enter a valid command.");
		}
		return studentPlaylistRequested;
	}
}
```

### <pre align="center">Final Design </pre>
The final project now has the functionality to search by song name and by artist to locate the playlist that the user may be searching for. It also now has a GUI to demonstrate the added functionality. Here is the code for the final version of the class that
controls the commands for the Jukebox Player and this class provides the functionality to the Jukebox Player GUI.
```
public class CommandManager {
	
	public CommandManager(){
	}
	
	// Method to print the main menu
	void printMainMenu(){
		System.out.println("\n\nWelcome to SNHU Jukebox Playlist Music!");
		System.out.println("Enter Student Playlist Name (Example: TestStudent1_Playlist): ");
		System.out.println("Quit: quit");
		System.out.print("Enter a Command : ");
	}
	
	String getCommand(){
		String command="";
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			command = br.readLine();
		}
		catch(Exception e){
			System.out.println("Something went wrong with the system input!   Please try again.");
		}
		return command;
	}
	
	String parseCommand(String command){
		String studentPlaylistRequested ="";
		if(command!=null && command.length()>0){
			studentPlaylistRequested = command;
		}
		else{
			System.out.println("Please enter a valid command.");
		}
		return studentPlaylistRequested;
	}
}
```
<img src="EnhancementOne.png"> 
