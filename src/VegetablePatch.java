import java.util.ArrayList;

public class VegetablePatch {

    private int maxVegetables;
    private String producedVegetables [] = null;
    private int count = 0;

    private boolean full = false;
    private boolean empty = true;


    public VegetablePatch(int capacity){
        this.maxVegetables = capacity;
        this.producedVegetables = new String[capacity];
    }


    public synchronized void put(String vegetable) throws InterruptedException {
        while(full){
            wait();
        }

        producedVegetables[count] = vegetable;
        count++;
        full = count >= maxVegetables;
        empty = false;
        notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while(empty){
            wait();
        }

        String bought = producedVegetables[--count];
        full = false;
        empty = count <= 0;
        notifyAll();
        return bought;


    }
}
