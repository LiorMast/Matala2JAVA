package assignment_2;

public class SoundSet {

    private int duration;
    int[] pitches = {};

    public SoundSet(int duration, int... pitches) {
        this.duration = duration;
        this.pitches = pitches;
    }


    public SoundSet(int duration, String... notes){
        this.duration = duration;
        this.pitches = new int[notes.length];
        for (int i = 0; i < notes.length; i++) {
            pitches[i] = assignment_2.PitchHelper.nameToPitch(notes[i]);
        }
    }

    public SoundSet(int duration){
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }

    public int[] getPitches() {
        return pitches;
    }

}
