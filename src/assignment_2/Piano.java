package assignment_2;

public class Piano extends Tunable {

    final static int NSimultaneousSounds = 10; // Static constant for maximum simultaneous sounds (fixed for pianos).


    /**
     * Constructs a new Piano object.
     */
    public Piano() {
        super("Piano");
        outTune = 65; // Set the `outTune` value specific to pianos.
    }

    /**
     * Returns the maximum number of simultaneous sounds a piano can produce.
     *
     * @return The maximum number of simultaneous sounds (10 for pianos).
     */
    @Override
    public int getNSimultaneousSounds() {
        return NSimultaneousSounds;
    }

    /**
     * Overrides the `getName` method from `Tunable` to explicitly return "Piano".
     *
     * @return The instrument's name ("Piano").
     */
    @Override
    public String getName() {
        return name;
    }


    /**
     * Plays a sliding sound effect from one pitch to another.
     *
     * @param from The starting pitch (MIDI note number).
     * @param to The ending pitch (MIDI note number).
     * @param duration The duration of the first and last notes, all other notes play for duration/10 ms.
     */
    public void playSlide(int from, int to, int duration) {
        if (from < to) { // Ascending slide
            play(new SoundSet(duration, from));
            for (int i = from + 1; i < to; i++) {
                play(new SoundSet(duration / 10, i));
            }
                play(new SoundSet(duration, to));
        } else { // Descending slide
            play(new SoundSet(duration, from));
            for (int i = from - 1; i > to; i--) {
                play(new SoundSet(duration / 10, i));
                }
                play(new SoundSet(duration, to));
            }
    }
}
