package com.mj.admin.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebSocketTest {
    public static void main(String[] args) {
        String[] answer={"江枫渔火对愁眠","夜半钟声到客船","张继"};
        ServerSocket serverSocket=null;
        Socket socket=null;
        DataInputStream in=null;
        DataOutputStream out=null;
        try{
            serverSocket=new ServerSocket(2010);

        }catch (IOException el){
            System.out.println(el);
        }
        try{
            System.out.println("等待客户端呼叫");
            socket=serverSocket.accept();//阻塞状态，除非有客户呼叫
            out=new DataOutputStream(socket.getOutputStream());
            in=new DataInputStream(socket.getInputStream());
            for(int i=0;i<answer.length;i++){
                String s=in.readUTF(); //in读取信息，阻塞状态
                System.out.println("服务器收到客户端的提问："+s);
                out.writeUTF(answer[i]);
                Thread.sleep(500);
            }

        }catch (Exception e){
            System.out.println("服务器已断开");
        }
    }
}
