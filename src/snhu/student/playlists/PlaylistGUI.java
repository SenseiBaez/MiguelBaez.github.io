package snhu.student.playlists;

import snhu.student.playlists.*; // Import statements for necessary classes
import snhu.jukebox.playlist.PlayableSong;
import snhu.jukebox.playlist.Song;
import javax.swing.*; // Importing Swing components for GUI
import java.awt.*; // Importing AWT components for layout and event handling
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap; // Importing HashMap for storing playlists
import java.util.Map; // Importing Map interface

/**
 * PlaylistGUI.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: November 15, 2023
 * Version: 1.0
 * 
 * Purpose: 
 * This file defines the PlaylistGUI class, which is part of a music management application. 
 * It provides a graphical user interface for users to manage playlists, including adding, 
 * removing, and searching for songs. The interface includes options to search by song title 
 * or artist, and to display playlists.
 * 
 * Issues:
 * - As of this version, the application does not support live updates to playlists; it requires
 *   a restart to reflect new changes made.
 * - The search functionality is case-sensitive, which may lead to missed matches.
 * - There is no validation for duplicate song entries.
 * 
 * Usage:
 * This class should be used as part of the snhu.student.playlists package and requires
 * related classes such as StudentPlaylist and PlayableSong for full functionality.
 * It is intended to be executed in a Java SE environment with Swing support.
 * 
 * 
 * Revision History:
 * - 1.0: Initial release. Basic GUI functionalities implemented.
 */

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

