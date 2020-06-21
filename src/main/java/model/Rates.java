package model;

public class Rates {

    public double USD;
    public double EUR;
    public double PLN;
    public double UAH;

    public Rates() {
    }

    public double getUSD() {
        return USD;
    }

    public double getEUR() {
        return EUR;
    }

    public double getPLN() {
        return PLN;
    }

    public double getUAH() {
        return UAH;
    }

    @Override
    public String toString() {
        return "model.Rates{" +
                "USD=" + USD +
                ", EUR=" + EUR +
                ", PLN=" + PLN +
                ", UAH=" + UAH +
                '}';
    }
}
