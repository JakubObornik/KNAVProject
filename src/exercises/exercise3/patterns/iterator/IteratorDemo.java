package exercises.exercise3.patterns.iterator;

import java.util.NoSuchElementException;

/** Iterates through a song collection by genre. */
public final class IteratorDemo {

    private IteratorDemo() {
    }

    public static void run() {
        SongCollection songs = new SongCollection(6);
        songs.addSong(new Song("Rock Anthem", Genre.ROCK));
        songs.addSong(new Song("Quiet Road", Genre.POP));
        songs.addSong(new Song("Blue Note", Genre.JAZZ));
        songs.addSong(new Song("Guitar Solo", Genre.ROCK));
        songs.addSong(new Song("City Lights", Genre.POP));

        for (Genre genre : Genre.values()) {
            System.out.println(genre + ":");
            SongIterator iterator = songs.createIterator(genre);
            while (iterator.hasNext()) System.out.println("  " + iterator.next());
        }
    }

    private enum Genre { ROCK, POP, JAZZ }
    private record Song(String name, Genre genre) {
        public String toString() { return name + " (" + genre + ")"; }
    }

    private interface SongIterator {
        boolean hasNext();
        Song next();
    }

    private static final class SongCollection {
        private final Song[] songs;
        private int count;

        private SongCollection(int capacity) { songs = new Song[capacity]; }
        void addSong(Song song) {
            if (count == songs.length) throw new IllegalStateException("Song collection is full");
            songs[count++] = song;
        }
        SongIterator createIterator(Genre genre) { return new GenreIterator(songs, count, genre); }
    }

    private static final class GenreIterator implements SongIterator {
        private final Song[] songs;
        private final int count;
        private final Genre genre;
        private int index;

        private GenreIterator(Song[] songs, int count, Genre genre) {
            this.songs = songs;
            this.count = count;
            this.genre = genre;
        }

        public boolean hasNext() {
            while (index < count && songs[index].genre() != genre) index++;
            return index < count;
        }

        public Song next() {
            if (!hasNext()) throw new NoSuchElementException();
            return songs[index++];
        }
    }
}
