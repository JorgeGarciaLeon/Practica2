import java.util.ArrayList;

public class Farmer extends Thread{

    private VegetablePatch patch;
    private int produceInt;
    private int maxWaitTime;

    private String vegetables [] = {
            "lettuce", "cabbage", "onion", "spinach",
            "potato", "celery", "asparagus", "radish",
            "broccoli", "artichoke", "tomato", "cucumber",
            "eggplant", "carrot", "green bean"};


    public Farmer(VegetablePatch patch, int produceInit, int maxWaitTime){
        this.patch = patch;
        this.produceInt = produceInit;
        this.maxWaitTime = maxWaitTime;
    }

    @Override
    public void run(){
        String vegetable;
        int randomNum = (int) (Math.random()*vegetables.length);
        for (int i = 0; i < produceInt; i++) {
            vegetable = vegetables[randomNum];

            try{
                System.out.println("Produced: " + vegetable);
                sleep((int)(Math.random()*this.maxWaitTime));
                patch.put(vegetable);

            }catch (InterruptedException err){
                err.getStackTrace();
            }
        }
    }

}
