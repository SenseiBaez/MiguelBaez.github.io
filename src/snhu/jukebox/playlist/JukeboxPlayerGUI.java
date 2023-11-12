package snhu.jukebox.playlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Queue;

public class JukeboxPlayerGUI {

    private Jukebox jukebox;
    private CommandManager cm;
    private JTextArea outputArea;
    private JTextField commandInput;

    public JukeboxPlayerGUI() {
        jukebox = new Jukebox(); // Initialize with your playlists
        cm = new CommandManager(); // This needs to work with the GUI now
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
        // If you have an icon, you can set it like this:
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

        // Set the frame size and make it visible
        frame.pack();
        frame.setVisible(true);
    }

    private void executeCommand(String command) {
        commandInput.setText(""); // Clear the input field
        if ("quit".equalsIgnoreCase(command)) {
            outputArea.append("Exiting the Playlist Loader...\n");
            System.exit(0);
        } else {
            String response = cm.parseCommand(command);
            outputArea.append(response + "\n");

            if (response.startsWith("The song")) {
                // Response from 'find' command is displayed directly.
            } else if (!response.isEmpty()) {
                // It's a playlist command, so we display the playlist content.
                Queue<PlayableSong> playlist = jukebox.getPlaylist(response);
                if (playlist.isEmpty()) {
                    outputArea.append("Playlist found! Try another song!\n");
                } else {
                    outputArea.append("Playlist found: " + response + "\n");
                    for (PlayableSong song : playlist) {
                        // Assuming PlayableSong has getTitle() and getArtist() methods.
                        outputArea.append(song.getTitle() + " by " + song.getArtist() + "\n");
                    }
                }
            } else {
                outputArea.append("Please enter a valid command.\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JukeboxPlayerGUI::new);
    }
}



