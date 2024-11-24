package aims.cart;

import aims.disc.DigitalVideoDisc;
import java.lang.*;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered =0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i =0; i < 20; i++) {
            if (qtyOrdered != 20) {
                if(itemsOrdered[i] == null) {
                    itemsOrdered[i] = disc;
                    System.out.println("The disc has been added");
                    qtyOrdered += 1;
                    break;
                }
            } else {
                System.out.println("The cart is almost full 1");
                break;
            }
        }
    }


    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        int k = 0; //bien index phan tu cua dvdList de cho vao itemsOrdered
        for(int i =0; i < 20; i++) {
            if(k == dvdList.length){ //neu k == length cua dvdList thi dung chay for
                break;
            }
            if (qtyOrdered != 20) {
                if(itemsOrdered[i] == null) {
                        itemsOrdered[i] = dvdList[k++]; //thuc hien xong roi thi k + 1
                        System.out.println("The disc " + k + " has been added");
                        qtyOrdered += 1;
                }
            } else {
                System.out.println("The cart is almost full 2.1");
                break;
            }
        }
    }




    /*
    //pass arbitrary number of arguments (pass bao nhieu tham so cung duoc)
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList_arbitrary){
       int k = 0; //bien index phan tu cua dvdList de cho vao itemsOrdered
        for(int i =0; i < 20; i++) {
            if(k ==  dvdList_arbitrary.length){ //neu k == length cua dvdList thi dung chay for
                break;
            }
            if (qtyOrdered != 20) {
                if(itemsOrdered[i] == null) {
                        itemsOrdered[i] = dvdList_arbitrary[k++]; //thuc hien xong roi thi k + 1
                        System.out.println("The disc " + k + " has been added");
                        qtyOrdered += 1;
                }
            } else {
                System.out.println("The cart is almost full 2.2");
                break;
            }
        }
    }
    */


    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        int k = 1; //danh dau dvd nao se dc add => k = 1 la dvd 1, k = 2 la dvd 2
        for(int i =0; i < 20; i++) {
            if (qtyOrdered != 20) {
                if(itemsOrdered[i] == null) {
                    if(k == 1) {
                        itemsOrdered[i] = dvd1;
                        System.out.println("The disc 1 has been added");
                        qtyOrdered += 1;
                        k++;
                    } else {
                        itemsOrdered[i] = dvd2;
                        System.out.println("The disc 2 has been added");
                        qtyOrdered += 1;
                        break;
                    }
                }
            } else {
                System.out.println("The cart is almost full 3");
                break;
            }
        }
    }


    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i = 0; i < 20; i++){
            if(itemsOrdered[i] != null) {
                if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {
                    itemsOrdered[i] = null;
                    System.out.println("xoa thanh cong");
                    qtyOrdered -= 1;
                    break;
                }
            }
            if(i == 19){
                System.out.println("xoa khong thanh cong");
            }
        }
    }

    public float totalCost(){
        float cost = 0;
        for(int i = 0; i < 20; i++){
            if(itemsOrdered[i] != null){
                cost += itemsOrdered[i].getCost();
            }
        }
        return cost;
    }

}