package thread.Synchronized;

/**
 * 当一个线程访问"某对象"的"Synchronized方法"或者"Synchronized代码块"时，其他线程对"该对象"的该"synchronized方法"或者"synchronized代码块"
 * 访问将被阻塞。
 *
 * 2019/05/25
 */
public class MyRunnable implements  Runnable{

    @Override
    public void run() {
        synchronized (this){
            try {
                for (int i=0;i<5;i++){
                    Thread.sleep(100); //休眠100ms
                    System.out.println(Thread.currentThread().getName()+"loop"+i);
                }
            }catch (InterruptedException ie){

            }
        }
    }

    public static void main(String[] args) {
        Runnable demo=new MyRunnable();
        Thread t1=new Thread(demo,"t1");
        Thread t2=new Thread(demo,"t2");
        t1.start();
        t2.start();

        //结果说明：run()方法存在"synchronized(this)代码块",而且t1和t2多是基于"demo这个Runnable对象"创建的线程。
        //这就意味着,我们可以将synchronized(this)的this看作是"demo这个Runnable对象";因此，线程t1和t2共享"demo对象"
        //的同步锁。所以，当一个线程运行的时候，另外一个线程必须等待"运行线程"释放"demo的同步锁"之后才能运行
    }
}

