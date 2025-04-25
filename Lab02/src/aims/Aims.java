package aims;

import java.util.Scanner;

import aims.store.Store;
import aims.cart.Cart;
import aims.media.Book;
import aims.media.DigitalVideoDisc;
import aims.media.Media;
import aims.media.Playable;
import aims.media.Track;
import aims.media.CompactDisc;
import java.util.ArrayList;
import java.util.List;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    storeMenu();
                    break;
                case "2":
                    updateStoreMenu();
                    break;
                case "3":
                    cartMenu();
                    break;
                case "0":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3");
                    break;
            }
        }
    }

    public static void storeMenu() {
        Store.displayStore();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("Enter media title to see details: ");
                    String mediaTitle = scanner.nextLine();
                    Media media = Store.displayDetailMedia(mediaTitle);
                    if (media == null) {
                        System.out.println("Media with title \"" + mediaTitle + "\" not found in store.");
                        break;
                    }
                    mediaDetailsMenu(media);
                    break;
                case "2":
                    System.out.print("Enter media title to add to cart: ");
                    String addMediaTitle = scanner.nextLine();
                    Media mediaToAdd = Store.searchMediaByTitle(addMediaTitle);
                    if (mediaToAdd == null) {
                        System.out.println("Media with title \"" + addMediaTitle + "\" not found in store.");
                        break;
                    }
                    Cart.addMedia(mediaToAdd);
                    break;
                case "3":
                    System.out.print("Enter media title to play: ");
                    String playMediaTitle = scanner.nextLine();
                    Media mediaToPlay = Store.searchMediaByTitle(playMediaTitle);
                    if (mediaToPlay == null) {
                        System.out.println("Media with title \"" + playMediaTitle + "\" not found in store.");
                        break;
                    }
                    if (mediaToPlay instanceof Book) {
                        System.out.println("Cannot play a book.");
                    } else {
                        ((Playable)mediaToPlay).play();
                    }
                    break;
                case "4":
                    cartMenu();
                    break;
                case "0":
                    scanner.close();
                    showMenu();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3-4");
                    break;
            }
        }
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    Cart.addMedia(media);
                    break;
                case "2":
                    if (media instanceof Book) {
                        System.out.println("Cannot play a book.");
                    } else {
                        ((Playable)media).play();
                    }
                    break;
                case "0":
                    scanner.close();
                    storeMenu();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2");
                    break;
            }
        }
    }

    public static void cartMenu() {
        Cart.print();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    filterMediaInCart();
                    break;
                case "2":
                    sortMediaInCart();
                    break;
                case "3":
                    System.out.print("Enter media title to remove from cart: ");
                    String removeMediaTitle = scanner.nextLine();
                    Media mediaToRemove = Store.searchMediaByTitle(removeMediaTitle);
                    if (mediaToRemove == null) {
                        System.out.println("Media with title \"" + removeMediaTitle + "\" not found in cart.");
                        break;
                    }
                    Cart.removeMedia(mediaToRemove);
                    break;
                case "4":
                    System.out.print("Enter media title to play: ");
                    String playMediaTitle = scanner.nextLine();
                    Media mediaToPlay = Store.searchMediaByTitle(playMediaTitle);
                    if (mediaToPlay == null) {
                        System.out.println("Media with title \"" + playMediaTitle + "\" not found in cart.");
                        break;
                    }
                    if (mediaToPlay instanceof Book) {
                        System.out.println("Cannot play a book.");
                    } else {
                        ((Playable)mediaToPlay).play();
                    }
                    break;
                case "5":
                    System.out.println("Your order is placed. Thank you for your order!");
                    Cart.emptyCart();
                    break;
                case "0":
                    scanner.close();
                    showMenu();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3-4-5");
                    break;
            }
        }
    }

    public static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("Enter type of media to add (Book/DVD/CD): ");
                    String mediaType = scanner.nextLine();
                    switch (mediaType.toLowerCase()) {
                        case "book":
                            System.out.print("Enter book title: ");
                            String bookTitle = scanner.nextLine();
                            System.out.print("Enter book category: ");
                            String bookCategory = scanner.nextLine();
                            System.out.print("Enter book author(s) (separate multiple authors with ','): ");                                
                            String authorsInput = scanner.nextLine();
                            List<String> bookAuthors = new ArrayList<>();
                            for (String author : authorsInput.split(",")) {
                                bookAuthors.add(author.trim());
                            }
                            System.out.print("Enter book cost: ");
                            float bookCost = scanner.nextFloat();
                            scanner.nextLine();
                            Store.addMedia(new Book(bookTitle, bookCategory, bookAuthors, bookCost));
                            break;
                        case "dvd":
                            System.out.print("Enter DVD title: ");
                            String dvdTitle = scanner.nextLine();
                            System.out.print("Enter DVD category: ");
                            String dvdCategory = scanner.nextLine();
                            System.out.print("Enter DVD director: ");
                            String dvdDirector = scanner.nextLine();
                            System.out.print("Enter DVD length (minutes): ");
                            int dvdLength = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            System.out.print("Enter DVD cost: ");
                            float dvdCost = scanner.nextFloat();
                            scanner.nextLine(); // consume newline
                            Store.addMedia(new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost));
                            break;
                        case "cd":
                            System.out.print("Enter CD title: ");
                            String cdTitle = scanner.nextLine();
                            System.out.print("Enter CD category: ");
                            String cdCategory = scanner.nextLine();
                            System.out.print("Enter CD artist: ");
                            String cdArtist = scanner.nextLine();
                            System.out.print("Enter number of tracks: ");
                            int numTracks = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            List<Track> tracks = new ArrayList<>();
                            for (int i = 0; i < numTracks; i++) {
                                System.out.print("Enter title of track " + (i + 1) + ": ");
                                String trackTitle = scanner.nextLine();
                                System.out.print("Enter length of track " + (i + 1) + " (seconds): ");
                                int trackLength = scanner.nextInt();
                                scanner.nextLine(); // consume newline
                                tracks.add(new Track(trackTitle, trackLength));
                            }
                            System.out.print("Enter CD cost: ");
                            float cdCost = scanner.nextFloat();
                            scanner.nextLine(); // consume newline
                            Store.addMedia(new CompactDisc(cdTitle, cdCategory, cdArtist, tracks, cdCost));
                            break;
                        default:
                            System.out.println("Invalid media type. Please choose Book, DVD, or CD.");
                            break;
                    }
                    break;
                case "2":
                System.out.print("Enter type of media to remove (Book/DVD/CD): ");
                String mediaTypeRemove = scanner.nextLine();
                switch (mediaTypeRemove.toLowerCase()) {
                    case "book":
                        System.out.print("Enter book title: ");
                        String bookTitle = scanner.nextLine();
                        Store.removeMedia(new Book(bookTitle));
                        break;
                    case "dvd":
                        System.out.print("Enter DVD title: ");
                        String dvdTitle = scanner.nextLine();
                        Store.removeMedia(new DigitalVideoDisc(dvdTitle));
                        break;
                    case "cd":
                        System.out.print("Enter CD title: ");
                        String cdTitle = scanner.nextLine();
                        Store.removeMedia(new CompactDisc(cdTitle));
                        break;
                    default:
                        System.out.println("Invalid media type. Please choose Book, DVD, or CD.");
                        break;
                }
                break;
                case "0":
                    scanner.close();
                    showMenu();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2");
                    break;
            }
            
        }
    }
    
    public static void filterMediaInCart() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. By id");
        System.out.println("2. By title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    String mediaId = scanner.nextLine();
                    try {
                        int id = Integer.parseInt(mediaId);
                        Media media = Cart.searchMediaById(id);
                        if (media != null) {
                            System.out.println(media.toString());
                        } else {
                            System.out.println("Media not found with id: " + id);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid id. Please enter a valid integer.");
                    }
                    break;
                case "2":
                String mediaTitle = scanner.nextLine();
                    Media media = Cart.searchMediaByTitle(mediaTitle);
                    if (media != null) {
                        System.out.println(media.toString());
                    } else {
                        System.out.println("Media not found with title: " + mediaTitle);
                    }
                    break;
                case "0":
                    scanner.close();
                    cartMenu();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2");
                    break;
            }
        }
    }

    public static void sortMediaInCart() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. By title");
        System.out.println("2. By cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    Cart.sortByTitleCost();
                    cartMenu();
                    return;
                case "2":
                    Cart.sortByCostTitle();
                    cartMenu();
                    return;
                case "0":
                    scanner.close();
                    cartMenu();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        showMenu();
    }
}
