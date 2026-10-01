package exercises.exercise2.patterns.bridge;

/** Combines media types with independent player implementations. */
public final class BridgeDemo {

    private BridgeDemo() {
    }

    public static void run() {
        Media[] examples = {
                new Music(new Mp3Player()),
                new Video(new Mp4Player()),
                new Music(new Mp4Player())
        };
        for (Media media : examples) {
            media.play("sample." + media.extension());
            media.stop();
        }
    }

    private interface MediaPlayer {
        void playMedia(String fileName);
        void stop();
    }

    private static final class Mp3Player implements MediaPlayer {
        public void playMedia(String fileName) { System.out.println("MP3 player: " + fileName); }
        public void stop() { System.out.println("MP3 playback stopped"); }
    }

    private static final class Mp4Player implements MediaPlayer {
        public void playMedia(String fileName) { System.out.println("MP4 player: " + fileName); }
        public void stop() { System.out.println("MP4 playback stopped"); }
    }

    private abstract static class Media {
        private final MediaPlayer player;

        private Media(MediaPlayer player) {
            this.player = player;
        }

        abstract String extension();

        void play(String fileName) {
            player.playMedia(fileName);
        }

        void stop() {
            player.stop();
        }
    }

    private static final class Music extends Media {
        private Music(MediaPlayer player) { super(player); }
        String extension() { return "mp3"; }
    }

    private static final class Video extends Media {
        private Video(MediaPlayer player) { super(player); }
        String extension() { return "mp4"; }
    }
}
