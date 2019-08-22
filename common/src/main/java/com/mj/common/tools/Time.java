package com.mj.common.tools;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Time implements ServletContextListener {
    public static void showDayTime(){
        Date sendDate = new Date();
        Timer dTimer = new Timer();
        dTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minutes = c.get(Calendar.MINUTE);
                if (hour == 11 && minutes == 59){
                    //每天11:59定时函数
                    System.out.println("每天任务已执行");
                }

            }
        },sendDate,24*60*60*10000);//设置没过24小时执行一次
    }
    public static void main(String[] args){
        showDayTime();
    }
//继承
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        showDayTime();
    }
//继承
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
