package aims.media;

public class Disc extends Media {
    private String director;
    private int length; // in minutes

    public Disc(){

    }
    
    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category,String director, int length, float cost) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }
    
    public Disc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(int id, String title, String category, float cost) {
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

}
