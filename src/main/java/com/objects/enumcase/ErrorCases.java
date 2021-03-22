package com.objects.enumcase;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ErrorCases {

    TokenIsValid("0001","token is valid"),
    TokenOverDue("0002","token is overdue");

    @JsonProperty("error_code")
    private String errorCode;
    //错误信息
    @JsonProperty("error_message")
    private String errorMessage;

    ErrorCases(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
