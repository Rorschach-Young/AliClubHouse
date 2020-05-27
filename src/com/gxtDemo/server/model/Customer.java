package com.gxtDemo.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    public Customer() {
    }

    public Customer(Integer id, String code, String name, String mnemonicCode, String type, String phone, String fax, String email, String address, Boolean mark, String company, Date birthday, String postCode, String bankAccount, String bank, String settlement, Date settlementTime, Date monthlyTime, String remark) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.mnemonicCode = mnemonicCode;
        this.type = type;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.address = address;
        this.mark = mark;
        this.company = company;
        this.birthday = birthday;
        this.postCode = postCode;
        this.bankAccount = bankAccount;
        this.bank = bank;
        this.settlement = settlement;
        this.settlementTime = settlementTime;
        this.monthlyTime = monthlyTime;
        this.remark = remark;
    }

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

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Column(name = "birthday", nullable = true)
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    @Column(name = "phone", nullable = false, length = 15)
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    @Column(name = "address", nullable = false, length = 255)
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    @Column(name = "code", nullable = false, length = 20)
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    @Column(name = "name", nullable = false, length = 255)
    public void setName(String name) {
        this.name = name;
    }

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    @Column(name = "mnemonicCode", nullable = false, length = 20)
    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }

    public String getType() {
        return type;
    }

    @Column(name = "type", nullable = false, length = 50)
    public void setType(String type) {
        this.type = type;
    }

    public String getFax() {
        return fax;
    }

    @Column(name = "fax", nullable = true, length = 20)
    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    @Column(name = "email", nullable = true, length = 30)
    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getMark() {
        return mark;
    }

    @Column(name = "mark", nullable = false, columnDefinition = "BOOLEAN")
    public void setMark(Boolean mark) {
        this.mark = mark;
    }

    public String getCompany() {
        return company;
    }

    @Column(name = "company", nullable = false, length = 255)
    public void setCompany(String company) {
        this.company = company;
    }

    public String getPostCode() {
        return postCode;
    }

    @Column(name = "postCode", nullable = true, length = 6)
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    @Column(name = "bankAccount", nullable = false, length = 40)
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBank() {
        return bank;
    }

    @Column(name = "bank", nullable = false, length = 50)
    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getSettlement() {
        return settlement;
    }

    @Column(name = "settlement", nullable = false, length = 50)
    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public Date getSettlementTime() {
        return settlementTime;
    }

    @Column(name = "settlementTime", nullable = true)
    public void setSettlementTime(Date settlementTime) {
        this.settlementTime = settlementTime;
    }

    public Date getMonthlyTime() {
        return monthlyTime;
    }

    @Column(name = "monthlyTime", nullable = true, length = 2)
    public void setMonthlyTime(Date monthlyTime) {
        this.monthlyTime = monthlyTime;
    }

    public String getRemark() {
        return remark;
    }

    @Column(name = "remark", nullable = true, length = 255)
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", mnemonicCode='" + mnemonicCode + '\'' +
                ", type='" + type + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", mark=" + mark +
                ", company='" + company + '\'' +
                ", birthday=" + birthday +
                ", postCode='" + postCode + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", bank='" + bank + '\'' +
                ", settlement='" + settlement + '\'' +
                ", settlementTime=" + settlementTime +
                ", monthlyTime=" + monthlyTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}

