package com.amall.core.bean;

import java.math.BigDecimal;

public class CityPartNerSum {
    private Integer id;

    private Long userid;

    private Short year;

    private Byte month;

    private BigDecimal fenhong;

    private BigDecimal buzhu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Byte getMonth() {
        return month;
    }

    public void setMonth(Byte month) {
        this.month = month;
    }

    public BigDecimal getFenhong() {
        return fenhong;
    }

    public void setFenhong(BigDecimal fenhong) {
        this.fenhong = fenhong;
    }

    public BigDecimal getBuzhu() {
        return buzhu;
    }

    public void setBuzhu(BigDecimal buzhu) {
        this.buzhu = buzhu;
    }
}