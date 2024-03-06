package aula3.ex2;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import aula3.ex1.Contador;

public class Fila extends Thread {

 //private final ArrayBlockingQueue<Integer> queue;
 Queue<Integer> test= new PriorityQueue<>();
 private int pos = -1;
 private int vector[];
  public Lock cadeado = new ReentrantLock();
  public int i;
 
  public Fila(int capacidade) {
    vector = new int[capacidade];
 }


    public class Incrementador extends Thread {
        @Override
        public void run() {
            for (int i = 1; i != 10000; i++) {
                push(i);
            }
        }
    }


    public synchronized void push(int i){
        pos++;
        vector[pos]=i;
    }
    public int tamanho(){
        return pos+1;
    }

    public synchronized int  pop(){
        if(pos>=0){
            return (vector[pos--]);
        }else{
            throw new IllegalStateException();
        }
    }
    public int getContagem(){
        return i;
    }
    public void incrementa() {
        cadeado.lock();
        try{
        i++;
        }finally{
            cadeado.unlock();
        }
       
    }
    public  static void main(String[] args){
            Thread[] threads = new Thread[6];
            Fila fila = new Fila(10000);
        
            long inicio= System.nanoTime();
            for(int i = 0; i!=threads.length;i++){
                threads[i]=fila.new Incrementador();
                threads[i].start();

            }
            for(Thread t: threads)
            try{
                t.join();
            }catch(InterruptedException e){

            }
            System.out.println("Contagem final:"+fila.tamanho()+" tempo " + (System.nanoTime()- inicio)/1000);
    }

}