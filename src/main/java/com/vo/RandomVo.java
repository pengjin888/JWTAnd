package com.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description
 * @Package com.vo
 * @ClassName 返回体
 * @Copyright: Copyright (c) 2020
 * @Date 2021-02-06 23:08
 * @Company www.peachfully.com.cn
 * @Author 桃我喜欢
 * @Version 1.0
 */
@AllArgsConstructor
@Data
public class RandomVo {
    private String name;
    @JsonProperty("num")
    private Integer randomNumber;
}
