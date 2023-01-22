package com.sample.batchscheduler.model;

public class CreditCard {

    private short id;
    private String uid;
    private String credit_card_number;
    private String credit_card_expiry_date;
    private String credit_card_type;

    public CreditCard() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

    public void setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }

    public String getCredit_card_expiry_date() {
        return credit_card_expiry_date;
    }

    public void setCredit_card_expiry_date(String credit_card_expiry_date) {
        this.credit_card_expiry_date = credit_card_expiry_date;
    }

    public String getCredit_card_type() {
        return credit_card_type;
    }

    public void setCredit_card_type(String credit_card_type) {
        this.credit_card_type = credit_card_type;
    }

    @Override
    public String toString() {
        return "CreditCard [id=" + id + ", uid=" + uid + ", credit_card_number=" + credit_card_number
                + ", credit_card_expiry_date=" + credit_card_expiry_date + ", credit_card_type=" + credit_card_type
                + "]";
    }
    
    
    

}