public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc " + disc.getTitle() + " has been added to the cart.");
        } else {
            System.out.println("The cart is full. Cannot add more discs.");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] discs) {
        for (int i = 0; i < discs.length; i++) {
            DigitalVideoDisc dvd = discs[i];
            addDigitalVideoDisc(dvd);
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        addDigitalVideoDisc(disc1);
        addDigitalVideoDisc(disc2);
    }


    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc " + disc.getTitle() + " has been removed from the cart.");
                return;
            }
        }
        System.out.println("The disc " + disc.getTitle() + " is not in the cart.");
    }
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void display() {
        System.out.println("Items in the cart:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].getTitle());
        }
    }
}
