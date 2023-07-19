package com.example.office.domain;


public enum LoanStatus {
    FIRSTAPPROVE("FIRSTAPPROVE", 110L),
    SECONDAPPROVE("SECONDAPPROVE", 120L),
    THIRDAPPROVE("THIRDAPPROVE", 200L);

    private  String key;
    private  Long value;



     LoanStatus(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }
}