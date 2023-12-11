import tkinter as tk
import sqlite3
import os


#PlaylistDataGUI.py

#Author: Miguel Baez
#Contact: miguel.baez-flores@snhu.edu
#Date: November 26, 2023
#Version: 1.0

#Purpose:
#This script implements a playlist management system for the different user playlists.
#It includes functionalities to search by song title or artist.

#Revision History:
#- 1.0: Initial release. Script uses SQL queries to find songs by title or artist.

def create_database(db_path):
    conn = sqlite3.connect(db_path)
    cursor = conn.cursor()

    # Table creation statements
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS artists (
            artist_id INTEGER PRIMARY KEY,
            artist_name TEXT NOT NULL UNIQUE
        )
    ''')
    
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS songs (
            song_id INTEGER PRIMARY KEY,
            song_name TEXT NOT NULL,
            artist_id INTEGER,
            FOREIGN KEY(artist_id) REFERENCES artists(artist_id)
        )
    ''')

    cursor.execute('''
        CREATE TABLE IF NOT EXISTS playlists (
            playlist_id INTEGER PRIMARY KEY,
            playlist_name TEXT NOT NULL,
            student_name TEXT NOT NULL
        )
    ''')

    cursor.execute('''
        CREATE TABLE IF NOT EXISTS playlist_songs (
            playlist_id INTEGER,
            song_id INTEGER,
            PRIMARY KEY (playlist_id, song_id),
            FOREIGN KEY (playlist_id) REFERENCES playlists(playlist_id),
            FOREIGN KEY (song_id) REFERENCES songs(song_id)
        )
    ''')

    # Commit changes and close connection
    conn.commit()
    conn.close()

# Usage
db_path = '/Users/baezduh/CS499/MiguelB_CS499_EnhancementThree/Playlist.db'
create_database(db_path)

def execute_sql_file(sql_file_path, db_path):
    # Connect to the SQLite database
    conn = sqlite3.connect(db_path)
    cursor = conn.cursor()

    # Read and execute the SQL script
    with open(sql_file_path, 'r') as sql_file:
        sql_script = sql_file.read()

    try:
        cursor.executescript(sql_script)
        conn.commit()
    except sqlite3.Error as e:
        print(f"An error occurred: {e}")
        conn.rollback()
    finally:
        conn.close()

# Usage
db_path = '/Users/baezduh/CS499/MiguelB_CS499_EnhancementThree/Playlist.db'
sql_file_path = '/Users/baezduh/CS499/MiguelB_CS499_EnhancementThree/PlaylistData.sql'
execute_sql_file(sql_file_path, db_path)

def search_songs(song_title):
    conn = sqlite3.connect('/Users/baezduh/CS499/MiguelB_CS499_EnhancementThree/Playlist.db')
    try:
        cur = conn.cursor()
        # Search in songs table
        cur.execute("SELECT * FROM songs WHERE LOWER(song_name) LIKE LOWER(?)", ('%' + song_title + '%',))
        songs_results = cur.fetchall()

        # Search in playlists by song
        cur.execute("""
            SELECT pl.playlist_name, s.song_name
            FROM playlists pl
            JOIN playlist_songs pls ON pl.playlist_id = pls.playlist_id
            JOIN songs s ON pls.song_id = s.song_id
            WHERE LOWER(s.song_name) LIKE LOWER(?)
        """, ('%' + song_title + '%',))
        playlists_results = cur.fetchall()

        return songs_results, playlists_results
    except sqlite3.Error as e:
        print(e)
    finally:
        if conn:
            conn.close()

def search_by_artist(artist_name):
    conn = sqlite3.connect('/Users/baezduh/CS499/MiguelB_CS499_EnhancementThree/Playlist.db')
    try:
        cur = conn.cursor()
        # Search in artists table
        cur.execute("SELECT * FROM artists WHERE LOWER(artist_name) LIKE LOWER(?)", ('%' + artist_name + '%',))
        artist_results = cur.fetchall()

        # Search in playlists by artist
        cur.execute("""
            SELECT pl.playlist_name, a.artist_name, s.song_name
            FROM playlists pl
            JOIN playlist_songs pls ON pl.playlist_id = pls.playlist_id
            JOIN songs s ON pls.song_id = s.song_id
            JOIN artists a ON s.artist_id = a.artist_id
            WHERE LOWER(a.artist_name) LIKE LOWER(?)
        """, ('%' + artist_name + '%',))
        playlists_artist_results = cur.fetchall()

        return artist_results, playlists_artist_results
    except sqlite3.Error as e:
        print(e)
    finally:
        if conn:
            conn.close()

def on_search():
    search_term = entry.get()

    # Clear existing data in the list boxes
    listbox_songs.delete(0, tk.END)
    listbox_playlists.delete(0, tk.END)
    listbox_artists.delete(0, tk.END)

    # Check the search option and execute the appropriate search
    if search_option.get() == 'song':
        songs, playlists = search_songs(search_term)
        # Add search results to the list boxes for songs and playlists
        for song in songs:
            listbox_songs.insert(tk.END, song)
        for playlist in playlists:
            listbox_playlists.insert(tk.END, f"Playlist: {playlist[0]}, Song: {playlist[1]}")
    elif search_option.get() == 'artist':
        artists, playlists_artists = search_by_artist(search_term)
        # Add search results to the list boxes for artists and playlists by artist
        for artist in artists:
            listbox_artists.insert(tk.END, artist)
        for playlist_artist in playlists_artists:
            listbox_playlists.insert(tk.END, f"Playlist: {playlist_artist[0]}, Artist: {playlist_artist[1]}, Song: {playlist_artist[2]}")

# GUI setup
root = tk.Tk()
root.title("Playlist Manager")

# GUI setup for radio buttons
search_option = tk.StringVar(value='song')
rb_song = tk.Radiobutton(root, text='Search by Song', variable=search_option, value='song')
rb_artist = tk.Radiobutton(root, text='Search by Artist', variable=search_option, value='artist')
rb_song.pack()
rb_artist.pack()

# Label for search field
label = tk.Label(root, text="Enter Song Title:")
label.pack(side=tk.TOP, pady=10)

# Search entry field
entry = tk.Entry(root, fg="black", bg="white", width=50)
entry.pack(side=tk.TOP, pady=10)

# Search button
search_button = tk.Button(root, text="Search", command=on_search)
search_button.pack(side=tk.TOP, pady=10)

# ListBoxes for displaying results
listbox_songs = tk.Listbox(root, width=50)
listbox_songs.pack(side=tk.TOP, pady=10)

listbox_playlists = tk.Listbox(root, width=50)
listbox_playlists.pack(side=tk.TOP, pady=10)

listbox_artists = tk.Listbox(root, width=50)  # Define the listbox_artists widget
listbox_artists.pack(side=tk.TOP, pady=10)  # Pack the listbox_artists widget

root.mainloop()