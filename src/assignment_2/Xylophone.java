package assignment_2;

public class Xylophone extends MusicalInstrument{

    final static int NSimultaneousSounds = 1;

    //constructors
    public Xylophone(){
        super("Xylophone");
    }
    @Override
    public String getName(){return name;}

    public int getNSimultaneousSounds(){return NSimultaneousSounds;}

    public String toString(){return name;}
}
