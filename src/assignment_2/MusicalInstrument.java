package assignment_2;

public abstract class MusicalInstrument {

    protected String name;

    protected static boolean isMute = false;
    protected Player p;
    public MusicalInstrument(String name){
        this.name=name;
        p = new Player(this.name);
    }

    abstract String getName();
    abstract int getNSimultaneousSounds();
    public boolean play(SoundSet soundset){

        try {
            if (soundset.getPitches().length > this.getNSimultaneousSounds()){ //if the method tries to play more notes than the instrument can handle, the playing fails
                throw new Exception(name + " can play at most "+getNSimultaneousSounds()+" simultaneous notes, cannot play a sound set with "+soundset.getPitches().length+" notes!");
            }else {
                System.out.println("Playing duration: " + soundset.getDuration() + "ms, notes: " + PitchHelper.pitchToName(soundset.getPitches()));
                if (!isMute) { // if the instrument is muted, skip playing the sound
                    p.playSound(soundset);
                }
                return true;
            }
        } catch (Exception e) { //if playing failed
            System.out.println(e.getMessage());
            return false;
        }

    }



    public void playSong(Song song){
        song.reset();
        System.out.println("Playing " + song.getTitle() + " on " + this.toString());
        boolean isPlaying = true;
        while (song.hasNext() && isPlaying) {
            isPlaying =  play(song.next());
        }
        if (!isPlaying){
            System.out.println("Stopped playing " + song.getTitle() + " due to error!");
        }else{
            System.out.println("Done playing "+song.getTitle());
        }


    }
    public String toString(){
        return getName();
    }
    public static void setMuteState(boolean muteState){
        isMute = muteState;
    }


}
