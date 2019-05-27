package thread.Synchronized;

class  MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i=0;i<5;i++){
                Thread.sleep(3);
                System.out.println(this.getName()+"(isDaemon="+this.isDaemon()+")"+",loop"+i);
            }
        }catch (InterruptedException ex){

        }
    }
}

class MyDaemon extends Thread{
    public MyDaemon(String name){
        super(name);
    }

    @Override
    public void run() {
        try{
            for(int i=0;i<10000;i++){
                Thread.sleep(1);
                System.out.println(this.getName()+"(isDaemon="+this.isDaemon()+")"+",loop"+i);
            }
        }catch (InterruptedException ex){
        }

    }
}

public class Demo2 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"(isDaemon="+Thread.currentThread().isDaemon()+")");
        Thread t1=new MyThread("t1");
        Thread t2=new MyDaemon("t2");
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}
