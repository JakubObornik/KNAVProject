package exercises.exercise2.patterns.facade;

/** Starts and stops a home theater through one facade. */
public final class FacadeDemo {

    private FacadeDemo() {
    }

    public static void run() {
        HomeTheaterFacade theater = new HomeTheaterFacade(
                new Light(), new DvdPlayer(), new Projector(), new SoundSystem());
        theater.watchMovie("The Matrix");
        theater.endMovie();
    }

    private static final class Light {
        void on() { System.out.println("Lights on"); }
        void dim() { System.out.println("Lights dimmed"); }
        void off() { System.out.println("Lights off"); }
    }

    private static final class DvdPlayer {
        void on() { System.out.println("DVD player on"); }
        void play(String movie) { System.out.println("Playing " + movie); }
        void stop() { System.out.println("DVD stopped"); }
        void off() { System.out.println("DVD player off"); }
    }

    private static final class Projector {
        void on() { System.out.println("Projector on"); }
        void wideScreenMode() { System.out.println("Widescreen mode"); }
        void off() { System.out.println("Projector off"); }
    }

    private static final class SoundSystem {
        void on() { System.out.println("Sound system on"); }
        void setVolume(int level) { System.out.println("Volume set to " + level); }
        void off() { System.out.println("Sound system off"); }
    }

    private static final class HomeTheaterFacade {
        private final Light light;
        private final DvdPlayer dvd;
        private final Projector projector;
        private final SoundSystem sound;

        private HomeTheaterFacade(Light light, DvdPlayer dvd, Projector projector, SoundSystem sound) {
            this.light = light;
            this.dvd = dvd;
            this.projector = projector;
            this.sound = sound;
        }

        void watchMovie(String movie) {
            System.out.println("Get ready to watch a movie");
            light.on();
            light.dim();
            projector.on();
            projector.wideScreenMode();
            sound.on();
            sound.setVolume(5);
            dvd.on();
            dvd.play(movie);
        }

        void endMovie() {
            System.out.println("Shutting down the home theater");
            dvd.stop();
            dvd.off();
            projector.off();
            sound.off();
            light.off();
        }
    }
}
