public class DigitalVideoDisc {
    private int id;
    String title;
    String category;
    String director;
    int length;
    float cost;
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super();
        this.id=++nbDigitalVideoDiscs;
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.id=++nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.id=++nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.id=++nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public static int getTotalDVDs() {
        return nbDigitalVideoDiscs;
    }
}
