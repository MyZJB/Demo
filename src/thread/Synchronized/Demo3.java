package thread.Synchronized;

//仓库
class Depot{
    private int capacity; //仓库的容量
    private int size; //仓库的实际数量

    public Depot(int capacity){
        this.capacity=capacity;
        this.size=0;
    }

    public synchronized void produce(int val){
        try{
            //left 表示"想要生产的数量"(有可能生产量太多，需多此生产)
            int left=val;
            while(left>0) {
                //库存已满时，等待"消费者" 消费产品
                while (size >= capacity) {
                    wait();
                }
                //获取"实际生产的数量"(即库存中新增的数量)
                //如果"库存"+"想要生产的数量">"总的数量",则"实际增量"="总的容量"-"当前容量"。(此时填满仓库)
                //否则"实际增量"="想要生产的数量"
                int inc = (size + left) > capacity ? (capacity - size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);
                //通知"消费者"可以消费了
                notifyAll();
            }
        }catch (InterruptedException ex){

        }
    }

    public synchronized void consume(int val){
        try{
            //left表示"客户要消费数量"(有可能消费了太大，库存不够，需要此消费)
            int left=val;
            while(left>0){
                //库存为0时，等待"生产者"生产产品
                while(size<=0) {
                    wait();
                }
                    //获取"实际消费的数量"(即库存中实际减少的数量)
                    //如果"库存"<"客户要消费的数量",则"实际消费量"="库存";
                    //否则， "实际消费量"="客户要消费的数量"。
                    int dec=(size<left)?size:left;
                    size-=dec;
                    left-=dec;
                    System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",Thread.currentThread().getName(), val, left, dec, size);
                    notifyAll();
                }
        }catch (InterruptedException ex){

        }
    }

    public String toString(){
        return "capacity:"+capacity+", actual size:"+size;
    }
}

//生产者
class  Producer{
    private Depot depot;

    public Producer(Depot depot){
        this.depot=depot;
    }

    //消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val){
        new Thread(){
            @Override
            public void  run(){
                depot.produce(val);
            }
        }.start();
    }
}

class  Customer{
    private Depot depot;

    public  Customer(Depot depot){
        this.depot=depot;
    }
    //消费产品:新建一个线程从仓库中消费产品
    public void consume(final int val){
        new Thread(){
            @Override
            public void run() {
                depot.consume(val);
            }
        }.start();
    }
}

/**
 *2019/05/27  生产者/消费者模型
 *
 * 生产/消费者问题是个非常典型的多线程问题,涉及到的对象包括"生产者"、"消费者"、"仓库"、和"产品"。他们之间的关系如下:
 *
 *
 * 1.生产者仅仅在仓库未满时产生，仓满则停止生产。
 * 2.消费者仅仅在仓储有产品的时候才能消费，则空则等待。
 * 3.当消费者发现仓储没有产品可消费时候会通知生产者生产。
 * 4.生产者在生产出可消费产品时候，应该通知等待的消费者去消费。
 */
public class Demo3 {
    public static void main(String[] args) {
        //说明
        //1.Producer是"生产者"类，它与"仓库(depot)"关联。当调用"生产者"的produce()方法时，它会新建一个线程并向"仓库"中生产产品。
        //2.Customer是"消费者"类,它与"仓库(depot)"关联。当调用"消费者"的consume()方法时，它会新建一个线程并消费""
        //3.Depot是"仓库"类，它仓库中记录"仓库的容量(capacity)"以及"仓库中当前产品数目(size)"。
        // "仓库"类的生产produce()和消费方法consume()方法多是synchronized方法,进入Synchronize方法体，意味着这个县城获取到了该"仓库"对象的同步锁。这也就是说，同一时间，生产者和消费者线程只能有一个能运行。
        //通过同步锁，实现对"残酷"的互斥访问。

        //  对于生产方法produce()方法而言:当仓库满时，生产者线程等待，需要等待消费者消费产品之后，生产线程才能生产；生产者线程生产完成产品之后 ，会通过notifyAll()唤醒同步锁上的所有线程，包括"消费者线程",即我们所说的"
        //  通知消费者进行消费"。
        //  对于消费方法consume()方法而言:当仓库为空时，消费者线程等待，需要等待生产者生产产品之后，消费者线程才能消费；消费者线程消费完成产品之后，会通过notifyAll()唤醒同步锁上的所有线程，包括"生产者线程"，即我们所说的"通知生产者进行生产"
        Depot mDepot=new Depot(100);
        Producer mPro=new Producer(mDepot);
        Customer mCus=new Customer(mDepot);
        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mCus.consume(110);
    }



}
