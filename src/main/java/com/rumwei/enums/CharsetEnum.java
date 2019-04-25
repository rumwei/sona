package com.rumwei.enums;

public enum CharsetEnum {
    utf8("UTF-8",1),
    gb2312("GB2312",2),
    gbk("GBK",3),
    iso88591("ISO-8859-1",4),
    ascii("ASCII",5);

    private String strVal;
    private int val;

    private CharsetEnum(String strVal, int val){
        this.strVal = strVal;
        this.val = val;
    }

    public String getStrVal(){return this.strVal;}
    public int getVal(){return this.val;}

}
