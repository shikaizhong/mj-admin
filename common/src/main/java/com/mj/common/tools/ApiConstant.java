package com.mj.common.tools;

/**
 * Created by gaolei on 2019/7/8
 */


public class ApiConstant {

    // Header 中 token 的 key
    public final static String AUTHORIZATION = "Authorization";

    // JWTUtil Redis 数据库 用户 key 前缀
    public static String USER_JWT_PREFIX = "api:jwt:";

    // Header 中 sign 的 key
    public static final String HEADER_ENCRYPTE_SIGN = "Encrypt-Sign";

    // 该项目签名 sign-key
    public static final String SIGN_KEY = "FB8EDB1A4ABB4F43A3721B06518112A9";

    /**
     * 文件上传路径
     */
    public static final String UPLOAD_PATH = "/home/file/";
    /**
     * 放在Tomcat的同一目录路径下
     */
    public static final String PRO_UPLOAD_PATH = "/home/ggj/soft/upload/";

    public static final String DEV_UPLOAD_PATH = "D:/麦佳/";
}
