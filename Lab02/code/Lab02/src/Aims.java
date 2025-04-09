public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());
        System.out.println();


        anOrder.display();
        System.out.println();

        anOrder.removeDigitalVideoDisc(dvd1);
        System.out.println("Items in the cart after removing: ");
        anOrder.display();
        System.out.println();
        System.out.println("Total cost is: ");
        System.out.println(anOrder.totalCost());
        System.out.println();


        System.out.println("DVD 1 ID: " + dvd1.getId());
        System.out.println("DVD 2 ID: " + dvd2.getId());
        System.out.println("Total number of DVDs: " + DigitalVideoDisc.getTotalDVDs());
    }
}
