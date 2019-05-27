package thread.Synchronized;

class ThreadA  extends  Thread{

    public ThreadA (String name){
        super(name);
    }

    @Override
    public void run() {
       /* synchronized (this){
            //System.out.println(Thread.currentThread().getName()+" notify");
            System.out.println(Thread.currentThread().getName() + " run ");
            //notify();
            // 死循环，不断运行。
            while(true)
                ;
        }*/

        System.out.println(Thread.currentThread().getName() + " run ");
        //notify();
        // 死循环，不断运行。
        while(true)
            ;
    }
}

public class WaitTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadA  t1=new ThreadA ("t1");
        synchronized (t1){

            System.out.println(Thread.currentThread().getName()+" start");
            t1.start();

            System.out.println(Thread.currentThread().getName()+" wait");
            t1.wait(3000);

            System.out.println(Thread.currentThread().getName()+" continue");
        }
    }

}
