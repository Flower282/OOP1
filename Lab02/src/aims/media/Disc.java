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

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

        
    @Override
    public void displayDetail() {
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Director: " + getDirector());
        System.out.println("Length: " + getLength());
        System.out.println("Cost: " + getCost());
    }
}
