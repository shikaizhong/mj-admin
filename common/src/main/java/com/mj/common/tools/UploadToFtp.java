//package com.mj.common.tools;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class UploadToFtp {
//    FTPClient ftpClient = new FTPClient();
//        try {
//        //连接ftp服务器 参数填服务器的ip
//        ftpClient.connect("120.79.137.163");
//
//        //进行登录 参数分别为账号 密码
//        ftpClient.login("ftpuser","123456");
//
//        //改变工作目录（按自己需要是否改变）
//        //只能选择local_root下已存在的目录
//        ftpClient.changeWorkingDirectory("img");
//
//        //设置文件类型为二进制文件
//        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//
//        //开启被动模式（按自己如何配置的ftp服务器来决定是否开启）
//        ftpClient.enterLocalPassiveMode();
//
//        //上传文件 参数：上传后的文件名，输入流
//        ftpClient.storeFile(file.getName(), new FileInputStream(file));
//        System.out.println(file.getName());
//    } catch (IOException e) {
//        e.printStackTrace();
//        return false;
//    }
//        return true;
//
//}
