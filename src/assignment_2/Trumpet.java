package assignment_2;

public class Trumpet extends MusicalInstrument implements Effectable{
    final static int NSimultaneousSounds = 1;
    private boolean effect;

    //constructors
    public Trumpet(){
        super("Trumpet");
    }
    @Override
    public String getName(){return name;}

    public int getNSimultaneousSounds(){return NSimultaneousSounds;}

    public void setEffectOn() {
        p.setInstrument("Muted Trumpet");
        effect=true;
    }

    @Override
    public void setEffectOff() {
        p.setInstrument("Trumpet");
        effect=false;
    }
    public String toString(){
        if(effect)
            return super.toString()+", muted";
        return super.toString();

    }
}
