package com.mj.admin.service;

class ProducerConsumerDemo {
    public static void main(String[] args){
        Resource resource = new Resource();
        Resource.Producer producer = new Resource.Producer(resource);
        Resource.Consumer consumer = new Resource.Consumer(resource);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        Thread t3 = new Thread(producer);
        Thread t4 = new Thread(consumer);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class Resource{
    private String name;
    private int count = 1;
    private boolean flag = false;
    public synchronized void set(String name){
        while (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.name = name+"---"+count++;
            System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
            flag = true;
            //线程全部唤醒
            this.notifyAll();
        }
    }
    public synchronized void out(){
        while (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"......消费者....."+this.name);
            flag =false;
            //唤醒全部线程
            this.notifyAll();
        }
    }
    static class Producer implements Runnable{
        private Resource resource;
        Producer(Resource resource){
            this.resource = resource;
        }
        public void run(){
            while (true){
                resource.set("+商品+");
            }
        }
    }
   static class Consumer implements Runnable{
        private Resource resource;
        Consumer(Resource resource){
            this.resource = resource;
        }
        public void run(){
            while (true){
                resource.out();
            }
        }
    }

}
