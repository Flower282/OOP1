package aims.media;

import java.util.List;

public class Book extends Media {
    private List<String> authors;

    public Book() {
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, List<String> authors, float cost) {
        super(title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, List<String> authors, float cost) {
        super(id, title, category, cost);
        this.authors = authors;
    }
    
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String author) {
        if(!authors.contains(author)){
            authors.add(author);
            System.out.println("Add author " + author + "successfully!");
        }else{
            System.out.println("Add author failed!");
        }
    }

    public void removeAuthor(String author) {
        if(authors.contains(author)){
            authors.remove(author);
            System.out.println("Remove author " + author + "successfully!");
        }else{
            System.out.println("Remove author failed!");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", authors=" + '\'' + String.join(", ", authors) + '\'' +
                ", cost=" + getCost() +
                '}';
    }

}

