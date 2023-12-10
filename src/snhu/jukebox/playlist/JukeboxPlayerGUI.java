package snhu.jukebox.playlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * JukeboxPlayerGUI.java
 * 
 * Author: Miguel Baez
 * Contact: miguel.baez-flores@snhu.edu
 * Date: December 10, 2023
 * Version: 3.0
 * 
 * Purpose:
 * The JukeboxPlayerGUI class is the graphical interface for the Jukebox Playlist System. It provides
 * an interactive platform for users to execute commands related to music playlist management, such as
 * searching for songs or playlists. The class integrates with the Jukebox and CommandManager to handle
 * these operations.
 * 
 * Implementation Notes:
 * - The GUI is built using Java Swing components, including JFrame, JTextField, JTextArea, and JButton.
 * - The Nimbus Look and Feel is set for a modern appearance.
 * - The createAndShowGUI method initializes the GUI components and layout.
 * - The executeCommand method processes user commands and displays the results in the output area.
 * - The GUI supports basic command execution such as searching for songs or playlists and exiting the 
 *   application.
 * 
 * Usage:
 * This class should be used as the primary user interface in the Jukebox Playlist System. Users can 
 * interact with the system through a friendly and intuitive GUI to manage and explore music playlists.
 * 
 * Revision History:
 * - 3.0: Initial release. Cleaned up class and added header for class explanation.
 */


public class JukeboxPlayerGUI {

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


