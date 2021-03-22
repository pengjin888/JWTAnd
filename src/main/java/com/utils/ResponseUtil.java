package com.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vo.FailureResponse;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class ResponseUtil {
    public static void sendMessage(ServletResponse response, String code, String message) throws IOException {
        OutputStream out = response.getOutputStream();
        FailureResponse errorResponse = new FailureResponse();
        errorResponse.setErrorCode(code);
        errorResponse.setErrorCode(message);
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String userJson = convertObjectToJson(errorResponse);
        //返回错误信息
        out.write(userJson.getBytes("UTF-8"));
        out.close();
    }

    //转为json对象
    public static String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
