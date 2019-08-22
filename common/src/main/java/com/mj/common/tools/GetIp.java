package com.mj.common.tools;

import javax.servlet.http.HttpServletRequest;
//获取本机ip
public class GetIp {
    private static String getRemortIp(HttpServletRequest httpServletRequest){
        if (httpServletRequest.getHeader("x-forwarded-for")==null){
            return httpServletRequest.getRemoteAddr();
        }
        return httpServletRequest.getHeader("x-forwarded-for");
    }
}
