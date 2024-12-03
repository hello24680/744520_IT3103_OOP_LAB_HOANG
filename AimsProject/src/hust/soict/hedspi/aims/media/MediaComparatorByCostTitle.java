package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        int compareCost = Float.compare(o2.getCost(),o1.getCost());

        if(compareCost == 0){
            int compareTitle = o1.getTitle().compareTo(o2.getTitle());
            return compareTitle;
        }
        return compareCost;
    }
}
