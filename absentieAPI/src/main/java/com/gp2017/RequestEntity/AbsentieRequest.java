package com.gp2017.RequestEntity;

public class AbsentieRequest {
    private String reden;
    private String toelichting;
    private int persoonId;
    private int lesId;

    public AbsentieRequest() {
    }

    public String getReden() {
        return reden;
    }

    public void setReden(String reden) {
        this.reden = reden;
    }

    public String getToelichting() {
        return toelichting;
    }

    public void setToelichting(String toelichting) {
        this.toelichting = toelichting;
    }

    public int getPersoonId() {
        return persoonId;
    }

    public void setPersoonId(int persoonId) {
        this.persoonId = persoonId;
    }

    public int getLesId() {
        return lesId;
    }

    public void setLesId(int lesId) {
        this.lesId = lesId;
    }
}
