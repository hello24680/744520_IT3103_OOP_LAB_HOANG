package hust.soict.hedspi.aims.media;


import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }


    boolean equals(Media mediaCheck){
        if(mediaCheck == null){
            return false;
        }

        if(this.title == mediaCheck.title){
            return true;
        }else{
            return false;
        }
    }

    //compareTo theo title
    @Override
    public int compareTo(Media o){
        int compareTitle = this.title.compareTo(o.title);
        if(compareTitle == 0){
            int compareCost = Float.compare(o.cost,this.cost);
            return  compareCost;
        }
        return compareTitle;
    }


    //compareTo theo cost
    /*
    @Override
    public int compareTo(Media o){
        int compareCost = Float.compare(o.cost,this.cost);

        if(compareCost == 0){
            int compareTitle = this.title.compareTo(o.title);
            return compareTitle;
        }
        return compareCost;
    }
    */


    public String toString() {
        String Media_print = this.getTitle();

        if(this.getCategory() != null){
            Media_print += " - ";
            Media_print += this.getCategory();
        }

        return "Media - " + Media_print + ": " + this.getCost() + "$";
    }

}
