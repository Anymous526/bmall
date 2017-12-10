package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class CloudStatistics implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Long goodsCount;

    private Long userCount;

    private Long angelCoinCount;

    private Long goodsPassCount;

    private Long goodsWinnerCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Long getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Long goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Long getUserCount() {
        return userCount;
    }

    public void setUserCount(Long userCount) {
        this.userCount = userCount;
    }

    public Long getAngelCoinCount() {
        return angelCoinCount;
    }

    public void setAngelCoinCount(Long angelCoinCount) {
        this.angelCoinCount = angelCoinCount;
    }

    public Long getGoodsPassCount() {
        return goodsPassCount;
    }

    public void setGoodsPassCount(Long goodsPassCount) {
        this.goodsPassCount = goodsPassCount;
    }

    public Long getGoodsWinnerCount() {
        return goodsWinnerCount;
    }

    public void setGoodsWinnerCount(Long goodsWinnerCount) {
        this.goodsWinnerCount = goodsWinnerCount;
    }
}