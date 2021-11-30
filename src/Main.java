public class Main {
    public static void main(String[] args) {
        VegetablePatch vegetables = new VegetablePatch(5);

        Farmer farmer1 = new Farmer(vegetables, 3, 1000);
        Farmer farmer2 = new Farmer(vegetables, 2, 1000);

        Customer customer1 = new Customer(vegetables,3, 6000);
        Customer customer2 = new Customer(vegetables,2, 6000);


        farmer1.start();
        farmer2.start();
        customer1.start();
        customer2.start();
    }
}
