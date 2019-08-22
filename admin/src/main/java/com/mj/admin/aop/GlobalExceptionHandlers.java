//package com.mj.admin.aop;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.HashMap;
//import java.util.Map;
///**
// * @Author Simon
// * @Method
// * @Version 1.0
// * @Return
// * @Exception
// * @Date 2019-08-21 0021 09:36:48
// */
//
////全局异常
////声明一个切面
//
//@ControllerAdvice
//public class GlobalExceptionHandlers {
//    @ExceptionHandler(RuntimeException.class)//捕获运行时异常
//    //该注解是返回json数据
//    @ResponseBody
//    public Map<String,Object> excetionHander(){
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("errorCode","101");
//        map.put("errorMsg","系统错误!");
//        return map;
//    }
//}
//
