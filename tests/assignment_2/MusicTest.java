package assignment_2;

import org.junit.jupiter.api.*;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MusicTest {

    private static int sleepTime = 1;

    private String expected, output;
    private SongLibrary library = SongLibrary.library;

    static TextCollector textCollector;
    static PrintStream origOut;

    @BeforeAll
    static void setup(){

        // Uncomment the two rows below in order to run the tests in a
        // fast print-only mode:

        // MusicalInstrument.setMuteState(true);
        // sleepTime = 0;

        // Collecting the text from System.out:
        origOut = System.out;
        textCollector = new TextCollector(System.out);
        System.setOut(new PrintStream(textCollector));
    }

    @AfterAll
    static void tearDown(){
        // restore original output
        System.setOut(origOut);
    }

    @BeforeEach
    void methodSetup() {
        // Verifying the output string, expected string, and text buffer are empty:
        output = "";
        expected = "";
        textCollector.collect();
    }

    @AfterEach
    void methodTearDown(){
        // Printing mismatches between expected and obtained outputs
        // (if there are any), and sleeping:
        if (!expected.equals(output)) {
            printMismatch(expected, output);
        }
        sleep(sleepTime);
    }

    @Test
    void testBasic() {
        // Testing single note and melody song playing:
        MusicalInstrument xylophone = new Xylophone();
        System.out.println(xylophone);

        xylophone.play(new SoundSet(500, "C4"));

        xylophone.playSong(library.getSong("Hissing of Summer Lawns"));

        expected =
                "Xylophone\n" +
                        "Playing duration: 500ms, notes: C4\n" +
                        "Playing Hissing of Summer Lawns on Xylophone\n" +
                        "Playing duration: 180ms, notes: D4\n" +
                        "Playing duration: 360ms, notes: F#4\n" +
                        "Playing duration: 360ms, notes: A4\n" +
                        "Playing duration: 720ms, notes: B4\n" +
                        "Playing duration: 240ms, notes: A4\n" +
                        "Playing duration: 240ms, notes: A4\n" +
                        "Playing duration: 240ms, notes: A4\n" +
                        "Playing duration: 360ms, notes: A4\n" +
                        "Playing duration: 180ms, notes: break\n" +
                        "Playing duration: 180ms, notes: B3\n" +
                        "Playing duration: 180ms, notes: B3\n" +
                        "Playing duration: 180ms, notes: B3\n" +
                        "Playing duration: 180ms, notes: D4\n" +
                        "Playing duration: 180ms, notes: B3\n" +
                        "Playing duration: 360ms, notes: F#4\n" +
                        "Playing duration: 360ms, notes: E4\n" +
                        "Playing duration: 360ms, notes: D4\n" +
                        "Playing duration: 180ms, notes: B3\n" +
                        "Playing duration: 540ms, notes: E4\n" +
                        "Playing duration: 180ms, notes: B3\n" +
                        "Playing duration: 1080ms, notes: break\n" +
                        "Playing duration: 180ms, notes: F#4\n" +
                        "Playing duration: 180ms, notes: E4\n" +
                        "Playing duration: 180ms, notes: F#4\n" +
                        "Playing duration: 180ms, notes: E4\n" +
                        "Playing duration: 180ms, notes: E4\n" +
                        "Playing duration: 180ms, notes: D4\n" +
                        "Playing duration: 180ms, notes: D4\n" +
                        "Playing duration: 180ms, notes: A#3\n" +
                        "Playing duration: 360ms, notes: E4\n" +
                        "Playing duration: 360ms, notes: break\n" +
                        "Playing duration: 180ms, notes: D4\n" +
                        "Playing duration: 180ms, notes: B3\n" +
                        "Playing duration: 540ms, notes: D4\n" +
                        "Playing duration: 540ms, notes: E4\n" +
                        "Playing duration: 360ms, notes: E4\n" +
                        "Playing duration: 900ms, notes: break\n" +
                        "Playing duration: 360ms, notes: F#4\n" +
                        "Playing duration: 180ms, notes: A4\n" +
                        "Playing duration: 1080ms, notes: B4\n" +
                        "Playing duration: 1260ms, notes: A4\n" +
                        "Playing duration: 360ms, notes: F#4\n" +
                        "Playing duration: 180ms, notes: F#4\n" +
                        "Playing duration: 180ms, notes: F#4\n" +
                        "Playing duration: 360ms, notes: D4\n" +
                        "Playing duration: 540ms, notes: E4\n" +
                        "Playing duration: 180ms, notes: A3\n" +
                        "Playing duration: 180ms, notes: A3\n" +
                        "Playing duration: 180ms, notes: F#4\n" +
                        "Playing duration: 180ms, notes: F#4\n" +
                        "Playing duration: 540ms, notes: E4\n" +
                        "Playing duration: 180ms, notes: D4\n" +
                        "Playing duration: 180ms, notes: B3\n" +
                        "Playing duration: 180ms, notes: E4\n" +
                        "Playing duration: 1440ms, notes: B3\n" +
                        "Done playing Hissing of Summer Lawns\n";

        output = textCollector.collect();
        assertTrue(expected.equals(output));
    }

    @Test
    void testHarmony() {
        // Testing a song with simultaneous notes.
        MusicalInstrument piano = new Piano();
        System.out.println(piano);
        piano.playSong(library.getSong("I Feel the Earth Move"));

        expected =
                "Piano\n" +
                        "Playing I Feel the Earth Move on Piano\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 512ms, notes: C3, G3, A#3, C4\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 512ms, notes: C3, G3, A#3, C4\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 256ms, notes: C3, G3, A#3, C4\n" +
                        "Playing duration: 512ms, notes: C3, F3, A3, C4\n" +
                        "Playing duration: 256ms, notes: C3, D#3, G3, C4\n" +
                        "Playing duration: 512ms, notes: C3, F3, A3, C4\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 512ms, notes: C3, G3, A#3, C4\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 512ms, notes: C3, G3, A#3, C4\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 256ms, notes: C3, G3, A#3, C4\n" +
                        "Playing duration: 512ms, notes: C3, F3, A3, C4\n" +
                        "Playing duration: 256ms, notes: C3, D#3, G3, G4\n" +
                        "Playing duration: 256ms, notes: C3, F3, A3, F4\n" +
                        "Playing duration: 256ms, notes: C3, F3, A3, D#4\n" +
                        "Playing duration: 256ms, notes: C2, G4\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 512ms, notes: C3, G3, A#3, C4\n" +
                        "Playing duration: 256ms, notes: C2, G4\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 512ms, notes: C3, G3, A#3, C4\n" +
                        "Playing duration: 256ms, notes: C2, F4\n" +
                        "Playing duration: 256ms, notes: C2, D#4\n" +
                        "Playing duration: 256ms, notes: C3, G3, A#3, C4\n" +
                        "Playing duration: 512ms, notes: C3, G3, A#3, D#4\n" +
                        "Playing duration: 256ms, notes: C3, D#3, G3, G4\n" +
                        "Playing duration: 256ms, notes: C3, F3, A3, F4\n" +
                        "Playing duration: 256ms, notes: C3, F3, A3, D#4\n" +
                        "Playing duration: 256ms, notes: C2, G4\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 256ms, notes: C3, G3, A#3, C4, A#4\n" +
                        "Playing duration: 256ms, notes: C3, G3, A#3, C4, G4\n" +
                        "Playing duration: 256ms, notes: C2, F4\n" +
                        "Playing duration: 256ms, notes: C2, D#4\n" +
                        "Playing duration: 448ms, notes: C3, G3, A#3, C4\n" +
                        "Playing duration: 64ms, notes: F#4\n" +
                        "Playing duration: 256ms, notes: C2, G4, A#4\n" +
                        "Playing duration: 256ms, notes: C2, F4, A4\n" +
                        "Playing duration: 256ms, notes: C3, D#4, G4\n" +
                        "Playing duration: 256ms, notes: C3, C4\n" +
                        "Playing duration: 256ms, notes: C2, D#4\n" +
                        "Playing duration: 256ms, notes: C2, G4\n" +
                        "Playing duration: 256ms, notes: C3, F4\n" +
                        "Playing duration: 256ms, notes: C3, D#4\n" +
                        "Playing duration: 2048ms, notes: F2, G#3, C4, D#4, F4\n" +
                        "Done playing I Feel the Earth Move\n";

        output = textCollector.collect();
        assertTrue(expected.equals(output));
    }

    @Test
    void testEffect() {
        // Testing switching an effect on and off:

        Song trill = library.getSong("Trill");

        ElectricGuitar guitar = new ElectricGuitar();
        System.out.println("Guitar with no effect:");
        guitar.playSong(trill);

        System.out.println("Guitar with effect:");
        guitar.setEffectOn();
        guitar.playSong(trill);

        System.out.println("Guitar with no effect again:");
        guitar.tune();
        guitar.setEffectOff();
        guitar.playSong(trill);
        sleep(sleepTime);

        Trumpet trumpet = new Trumpet();
        System.out.println("Trumpet with no effect:");
        trumpet.playSong(trill);

        System.out.println("Trumpet with effect:");
        trumpet.setEffectOn();
        trumpet.playSong(trill);

        System.out.println("Trumpet with no effect again:");
        trumpet.setEffectOff();
        trumpet.playSong(trill);

        expected =
                "Guitar with no effect:\n" +
                        "Playing Trill on Electric Guitar\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Done playing Trill\n" +
                        "Guitar with effect:\n" +
                        "Playing Trill on Electric Guitar with distortion\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Done playing Trill\n" +
                        "Guitar with no effect again:\n" +
                        "Tuning...\n" +
                        "Playing Trill on Electric Guitar\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Done playing Trill\n" +
                        "Trumpet with no effect:\n" +
                        "Playing Trill on Trumpet\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Done playing Trill\n" +
                        "Trumpet with effect:\n" +
                        "Playing Trill on Trumpet, muted\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Done playing Trill\n" +
                        "Trumpet with no effect again:\n" +
                        "Playing Trill on Trumpet\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Done playing Trill\n";

        output = textCollector.collect();
        assertTrue(expected.equals(output));
    }

    @Test
    void testSlide() {
        // Testing piano slide:
        Piano piano = new Piano();
        System.out.println("Slide up...");
        piano.playSlide(60, 72, 500);
        sleep(sleepTime);
        System.out.println("\nAnd slide down...");
        piano.playSlide(72, 60, 500);

        expected =
                "Slide up...\n" +
                        "Playing duration: 500ms, notes: C4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 50ms, notes: D4\n" +
                        "Playing duration: 50ms, notes: D#4\n" +
                        "Playing duration: 50ms, notes: E4\n" +
                        "Playing duration: 50ms, notes: F4\n" +
                        "Playing duration: 50ms, notes: F#4\n" +
                        "Playing duration: 50ms, notes: G4\n" +
                        "Playing duration: 50ms, notes: G#4\n" +
                        "Playing duration: 50ms, notes: A4\n" +
                        "Playing duration: 50ms, notes: A#4\n" +
                        "Playing duration: 50ms, notes: B4\n" +
                        "Playing duration: 500ms, notes: C5\n" +
                        "\n" +
                        "And slide down...\n" +
                        "Playing duration: 500ms, notes: C5\n" +
                        "Playing duration: 50ms, notes: B4\n" +
                        "Playing duration: 50ms, notes: A#4\n" +
                        "Playing duration: 50ms, notes: A4\n" +
                        "Playing duration: 50ms, notes: G#4\n" +
                        "Playing duration: 50ms, notes: G4\n" +
                        "Playing duration: 50ms, notes: F#4\n" +
                        "Playing duration: 50ms, notes: F4\n" +
                        "Playing duration: 50ms, notes: E4\n" +
                        "Playing duration: 50ms, notes: D#4\n" +
                        "Playing duration: 50ms, notes: D4\n" +
                        "Playing duration: 50ms, notes: C#4\n" +
                        "Playing duration: 500ms, notes: C4\n";

        output = textCollector.collect();
        assertTrue(expected.equals(output));
    }

    @Test
    void testOutOfTune() {
        // Testing out of tune cases for Tunable instruments:

        Piano piano = new Piano();

        // Playing slides to induce out of tuning:
        piano.playSlide(60, 84, 300);
        sleep(sleepTime);
        piano.playSlide(84, 60, 300);

        // Playing a song:
        Song littleJonathan = SongLibrary.library.getSong("Little Jonathan");
        sleep(sleepTime);
        System.out.println();
        piano.playSong(littleJonathan);

        sleep(sleepTime);
        System.out.println();

        // Playing the song after tuning:
        piano.tune();
        piano.playSong(littleJonathan);
        sleep(sleepTime);

        MusicalInstrument guitar = new ElectricGuitar();
        guitar.playSong(littleJonathan);

        expected =
                "Playing duration: 300ms, notes: C4\n" +
                        "Playing duration: 30ms, notes: C#4\n" +
                        "Playing duration: 30ms, notes: D4\n" +
                        "Playing duration: 30ms, notes: D#4\n" +
                        "Playing duration: 30ms, notes: E4\n" +
                        "Playing duration: 30ms, notes: F4\n" +
                        "Playing duration: 30ms, notes: F#4\n" +
                        "Playing duration: 30ms, notes: G4\n" +
                        "Playing duration: 30ms, notes: G#4\n" +
                        "Playing duration: 30ms, notes: A4\n" +
                        "Playing duration: 30ms, notes: A#4\n" +
                        "Playing duration: 30ms, notes: B4\n" +
                        "Playing duration: 30ms, notes: C5\n" +
                        "Playing duration: 30ms, notes: C#5\n" +
                        "Playing duration: 30ms, notes: D5\n" +
                        "Playing duration: 30ms, notes: D#5\n" +
                        "Playing duration: 30ms, notes: E5\n" +
                        "Playing duration: 30ms, notes: F5\n" +
                        "Playing duration: 30ms, notes: F#5\n" +
                        "Playing duration: 30ms, notes: G5\n" +
                        "Playing duration: 30ms, notes: G#5\n" +
                        "Playing duration: 30ms, notes: A5\n" +
                        "Playing duration: 30ms, notes: A#5\n" +
                        "Playing duration: 30ms, notes: B5\n" +
                        "Playing duration: 300ms, notes: C6\n" +
                        "Playing duration: 300ms, notes: C6\n" +
                        "Playing duration: 30ms, notes: B5\n" +
                        "Playing duration: 30ms, notes: A#5\n" +
                        "Playing duration: 30ms, notes: A5\n" +
                        "Playing duration: 30ms, notes: G#5\n" +
                        "Playing duration: 30ms, notes: G5\n" +
                        "Playing duration: 30ms, notes: F#5\n" +
                        "Playing duration: 30ms, notes: F5\n" +
                        "Playing duration: 30ms, notes: E5\n" +
                        "Playing duration: 30ms, notes: D#5\n" +
                        "Playing duration: 30ms, notes: D5\n" +
                        "Playing duration: 30ms, notes: C#5\n" +
                        "Playing duration: 30ms, notes: C5\n" +
                        "Playing duration: 30ms, notes: B4\n" +
                        "Playing duration: 30ms, notes: A#4\n" +
                        "Playing duration: 30ms, notes: A4\n" +
                        "Playing duration: 30ms, notes: G#4\n" +
                        "Playing duration: 30ms, notes: G4\n" +
                        "Playing duration: 30ms, notes: F#4\n" +
                        "Playing duration: 30ms, notes: F4\n" +
                        "Playing duration: 30ms, notes: E4\n" +
                        "Playing duration: 30ms, notes: D#4\n" +
                        "Playing duration: 30ms, notes: D4\n" +
                        "Playing duration: 30ms, notes: C#4\n" +
                        "Playing duration: 300ms, notes: C4\n" +
                        "\n" +
                        "Playing Little Jonathan on Piano\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: E4\n" +
                        "Playing duration: 500ms, notes: E4\n" +
                        "Playing duration: 250ms, notes: F4\n" +
                        "Playing duration: 250ms, notes: D4\n" +
                        "Playing duration: 500ms, notes: D4\n" +
                        "Playing duration: 250ms, notes: C4\n" +
                        "Playing duration: 250ms, notes: D4\n" +
                        "Playing duration: 250ms, notes: E4\n" +
                        "Playing duration: 250ms, notes: F4\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 500ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: E4\n" +
                        "Playing duration: 500ms, notes: D#4\n" +
                        "Playing duration: 250ms, notes: E4\n" +
                        "Playing duration: 250ms, notes: C#4\n" +
                        "Playing duration: 500ms, notes: C#4\n" +
                        "Playing duration: 250ms, notes: B3\n" +
                        "Playing duration: 250ms, notes: D#4\n" +
                        "Playing duration: 250ms, notes: F#4\n" +
                        "Playing duration: 250ms, notes: F#4\n" +
                        "Playing duration: 1000ms, notes: B3\n" +
                        "Done playing Little Jonathan\n" +
                        "\n" +
                        "Tuning...\n" +
                        "Playing Little Jonathan on Piano\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: E4\n" +
                        "Playing duration: 500ms, notes: E4\n" +
                        "Playing duration: 250ms, notes: F4\n" +
                        "Playing duration: 250ms, notes: D4\n" +
                        "Playing duration: 500ms, notes: D4\n" +
                        "Playing duration: 250ms, notes: C4\n" +
                        "Playing duration: 250ms, notes: D4\n" +
                        "Playing duration: 250ms, notes: E4\n" +
                        "Playing duration: 250ms, notes: F4\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 500ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: E4\n" +
                        "Playing duration: 500ms, notes: E4\n" +
                        "Playing duration: 250ms, notes: F4\n" +
                        "Playing duration: 250ms, notes: D4\n" +
                        "Playing duration: 500ms, notes: D4\n" +
                        "Playing duration: 250ms, notes: C4\n" +
                        "Playing duration: 250ms, notes: E4\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 1000ms, notes: C4\n" +
                        "Done playing Little Jonathan\n" +
                        "Playing Little Jonathan on Electric Guitar\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: E4\n" +
                        "Playing duration: 500ms, notes: E4\n" +
                        "Playing duration: 250ms, notes: F4\n" +
                        "Playing duration: 250ms, notes: D4\n" +
                        "Playing duration: 500ms, notes: D4\n" +
                        "Playing duration: 250ms, notes: C4\n" +
                        "Playing duration: 250ms, notes: D4\n" +
                        "Playing duration: 250ms, notes: E4\n" +
                        "Playing duration: 250ms, notes: F4\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 500ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: G4\n" +
                        "Playing duration: 250ms, notes: E4\n" +
                        "Playing duration: 500ms, notes: E4\n" +
                        "Playing duration: 250ms, notes: F4\n" +
                        "Playing duration: 250ms, notes: D4\n" +
                        "Playing duration: 500ms, notes: D4\n" +
                        "Playing duration: 250ms, notes: C4\n" +
                        "Playing duration: 250ms, notes: D#4\n" +
                        "Playing duration: 250ms, notes: F#4\n" +
                        "Playing duration: 250ms, notes: F#4\n" +
                        "Playing duration: 1000ms, notes: B3\n" +
                        "Done playing Little Jonathan\n";

        output = textCollector.collect();
        assertTrue(expected.equals(output));
    }

    @Test
    void testSimultaneousNotes() {
        SoundSet chordAbdim7 = new SoundSet(
                2000, "G2", "F3", "Ab3", "B3", "E4", "Ab4");
        SoundSet chordAbdim7Extended = new SoundSet(
                2000, "G2", "Ab2", "F3", "Ab3", "B3", "E4", "G4", "B4", "F4", "Ab4");
        SoundSet chordAbdim7VeryExtended = new SoundSet(
                2000, "G2", "Ab2", "B2", "F3", "Ab3", "B3", "E4", "G4", "B4", "F4", "Ab4");

        Piano piano = new Piano();
        piano.play(chordAbdim7);
        piano.play(chordAbdim7Extended);
        piano.play(chordAbdim7VeryExtended);

        ElectricGuitar guitar = new ElectricGuitar();
        guitar.play(chordAbdim7);
        guitar.play(chordAbdim7Extended);

        Trumpet trumpet = new Trumpet();
        trumpet.play(new SoundSet(1000, "G2"));
        trumpet.play(new SoundSet(1000, "G2", "F3"));
        trumpet.playSong(library.getSong("I Feel the Earth Move"));

        expected =
                "Playing duration: 2000ms, notes: G2, F3, G#3, B3, E4, G#4\n" +
                        "Playing duration: 2000ms, notes: G2, G#2, F3, G#3, B3, E4, G4, B4, F4, G#4\n" +
                        "Piano can play at most 10 simultaneous notes, cannot play a sound set with 11 notes!\n" +
                        "Playing duration: 2000ms, notes: G2, F3, G#3, B3, E4, G#4\n" +
                        "Electric Guitar can play at most 6 simultaneous notes, cannot play a sound set with 10 notes!\n" +
                        "Playing duration: 1000ms, notes: G2\n" +
                        "Trumpet can play at most 1 simultaneous notes, cannot play a sound set with 2 notes!\n" +
                        "Playing I Feel the Earth Move on Trumpet\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Playing duration: 256ms, notes: C2\n" +
                        "Trumpet can play at most 1 simultaneous notes, cannot play a sound set with 4 notes!\n" +
                        "Stopped playing I Feel the Earth Move due to error!\n";

        output = textCollector.collect();
        assertTrue(expected.equals(output));
    }

    @Test
    void testTypeCheck() {
        Xylophone xylophone = new Xylophone();
        Piano piano = new Piano();
        ElectricGuitar guitar = new ElectricGuitar();
        Trumpet trumpet = new Trumpet();

        MusicalInstrument[] instruments = {xylophone, piano, guitar, trumpet};

        String res = "";

        for (MusicalInstrument instrument : instruments) {
            String hasEffect = "has no effect", hasTune = "is not tunable";
            if (instrument instanceof Effectable) {
                hasEffect = "has effect";
            }
            if (instrument instanceof Tunable) {
                hasTune = "is tunable";
            }
            res += instrument.getName() + " " + hasEffect + " and " + hasTune + "\n";
        }

        System.out.println(res);

        expected =
                "Xylophone has no effect and is not tunable\n" +
                        "Piano has no effect and is tunable\n" +
                        "Electric Guitar has effect and is tunable\n" +
                        "Trumpet has effect and is not tunable\n\n";
        output = textCollector.collect();
        assertTrue(expected.equals(output));
    }


    private static void printMismatch(String expected, String output) {
        int maxIx = Math.min(expected.length(), output.length());
        int i = 0;
        for (; i < maxIx && output.charAt(i) == expected.charAt(i); i++);
        if (i == maxIx) {
            // One string is a prefix of the other
            if (maxIx == output.length()) {
                // output is shorter than expected
                System.err.println("Output contains only " + maxIx +
                        " characters out of an expected " + expected.length() +
                        " characters. Missing expected suffix:");
                System.err.println("\"" + expected.substring(maxIx) + "\"");
            }
            else {
                // output is longer than expected
                System.err.println("Expected output contains only " + maxIx +
                        " characters, output contained " + output.length() +
                        " characters. Unexpected suffix:");
                System.err.println("\"" + output.substring(maxIx) + "\"");
            }
        }
        else {
            String prefix = expected.substring(0, i + 1);
            int rowIx = (int) prefix.chars().filter(ch -> ch == '\n').count() + 1;
            int rowStart = prefix.lastIndexOf('\n') + 1;
            int mismatchIx = i - rowStart + 1;
            String expectedSuffix = expected.substring(rowStart);
            String outputSuffix = output.substring(rowStart);
            int expectedRowEnd = expectedSuffix.indexOf('\n');
            if (expectedRowEnd == -1) {
                expectedRowEnd = expectedSuffix.length();
            }
            int outputRowEnd = outputSuffix.indexOf('\n');
            if (outputRowEnd == -1) {
                outputRowEnd = outputSuffix.length();
            }

            System.err.println("First output mismatch at row " + rowIx + ", character " + mismatchIx + ":");
            System.err.println("Expected: \"" + expectedSuffix.substring(0, expectedRowEnd) + "\"");
            System.err.println("Obtained: \"" + outputSuffix.substring(0, outputRowEnd) + "\"");
        }
    }

    private static void sleep(int seconds) {
        // Auxiliary function to delay the program for a given amount of seconds.
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
