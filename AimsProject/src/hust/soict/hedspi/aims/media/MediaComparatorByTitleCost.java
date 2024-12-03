package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media o1, Media o2) {
        int compareTitle = o1.getTitle().compareTo(o2.getTitle());

        if(compareTitle == 0){
            int compareCost = Float.compare(o2.getCost(),o1.getCost());
            return compareCost;
        }
        return compareTitle;
    }
}
