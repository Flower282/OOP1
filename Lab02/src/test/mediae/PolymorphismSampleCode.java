package test.mediae;
import aims.media.Media;
import aims.media.Track;
import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.DigitalVideoDisc;
import java.util.ArrayList;
import java.util.List;

public class PolymorphismSampleCode {
public static void main(String[] args) {
    List<Media> mediae = new ArrayList<>();
    List<String> authors = new ArrayList<>();
    List<Track> tracks = new ArrayList<>();
    authors.add("Author 1");
    authors.add("Author 2");
    tracks.add(new Track("Track 1", 10));
    tracks.add(new Track("Track 2", 20));
    Media book = new Book("Book Title", "Book Category", authors, 10.0f);
    Media cd = new CompactDisc("CD Title", "CD Category", "CD Artist", tracks, 15.0f);   
    Media dvd = new DigitalVideoDisc("DVD Title", "DVD Category", "DVD Director", 120, 20.0f);
    

    mediae.add(book);
    mediae.add(cd);
    mediae.add(dvd);
    for(Media m : mediae) {
        System.out.println(m.toString());
    }
}
}
