package assignment_2;

public class Song {
    private int setNumber = 0;  // Internal counter for tracking the current sound set index.
    private String title; // Title of the song.
    private SoundSet[] sounds; // Array of SoundSet objects representing the song's sequence.

    /**
     * Constructs a new Song object with the given title and sound sets.
     *
     * @param title The title of the song.
     * @param sounds An array of SoundSet objects representing the song sequence.
     */
    public Song(String title, SoundSet[] sounds) {
        setTitle(title);
        setSounds(sounds);
    }


    /**
     * Sets the title of the song.
     *
     * @param title The new title of the song.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the array of sound sets for the song.
     *
     * @param sounds An array of SoundSet objects representing the song sequence.
     */
    public void setSounds(SoundSet[] sounds) {
        this.sounds = sounds;
    }

    /**
     * Returns the title of the song.
     *
     * @return The song title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Checks if there are more sound sets in the song based on the current index.
     * Resets the counter if reaching the end during iteration.
     *
     * @return True if there are more sound sets, false otherwise.
     */
    public boolean hasNext() {
        if (setNumber + 1 > sounds.length){
            reset(); // Reset counter if reaching the end during iteration.
            return false;
        }

        return true;
    }

    /**
     * Returns the next sound set in the sequence and increments the internal counter.
     *
     * @return The next SoundSet object.
     */
    public SoundSet next(){
        return sounds[setNumber++];
    }

    /**
     * Resets the internal counter to the beginning of the song.
     */
    public void reset(){setNumber=0;}


}
