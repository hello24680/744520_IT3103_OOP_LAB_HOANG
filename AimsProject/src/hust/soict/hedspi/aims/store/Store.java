package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.*;


public class Store {
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[100];
    int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < 100; i++) {
            if (qtyInStore != 100) {
                if (itemsInStore[i] == null) {
                    itemsInStore[i] = disc;
                    System.out.println("The disc has been added");
                    qtyInStore += 1;
                    break;
                }
            } else {
                System.out.println("The disc can't add to Store");
                break;
            }
        }

    }

    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < 100; i++) {
            if (itemsInStore[i] != null) {
                if (itemsInStore[i].getTitle().equals(disc.getTitle())) {
                    itemsInStore[i] = null;
                    System.out.println("xoa thanh cong");
                    qtyInStore -= 1;
                    break;
                }
            }
            if (i == 99) {
                System.out.println("xoa khong thanh cong");
            }
        }
    }

    public void printDVD() {
        for (int i = 0; i < 100; i++) {
            if (itemsInStore[i] != null) {
                System.out.println("id: " + itemsInStore[i].getId() + ";title: " + itemsInStore[i].getTitle());
            }
        }
    }
}
