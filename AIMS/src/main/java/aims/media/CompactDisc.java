package aims.media;

import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    List<Track> tracks;
    
    public CompactDisc() {
    }

    public CompactDisc(String title){
        super(title);
    }

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, String artist, List<Track> tracks, float cost) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, String artist, List<Track> tracks, float cost) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track added successfully.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed successfully.");
        } else {
            System.out.println("Track does not exist in the CD.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        int totalLength = 0;
        for(Track track : tracks){
            totalLength += track.getLength();
        }
        System.out.println("Total length: " + totalLength);
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder trackList = new StringBuilder();
        for (Track track : tracks) {
            trackList.append(track.toString()).append("-");
        }

        if (trackList.length() > 0) {
            trackList.setLength(trackList.length() - 1);
        }
        return "CompactDisc{" +
                "title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", artist='" + artist + '\'' +
                ", tracks=" + trackList +
                ", cost=" + getCost() +
                '}';
}
}
