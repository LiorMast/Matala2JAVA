package assignment_2;

public class SoundSet {

    private int duration;  // Duration of the sound in milliseconds.
    int[] pitches = {}; // Array of MIDI pitch numbers representing the notes in the sound set.

    /**
     * Constructs a SoundSet object with a specified duration and optionally MIDI pitches.
     *
     * @param duration The duration of the sound in milliseconds.
     * @param pitches An array of MIDI pitch numbers (optional).
     */
    public SoundSet(int duration, int... pitches) {
        this.duration = duration;
        this.pitches = pitches;
    }


    /**
     * Constructs a SoundSet object with a specified duration and notes represented as strings.
     *
     * @param duration The duration of the sound in milliseconds.
     * @param notes An array of note names (e.g., "C4", "A#3").
     */
    public SoundSet(int duration, String... notes){
        this.duration = duration;
        this.pitches = new int[notes.length];
        for (int i = 0; i < notes.length; i++) {
            pitches[i] = assignment_2.PitchHelper.nameToPitch(notes[i]);
        }
    }

    /**
     * Constructs a SoundSet object with a specified duration but no pitches.
     *
     * @param duration The duration of the sound in milliseconds.
     */
    public SoundSet(int duration){
        this.duration = duration;
    }

    /**
     * Gets the duration of the sound set.
     *
     * @return The duration in milliseconds.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets the array of MIDI pitch numbers in the sound set.
     *
     * @return The array of MIDI pitches.
     */
    public int[] getPitches() {
        return pitches;
    }

}
