package assignment_2;

public abstract class MusicalInstrument {

    protected String name;

    protected static boolean isMute = false; // Static flag for muting the instrument.

    protected Player p;  // Reference to a Player object for sound playback.

    /**
     * Constructs a new MusicalInstrument object with the given name.
     *
     * @param name The name of the instrument.
     */
    public MusicalInstrument(String name){
        this.name=name;
        p = new Player(this.name); // Create a Player instance linked to this instrument.
    }

    abstract String getName();

    /**
     * Returns the maximum number of simultaneous sounds this instrument can produce.
     *
     * @return The maximum number of simultaneous sounds.
     */
    abstract int getNSimultaneousSounds();

    /**
     * Attempts to play the given sound set on this instrument.
     *
     * * @param soundset The sound set to play.
     * @return True if the sound set was played successfully, false otherwise
     *
     * * @throws Exception If the sound set contains more notes than the instrument can handle.
     */
    public boolean play(SoundSet soundset){

        try {
            if (soundset.getPitches().length > this.getNSimultaneousSounds()){ //if the method tries to play more notes than the instrument can handle, the playing fails
                throw new Exception(name + " can play at most "+getNSimultaneousSounds()+" simultaneous notes, cannot play a sound set with "+soundset.getPitches().length+" notes!");
            }else {
                System.out.println("Playing duration: " + soundset.getDuration() + "ms, notes: " + PitchHelper.pitchToName(soundset.getPitches()));
                if (!isMute) { // Check if the instrument is muted before playing.
                    p.playSound(soundset);
                }
                return true;
            }
        } catch (Exception e) { //if playing failed
            System.out.println(e.getMessage());
            return false;
        }

    }


    /**
     * Plays the given song on this instrument.
     *
     * @param song The song to play.
     */
    public void playSong(Song song){
        song.reset();
        System.out.println("Playing " + song.getTitle() + " on " + this.toString());
        boolean isPlaying = true;
        while (song.hasNext() && isPlaying) {
            isPlaying = play(song.next()); // Play each sound set in the song.
        }
        if (!isPlaying){
            System.out.println("Stopped playing " + song.getTitle() + " due to error!");
        }else{
            System.out.println("Done playing "+song.getTitle());
        }


    }


    /**
     * Returns a string representation of this instrument.
     *
     * @return The instrument's name.
     */
    public String toString(){
        return getName();
    }

    /**
     * Sets the mute state for all instruments of this type.
     *
     * @param muteState True to mute, false to unmute.
     */
    public static void setMuteState(boolean muteState){
        isMute = muteState;
    }


}
