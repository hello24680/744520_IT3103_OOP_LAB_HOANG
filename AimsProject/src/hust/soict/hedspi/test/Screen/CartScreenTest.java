package hust.soict.hedspi.test.Screen;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

public class CartScreenTest {
    public static Cart cartTest = new Cart();


    public static void main(String[] args) {

        Cart cartTest = new Cart();
        // DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "Inception", "Science Fiction", 22.95f, "Christopher Nolan", 148);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Dark Knight", "Action", 19.50f, "Christopher Nolan", 152);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Forrest Gump", "Drama", 18.75f, "Robert Zemeckis", 142);

        cartTest.addMedia(dvd1);
        cartTest.addMedia(dvd2);
        cartTest.addMedia(dvd3);

        // Book
        Book book7 = new Book(7, "1984", "Dystopian Fiction", 7.99f);
        book7.addAuthor("George Orwell");
        Book book8 = new Book(8, "Brave New World", "Dystopian Fiction", 8.49f);
        book8.addAuthor("Aldous Huxley");
        Book book9 = new Book(9, "Dune", "Science Fiction", 10.75f);
        book9.addAuthor("Frank Herbert");

        cartTest.addMedia(book7);
        cartTest.addMedia(book8);
        cartTest.addMedia(book9);


        // CD + Track
        CompactDisc cd4 = new CompactDisc(4, "The Wall", "Rock", 13.99f, "Pink Floyd", "PF");
        Track track41 = new Track("Another Brick in the Wall", 214);
        Track track42 = new Track("Comfortably Numb", 384);
        Track track43 = new Track("Hey You", 274);
        cd4.addTrack(track41);
        cd4.addTrack(track42);
        cd4.addTrack(track43);

        CompactDisc cd5 = new CompactDisc(5, "Abbey Road", "Rock", 14.50f, "The Beatles", "TB");
        Track track51 = new Track("Come Together", 259);
        Track track52 = new Track("Here Comes the Sun", 185);
        cd5.addTrack(track51);
        cd5.addTrack(track52);

        CompactDisc cd6 = new CompactDisc(6, "Back in Black", "Rock", 12.99f, "AC/DC", "A/D");
        Track track61 = new Track("Back in Black", 255);
        Track track62 = new Track("You Shook Me All Night Long", 210);
        Track track63 = new Track("Hells Bells", 312);
        cd6.addTrack(track61);
        cd6.addTrack(track62);
        cd6.addTrack(track63);

        cartTest.addMedia(cd4);
        cartTest.addMedia(cd5);
        cartTest.addMedia(cd6);


        //new CartScreen(cartTest);
    }
}