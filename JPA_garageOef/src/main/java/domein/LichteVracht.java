package domein;

import jakarta.persistence.Entity;

@Entity
public class LichteVracht extends Vervoermiddel {

    private static final long serialVersionUID = 1L;
    private double massa;

    public LichteVracht(double massa, String nummerplaat) {
        super(nummerplaat);
        this.massa = massa;
    }

    public LichteVracht() {

    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    @Override
    public double geefVerkeersbelasting() {
        throw new UnsupportedOperationException("Not supported yet.");
        //volgens maximale massa
    }
}
