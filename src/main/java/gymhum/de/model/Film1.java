package gymhum.de.model;

public class Film1 {
    
    String titel;
    int fsk;
    int laenge;

    public Film1(String titel, int fsk, int laenge) {
        setFsk(fsk);
        setLaenge(laenge);
        setTitel(titel);

    }

    public void setFsk(int fsk) {
        this.fsk = fsk;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getFsk() {
        return fsk;
    }

    public int getLaenge() {
        return laenge;
    }

    public String getTitel() {
        return titel;
    }
}
