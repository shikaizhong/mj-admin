package com.mj.admin.service;

public class Thread2Test implements Runnable{//extends Thread {
    private int tick = 100;
    Object object =new Object();
    public void run(){
        while (true){
            //synchronized内要传一个对象
            synchronized (object) {
                if (tick > 0) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "sale : " + tick--);
                }
            }
        }
    }
  static class TickDemo{
        public static void main(String[] args){
//            Thread2Test thread2Test1 = new Thread2Test();
//            Thread2Test thread2Test2 = new Thread2Test();
//            Thread2Test thread2Test3 = new Thread2Test();
//            Thread2Test thread2Test4 = new Thread2Test();
//            thread2Test1.start();
//            thread2Test2.start();
//            thread2Test3.start();
//            thread2Test4.start();
            Thread2Test thread2Test = new Thread2Test();
            Thread thread1 =new Thread(thread2Test);
            Thread thread2 =new Thread(thread2Test);
            Thread thread3 =new Thread(thread2Test);
            Thread thread4 =new Thread(thread2Test);
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
        }
    }
}
