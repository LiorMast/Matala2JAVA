package assignment_2;

public class Trumpet extends MusicalInstrument implements Effectable{
    public static final int NSimultaneousSounds = 1; // Static constant representing the maximum number of simultaneous sounds a trumpet can produce (fixed).
    private boolean effect; // Flag indicating whether the mute effect is currently active.

    /**
     * Constructs a new Trumpet object named "Trumpet".
     */
    public Trumpet(){
        super("Trumpet");
    }

    /**
     * Overrides the getName method from MusicalInstrument to return the instrument's name ("Trumpet").
     *
     * @return The instrument's name ("Trumpet").
     */
    @Override
    public String getName(){return name;}

    /**
     * Overrides the getNSimultaneousSounds method from MusicalInstrument to return the maximum number of simultaneous sounds (1).
     *
     * @return The maximum number of simultaneous sounds (1).
     */
    public int getNSimultaneousSounds(){return NSimultaneousSounds;}

    /**
     * Implements the setEffectOn method from Effectable to activate the mute effect.
     *
     * Sets the Player object's instrument to "Muted Trumpet" and sets the effect flag to true.
     */
    @Override
    public void setEffectOn() {
        p.setInstrument("Muted Trumpet");
        effect=true;
    }

    /**
     * Implements the setEffectOff method from Effectable to deactivate the mute effect.
     *
     * Sets the Player object's instrument back to "Trumpet" and sets the effect flag to false.
     */
    @Override
    public void setEffectOff() {
        p.setInstrument("Trumpet");
        effect=false;
    }

    /**
     * Overrides the toString method to return the instrument's name with ", muted" appended if the mute effect is on.
     *
     * @return The instrument's name (with ", muted" if the effect is active).
     */
    @Override
    public String toString(){
        if(effect)
            return super.toString()+", muted";
        return super.toString();

    }
}
