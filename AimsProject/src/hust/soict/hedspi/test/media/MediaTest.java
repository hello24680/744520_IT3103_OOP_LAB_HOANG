package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaTest {
    public static void main(String[] args){
        List<Media> mediae = new ArrayList<Media>();

        //create media
         //CD
        CompactDisc CD1 = new CompactDisc(1,"MU","1 mon qua",1.5f,"siu","hoang1");
         //dvd
        DigitalVideoDisc DVD1 = new DigitalVideoDisc(2,"Barsa","null",0.5f,"siuu",1);
         //book
        Book Book3 = new Book(3,"Che","null",3f);

        //add vao mediae
        mediae.add(CD1);
        mediae.add(DVD1);
        mediae.add(Book3);

        //test in ra man hinh
        System.out.println("\n");
        System.out.println("test add");
        for(Media m: mediae){
            System.out.println(m.toString());
        }



        //test sap xep su dung comparator
        //compare by title
        System.out.println("\n");
        System.out.println("compare by title");
        Collections.sort(mediae,Media.COMPARE_BY_TITLE_COST);
        for(Media tmp: mediae){
            if(tmp != null){
                System.out.println(tmp.toString());
            }
        }

        //compare by cost
        System.out.println("\n");
        System.out.println("compare by cost");
        Collections.sort(mediae,Media.COMPARE_BY_COST_TITLE);
        for(Media tmp: mediae){
            if(tmp != null){
                System.out.println(tmp.toString());
            }
        }



        //test sap xep su dung comparable
        //compareTo by title
        System.out.println("\n");
        System.out.println("compareTo by title");
        Collections.sort(mediae);
        for(Media tmp: mediae){
            if(tmp != null){
                System.out.println(tmp.toString());
            }
        }

        //compareTo by cost
        /*
        System.out.println("\n");
        System.out.println("compareTo by cost");
        Collections.sort(mediae);
        for(Media tmp: mediae){
            if(tmp != null){
                System.out.println(tmp.toString());
            }
        }
        */



        //compareTo DVD theo title->length->cost

        DigitalVideoDisc DVD2 = new DigitalVideoDisc(4,"Barsa","null",0.5f,"siuu",2);
        mediae.add(DVD2);
        DigitalVideoDisc DVD3 = new DigitalVideoDisc(5,"Barsa","null",2f,"siuu",2);
        mediae.add(DVD3);

        System.out.println("\n");
        System.out.println("compareTo DVD theo title->length->cost");
        Collections.sort(mediae);
        for(Media tmp: mediae){
            if(tmp != null){
                System.out.println(tmp.toString());
            }
        }

    }
}
