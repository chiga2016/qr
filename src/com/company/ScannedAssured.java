package com.company;

import java.math.BigInteger;

public class ScannedAssured {
    private String tip ;
    private String npolis ;
    private String fio;
    private String sex;
    private String dr;
    private String srok;
    private String ecp;

    public ScannedAssured() {
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getNpolis() {
        return npolis;
    }

    public void setNpolis(BigInteger npolis) {
        if(npolis.toString().length()==15){
            this.npolis = "0"+npolis.toString();
        }
        this.npolis = npolis.toString();
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getSrok() {
        return srok;
    }

    public void setSrok(String srok) {
        this.srok = srok;
    }

    public String getEcp() {
        return ecp;
    }

    public void setEcp(String ecp) {
        this.ecp = ecp;
    }

    @Override
    public String toString() {
        return "ScannedAssured{" +
                "tip='" + tip + '\'' +
                ", npolis='" + npolis + '\'' +
                ", fio='" + fio + '\'' +
                ", sex='" + sex + '\'' +
                ", dr='" + dr + '\'' +
                ", srok='" + srok + '\'' +
                ", ecp='" + ecp + '\'' +
                '}';
    }
}
