package hust.soict.hedspi.aims.test;

import hust.soict.hedspi.aims.disc.*;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
    }


    public static void swap(Object d1, Object d2) {
        Object temp = d1;
        d1 = d2;
        d2 = temp;
    }



    public static void changeTitle(DigitalVideoDisc dvd, String newTitle) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(newTitle);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    /*
    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tmp1 = dvd1.getTitle();
        String tmp2 = dvd2.getTitle();
        dvd1.setTitle(tmp2);
        dvd2.setTitle(tmp1);
    }
    */


}
