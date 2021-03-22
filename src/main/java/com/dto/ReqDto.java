package com.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @Description
 * @Package com.dto
 * @ClassName 请求
 * @Copyright: Copyright (c) 2020
 * @Date 2021-02-07 1:39
 * @Company www.peachfully.com.cn
 * @Author 桃我喜欢
 * @Version 1.0
 */
@Data
public class ReqDto {
    @JsonProperty("num")
    private Integer number;
}
