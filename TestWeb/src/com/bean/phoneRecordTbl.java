package com.bean;

/*
 序号 主叫号码    对端位置计费区号    被叫号码    开始时间    
 时长 费用(分)   呼叫方式    附加费(分)*/

public class phoneRecordTbl {
    private String num;
    private String from_phone;
    private String city_code;
    private String to_phone;
    //private String st_time;
    private String time_length;
    private String price;
    private String way;
    private String extend_price;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFrom_phone() {
        return from_phone;
    }

    public void setFrom_phone(String from_phone) {
        this.from_phone = from_phone;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getTo_phone() {
        return to_phone;
    }

    public void setTo_phone(String to_phone) {
        this.to_phone = to_phone;
    }
//
//  public String getSt_time() {
//      return st_time;
//  }
//
//  public void setSt_time(String st_time) {
//      this.st_time = st_time;
//  }

    public String getTime_length() {
        return time_length;
    }

    public void setTime_length(String time_length) {
        this.time_length = time_length;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getExtend_price() {
        return extend_price;
    }

    public void setExtend_price(String extend_price) {
        this.extend_price = extend_price;
    }

}
