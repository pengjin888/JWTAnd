package com.filter;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.exception.JWTVerifyException;
import com.service.UserService;
import com.utils.ResponseUtil;
import com.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *
 */
@Slf4j
@WebFilter(urlPatterns = "/*")//*通配符（*）表示对所有的web资源进行拦截*/
public class JWTVerifyFilter implements Filter {
    @Resource
    UserService userService;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String uri = servletRequest.getRequestURI();
        StringBuffer url= servletRequest.getRequestURL();
        //与用户相关直接放行
        if (uri.startsWith("/user")){
            chain.doFilter(request,response);
        }else {
            try {
                if (StringUtil.isBlank(servletRequest.getHeader("Authorization")) || servletRequest.getHeader("Authorization").length() < 8) {
                    log.warn("[doFilter] token is null");
                    throw new JWTVerifyException("token is null");
                } else {
                    String token = servletRequest.getHeader("Authorization").substring(7);
                    DecodedJWT decodedJWT = userService.verify(token);
                    Claim userID = decodedJWT.getClaim("user_id");
                    request.setAttribute("user_id", userID);
                }
            } catch (JWTVerifyException ex) {
                ResponseUtil.sendMessage(response, "0000", "token is null");
            } catch (SignatureVerificationException ex) {
                ResponseUtil.sendMessage(response, "0001", "token is valid");
            } catch (TokenExpiredException ex) {
                ResponseUtil.sendMessage(response, "0002", "token overdue");
            } catch (AlgorithmMismatchException ex) {
                ResponseUtil.sendMessage(response, "0003", "different algorithm");
            }catch (Exception ex){
                ResponseUtil.sendMessage(response, "0001", "token is valid");
            }
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }
}
