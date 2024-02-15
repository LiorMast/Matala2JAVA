package assignment_2;

public class Piano extends Tunable {
//    final static int outTune = 65;
    final static int NSimultaneousSounds = 10;
//    private int tuneCounter;

    public Piano() {
        super("Piano");
        outTune = 65;
    }

    @Override
    public int getNSimultaneousSounds() {
        return NSimultaneousSounds;
    }

    public String getName() {
        return name;
    }

//    public boolean isOutOfTune() {
//
//        return tuneCounter >= outTune;
//    }

//    @Override
//    public void incrementTuneCounter() {
//        tuneCounter++;
//    }

//    @Override
//    public boolean play(SoundSet soundset) {
//
//        if (isOutOfTune()){
//
//            int[] newPitches = soundset.getPitches().clone();
//            for (int i = 0; i < soundset.getPitches().length; i++) {
//                --newPitches[i];
//            }
//            boolean isPlaying =super.play(new SoundSet(soundset.getDuration(), newPitches));
//            return isPlaying;
//        }
//
//        boolean isPlaying = super.play(soundset);
//        if (isPlaying) {
//            incrementTuneCounter();
//        }
//        return isPlaying;
//    }

//    public void tune() {
//        System.out.println("Tuning...");
//        tuneCounter = 0;
//    }

    public void playSlide(int from, int to, int duration) {
        if (from < to) {
            play(new SoundSet(duration, from));
            for (int i = from + 1; i < to; i++) {
                play(new SoundSet(duration / 10, i));
            }
                play(new SoundSet(duration, to));
        } else {
            play(new SoundSet(duration, from));
            for (int i = from - 1; i > to; i--) {
                play(new SoundSet(duration / 10, i));
                }
                play(new SoundSet(duration, to));
            }
    }
}
