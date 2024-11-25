package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.store.*;

public class StoreTest {
    public static void main(String[] args) {
        Store storeTest = new Store();

        //test add vao store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        storeTest.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        storeTest.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation","Director", 89, 18.99f);
        storeTest.addDVD(dvd3);

        storeTest.printDVD(); //in ra ket qua storeTest add


        //test remove
        storeTest.removeDVD(dvd2);
        storeTest.printDVD(); //in ra ket qua storeTest da duoc remove

        //test khong tim thay dvd remove
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("not found");
        storeTest.removeDVD(dvd4);

    }
}
