package SynchronousAndAsynchronous;

import java.util.concurrent.TimeUnit;

interface AsyncEventListner{
    void onRunningEvent();
}
public class Asynchronous {



    public static void waitFor(int Seconds){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void add()  {
        waitFor(4);
        System.out.println("Adding");
    }
    public void subtract() {
        waitFor(3);
        System.out.println("Subtracting");
    }
    public void multiply(){
        waitFor(2);

        System.out.println("Multiply");
    }
    public void division() {
        waitFor(1);

        System.out.println("Division");
    }

    private AsyncEventListner aListner;
    public void registeringEvent(AsyncEventListner aListner){
        waitFor(10);
        this.aListner = aListner;
    }

    public void  checkingAsync(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("Performing some Async Operations");
                if(aListner != null){
                    aListner.onRunningEvent();
                }
            }
        }).start();
    }

    public static void main(String[] args){
        Asynchronous obj = new Asynchronous();

        AsyncEventListner aListener = new SubCalss();

        new Thread(new Runnable(){
            @Override
            public void run(){
                obj.add();
                obj.subtract();
                obj.division();
                obj.add();
            }
        }).start();
        obj.checkingAsync();

        obj.registeringEvent(aListener);

        obj.checkingAsync();
        obj.checkingAsync();


//        obj.add();
//        obj.subtract();
//        obj.multiply();
//        obj.division();

    }
}

class SubCalss implements AsyncEventListner{

    @Override
    public void onRunningEvent() {
        System.out.println("Performing some callback afetr the first asynchronous taks");
    }
}
