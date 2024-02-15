package assignment_2;

public class ElectricGuitar extends Tunable implements Effectable{
//    final static int outTune = 20;

    final static int NSimultaneousSounds = 6;
    private int tuneCounter;
    private boolean effect;

    //constructors
    public ElectricGuitar()
    {
        super("Electric Guitar");
        outTune = 20;
    }
    @Override
    public String getName(){return name;}

    public int getNSimultaneousSounds(){return NSimultaneousSounds;}

//    @Override
//    public boolean isOutOfTune() {
//        return tuneCounter >= outTune;
//    }

//    @Override
//    public void incrementTuneCounter() {
//        tuneCounter++;
//    }

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

//    @Override
//    public void tune() {
//        System.out.println("Tuning...");
//        tuneCounter = 0;
//    }

    @Override
    public void setEffectOn() {
        p.setInstrument("Distortion Electric Guitar");
        effect=true;
    }

    @Override
    public void setEffectOff() {
        p.setInstrument("Electric Guitar");
        effect=false;
    }
    public String toString(){
        if(effect)
            return super.toString()+" with distortion";
        return super.toString();

    }
}
