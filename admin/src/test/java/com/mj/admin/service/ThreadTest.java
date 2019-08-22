package com.mj.admin.service;
class ThreadTest extends Thread {
    private String name;
    ThreadTest(String name){
        this.name = name;
    }
    public void run(){
        for (int x=0;x<60;x++) {
            System.out.println((Thread.currentThread()==this)+" "+this.getName()+"Thread run"+x);
        }
    }
static class ThreadDemo
    {
        public static void main(String[] args) throws InterruptedException {
            ThreadTest threadTest = new ThreadTest("simon");
            ThreadTest threadTest1 = new ThreadTest("persion");
            threadTest.start();
            threadTest1.start();
            for (int x=0;x<60;x++) {
                System.out.println("Thread2"+" "+x);
            }
        }
    }
}
