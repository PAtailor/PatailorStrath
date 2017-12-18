package lab2;

public class Lab2 {
public static int ages[] = {20, 45, 47, 38, 35, 67, 18, 34};

    public static void main(String[] args) {
        
Thread t1 = new Thread(new Runnable() {
    @Override public void run() {for(int i=0;i<ages.length;i++){
        System.out.println("Task A: The age is"+ ages[i]);}}});
Thread t2 = new Thread(new Runnable() {
    @Override public void run() {for(int i=0;i<ages.length;i++){
        int b = ages[i]-18;
        System.out.println("Task B: "+b);}}});
Thread t3 = new Thread(new Runnable() {
    @Override public void run() {for(int i=0;i<ages.length;i++){
        int f =((ages[i]-18)/5)+1;
        System.out.println("Task C: The age is " +ages[i] +" Number of times voted "+f );}}});

t1.start();
    try {t1.join();} 
    catch (InterruptedException e) {    }
t2.start();
t3.start();
}    
}
