public class Customer extends Thread{
    private VegetablePatch patch;
    private int expectUnits;
    private int maxWaitTime;

    public Customer(VegetablePatch patch, int expectUnits, int maxWaitTime) {
        this.patch = patch;
        this.expectUnits = expectUnits;
        this.maxWaitTime = maxWaitTime;
    }

    @Override
    public void run(){
        String vegetable;

        try{
            for (int i = 0; i < expectUnits; i++) {
                sleep((int)(Math.random()*this.maxWaitTime));
                vegetable = patch.get();
                System.out.println("Consumed: " + vegetable);
            }
        }catch (InterruptedException err){
            err.printStackTrace();
        }
    }
}
