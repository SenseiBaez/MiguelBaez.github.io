# <pre align="center">Enhancement Three: Databases</pre>

## <pre align="center">Playlist Database</pre>

For <code>Enhancement Three: Databases</code>, The artifact that was created here was a database filled with the data that has been used in my previous enhancements. That being the different musical artists and their songs, and the different users and their playlists.  This was created by me as the original scope of the artifact did not include having a database. A GUI was also created for the database to demonstrate the functionality of the database and the SQL queries that I created. This artifact showcases my ability to adapt and overcome. This undertaking involved all of the languages that I am very weak in, and I was able to overcome that obstacle and create the enhancement that I wanted.  By creating the relational database in SQLite, it demonstrated my ability to design a database schema by defining tables, specifying primary and foreign keys, and ensuring data integrity through constraints. 
I was able to demonstrate my proficiency in software engineer by meeting the course outcomes. I was able to employ strategies for building collaborative environments that enable diverse audiences to support organizational decision making in the field of Computer Science by using two programming languages to collaborate on a software project. In the professional world multiple developers can work on different aspects of a project. That would include the database design, the SQL queries, and the GUI development. So, by me using the two languages to achieve my end goal, demonstrates a collaborative environment. I demonstrated my ability to design, develop, and deliver professional-quality oral, written, and visual communications that are coherent, technically sound, and appropriately adapted to specific audiences and contexts by documenting the code with clear comments that indicate what is happening in different instances of both the Python code and the SQL code. Having a GUI is also a good example of a visual communication medium that is made to be coherent and user-friendly. I designed and evaluated computing solutions that solve a given problem using algorithmic principles and computer science practices and standards appropriate to its solution, while managing the trade-offs involved in design choices (data structures and algorithms) by my SQL code. It demonstrated the usage of well-founded techniques and skills in database design, and the Python code showcases software engineering principles in GUI development and code organization. With the two languages combined, they implement a computer solution that delivers value by allowing the end-user to search for songs and artists.
This has been the most challenging enhancement for me so far because of my lack of knowledge in SQL and in Python. I had to spend a lot of time researching the different way to query things and how to link the SQL file and the database file to my Python file. I’ve never made a database on my own and that was a challenge that I had to overcome. This week was also a holiday week so that interfered with everything as well. I also learned a lot. I brushed up on my SQL knowledge and Python knowledge. I have a better understanding of the relationship between the SQL script and its database. I learned how to create a GUI in Python using tkinter. Overall, it was a challenging but rewarding experience. I know that I will be making many adjustments to the code for the final delivery.


I incorporated feedback I received previously from into this code. I made sure to comment the code to explain what is going on at each step and I included a header with the overall explanation of class functionality. This is the <code>PlaylistDataGUI.py</code>class.

```

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

```


### <pre align="center">Original Project </pre>
The code for the first two enhancements was shared as the code used was the original jukebox player code. This third enhancement was made from scratch from the data from the Jukebox Player. The database was created from all the various artists, songs, and playlists from the various students or users if you will.

### <pre align="center">Final Design </pre>
This is the database, created with SQL, and the resulting GUI that I created using Python.
```

CREATE TABLE
     artists (
        artist_id INTEGER PRIMARY KEY,
        artist_name TEXT NOT NULL UNIQUE
    );

--Creating the songs table
CREATE TABLE
    songs (
        song_id INTEGER PRIMARY KEY,
        song_name TEXT NOT NULL,
        artist_id INTEGER,
        FOREIGN KEY (artist_id) REFERENCES artists (artist_id)
    );

-- Creating the playlists table
CREATE TABLE
    playlists (
        playlist_id INTEGER PRIMARY KEY,
        playlist_name TEXT NOT NULL,
        student_name TEXT NOT NULL
    );

-- Creating the playlist songs table
CREATE TABLE
    playlist_songs (
        playlist_id INTEGER,
        song_id INTEGER,
        PRIMARY KEY (playlist_id, song_id),
        FOREIGN KEY (playlist_id) REFERENCES playlists (playlist_id),
        FOREIGN KEY (song_id) REFERENCES songs (song_id)
    );

-- Inserting the various artists and songs into the appropriate tables
-- Inserting Adele into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Adele');

-- Inserting songs for Adele
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Hello',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Adele'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Rolling in the Deep',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Adele'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Set Fire to the Rain',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Adele'
        )
    );

-- Inserting Amon Amarth into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Amon Amarth');

-- Inserting songs for Amon Amarth
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'With Oden On Our Side',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Amon Amarth'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Crack the Sky',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Amon Amarth'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Twilight Of The Thunder God',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Amon Amarth'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Raise Your Horns',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Amon Amarth'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Ravens Flight',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Amon Amarth'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Shield Wall',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Amon Amarth'
        )
    );

-- Inserting Elivs Presley into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Elvis Presley');

-- Inserting songs for Elvis Presley
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "That's All Right",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Elvis Presley'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Hound Dog",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Elvis Presley'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Are You Lonesome Tonight?",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Elvis Presley'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Suspicious Minds",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Elvis Presley'
        )
    );

-- Inserting Glass Animals into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Glass Animals');

-- Inserting songs for Glass Animals
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Gooey',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Glass Animals'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Heat Waves',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Glass Animals'
        )
    );

-- Inserting Imagine Dragons into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Imagine Dragons');

-- Inserting songs for Imagine Dragons
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Believer',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Imagine Dragons'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Radioactive',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Imagine Dragons'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        'Demons',
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Imagine Dragons'
        )
    );

-- Inserting Jessie Murph into artists table
INSERT
    artists (artist_name)
VALUES
    ('Jessie Murph');

-- Inserting songs for Jessie Murph
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "I Would've",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Jessie Murph'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Look Who's Crying' Now",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Jessie Murph'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Sobriety",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Jessie Murph'
        )
    );

-- Inserting Jimi Hendrix into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Jimi Hendrix');

-- Inserting songs for Jimi Hendrix
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Purple Haze",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Jimi Hendrix'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Fire",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Jimi Hendrix'
        )
    );

-- Inserting Johnny Cash into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Johnny Cash');

-- Inserting songs for Johnny Cash
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Hurt",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Johnny Cash'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Folsom Prison Blues",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Johnny Cash'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Boy Named Sue",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Johnny Cash'
        )
    );

-- Inserting Katy Perry into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Katy Perry');

-- Inserting songs for Katy Perry
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Wide Awake",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Katy Perry'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Teenage Dream",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Katy Perry'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Hot n Cold",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Katy Perry'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "I Kissed a Girl",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Katy Perry'
        )
    );

-- Inserting Linkin Park into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Linkin Park');

-- Inserting songs for Linkin Park
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "In The End",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Linkin Park'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Numb",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Linkin Park'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "New Divide",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Linkin Park'
        )
    );

-- Inserting Metallica into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Metallica');

-- Inserting songs for Metallica
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Master of Puppets",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Metallica'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "For Whom the Bell Tolls",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Metallica'
        )
    );

-- Inserting Michael Jackson into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Michael Jackson');

-- Inserting songs for Michael Jackson
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Billie Jean",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Michael Jackson'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "The Way You Make Me Feel",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Michael Jackson'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Beat It",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Michael Jackson'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Smooth Criminal",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Michael Jackson'
        )
    );

-- Inserting Modest Mouse into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Modest Mouse');

-- Inserting songs for Modest Mouse
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Float On",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Modest Mouse'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Dashboard",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Modest Mouse'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Lampshades On Fire",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Modest Mouse'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "We Are Between",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Modest Mouse'
        )
    );

-- Inserting Nelly into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Nelly');

-- Inserting songs for Nelly
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Hot in Here",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Nelly'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Grillz",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Nelly'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Ride Wit Me",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Nelly'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "E.I",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Nelly'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "All A Dream",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Nelly'
        )
    );

-- Inserting NSYNC into the artists table
INSERT
    artists (artist_name)
VALUES
    ('NSYNC');

-- Inserting songs for NSYNC
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Bye Bye",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'NSYNC'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Gone",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'NSYNC'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Girlfriend",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'NSYNC'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "I want you back",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'NSYNC'
        )
    );

--Inserting Panice at the disco into the artists table
INSERT
    artists (artist_name)
VALUES
    ("Panic! At the Disco");

-- Inserting songs for Panic at the disco
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "I Write Sins Not Tragedies",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = "Panic! At the Disco"
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "But It's Better If You Do",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = "Panic! At the Disco"
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "High Hopes",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = "Panic! At the Disco"
        )
    );

-- Inserting Papa Roach into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Papa Roach');

-- Inserting songs for Papa Roach
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Forever",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Papa Roach'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Get Away With Murder",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Papa Roach'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Last Resort",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Papa Roach'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Help",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Papa Roach'
        )
    );

-- Inserting Rosenfeld into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Rosenfeld');

-- Inserting songs for Rosenfeld 
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Do It For Me",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Rosenfeld'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Gimmie Love",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Rosenfeld'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "I Want To",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Rosenfeld'
        )
    );

-- Inserting Slushii into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Slushii');

-- Inserting songs for Slushii
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "All I Need",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Slushii'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "LUV U NEED U",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Slushii'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Far Away",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Slushii'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "So Long",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Slushii'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Twinbow",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Slushii'
        )
    );

-- Inserting Tame Impala into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Tame Impala');

-- Inserting songs for Tame Impala
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Elephant",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Tame Impala'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Feels Like We Only Go Backwards",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Tame Impala'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "The Less I Know The Better",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Tame Impala'
        )
    );

-- Inserting Taylor Swift into the artists table
INSERT
    artists (artist_name)
VALUES
    ('Taylor Swift');

-- Inserting songs for Taylor 
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "You Belong WIth Me",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Taylor Swift'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Love Story",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Taylor Swift'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Bad Blood",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Taylor Swift'
        )
    );

-- Inserting The Beatles into the artists table
INSERT
    artists (artist_id)
VALUES
    ('The Beatles');

-- Inserting songs for The Beatles
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Yellow Submarine",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Beatles'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "All You Need Is Love",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Beatles'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Now And Then",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Beatles'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Help!",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Beatles'
        )
    );

-- Inserting The Dead Poet Society into the artists table
INSERT
    artists (artist_id)
VALUES
    ('The Dead Poet Society');

-- Inserting songs for The Dead Poet Society
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        ".CoDA.",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Dead Poet Society'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        ".intoodeep.",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Dead Poet Society'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Sound and Silence",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Dead Poet Society'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Lo Air",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Dead Poet Society'
        )
    );

-- Inserting The Eagles into the artists table
INSERT
    artists (artist_id)
VALUES
    ('The Eagles');

-- Inserting songs for The Eagles
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Hotel California",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Eagles'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Take It Easy",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Eagles'
        )
    );

-- Inserting The Story So Far into the artists table
INSERT
    artists (artist_id)
VALUES
    ('The Story So Far');

-- Inserting songs for The Story So Far
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "States and Minds",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Story So Far'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Roam",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Story So Far'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Mt. Diablo",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Story So Far'
        )
    );

-- Inserting The Wallflowers into the artists table
INSERT
    artists (artist_id)
VALUES
    ('The Wallflowers');

-- Inserting songs for The Wallflowers
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "One Headlight",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Wallflowers'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "6th Avenue Heartache",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Wallflowers'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Closer to You",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Wallflowers'
        )
    );

-- Inserting The Weeknd into the artists table
INSERT
    artists (artist_id)
VALUES
    ('The Weeknd');

-- Inserting songs for The Weeknd
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Starboy",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Weeknd'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Blinding Lights",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Weeknd'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Die For You",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'The Weeknd'
        )
    );

-- Inserting ThreeOHThree into the artists table
INSERT
    artists (artist_id)
VALUES
    ("3OH!3");

-- Inserting songs for ThreeOHThree
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "DONTTRUSTME",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = "3OH!3"
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "STARSSTRUKK",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = "3OH!3"
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "We Are Young",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = "3OH!3"
        )
    );

-- Inserting Travis Scott into the artists table
INSERT
    artists (artist_id)
VALUES
    ('Travis Scott');

-- Inserting songs for Travis Scott
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Butterfly Effect",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Travis Scott'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "MELTDOWN",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Travis Scott'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "SAY MY GRACE",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Travis Scott'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "HYAYNA",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Travis Scott'
        )
    );

-- Inserting Two Feet into the artists table
INSERT
    artists (artist_id)
VALUES
    ('Two Feet');

-- Inserting songs for Two Feet
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "I Feel Like I'm Drowning",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Two Feet'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "I Want It",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Two Feet'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Nightmares",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Two Feet'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Back Of My Mind",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Two Feet'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Lies",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Two Feet'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Devil",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Two Feet'
        )
    );

-- Inserting Virtual Riot into the artists table
INSERT
    artists (artist_id)
VALUES
    ('Virtual Riot');

-- Inserting songs for Virtual Riot
INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Everyday",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Virtual Riot'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Nasty",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Virtual Riot'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "Energy Drinks",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Virtual Riot'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "We're Not Alone",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Virtual Riot'
        )
    );

INSERT INTO
    songs (song_name, artist_id)
VALUES
    (
        "This Could Be Us",
        (
            SELECT
                artist_id
            FROM
                artists
            WHERE
                artist_name = 'Virtual Riot'
        )
    );

-- Inserting the different people and their playlists
INSERT INTO
    playlists (playlist_name, student_name)
VALUES
    ('MiguelBaez_Playlist', 'Miguel Baez');

INSERT INTO
    playlists (playlist_name, student_name)
VALUES
    ('CassieBaez_Playlist', 'Cassie Baez');

INSERT INTO
    playlists (playlist_name, student_name)
VALUES
    ('DavidPaul_Playlist', 'David Paul');

INSERT INTO
    playlists (playlist_name, student_name)
VALUES
    ('HaiNguyen_Playlist', 'Hai Nguyen');

INSERT INTO
    playlists (playlist_name, student_name)
VALUES
    ('JuanGarcia_Playlist', 'Juan Garcia');

INSERT INTO
    playlists (playlist_name, student_name)
VALUES
    ('KarenSoto_Playlist', 'Karen Soto');

INSERT INTO
    playlists (playlist_name, student_name)
VALUES
    ('KatieEarnst_Playlist', 'Katie Earnst');

-- Inserting the various songs into each person's playlist
-- Inserting the songs that pertain to Miguel Baez's Playlist
INSERT INTO
    playlist_songs (playlist_id, song_id)
SELECT
    (
        SELECT
            playlist_id
        FROM
            playlists
        WHERE
            playlist_name = 'MiguelBaez_Playlist'
    ) AS playlist_id,
    songs.song_id
FROM
    songs
    JOIN artists ON songs.artist_id = artists.artist_id
WHERE
    artists.artist_name IN (
        'Metallica',
        'Imagine Dragons',
        '3OH!3',
        'Tame Impala',
        'Glass Animals'
    );

-- Inserting the songs that pertain to Cassie Baez's Playlist
INSERT INTO
    playlist_songs (playlist_id, song_id)
SELECT
    (
        SELECT
            playlist_id
        FROM
            playlists
        WHERE
            playlist_name = 'CassieBaez_Playlist'
    ) AS playlist_id,
    songs.song_id
FROM
    songs
    JOIN artists ON songs.artist_id = artists.artist_id
WHERE
    artists.artist_name IN (
        'Adele',
        'Elvis Presley',
        'Jessie Murph',
        'Jimi Hendrix',
        'Johnny Cash'
    );

-- Inserting the songs that pertain to David Paul's Playlist
INSERT INTO
    playlist_songs (playlist_id, song_id)
SELECT
    (
        SELECT
            playlist_id
        FROM
            playlists
        WHERE
            playlist_name = 'DavidPaul_Playlist'
    ) AS playlist_id,
    songs.song_id
FROM
    songs
    JOIN artists ON songs.artist_id = artists.artist_id
WHERE
    artists.artist_name IN (
        'Katy Perry',
        'Linkin Park',
        'Michael Jackson',
        'Modest Mouse',
        'Travis Scott'
    );

-- Inserting the songs that pertain to Hai Nguyen's Playlist
INSERT INTO
    playlist_songs (playlist_id, song_id)
SELECT
    (
        SELECT
            playlist_id
        FROM
            playlists
        WHERE
            playlist_name = 'HaiNguyen_Playlist'
    ) AS playlist_id,
    songs.song_id
FROM
    songs
    JOIN artists ON songs.artist_id = artists.artist_id
WHERE
    artists.artist_name IN ('The Eagles', 'Taylor Swift', 'Amon Amarth');

-- Inserting the songs that pertain to Juan Garcia's Playlist
INSERT INTO
    playlist_songs (playlist_id, song_id)
SELECT
    (
        SELECT
            playlist_id
        FROM
            playlists
        WHERE
            playlist_name = 'JuanGarcia_Playlist'
    ) AS playlist_id,
    songs.song_id
FROM
    songs
    JOIN artists ON songs.artist_id = artists.artist_id
WHERE
    artists.artist_name IN (
        'Papa Roach',
        'Rosenfeld',
        'Slushii',
        'The Beatles'
    );

-- Inserting the songs that pertain to Karen Soto's Playlist
INSERT INTO
    playlist_songs (playlist_id, song_id)
SELECT
    (
        SELECT
            playlist_id
        FROM
            playlists
        WHERE
            playlist_name = 'KarenSoto_Playlist'
    ) AS playlist_id,
    songs.song_id
FROM
    songs
    JOIN artists ON songs.artist_id = artists.artist_id
WHERE
    artists.artist_name IN (
        'Nelly',
        'NSYNC',
        'Two Feet',
        'Panic! At The Disco',
        'Virtual Riot'
    );

-- Inserting the songs that pertain to Katie Earnst's Playlist
INSERT INTO
    playlist_songs (playlist_id, song_id)
SELECT
    (
        SELECT
            playlist_id
        FROM
            playlists
        WHERE
            playlist_name = 'KatieEarnst_Playlist'
    ) AS playlist_id,
    songs.song_id
FROM
    songs
    JOIN artists ON songs.artist_id = artists.artist_id
WHERE
    artists.artist_name IN (
        'The Dead Poet Society',
        'The Story So Far',
        'The Wallflowers',
        'The Weeknd'
    );

-- Query to search for a song inside the songs table
SELECT
    *
FROM
    songs
WHERE
    LOWER(song_name) LIKE LOWER('%search_term%');

-- Query to search for a song in each person's playlist
SELECT
    pl.playlist_name,
    s.song_name
FROM
    playlists pl
    JOIN playlist_songs pls ON pl.playlist_id = pls.playlist_id
    JOIN songs s ON pls.song_id = s.song_id
WHERE
    LOWER(s.song_name) LIKE LOWER('%search_term%');

SELECT * FROM artists WHERE LOWER(artist_name) LIKE LOWER('%search_term%');

SELECT pl.playlist_name, a.artist_name, s.song_name
FROM playlists pl
JOIN playlist_songs pls ON pl.playlist_id = pls.playlist_id
JOIN songs s ON pls.song_id = s.song_id
JOIN artists a ON s.artist_id = a.artist_id
WHERE LOWER(a.artist_name) LIKE LOWER('%search_term%');
```
<img src="EnhancementThree.png"> 
