package practice.dev.java8.lang.examples;

public class ThreadJoin extends Thread{
public static void main(String[] args) {
Thread t1 = new Thread("T1");
Thread t2 = new Thread("T2");
try {
t1.join();
t2.join();
} catch (InterruptedException e) {
System.out.println("Main Thread interrupted.");
}
}
public void run(){
System.out.println("Run executed");
}
}
