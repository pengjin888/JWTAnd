package com.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.dto.ReqDto;
import com.service.ProductsService;
import com.service.TbSkuService;
import com.vo.RandomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Package com.controller
 * @ClassName 前后端接口
 * @Copyright: Copyright (c) 2020
 * @Date 2021-01-31 16:04
 * @Company www.peachfully.com.cn
 * @Author 桃我喜欢
 * @Version 1.0
 */
@RestController
@RequestMapping("/spring")
public class TestController {
    @Resource
    TbSkuService tbSkuService;

    @Resource
    ProductsService productsService;

    @RequestMapping("/test1")
    public Object test(){
        List select = tbSkuService.select(1);
        return select;
    }

    @RequestMapping("/test2")
    public Object test2(){
        return productsService.select();
    }

    @PostMapping("/test")
    public Object getRandomNumber(@RequestParam(name = "sir") String user, @RequestBody() ReqDto dto, HttpServletRequest request){
        Random random = new Random();
        int x = random.nextInt();
        System.out.println(request.getHeader("Access-Token"));
        return new RandomVo(user+" with "+dto.getNumber(),x);
    }

    @GetMapping("/select")
    public List select(){
        return tbSkuService.select(2);
    }

}
