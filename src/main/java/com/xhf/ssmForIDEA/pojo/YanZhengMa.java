package com.xhf.ssmForIDEA.pojo;

import java.util.Date;

public class YanZhengMa {
    //验证码类，用于实现验证码的校验
    private Date date;
    private String yzm;
    private String mailadress;

    public YanZhengMa(){

    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getYzm() {
        return yzm;
    }
    public void setYzm(String yzm) {
        this.yzm = yzm;
    }
    public String getMailadress() {
        return mailadress;
    }
    public void setMailadress(String mailadress) {
        this.mailadress = mailadress;
    }

}
