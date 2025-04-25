package aims.cart;

import java.util.ArrayList;
import java.util.List;

import aims.media.Media;

public class Cart {

    private static List<Media> itemsOrdered = new ArrayList<>();

    public static void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added to the cart.");
        } else {
            System.out.println(media.getTitle() + " is already in the cart.");
        }
    }
       
    public static void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }
    
    public static float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public static void emptyCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been emptied.");
    }

    public static Media searchMediaByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equals(title)) {
                return m;
            }
        }
        return null;
    }

    public static Media searchMediaById(int id) {
        if (id > 0 && id <= itemsOrdered.size()) {
            return itemsOrdered.get(id - 1);
        }
        return null;
    }

    public static void sortByTitleCost() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public static void sortByCostTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public static void print() {
        System.out.println("***************************CART***************************");
        System.out.println("Ordered items:");
        for (Media media : itemsOrdered) {
            System.out.println((itemsOrdered.indexOf(media) + 1) + ". " + media.toString());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("**********************************************************");
    }
}
