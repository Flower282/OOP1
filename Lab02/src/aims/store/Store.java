package aims.store;
import aims.media.Media;

import java.util.ArrayList;

public class Store {
    private static ArrayList<Media> itemsInStore = new ArrayList<>();
    //implements addDVD and remove DVD method



    public static void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added to the store.");
        } else {
            System.out.println(media.getTitle() + " is already in the store.");
        }
    }
       
    public static void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println(media.getTitle() + " is not in the store.");
        }
    }

    public static void displayStore() {
        System.out.println("Items in store: ");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }

    public static Media displayDetailMedia(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equals(title)) {
                System.out.println(m.toString());
                return m;
            }
        }
        return null;
    }

    public static Media searchMediaByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equals(title)) {
                return m;
            }
        }
        return null;
    }

}
