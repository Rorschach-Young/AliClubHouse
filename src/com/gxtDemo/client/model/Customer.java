package com.gxtDemo.client.model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private Integer id;// 主键 id
    private String code;// 客户代码
    private String name;// 客户名称
    private String mnemonicCode;// 助记码
    private String type;// 客户类型
    private String phone;// 电话
    private String fax;// 传真
    private String email;// 邮箱
    private String address;// 联系地址
    private Boolean mark;// 启用标记
    private String company;// 工作单位
    private Date birthday;// 出生日期
    private String postCode;// 邮编
    private String bankAccount;// 银行账号
    private String bank;// 银行
    private String settlement;// 结算方式
    private Date settlementTime;// 结账日期
    private Date monthlyTime;// 月结日期
    private String remark;// 备注

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getMark() {
        return mark;
    }

    public void setMark(Boolean mark){ this.mark = mark; }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public Date getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(Date settlementTime) {
        this.settlementTime = settlementTime;
    }

    public Date getMonthlyTime() {
        return monthlyTime;
    }

    public void setMonthlyTime(Date monthlyTime) {
        this.monthlyTime = monthlyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", mnemonicCode='" + mnemonicCode + '\'' +
                ", type='" + type + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", mark=" + mark +
                ", company='" + company + '\'' +
                ", birthday=" + birthday +
                ", postCode='" + postCode + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", bank='" + bank + '\'' +
                ", settlement='" + settlement + '\'' +
                ", settlementTime=" + settlementTime +
                ", monthlyTime='" + monthlyTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
