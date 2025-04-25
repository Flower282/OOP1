package test.store;

import aims.media.DigitalVideoDisc;
import aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create some DigitalVideoDisc objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Add DVDs to the store
        Store.addMedia(dvd1);
        Store.addMedia(dvd2);
        Store.addMedia(dvd3);

        // Remove a DVD from the store
        Store.removeMedia(dvd2);

        // Try to remove a DVD that is not in the store
        Store.removeMedia(dvd2);
    }
}
