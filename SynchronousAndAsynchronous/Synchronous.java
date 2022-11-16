package SynchronousAndAsynchronous;

public class Synchronous {
    public void add(){
        System.out.println("Adding");
    }
    public void subtract(){
        System.out.println("Subtracting");
    }
    public void multiply(){
        System.out.println("Multiply");
    }
    public void division(){
        System.out.println("Division");
    }

    public static void main(String[] args) {
        Synchronous obj = new Synchronous();
        obj.add();
        obj.subtract();
        obj.multiply();
        obj.division();

    }

}
