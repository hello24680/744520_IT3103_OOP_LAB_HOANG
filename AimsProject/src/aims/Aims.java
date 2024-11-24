package aims;

import aims.cart.Cart;
import aims.disc.DigitalVideoDisc;


//import java.*;
public class Aims {

    public static void main(String[] args){
        //Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        //print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());


        //removing items not found in the cart
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("test_removeNotFound");
        anOrder.removeDigitalVideoDisc(dvd4); // test ko tim thay dvd trong cart

        //test removeing dvd2
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total Cost khi xoa dvd 2: ");
        System.out.println(anOrder.totalCost());


        //test overload pass array dvd to addDigitalVideoDisc(DigitalVideoDisc[] dvdList)
        DigitalVideoDisc arr_dvd[] = {new DigitalVideoDisc("arr_dvd0"),new DigitalVideoDisc("arr_dvd1"),new DigitalVideoDisc("arr_dvd2")};
        anOrder.addDigitalVideoDisc(arr_dvd);


        /*
        //test overload pass arbitrary argument to addDigitalVideoDisc(DigitalVideoDisc... dvdList_arbitrary)
        DigitalVideoDisc arbitrary_dvd0 = new DigitalVideoDisc("arbitrary_dvd0");
        DigitalVideoDisc arbitrary_dvd1 = new DigitalVideoDisc("arbitrary_dvd1");
        DigitalVideoDisc arbitrary_dvd2 = new DigitalVideoDisc("arbitrary_dvd2");
        anOrder.addDigitalVideoDisc(arbitrary_dvd0,arbitrary_dvd1,arbitrary_dvd2);
        */

        //test overload pass 2 dvd to addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2)
        DigitalVideoDisc two_dvd0 = new DigitalVideoDisc("two_dvd0");
        DigitalVideoDisc two_dvd1 = new DigitalVideoDisc("two_dvd1");
        anOrder.addDigitalVideoDisc(two_dvd0,two_dvd1);
    }
}
