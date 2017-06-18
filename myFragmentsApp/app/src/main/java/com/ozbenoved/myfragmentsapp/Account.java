package com.ozbenoved.myfragmentsapp;

/**
 * Created by oz ben oved on 6/18/2017.
 */

public class Account {

    private static int counter;
    private int accountId;
    private String text1;
    private String text2;


    public Account(String text1, String text2) {
        accountId = counter++;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}



