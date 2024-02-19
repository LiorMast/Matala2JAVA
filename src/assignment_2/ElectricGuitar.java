package assignment_2;

public class ElectricGuitar extends Tunable implements Effectable{

    final static int NSimultaneousSounds = 6; // Static constant representing the maximum number of simultaneous sounds an electric guitar can produce.
    private boolean effect; // Indicates whether the distortion effect is currently active.

    /**
     * Constructs a new ElectricGuitar object named "Electric Guitar" and sets the outTune value to 20.
     */
    public ElectricGuitar()
    {
        super("Electric Guitar");
        outTune = 20;
    }

    /**
     * Overrides the getName method from Tunable to return "Electric Guitar".
     *
     * @return The instrument's name ("Electric Guitar").
     */
    @Override
    public String getName(){return name;}

    /**
     * Overrides the getNSimultaneousSounds method from Tunable to return the maximum number of simultaneous sounds (6).
     *
     * @return The maximum number of simultaneous sounds (6).
     */
    public int getNSimultaneousSounds(){return NSimultaneousSounds;}

    /**
     * Implements the setEffectOn method from Effectable to activate the distortion effect.
     *
     * Changes the Player object's instrument to "Distortion Electric Guitar" and sets the effect flag to true.
     */
    @Override
    public void setEffectOn() {
        p.setInstrument("Distortion Electric Guitar");
        effect=true;
    }

    /**
     * Implements the setEffectOff method from Effectable to deactivate the distortion effect.
     *
     * Changes the Player object's instrument back to "Electric Guitar" and sets the effect flag to false.
     */
    @Override
    public void setEffectOff() {
        p.setInstrument("Electric Guitar");
        effect=false;
    }

    /**
     * Overrides the toString method to return the instrument's name with "with distortion" appended if the effect is on.
     *
     * @return The instrument's name (with "with distortion" if the effect is active).
     */
    @Override
    public String toString(){
        if(effect)
            return super.toString()+" with distortion";
        return super.toString();

    }
}
