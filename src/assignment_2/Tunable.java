package assignment_2;

public abstract class Tunable extends MusicalInstrument {
    protected int outTune;
    protected int tuneCounter;

    public Tunable(String name){
        super(name);
        this.tuneCounter=0;
    }
    public boolean play(SoundSet soundset) {

        if (isOutOfTune()){

            int[] newPitches = soundset.getPitches().clone();
            for (int i = 0; i < soundset.getPitches().length; i++) {
                --newPitches[i];
            }
            boolean isPlaying =super.play(new SoundSet(soundset.getDuration(), newPitches));
            return isPlaying;
        }

        boolean isPlaying = super.play(soundset);
        if (isPlaying) {
            incrementTuneCounter();
        }
        return isPlaying;
    }

    public boolean isOutOfTune() {

        return tuneCounter >= outTune;
    }

    public void incrementTuneCounter() {
        tuneCounter++;
    }

    public void tune() {
        System.out.println("Tuning...");
        tuneCounter = 0;
    }
}
