package hust.soict.hedspi.aims.Cart;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media mediaNew){
        for(Media tmp :itemsOrdered){
            if(tmp != null) {
                if (tmp.getTitle() == mediaNew.getTitle()) {
                    System.out.println("media da ton tai");
                    return;
                }
            }
        }
        itemsOrdered.add(mediaNew);
    }

    public void removeMedia(Media mediaRemove){
        for(Media tmp :itemsOrdered){
            if(tmp != null) {
                if (tmp.getTitle() == mediaRemove.getTitle()) {
                    itemsOrdered.remove(tmp);
                    return;
                }
            }
        }
        System.out.println("Media khong ton tai");
    }

    public float totalCost(){
        float count_cost = 0;
        for(Media tmp :itemsOrdered){
            if(tmp != null) {
                count_cost += tmp.getCost();
            }
        }
        return count_cost;
    }

    public void sortByTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        for(Media tmp: itemsOrdered){
            if(tmp != null){
                System.out.println(tmp.toString());
            }
        }
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        for(Media tmp: itemsOrdered){
            if(tmp != null){
                System.out.println(tmp.toString());
            }
        }
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (Media tmp : itemsOrdered) {
            System.out.println(tmp.toString());
        }

        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("***************************************************");
    }

    public Media searchByTitle(String title) {
        for (Media tmp : itemsOrdered) {
            if (tmp.getTitle().equals(title))
                return tmp;
        }

        return null;
    }

    public Media searchById(int id) {
        for (Media tmp : itemsOrdered) {
            if (tmp.getId() == id)
                return tmp;
        }

        return null;
    }

    public void empty() {
        itemsOrdered.clear();
    }
}
