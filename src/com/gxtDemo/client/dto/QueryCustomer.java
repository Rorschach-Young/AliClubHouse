package com.gxtDemo.client.dto;

import java.io.Serializable;

public class QueryCustomer implements Serializable {
    private String code;
    private String name;
    private String mnemonicCode;

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

    @Override
    public String toString() {
        return "QueryCustomer{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", mnemonicCode='" + mnemonicCode + '\'' +
                '}';
    }
}
