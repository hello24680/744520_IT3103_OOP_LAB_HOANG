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
                System.out.println("The cart is almost full");
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
