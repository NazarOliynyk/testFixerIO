package model;

import java.util.Date;

public class CurrencyRates {

    private boolean success;
    private Error error;
    private long timestamp;
    private boolean historical;
    private String base;
    private Date date;
    private Rates rates;

    public CurrencyRates() {
    }

    public boolean isSuccess() {
        return success;
    }

    public Error getError() {
        return error;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public boolean isHistorical() {
        return historical;
    }

    public String getBase() {
        return base;
    }

    public Date getDate() {
        return date;
    }

    public Rates getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "CurrencyRates{" +
                "success=" + success +
                ", error='" + error + '\'' +
                ", timestamp=" + timestamp +
                ", historical=" + historical +
                ", base='" + base + '\'' +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }
}