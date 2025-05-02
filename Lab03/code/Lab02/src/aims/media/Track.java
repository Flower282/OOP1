package aims.media;

import java.util.Objects;

public class Track implements Playable {
    String title;
    int length;

    public Track() {
        // Default constructor
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track track = (Track) obj;
        return Objects.equals(this.title, track.title) 
                && this.length == track.length;
    }

    @Override
    public String toString() {
        return "[" +
                "title='" + title + '\'' +
                ", length=" + length +
                ']';
    }
}
