package ex1;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Contador {

    public class Incrementador extends Thread {
        @Override
        public void run() {
            for (int i = 0; i != 10000; i++) {
                incrementa();
            }
        }
    }

    private int i = 0;
    public Lock cadeado = new ReentrantLock();
    private AtomicInteger contagem= new AtomicInteger();
    
    public int getContagem(){
        return i;
    }
    public void incrementa() {
        /*cadeado.lock();
        try{
        i++;
        }finally{
            cadeado.unlock();
        }*/
        contagem.incrementAndGet();
    }

    public  static void main(String[] args){
            Thread[] threads = new Thread[4];
            Contador contador = new Contador();
            long inicio= System.nanoTime();
            for(int i = 0; i!=threads.length;i++){
                threads[i]=contador.new Incrementador();
                threads[i].start();

            }
            for(Thread t: threads)
            try{
                t.join();
            }catch(InterruptedException e){

            }
            System.out.println("Contagem final:"+contador.getContagem()+" tempo " + (System.nanoTime()- inicio)/1000);
    }

   
}
