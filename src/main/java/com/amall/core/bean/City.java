package com.amall.core.bean;

public class City {
    private Long cityid;

    private String fletter;

    private String prov;

    private String city;

    private String suocity;

    private String domain;

    private String pinyin;

    private String suoxie;

    private Boolean iffocus;

    private String quhao;

    private String point;

    private Boolean done;

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public String getFletter() {
        return fletter;
    }

    public void setFletter(String fletter) {
        this.fletter = fletter == null ? null : fletter.trim();
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov == null ? null : prov.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getSuocity() {
        return suocity;
    }

    public void setSuocity(String suocity) {
        this.suocity = suocity == null ? null : suocity.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getSuoxie() {
        return suoxie;
    }

    public void setSuoxie(String suoxie) {
        this.suoxie = suoxie == null ? null : suoxie.trim();
    }

    public Boolean getIffocus() {
        return iffocus;
    }

    public void setIffocus(Boolean iffocus) {
        this.iffocus = iffocus;
    }

    public String getQuhao() {
        return quhao;
    }

    public void setQuhao(String quhao) {
        this.quhao = quhao == null ? null : quhao.trim();
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}