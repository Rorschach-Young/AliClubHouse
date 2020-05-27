package com.gxtDemo.client.dto;

import java.io.Serializable;
import java.util.Date;

public class QueryCustomerDTO implements Serializable {
    private Integer id;
    private String code;
    private String name;
    private String mnemonicCode;
    private String type;
    private String phone;
    private String fax;
    private String email;
    private String address;
    private Boolean mark;
    private String company;
    private Date birthday;
    private String postCode;
    private String bankAccount;
    private String bank;
    private String settlement;
    private Date settlementTime;
    private Date monthlyTime;
    private String remark;

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
