package com.ozbenoved.recylerview_adapter_et_tv;

/**
 * Created by oz ben oved on 6/11/2017.
 */

public class Dugma {

    static int EDIT = 0;
    static int NOT_EDIT  = 1;

    private String text1;
    private String text2;
    private int type = NOT_EDIT;

    public Dugma(int type){
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

}
