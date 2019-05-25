package thread.Synchronized;


class  Count{
    //含有synchronized同步块的方法
    public void synMethod(){
        synchronized (this){
            try{
                for (int i=0;i<5;i++){
                    Thread.sleep(100); //休眠100ms
                    System.out.println(Thread.currentThread().getName()+"synMethod loop"+i);
                }
            }catch (InterruptedException ie){

            }
        }
    }

    //非同步的方法
    public void nonSynMethod(){
        try{
            for (int i=0;i<5;i++){
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+"nonSynMethod loop"+i);
            }
        }catch (InterruptedException ie){

        }
    }
}

/**
 * 当一个线程访问某对象的synchronized方法或者synchronized代码块时，其他线程依然可以访问该对象的非同步代码块
 *
 * 结果说明:
 * 主线程中新建两个线程t1和t2。t1调用count对象的synMethod()方法，该方法内含有同步块；而t2则会调用count调用nonSynMethod()方法，
 * 该方法不是同步方法。t1运行时，虽然调用synchronized(this)获取"count"的同步锁；但是并没有造成t2的阻塞，因为t2没有调用count同步锁
 *
 *
 * 2019/05/25
 */
public class Demo1 {
    public static void main(String[] args) {
        final Count count=new Count();
        //新建t1,t1会调用"count对象"的synMethod()方法
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                count.synMethod();
            }
        },"t1");

        //新建t2,t2会调用"count对象"的nonSynMethod()方法
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                count.nonSynMethod();
            }
        },"t2");
        t1.start();
        t2.start();
    }


}
