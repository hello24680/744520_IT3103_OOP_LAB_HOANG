package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.Cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        //Create a new cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        //Test the print method
        cart.PrintCart();

        //Test the search methods
            //Test the search by id
                //tim thay id
                    cart.search(2);
                //khong tim thay id
                    cart.search(5);
            //Test the search by title
                //tim thay title
                    cart.search("The Lion King");
                //khong tim thay title
                    cart.search("no found");
                //tim thay 2 dvd cung title
                    //add 1 dvd cung ten "Aladin"
                    DigitalVideoDisc dvd_test_two_title = new DigitalVideoDisc("Aladin" ,"MU", 1.5f);
                    cart.addDigitalVideoDisc(dvd_test_two_title);
                    //test search
                    cart.search("Aladin");
    }
}
