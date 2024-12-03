package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost, director, length);
    }


    @Override
    public String toString() {
        String dvd_print = this.getTitle();

        if(this.getCategory() != null){
            dvd_print += " - ";
            dvd_print += this.getCategory();
        }

        if(this.getDirector() != null){
            dvd_print += " - ";
            dvd_print += this.getDirector();
        }

        if(this.getLength() != 0){
            dvd_print += " - ";
            dvd_print += this.getLength();
        }
        return "DVD - " + dvd_print + ": " + this.getCost() + "$";
    }


    public boolean isMatch(String titleToFind){
        if(this.getTitle() == titleToFind){
            return true;
        }else{
            return false;
        }
    }


    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }



    //compareTo DVD theo title->length->cost
    @Override
    public int compareTo(Media other) {
        if (other instanceof DigitalVideoDisc) {

            DigitalVideoDisc otherDVD = (DigitalVideoDisc) other;

            // So sanh title
            int titleComparison = this.getTitle().compareTo(otherDVD.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }

            // So sanh length
            int lengthComparison = Integer.compare(otherDVD.getLength(), this.getLength());
            if (lengthComparison != 0) {
                return lengthComparison;
            }

            // So sanh cost
            return Float.compare(otherDVD.getCost(), this.getCost());
        }

        // cac loai khac su dung quy tac cua lop cha media
        return super.compareTo(other);
    }

}
