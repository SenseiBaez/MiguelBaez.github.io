package snhu.jukebox.playlist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import snhu.student.playlists.*;

public class JukeboxPlayer {

    private CommandManager commandManager;
    private JTextArea outputArea;
    private JTextField commandInputField;
    private Jukebox jukebox;
    private PlaylistSearcher playlistSearcher;

    public JukeboxPlayer() {
        jukebox = new Jukebox();
        commandManager = new CommandManager();
        playlistSearcher = new PlaylistSearcher();
        initializeUI();
    }

    private void initializeUI() {
        // Create and set up the window
        JFrame frame = new JFrame("SNHU Jukebox Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Text area for output
        outputArea = new JTextArea(8, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Text field for user input
        commandInputField = new JTextField();

        // Button to execute commands
        JButton executeButton = new JButton("Execute");
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = commandInputField.getText();
                executeCommand(command);
                commandInputField.setText(""); // Clear input field after command
            }
        });

        // Add components to frame
        frame.add(commandInputField, BorderLayout.NORTH);
        frame.add(executeButton, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Display the window
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true);
    }

    private void executeCommand(String command) {
        if ("quit".equalsIgnoreCase(command)) {
            outputArea.append("Exiting Jukebox Player.\n");
            System.exit(0);
        } else {
            String response = commandManager.parseCommand(command);
            outputArea.append(response + "\n");

            // If the command starts with 'find', handle the song search
            if (command.startsWith("find ")) {
                String songName = command.substring(5).trim();
                PlaylistSearchResult result = playlistSearcher.findPlaylistBySong(songName);

                if (result != null) {
                    String playlistName = result.getPlaylistName();
                    Queue<PlayableSong> playlist = jukebox.getPlaylist(playlistName);

                    if (playlist != null) {
                        // If a playlist is found, display its songs
                        outputArea.append("Songs in '" + playlistName + "':\n");
                        for (PlayableSong song : playlist) {
                            outputArea.append(song.getTitle() + " by " + song.getArtist() + "\n");
                        }
                    } else {
                        outputArea.append("Playlist not found.\n");
                    }
                } else {
                    // If the song is not found in any playlist
                    outputArea.append("The song '" + songName + "' is not in any playlist.\n");
                }
            }
            // Additional handling for other commands can be added here
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JukeboxPlayer(); // Create and run the GUI
            }
        });
    }
}






