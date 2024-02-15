package assignment_2;

public class Song {
    private int setNumber = 0;
    private String title;
    private SoundSet[] sounds;

    public Song(String title, SoundSet[] sounds) {
        setTitle(title);
        setSounds(sounds);
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setSounds(SoundSet[] sounds) {
        this.sounds = sounds;
//        this.sounds = new SoundSet[sounds.length];
//        for (int i = 0; i < sounds.length; i++)
//            this.sounds[i] = sounds[i];
    }

    // getters
    public String getTitle() {
        return title;
    }

    //methםds

    public boolean hasNext() {
        if (setNumber + 1 > sounds.length){
            reset();
            return false;
        }

        return true;
    }
    public SoundSet next(){
        return sounds[setNumber++];
    }
    public void reset(){setNumber=0;}


}
