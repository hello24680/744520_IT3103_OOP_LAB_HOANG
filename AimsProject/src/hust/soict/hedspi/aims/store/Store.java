package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;


public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();


    public void addMedia(Media mediaNew){
        for(Media tmp :itemsInStore){
            if(tmp != null) {
                if (tmp.getTitle() == mediaNew.getTitle()) {
                    System.out.println("media da ton tai");
                    return;
                }
            }
        }
        itemsInStore.add(mediaNew);
    }

    public void removeMedia(Media mediaRemove){
        for(Media tmp :itemsInStore){
            if(tmp != null) {
                if (tmp.getTitle() == mediaRemove.getTitle()) {
                    itemsInStore.remove(tmp);
                    return;
                }
            }
        }
        System.out.println("Media khong ton tai");
    }

    public void printStore() {
        for (Media tmp : itemsInStore) {
            System.out.println(tmp.toString());
        }
    }

    public Media searchByTitle(String title) {
        for (Media tmp : itemsInStore) {
            if (tmp.getTitle().equals(title)) {
                return tmp;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }


}
