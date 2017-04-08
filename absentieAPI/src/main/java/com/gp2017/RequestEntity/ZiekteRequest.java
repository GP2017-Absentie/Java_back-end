package com.gp2017.RequestEntity;

public class ZiekteRequest {
    private int persoonId;
    private String datum;

    public ZiekteRequest() {
    }

    public int getPersoonId() {
        return persoonId;
    }

    public void setPersoonId(int persoonId) {
        this.persoonId = persoonId;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}
