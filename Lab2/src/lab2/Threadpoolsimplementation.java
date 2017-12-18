package lab2;

import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;


public class Threadpoolsimplementation implements Runnable{
private final String message;  
public static int ages[] = {20, 45, 47, 38, 35, 67, 18, 34};

public Threadpoolsimplementation(String s){this.message=s;}  

@Override
public void run() {  
synchronized(this){for(int i=0;i<ages.length;i++){
    System.out.println(Thread.currentThread().getName()+" Task 1: The age is "+ ages[i]);
    int b = ages[i]-18;
    System.out.println(Thread.currentThread().getName()+" Task 2: You are "+b +" yrs old");
    int f =((ages[i]-18)/5)+1;
    System.out.println(Thread.currentThread().getName()+" Task 3: The age is " +ages[i] +" Number of times voted "+f );
}}}
 

public static void main(String[] args) {  
ExecutorService executor = Executors.newFixedThreadPool(2);//creating a pool of 3 threads  

Runnable one = new Threadpoolsimplementation("" );  
executor.execute(one);//calling execute method of ExecutorService  

executor.shutdown();  
while (!executor.isTerminated()) {   }  
System.out.println("Finished all threads");  }}