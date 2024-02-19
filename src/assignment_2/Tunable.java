package assignment_2;

public abstract class Tunable extends MusicalInstrument {
    protected int outTune; // Number of successful plays before instrument goes out of tune
    protected int tuneCounter; // Counter for successful plays since last tuning

    /**
     * Constructs a new Tunable instrument with the given name.
     *
     * @param name The name of the instrument.
     */
    public Tunable(String name){
        super(name);
        this.tuneCounter=0;
    }

    /**
     * Overrides the play method from MusicalInstrument to handle tuning.
     *
     * @param soundset The sound set to play.
     * @return True if the sound set was played successfully, false otherwise.
     */
    @Override
    public boolean play(SoundSet soundset) {

        if (isOutOfTune()){
            // Adjust pitches for out-of-tune playing
            int[] newPitches = soundset.getPitches().clone();
            for (int i = 0; i < soundset.getPitches().length; i++) {
                --newPitches[i]; // Lower each pitch by one step
            }
            boolean isPlaying =super.play(new SoundSet(soundset.getDuration(), newPitches));
            return isPlaying;
        }

        boolean isPlaying = super.play(soundset);
        if (isPlaying) {
            incrementTuneCounter(); // Track successful plays
        }
        return isPlaying;
    }

    /**
     * Checks if the instrument is out of tune.
     *
     * @return True if the instrument is out of tune, false otherwise.
     */
    public boolean isOutOfTune() {

        return tuneCounter >= outTune;
    }

    /**
     * Increments the tune counter.
     */
    public void incrementTuneCounter() {
        tuneCounter++;
    }

    /**
     * Tunes the instrument, resetting the tune counter.
     */
    public void tune() {
        System.out.println("Tuning...");
        tuneCounter = 0;
    }
}
