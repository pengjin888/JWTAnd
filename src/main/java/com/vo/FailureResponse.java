package com.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FailureResponse {
    //错误码
    @JsonProperty("error_code")
    private String errorCode;
    //错误信息
    @JsonProperty("error_message")
    private String errorMessage;
}
