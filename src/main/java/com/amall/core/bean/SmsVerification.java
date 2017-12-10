package com.amall.core.bean;

public class SmsVerification {
    private Long id;

    private String smsPhone;        //注册手机号码

    private String smsCreateDate;   //注册码生成时间
 
    private Integer smsCount;       //发送次数

    private String smsCode;         //生成的随机码

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSmsPhone() {
        return smsPhone;
    }

    public void setSmsPhone(String smsPhone) {
        this.smsPhone = smsPhone == null ? null : smsPhone.trim();
    }

    public String getSmsCreateDate() {
        return smsCreateDate;
    }

    public void setSmsCreateDate(String smsCreateDate) {
        this.smsCreateDate = smsCreateDate == null ? null : smsCreateDate.trim();
    }

    public Integer getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(Integer smsCount) {
        this.smsCount = smsCount;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode == null ? null : smsCode.trim();
    }
}