package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName){
        if(authors.contains(authorName) == false){
            authors.add(authorName);
        }else{
            System.out.println("da ton tai author");
        }
    }

    public void removeAuthor(String authorName){
        if(authors.contains(authorName) == true){
            authors.remove(authorName);
        }else{
            System.out.println("khong ton tai author de xoa");
        }
    }

    public String toString() {
        String Book_print = this.getTitle();

        if(this.getCategory() != null){
            Book_print += " - ";
            Book_print += this.getCategory();
        }

        return "Book - " + Book_print + ": " + this.getCost() + "$";
    }

}
