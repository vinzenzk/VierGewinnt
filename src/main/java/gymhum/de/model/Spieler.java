package gymhum.de.model;

public class Spieler {
    boolean spieler;
    //x=false o=true

    public Spieler(boolean spieler) {
        setSpieler(false);
    }

    public void setSpieler(boolean spieler) {
        this.spieler = spieler;
    }
    public boolean getSpieler() {
        return spieler;
    }
}
