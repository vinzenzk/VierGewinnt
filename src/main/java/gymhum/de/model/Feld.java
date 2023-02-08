package gymhum.de.model;

public class Feld {
    boolean frei;
    boolean xo;
    //x = false o = true

    public Feld() {
        setFrei(true);
    }

    public void setFrei(boolean frei) {
        this.frei = frei;
    }

    public void setXo(boolean xo) {
        this.xo = xo;
    }

    public boolean getXo() {
        return xo;
    }

    public boolean getFrei()          {
        return frei;
    }
}
